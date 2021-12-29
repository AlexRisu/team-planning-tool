FROM maven:3.8.2-openjdk-17  AS builder
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17-alpine
COPY --from=builder target/*.jar app.jar
ENV DB_URL=mysql-db
ENTRYPOINT ["java","-jar","/app.jar"]
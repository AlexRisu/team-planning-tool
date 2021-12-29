# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
ENV FRONTEND_FOLDER=frontend
COPY $FRONTEND_FOLDER/package*.json ./
RUN npm install
COPY $FRONTEND_FOLDER/babel.config.js babel.config.js
COPY $FRONTEND_FOLDER/.env .env
COPY $FRONTEND_FOLDER/public public
COPY $FRONTEND_FOLDER/src src
RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
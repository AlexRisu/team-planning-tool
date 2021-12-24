package de.ssd.models.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@NoArgsConstructor
@Getter
@Setter
@IdClass(EventTagId.class)
public class EventTagEntity {
    @Id
    @Column
    private String name;

    @Id
    private String context;

    @Column
    private String description;

    @Column
    private String color;

}

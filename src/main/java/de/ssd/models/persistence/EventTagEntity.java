package de.ssd.models.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class EventTagEntity {
    @Id
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String color;

}

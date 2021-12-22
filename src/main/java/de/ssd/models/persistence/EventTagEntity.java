package de.ssd.models.persistence;

import de.ssd.models.EventTag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EventTagEntity {
    @Id
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String color;

    public static EventTagEntity of(EventTag eventTag) {
        return new EventTagEntity(eventTag.getName(), eventTag.getDescription(), eventTag.getColor());
    }
}

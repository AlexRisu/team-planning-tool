package de.ssd.models.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
public class EventId implements Serializable {
    private long id;
    private String context;
}

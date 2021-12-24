package de.ssd.models.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
public class EventTagId implements Serializable {
    private String name;
    private String context;
}

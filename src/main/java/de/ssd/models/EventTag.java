package de.ssd.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class EventTag {
    @EqualsAndHashCode.Include
    private final String name;

    @EqualsAndHashCode.Include
    private final String context;

    private final String description;

    private final String color;
}

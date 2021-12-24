package de.ssd.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EventTag {
    private final String name;

    private final String description;

    private final String color;
}

package de.ssd.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EventTag {
    private String name;

    private String description;

    private String color;
}

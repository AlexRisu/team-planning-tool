package de.ssd.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Event {
    private final String title;

    @Setter
    private String description = "";

    private final Set<EventTag> eventTagList = new HashSet<>();

    public void add(EventTag eventTag){
        this.eventTagList.add(eventTag);
    }

    public void addAll(Collection<EventTag> eventTags){
        this.eventTagList.addAll(eventTags);
    }
}

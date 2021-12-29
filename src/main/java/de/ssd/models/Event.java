package de.ssd.models;

import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class Event {

    private final String context;

    private final String title;

    @Setter
    private String description = "";

    private float duration;

    @EqualsAndHashCode.Exclude
    private final Set<EventTag> eventTagList = new HashSet<>();

    public void add(EventTag eventTag) {
        this.eventTagList.add(eventTag);
    }

    public void addAll(Collection<EventTag> eventTags) {
        this.eventTagList.addAll(eventTags);
    }
}

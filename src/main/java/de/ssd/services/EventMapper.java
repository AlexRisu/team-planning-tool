package de.ssd.services;

import de.ssd.models.Event;
import de.ssd.models.EventTag;
import de.ssd.models.persistence.EventEntity;
import de.ssd.models.persistence.EventTagEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EventMapper {
    public EventEntity toEntity(Event event) {
        EventEntity eventEntity = new EventEntity(event.getTitle(), event.getDescription());
        eventEntity.addAll(event.getEventTagList().stream().map(this::toEntity).collect(Collectors.toSet()));
        eventEntity.setContext(event.getContext());
        return eventEntity;
    }

    private EventTagEntity toEntity(EventTag eventTag) {
        final EventTagEntity eventTagEntity = new EventTagEntity();
        eventTagEntity.setName(eventTag.getName());
        eventTagEntity.setContext(eventTag.getContext());
        eventTagEntity.setDescription(eventTag.getDescription());
        eventTagEntity.setColor(eventTag.getColor());
        return eventTagEntity;
    }

    public Event toDomain(EventEntity eventEntity) {
        return Event.builder()
                .context(eventEntity.getContext())
                .title(eventEntity.getTitle())
                .description(eventEntity.getDescription())
                .duration(eventEntity.getDuration())
                .build();
    }
}

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
        EventEntity eventDTO = new EventEntity(event.getTitle(), event.getDescription());
        eventDTO.addAll(event.getEventTagList().stream().map(this::toEntity).collect(Collectors.toSet()));
        return eventDTO;
    }

    private EventTagEntity toEntity(EventTag eventTag) {
        final EventTagEntity eventTagEntity = new EventTagEntity();
        eventTagEntity.setName(eventTag.getName());
        eventTagEntity.setDescription(eventTag.getDescription());
        eventTagEntity.setColor(eventTag.getColor());
        return eventTagEntity;
    }
}

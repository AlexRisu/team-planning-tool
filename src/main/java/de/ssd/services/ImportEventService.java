package de.ssd.services;

import de.ssd.exceptions.InvalidEventException;
import de.ssd.models.Event;
import de.ssd.models.persistence.EventEntity;
import de.ssd.models.persistence.EventTagEntity;
import de.ssd.models.persistence.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImportEventService {

    private final EventRepository eventRepository;

    public void importEvent(Event event){
        validateEvent(event);
        EventEntity eventEntity = new EventEntity(event.getTitle(), event.getDescription());
        eventEntity.addAll(event.getEventTagList().stream().map(EventTagEntity::of).collect(Collectors.toSet()));

        eventRepository.save(eventEntity);
    }

    private void validateEvent(Event event) {
        if(event.getTitle() == null || event.getTitle().isBlank()){
            throw new InvalidEventException();
        }
    }
}

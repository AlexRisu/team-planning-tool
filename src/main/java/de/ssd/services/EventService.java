package de.ssd.services;

import de.ssd.models.Event;
import de.ssd.models.persistence.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public Collection<Event> getEventsByContext(String context) {
        return this.eventRepository.findAllByContext(context).stream().map(eventMapper::toDomain).toList();
    }
}

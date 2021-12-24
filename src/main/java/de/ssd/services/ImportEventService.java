package de.ssd.services;

import de.ssd.exceptions.InvalidEventException;
import de.ssd.exceptions.InvalidEventTagException;
import de.ssd.models.Event;
import de.ssd.models.EventTag;
import de.ssd.models.persistence.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ImportEventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public void importEvent(Event event) {
        validateEvent(event);
        eventRepository.save(eventMapper.toEntity(event));
    }

    private void validateEvent(Event event) {
        final boolean eventTitleIsInvalid = event.getTitle() == null || event.getTitle().isBlank();
        final boolean eventContextIsInvalid = event.getContext() == null || event.getContext().isBlank();
        if (eventTitleIsInvalid || eventContextIsInvalid) {
            throw new InvalidEventException();
        }
        validateEventTags(event.getEventTagList());
    }

    private void validateEventTags(Set<EventTag> eventTagList) {
        final boolean hasInvalidEntries = eventTagList
                .stream()
                .dropWhile(eventTag
                        -> eventTag.getName() == null
                        || eventTag.getName().isBlank()
                        || eventTag.getContext() == null
                        || eventTag.getContext().isBlank())
                .count() != eventTagList.size();
        if (hasInvalidEntries) {
            throw new InvalidEventTagException();
        }
    }
}

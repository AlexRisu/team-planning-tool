package de.ssd.apis;

import de.ssd.models.Event;
import de.ssd.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class EventApi {

    private final EventService eventService;

    public Collection<Event> getEventsByContext(String context) {
        return eventService.getEventsByContext(context);
    }
}

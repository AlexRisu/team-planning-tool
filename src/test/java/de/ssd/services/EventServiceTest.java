package de.ssd.services;

import de.ssd.models.Event;
import de.ssd.models.persistence.EventEntity;
import de.ssd.models.persistence.repositories.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    EventRepository eventRepository;

    @Spy
    EventMapper eventMapper;

    @InjectMocks
    private EventService eventService;

    @Test
    void testGetEventByContext() {
        final EventEntity eventEntity = new EventEntity();
        eventEntity.setContext("testContext");
        when(eventRepository.findAllByContext("testContext")).thenReturn(List.of(eventEntity));

        final Collection<Event> actual = eventService.getEventsByContext("testContext");

        assertThat(actual).asList().hasSize(1).contains(eventMapper.toDomain(eventEntity));
    }

    @Test
    void testEventWithDuration() {
        final EventEntity expected = new EventEntity();
        expected.setContext("testContext");
        expected.setDuration(2f);
        when(eventRepository.findAllByContext("testContext")).thenReturn(List.of(expected));

        final Collection<Event> actual = eventService.getEventsByContext("testContext");

        assertThat(actual).asList().hasSize(1).contains(eventMapper.toDomain(expected));
    }
}

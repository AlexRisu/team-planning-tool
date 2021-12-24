package de.ssd.apis;

import de.ssd.models.Event;
import de.ssd.services.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventApiTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventApi eventApi;

    @Test
    void testGetEventByContext() {
        final Event expected = new Event("test", "title");
        when(eventService.getEventsByContext("test")).thenReturn(List.of(expected));

        assertThat(eventApi.getEventsByContext("test")).asList().hasSize(1).contains(expected);
    }

}

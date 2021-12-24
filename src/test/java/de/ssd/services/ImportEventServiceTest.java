package de.ssd.services;

import de.ssd.exceptions.InvalidEventException;
import de.ssd.exceptions.InvalidEventTagException;
import de.ssd.models.Event;
import de.ssd.models.EventTag;
import de.ssd.models.persistence.EventEntity;
import de.ssd.models.persistence.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class ImportEventServiceTest {

    @Mock
    EventRepository eventRepositoryMock;

    @Spy
    EventMapper eventMapper;

    @InjectMocks
    ImportEventService importEventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEventImport() {
        Event event = new Event("Test");
        event.setDescription("Event for testing purposes.");
        final EventEntity expected = eventMapper.toEntity(event);

        importEventService.importEvent(event);

        assertThat(event).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void testAnotherEventImport() {
        Event event = new Event("Test");
        event.setDescription("A tag for testing purposes again.");
        final EventTag eventTag = new EventTag("test-tag", "A tag for testing purposes.", "blue");
        event.add(eventTag);
        final EventEntity expected = eventMapper.toEntity(event);

        importEventService.importEvent(event);

        assertThat(event).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void testInvalidTestTag() {
        Event event = new Event("Test");
        event.setDescription("A tag for testing purposes again.");
        final EventTag eventTag = new EventTag("", "", "");
        event.add(eventTag);
        final EventEntity expected = eventMapper.toEntity(event);

        assertThatExceptionOfType(InvalidEventTagException.class).isThrownBy(() -> importEventService.importEvent(event));
    }

    @Test
    void testInvalidEventImport() {

        assertThatThrownBy(() -> importEventService.importEvent(new Event("")))
                .isInstanceOf(InvalidEventException.class);
    }

    @Test
    void testAnotherInvalidEventImport() {

        assertThatThrownBy(() -> importEventService.importEvent(new Event(null)))
                .isInstanceOf(InvalidEventException.class);
    }
}

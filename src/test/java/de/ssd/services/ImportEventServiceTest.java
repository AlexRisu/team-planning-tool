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
        Event event = new Event("TestContext", "Test");
        event.setDescription("Event for testing purposes.");
        final EventEntity expected = eventMapper.toEntity(event);

        importEventService.importEvent(event);

        assertThat(event).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void testAnotherEventImport() {
        Event event = new Event("TestContext", "Test");
        event.setDescription("A tag for testing purposes again.");
        final EventTag eventTag = new EventTag("test-tag", "app", "A tag for testing purposes.", "blue");
        event.add(eventTag);
        final EventEntity expected = eventMapper.toEntity(event);

        importEventService.importEvent(event);

        assertThat(event).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void testInvalidTestTag() {
        Event event = new Event("TestContext", "Test");
        event.setDescription("A tag for testing purposes again.");
        final EventTag eventTag = new EventTag("", "app", "", "");
        event.add(eventTag);

        assertThatExceptionOfType(InvalidEventTagException.class).isThrownBy(() -> importEventService.importEvent(event));
    }

    @Test
    void testAnotherInvalidTestTag() {
        Event event = new Event("TestContext", "Test");
        event.setDescription("A tag for testing purposes again.");
        final EventTag eventTag = new EventTag("test", null, "", "");
        event.add(eventTag);

        assertThatExceptionOfType(InvalidEventTagException.class).isThrownBy(() -> importEventService.importEvent(event));
    }

    @Test
    void testInvalidEventImport() {

        assertThatThrownBy(() -> importEventService.importEvent(new Event("app", "")))
                .isInstanceOf(InvalidEventException.class);
    }

    @Test
    void testInvalidContextEventImport() {

        assertThatThrownBy(() -> importEventService.importEvent(new Event("", "test")))
                .isInstanceOf(InvalidEventException.class);
    }

    @Test
    void testAnotherInvalidEventImport() {

        assertThatThrownBy(() -> importEventService.importEvent(new Event("app", null)))
                .isInstanceOf(InvalidEventException.class);
    }

    @Test
    void testAnotherInvalidContextEventImport() {

        assertThatThrownBy(() -> importEventService.importEvent(new Event(null, "test")))
                .isInstanceOf(InvalidEventException.class);
    }
}

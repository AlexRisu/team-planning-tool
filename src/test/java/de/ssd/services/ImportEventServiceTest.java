package de.ssd.services;

import de.ssd.exceptions.InvalidEventException;
import de.ssd.exceptions.InvalidEventTagException;
import de.ssd.models.Event;
import de.ssd.models.EventTag;
import de.ssd.models.persistence.EventEntity;
import de.ssd.models.persistence.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource
    void testAnotherInvalidTestTag(final EventTag eventTag) {
        Event event = new Event("TestContext", "Test");
        event.setDescription("A tag for testing purposes again.");
        event.add(eventTag);

        assertThatExceptionOfType(InvalidEventTagException.class).isThrownBy(() -> importEventService.importEvent(event));
    }

    private static Stream<Arguments> testAnotherInvalidTestTag() {
        return Stream.of(
                Arguments.of(new EventTag("test", null, "", "")),
                Arguments.of(new EventTag(null, "app", "", "")),
                Arguments.of(new EventTag("", "app", "", "")),
                Arguments.of(new EventTag(null, null, "", "")),
                Arguments.of(new EventTag("test", "", "", ""))
        );
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

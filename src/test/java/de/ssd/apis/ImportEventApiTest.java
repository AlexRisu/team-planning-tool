package de.ssd.apis;

import de.ssd.models.Event;
import de.ssd.services.ImportEventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class ImportEventApiTest {

    @Mock
    ImportEventService importEventServiceMock;

    @InjectMocks
    ImportEventApi importEventApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEventImport() {
        final Event event = new Event("test");

        importEventApi.importEvent(event);

        verify(importEventServiceMock).importEvent(event);
    }
}

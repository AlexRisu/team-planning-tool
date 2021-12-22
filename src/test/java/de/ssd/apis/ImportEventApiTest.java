package de.ssd.apis;

import de.ssd.models.Event;
import de.ssd.services.ImportEventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ImportEventApiTest {

    @Mock
    ImportEventService importEventServiceMock;

    @InjectMocks
    ImportEventApi importEventApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenImportEventGetsCalled_thenImportEventShouldBeCalled(){

        importEventApi.importEvent(new Event("", ""));

        verify(importEventServiceMock).importEvent(Mockito.any());
    }
}

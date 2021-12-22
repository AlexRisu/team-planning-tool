package de.ssd.services;

import de.ssd.models.Event;
import de.ssd.models.persistence.EventEntity;
import de.ssd.models.persistence.EventTagEntity;
import de.ssd.models.persistence.repositories.EventRepository;
import eye2web.modelmapper.ModelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.stream.Collectors;

import static org.mockito.Mockito.verify;

public class ImportEventServiceTest {

    @Mock
    EventRepository eventRepositoryMock;

    @InjectMocks
    ImportEventService importEventService;

    ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenImportGetsCalled_thenEventShouldBeSaved(){
        Event event = new Event("TestTag", "A tag for testing purposes.");
        EventEntity eventEntity = new EventEntity(event.getTitle(), event.getDescription());
        eventEntity.addAll(event.getEventTagList().stream().map(EventTagEntity::of).collect(Collectors.toSet()));

        importEventService.importEvent(event);

        verify(eventRepositoryMock).save(Mockito.any());
    }


}

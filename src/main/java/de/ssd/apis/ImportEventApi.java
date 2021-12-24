package de.ssd.apis;

import de.ssd.models.Event;
import de.ssd.services.ImportEventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportEventApi {

    private final ImportEventService importEventService;

    public ImportEventApi(ImportEventService importEventService) {
        this.importEventService = importEventService;
    }

    @PostMapping("/event/import")
    public void importEvent(Event event) {
        importEventService.importEvent(event);
    }
}

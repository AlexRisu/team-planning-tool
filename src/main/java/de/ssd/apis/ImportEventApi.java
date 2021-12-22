package de.ssd.apis;

import de.ssd.models.Event;
import de.ssd.services.ImportEventService;
import org.springframework.web.bind.annotation.RequestParam;

public class ImportEventApi {

    private final ImportEventService importEventService;

    public ImportEventApi(ImportEventService importEventService) {
        this.importEventService = importEventService;
    }

    public void importEvent(@RequestParam Event event){

    }
}

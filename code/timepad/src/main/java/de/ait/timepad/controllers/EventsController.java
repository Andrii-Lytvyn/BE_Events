package de.ait.timepad.controllers;

import de.ait.timepad.controllers.api.EventsApi;
import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.dto.UpdateEventDto;
import de.ait.timepad.models.Event;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;


@RequiredArgsConstructor
@RestController

public class EventsController implements EventsApi {

    private final EventsService eventsService;

    @Override
    public EventDto addEvent(@RequestBody NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }

    @Override
    public EventsDto getAllEvents() {
        return eventsService.getAllEvents();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        return eventsService.deleteEvent(eventId);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return eventsService.updateEvent(eventId,updateEvent);
    }

    @Override
    public EventsDto getPaginatedEvents(int page, int size) {
        return eventsService.getPaginatedEvents(page,size);
    }


    //////////////////////////////


}

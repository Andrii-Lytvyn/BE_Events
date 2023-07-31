package de.ait.timepad.services;

import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.dto.UpdateEventDto;
import de.ait.timepad.models.Event;

import java.util.List;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);

    EventsDto getAllEvents();
    EventDto deleteEvent(Long eventId);

    EventDto updateEvent(Long eventId, UpdateEventDto updateEvent);

    EventsDto getPaginatedEvents(int page, int size);
}

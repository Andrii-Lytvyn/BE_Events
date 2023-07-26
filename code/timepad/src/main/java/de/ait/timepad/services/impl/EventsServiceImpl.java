package de.ait.timepad.services.impl;

import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.EventsRepository;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.timepad.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .name(newEvent.getName())
                .description(newEvent.getDescription())
                .place(newEvent.getPlace())
                .author(newEvent.getAuthor())
                .quantityOfMembers(newEvent.getQuantityOfMembers())
                .photo(newEvent.getPhoto())
                .date(newEvent.getDate())
                .status(Event.Status.EXPECTED).build();
        eventsRepository.saveEvent(event);
        return EventDto.from(event);
    }

    @Override
    public EventsDto getAllEvents() {
        List<Event> events = eventsRepository.findAllEvents();
        return EventsDto.builder()
                .events(from(events))
                .count(events.size())
                .build();
    }
}

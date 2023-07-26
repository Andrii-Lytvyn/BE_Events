package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;

import java.util.List;

public interface EventsRepository {

    void saveEvent(Event event);
    List<Event> findAllEvents();

    void clearEvents();
}


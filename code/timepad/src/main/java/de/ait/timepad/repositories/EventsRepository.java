package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;

import java.util.List;
import java.util.Optional;

public interface EventsRepository {
//TODO переделать под крад. Рефактор методов
    void saveEvent(Event event);
    List<Event> findAllEvents();
    Optional<Event> findById(Long id);
    void clearEvents();

    void delete(Event event);
}


package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventsRepository {
//TODO переделать под крад. Рефактор методов
    void save(Event event);
    List<Event> findAll();
    Optional<Event> findById(Long id);
    void clear();

    void delete(Event event);
}


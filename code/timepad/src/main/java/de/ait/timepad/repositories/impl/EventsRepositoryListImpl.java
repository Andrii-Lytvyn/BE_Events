package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.EventsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EventsRepositoryListImpl implements EventsRepository {
    private static List<Event> events = new ArrayList<>();

    @Override
    public void saveEvent(Event event) {
        if (event.getId() == null) {
            event.setId((long) events.size() + 1);
            events.add(event);
        }else
        {
             //TODO: обновляем, но тут не надо, т.к. это список объектов
            //если это БД или файл то обновляем в хранилище
        }
    }

    @Override
    public List<Event> findAllEvents() {
        return new ArrayList<>(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return Optional.of(event);
            }
        }
        return Optional.empty();
    }

    @Override
    public void clearEvents() {
        events.clear();
    }

    @Override
    public void delete(Event event) {
        events.remove(event);
    }

}

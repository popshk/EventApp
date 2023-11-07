package com.event.app.service;

import com.event.app.model.Customer;
import com.event.app.model.Event;
import com.event.app.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public List<Event> getEventsByCreator(Customer creator) {
        return eventRepo.getEventsByCreator(creator);
    }

    public void CreateEvent(final Event event) {
        event.setCreator(event.getCreator());
        eventRepo.save(event);
    }


}

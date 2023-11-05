package com.event.app.service;

import com.event.app.model.Customer;
import com.event.app.model.Event;
import com.event.app.repo.EventRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    @PostConstruct
    public Set<Event> getAllEvents() {
        Set<Event> allEvents = new HashSet<>(eventRepo.findAll());
        System.out.println(allEvents);
        return allEvents;
    }

    public Set<Event> getAllEventsByCreator(Customer creator) {
        Set<Event> allEventsByCreator = new HashSet<>(eventRepo.getEventsByCreator(creator));
        return allEventsByCreator;
    }
}

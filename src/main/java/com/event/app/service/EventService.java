package com.event.app.service;

import com.event.app.model.Event;
import com.event.app.model.User;
import com.event.app.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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

    public List<Event> getEventsByCreator(User creator) {
        return eventRepo.getEventsByCreator(creator);
    }

    public List<Event> getEventsByMembersContains(User member) {
        return eventRepo.getEventsByMembersContains(member);
    }

    public Event getEventById(String id) {
        return eventRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Event not found with id: " + id));
    }

    public void createEvent(final Event event) {
        addMemberToEvent(event,event.getCreator());
        eventRepo.save(event);
    }

    public void addMemberToEvent(Event event,User member){
        List<User> members = event.getMembers();
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(member);
        event.setMembers(members);
        eventRepo.save(event);
    }
}

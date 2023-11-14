package com.event.app.repo;

import com.event.app.model.Event;
import com.event.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends MongoRepository<Event, String> {

    List<Event> getEventsByCreator(User creator);

    List<Event> getEventsByMembersContains(User member);

    Event findEventById(String id);
}
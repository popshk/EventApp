package com.event.app.repo;

import com.event.app.model.Customer;
import com.event.app.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends MongoRepository<Event, String> {
List<Event> getEventsByCreator(Customer creator);

}

package com.event.app.repo;

import com.event.app.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends MongoRepository<Event,String> {
}

package com.event.app.repo;

import com.event.app.model.Event;
import com.event.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    Optional<User> findByUsername(String nickname);

    Optional<User> findUserByEmail(String email);
}

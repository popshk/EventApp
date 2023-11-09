package com.event.app.config;

import com.event.app.model.Event;
import com.event.app.model.User;
import com.event.app.repo.EventRepo;
import com.event.app.repo.UserRepo;
import com.event.app.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataLoader {

    private final UserRepo userRepository;
    private final EventRepo eventRepository;
    private final UserService userService;

    @Autowired
    public DataLoader(UserRepo userRepository, EventRepo eventRepository, UserService userService) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        userRepository.insert(User.builder().username("Paradox").build());
        userRepository.insert(User.builder().username("Grumpy").build());
        userService.loadUserByUsername("Grumpy");
        User customer = userRepository.findAll().get(0);
        List<User> all = userRepository.findAll();
        eventRepository.insert(Event.builder().name("test").creator(customer).members(all).build());
    }
}

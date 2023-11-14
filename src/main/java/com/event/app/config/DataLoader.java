package com.event.app.config;

import com.event.app.config.security.Role;
import com.event.app.model.Event;
import com.event.app.model.User;
import com.event.app.repo.EventRepo;
import com.event.app.repo.UserRepo;
import com.event.app.service.EventService;
import com.event.app.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service

public class DataLoader {

    private final UserRepo userRepository;
    private final EventRepo eventRepository;
    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public DataLoader(UserRepo userRepository, EventRepo eventRepository, EventService eventService, UserService userService) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        User user1 = User.builder().username("Mira").password("123").roles(Collections.singleton(Role.ADMIN)).build();
        User user2 = User.builder().username("Dima").password("123").roles(Collections.singleton(Role.ADMIN)).build();
        userService.createUser(user1);
        userService.createUser(user2);
        Event event1 = Event.builder().name("Mira's birthday").creator(user1).eventDate(LocalDate.of(2023,11,25)).build();
        eventService.createEvent(event1);
        eventService.addMemberToEvent(event1,user2);
    }
}

package com.event.app.service;

import com.event.app.model.Event;
import com.event.app.repo.EventRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepo repository;

    @PostConstruct
    private void init() {
        repository.insert(Event.builder().name("jopa").build());
    }

    @PostConstruct
    private void find() {
        System.out.println(repository.findById("65426c8dc723952288906b11").get());
    }

}

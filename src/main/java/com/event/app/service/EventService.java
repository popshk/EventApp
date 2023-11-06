package com.event.app.service;

import com.event.app.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepo repository;

    @Autowired
    public EventService(EventRepo repository) {
        this.repository = repository;
    }
}

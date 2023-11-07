package com.event.app.controller;

import com.event.app.model.Event;
import com.event.app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String GetEvent(Model model) {
        List<Event> allEvents = eventService.getAllEvents();
        model.addAttribute("events", allEvents);
        return "event";
    }
}

package com.event.app.controller;

import com.event.app.model.Event;
import com.event.app.model.User;
import com.event.app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String GetMainPage(Model model, @AuthenticationPrincipal User user) {
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("username", user.getUsername());
            List<Event> allEvents = eventService.getEventsByMembersContains(user);
            model.addAttribute("events", allEvents);
        } else {
            model.addAttribute("username", "Guest");
        }
        return "main";
    }

    @GetMapping("/event/{id}")
    public String GetEvent(@PathVariable String id, Model model, @AuthenticationPrincipal User user) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("user", user);
        model.addAttribute("username", user.getUsername());
        return "event";
    }
}

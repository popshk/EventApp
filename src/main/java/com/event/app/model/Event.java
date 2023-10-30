package com.event.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Document
@Data
public class Event {
    @Id
    private final String id;
    private final String name;
    private final LocalDate eventDate;
    private final String eventLocation;
    private final Customer creator;
    private final Set<Customer> customers;



}

package com.event.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.Set;

@Document
@Data
@Builder
public class Event {

    @MongoId
    private final String id;
    private final String name;
    private final LocalDate eventDate;
    private final String eventLocation;
    private final Customer creator;
    private final Set<Customer> customers;

}

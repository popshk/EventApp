package com.event.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
@Builder
public class Event {

    @MongoId
    private final String id;

    private final String name;
    private final LocalDate eventDate;
    private final String eventLocation;

    @DBRef
    private final Customer creator;

    @DBRef
    private final List<Customer> members;
}

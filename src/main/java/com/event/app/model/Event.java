package com.event.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Event {
    @Id
    private final String id;
}

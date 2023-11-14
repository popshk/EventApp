package com.event.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
public class Event {

    @MongoId
    private String id;
    private String name;
    private LocalDate eventDate;
    private String eventLocation;

    @DBRef
    private User creator;

    @DBRef
    private List<User> members;

    public String getFormattedDate() {
        if (eventDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return eventDate.format(formatter);
    }
}

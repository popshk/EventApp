package com.event.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Data
@Builder
public class Customer {

    @MongoId
    private final String id;

    private final String nickName;
    private final String firstName;
    private final String lastName;
    private final List<Event> eventCreated;
    private final List<Event> eventJoined;
    private final List<Customer> friendList;

}

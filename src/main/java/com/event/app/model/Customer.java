package com.event.app.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Document
@Data
public class Customer {
    @Id
    private final String id;

    private final String nickName;
    private final String firstName;
    private final String lastName;
    private final Set<Event> eventCreated;
    private final Set<Event> eventJoined;
    private Set<Customer> friendList;




}

package com.event.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
public class Group {
    @Id
    private final String id;
    private final String name;
    private final Set<Customer> customers;



}

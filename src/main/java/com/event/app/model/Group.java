package com.event.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Data
@Builder
public class Group {

    @MongoId
    private final String id;
    private final String name;
    private final List<User> customers;
}

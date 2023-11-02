package com.event.app.config;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataCleaner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PreDestroy
    public void cleanDatabase() {
        if (mongoTemplate == null) {
            System.out.println("MongoTemplate not initialised");
            return;
        }
        System.out.println("Cleaning data base...");
        Set<String> collections = mongoTemplate.getCollectionNames();
        for (String collectionName : collections) {
            mongoTemplate.dropCollection(collectionName);
        }
        System.out.println("Data base cleaned.");
    }

}
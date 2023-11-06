package com.event.app.service;

import com.event.app.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepo repository;

    @Autowired
    public CustomerService(CustomerRepo repository) {
        this.repository = repository;
    }
}

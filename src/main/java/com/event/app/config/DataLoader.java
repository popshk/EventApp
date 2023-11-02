package com.event.app.config;
import com.event.app.model.Customer;
import com.event.app.model.Event;
import com.event.app.repo.CustomerRepo;
import com.event.app.repo.EventRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DataLoader {
    private final CustomerRepo customerRepository;
    private final EventRepo eventRepository;

    @Autowired
    public DataLoader(CustomerRepo customerRepository, EventRepo eventRepository) {
        this.customerRepository = customerRepository;
        this.eventRepository = eventRepository;
    }


    @PostConstruct
    private void init() {
        customerRepository.insert(Customer.builder().nickName("Vadya").build());
        eventRepository.insert(Event.builder().name("jopa").build());
    }
}

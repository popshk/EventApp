package com.event.app.service;

import com.event.app.config.security.Role;
import com.event.app.model.Customer;
import com.event.app.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomerService implements UserDetailsService {

    private final CustomerRepo customerRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerService(CustomerRepo repository, PasswordEncoder passwordEncoder) {
        this.customerRepo = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveCustomer(final Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRoles(Collections.singleton(Role.USER));
        customerRepo.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByUsername(username);
        System.out.println("Loading user by username: " + username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return customer;
    }
}
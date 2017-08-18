package com.example.spring.repository;

import java.util.List;

import com.example.spring.model.Customer;

public interface CustomerRepository {

    void save(Customer c);

    List<Customer> list();
    
}

package com.codegym.service;

import com.codegym.model.Customer;

public interface ICustomerService {
    Iterable<Customer> findAll();


    Customer findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
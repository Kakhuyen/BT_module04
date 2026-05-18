package com.codegym.customermanagementthymeleaf.service;

import com.codegym.customermanagementthymeleaf.model.Customer;

import java.util.*;

public class CustomerService
        implements ICustomerService {

    private static final Map<Integer, Customer> customers;

    static {

        customers = new HashMap<>();

        customers.put(1,
                new Customer(
                        1,
                        "John",
                        "john@gmail.com",
                        "Ha Noi"));

        customers.put(2,
                new Customer(
                        2,
                        "Alex",
                        "alex@gmail.com",
                        "Sai Gon"));

        customers.put(3,
                new Customer(
                        3,
                        "Rose",
                        "rose@gmail.com",
                        "Da Nang"));
    }

    @Override
    public List<Customer> findAll() {

        return new ArrayList<>(customers.values());

    }

    @Override
    public void save(Customer customer) {

        customers.put(customer.getId(), customer);

    }

    @Override
    public Customer findById(int id) {

        return customers.get(id);

    }

    @Override
    public void update(int id, Customer customer) {

        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {

        customers.remove(id);

    }
}
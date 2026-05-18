package com.codegym.customermanagement.service.impl;

import com.codegym.customermanagement.model.Customer;
import com.codegym.customermanagement.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleCustomerServiceImpl
        implements CustomerService {

    private static Map<Long, Customer> customers;

    static {

        customers = new HashMap<>();

        customers.put(1L,
                new Customer(
                        1L,
                        "Nguyen Khac Nhat",
                        "nhat@codegym.vn",
                        "Ha Noi"));

        customers.put(2L,
                new Customer(
                        2L,
                        "Dang Huy Hoa",
                        "hoa.dang@codegym.vn",
                        "Da Nang"));

        customers.put(3L,
                new Customer(
                        3L,
                        "Le Thi Chau",
                        "chau.le@codegym.vn",
                        "Ha Noi"));
    }

    @Override
    public List<Customer> findAll() {

        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {

        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {

        customers.put(customer.getId(), customer);
    }
}
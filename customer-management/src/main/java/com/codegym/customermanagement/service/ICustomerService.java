package com.codegym.customermanagement.service;
import java.util.List;
import com.codegym.customermanagement.model.Customer;
public interface CustomerService {
    List<Customer>  findAll();
    Customer findById(int id);
}

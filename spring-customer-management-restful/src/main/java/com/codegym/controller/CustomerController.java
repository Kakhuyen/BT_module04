package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.findById(id);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        return ResponseEntity.ok(customerService.save(customer));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
        customerService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
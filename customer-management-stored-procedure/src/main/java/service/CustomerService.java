package service;

import model.Customer;
import repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        return customerRepository.saveWithStoredProcedure(customer);
    }
}
package service;

import model.Customer;

public interface ICustomerService {

    boolean saveWithStoredProcedure(Customer customer);
}
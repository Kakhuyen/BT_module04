package repository;

import model.Customer;

public interface ICustomerRepository {

    boolean saveWithStoredProcedure(Customer customer);
}
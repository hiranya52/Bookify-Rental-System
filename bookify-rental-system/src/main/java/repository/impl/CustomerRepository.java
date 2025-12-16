package repository.impl;

import model.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {

    public String getLastCustomerId() throws SQLException;
    public List<Customer> getAllCustomers() throws SQLException;
    public void addCustomer(Customer customer) throws SQLException;

}

package repository.impl;

import model.dto.CustomerDTO;
import model.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {

    public String getLastCustomerId() throws SQLException;
    public List<Customer> getAllCustomers() throws SQLException;
    public void addCustomer(Customer customer) throws SQLException;
    public Customer getCustomer(String phoneNo) throws SQLException;
    public void updateCustomer(String id, String title, String name, String phoneNo, String email) throws SQLException;

}

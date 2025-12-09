package service;

import model.dto.CustomerDTO;
import model.entity.Customer;
import repository.CustomerRepository;

import java.sql.SQLException;

public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public void addCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNo(),
                customerDTO.getEmail()
        );

        try {
            customerRepository.addCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

package service;

import model.dto.CustomerDTO;
import model.entity.Customer;
import repository.CustomerRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();


    public String getLastCustomerId(){

        try {
            return customerRepository.getLastCustomerId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<CustomerDTO> getAllCustomers(){

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        try {
            List<Customer> customerList = customerRepository.getAllCustomers();

            for(Customer customer : customerList){

                customerDTOS.add(
                        new CustomerDTO(
                                customer.getId(),
                                customer.getName(),
                                customer.getPhoneNo(),
                                customer.getEmail()
                        )
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerDTOS;

    }


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

package service;

import model.dto.CustomerDTO;
import model.entity.Customer;
import repository.CustomerRepositoryImpl;
import service.impl.CustomerService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();


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
                                customer.getTitle(),
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
                customerDTO.getTitle(),
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


    public CustomerDTO getCustomer(String phoneNo) {

        try {
            Customer customer =  customerRepository.getCustomer(phoneNo);

            return new CustomerDTO(
                    customer.getId(),
                    customer.getTitle(),
                    customer.getName(),
                    customer.getPhoneNo(),
                    customer.getEmail()
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

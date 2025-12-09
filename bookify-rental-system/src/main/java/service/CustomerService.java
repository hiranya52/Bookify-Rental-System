package service;

import model.dto.CustomerDTO;
import model.entity.Customer;
import repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public void addCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNo(),
                customerDTO.getEmail()
        );

        customerRepository.addCustomer(customer);

    }

}

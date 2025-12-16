package service.impl;

import model.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    public String getLastCustomerId();
    public ArrayList<CustomerDTO> getAllCustomers();
    public void addCustomer(CustomerDTO customerDTO);

}

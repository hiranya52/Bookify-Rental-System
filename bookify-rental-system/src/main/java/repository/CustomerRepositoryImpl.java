package repository;

import db.DBConnection;
import model.dto.CustomerDTO;
import model.entity.Customer;
import repository.impl.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository    {

    public String getLastCustomerId() throws SQLException {

        String lastId = null;

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT id FROM customers ORDER BY id DESC LIMIT 1";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getString(1);
        }

        return lastId;
    }


    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customerList = new ArrayList<>();

            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM Customers";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("contact"),
                        resultSet.getString("email")
                ));
            }
        return customerList;
    }


    public void addCustomer(Customer customer) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1, customer.getId());
        preparedStatement.setObject(2, customer.getTitle());
        preparedStatement.setObject(3, customer.getName());
        preparedStatement.setObject(4, customer.getPhoneNo());
        preparedStatement.setObject(5, customer.getEmail());

        preparedStatement.executeUpdate();

    }

    public Customer getCustomer(String phoneNo) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT * FROM customers WHERE contact = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setString(1,phoneNo);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return null;
    }


}

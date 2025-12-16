package repository;

import db.DBConnection;
import model.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public String getLastCustomerId() throws SQLException {

        String lastId = null;

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT customer_id FROM customers ORDER BY customer_id DESC LIMIT 1";

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
                        resultSet.getString("customer_id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                ));
            }
        return customerList;
    }


    public void addCustomer(Customer customer) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO customers VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1, customer.getId());
        preparedStatement.setObject(2, customer.getName());
        preparedStatement.setObject(3, customer.getPhoneNo());
        preparedStatement.setObject(4, customer.getEmail());

        preparedStatement.executeUpdate();

    }


}

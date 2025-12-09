package repository;

import db.DBConnection;
import model.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

package repository;

import db.DBConnection;
import model.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {

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

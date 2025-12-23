package repository;

import db.DBConnection;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl {


    public String getLastUserId() throws SQLException {

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


    public void addUser(User user) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,user.getId());
        preparedStatement.setObject(2,user.getName());
        preparedStatement.setObject(3,user.getContact());
        preparedStatement.setObject(4,user.getAddress());
        preparedStatement.setObject(5,user.getEmail());

        preparedStatement.executeUpdate();

    }




}

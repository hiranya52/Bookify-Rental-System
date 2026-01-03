package repository;

import db.DBConnection;
import model.entity.User;
import repository.impl.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

//----------------------Get Last User ID----------------------//
    public String getLastUserId() throws SQLException {

        String lastId = null;
        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT id FROM users ORDER BY id DESC LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getString(1);
        }

        return lastId;
    }

//----------------------Add User----------------------//
    public void addUser(User user) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,user.getId());
        preparedStatement.setObject(2,user.getTitle());
        preparedStatement.setObject(3,user.getName());
        preparedStatement.setObject(4,user.getContact());
        preparedStatement.setObject(5,user.getEmail());
        preparedStatement.setObject(6,user.getRole());

        preparedStatement.executeUpdate();

    }

//----------------------Get All Users----------------------//
    public List<User> getAllUsers() throws SQLException {

        List<User> users = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Select * From users";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            users.add(new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }
        return users;
    }

//----------------------Get User----------------------//
    @Override
    public User getUser(String phoneNo) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM users WHERE contact = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,phoneNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            return new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

//----------------------Update User----------------------//
    @Override
    public void updateUser(String id, String title, String name, String contact, String email, String role)  throws SQLException{

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "UPDATE users SET title = ?, name = ?, contact = ?, email = ?, role = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,title);
        preparedStatement.setObject(2,name);
        preparedStatement.setObject(3,contact);
        preparedStatement.setObject(4,email);
        preparedStatement.setObject(5,role);
        preparedStatement.setObject(6,id);

        preparedStatement.executeUpdate();

    }


}

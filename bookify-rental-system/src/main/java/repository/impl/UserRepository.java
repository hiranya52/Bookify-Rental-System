package repository.impl;

import model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    public String getLastUserId() throws SQLException;
    public void addUser(User user) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    User getUser(String phoneNo) throws SQLException;
}

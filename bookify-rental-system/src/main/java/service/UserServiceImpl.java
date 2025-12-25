package service;

import model.dto.UserDTO;
import model.entity.User;
import repository.UserRepositoryImpl;

import java.sql.SQLException;

public class UserServiceImpl {

    UserRepositoryImpl userRepository = new UserRepositoryImpl();


    public void addUser(UserDTO userDTO) {

        User user = new User(
                userDTO.getId(),
                userDTO.getTitle(),
                userDTO.getName(),
                userDTO.getContact(),
                userDTO.getEmail(),
                userDTO.getRole()
        );

        try {
            userRepository.addUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getLastUserId() {

        try {
            return userRepository.getLastUserId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

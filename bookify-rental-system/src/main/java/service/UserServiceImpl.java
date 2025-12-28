package service;

import model.dto.UserDTO;
import model.entity.User;
import repository.UserRepositoryImpl;
import service.impl.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

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

    public List<UserDTO> getAllUsers(){

        try {
            List<User> users = userRepository.getAllUsers();
            List<UserDTO> userDTOS = new ArrayList<>();

            for (User user : users){
                userDTOS.add(new UserDTO(
                        user.getId(),
                        user.getTitle(),
                        user.getName(),
                        user.getContact(),
                        user.getEmail(),
                        user.getRole()
                ));
            }
            return userDTOS;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}

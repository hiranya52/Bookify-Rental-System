package service;

import model.dto.UserDTO;
import model.entity.User;
import repository.UserRepositoryImpl;
import repository.impl.UserRepository;
import service.impl.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepositoryImpl();

//----------------------Add User----------------------//
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

//----------------------Get Last User ID----------------------//
    public String getLastUserId() {

        try {
            return userRepository.getLastUserId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//----------------------Get All Users----------------------//
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

//----------------------Get User----------------------//
    @Override
    public UserDTO getUser(String phoneNo) {

        try {
            User user = userRepository.getUser(phoneNo);

            return new UserDTO(
                    user.getId(),
                    user.getTitle(),
                    user.getName(),
                    user.getContact(),
                    user.getEmail(),
                    user.getRole()
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------Update User----------------------//
    @Override
    public void updateUser(String id, String title, String name, String contact, String email, String role) {

        try {
            userRepository.updateUser(id,title,name,contact,email,role);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

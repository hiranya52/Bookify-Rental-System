package service.impl;

import model.dto.UserDTO;
import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);
    String getLastUserId();
    List<UserDTO> getAllUsers();
    UserDTO getUser(String phoneNo);
    void updateUser(String id, String title, String name, String contact, String email, String role);
    void deleteUser(String id);

}

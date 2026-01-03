package service.impl;

import model.dto.UserDTO;
import java.util.List;

public interface UserService {

    public void addUser(UserDTO userDTO);
    public String getLastUserId();
    public List<UserDTO> getAllUsers();
    UserDTO getUser(String phoneNo);
}

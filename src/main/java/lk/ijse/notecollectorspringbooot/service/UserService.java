package lk.ijse.notecollectorspringbooot.service;


import lk.ijse.notecollectorspringbooot.dto.UserStatus;
import lk.ijse.notecollectorspringbooot.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser(String userId);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
}

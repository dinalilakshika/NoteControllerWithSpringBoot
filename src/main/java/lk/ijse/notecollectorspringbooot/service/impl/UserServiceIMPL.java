package lk.ijse.notecollectorspringbooot.service.impl;

import jakarta.transaction.Transactional;

import lk.ijse.notecollectorspringbooot.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.notecollectorspringbooot.dao.UserDao;
import lk.ijse.notecollectorspringbooot.dto.UserStatus;
import lk.ijse.notecollectorspringbooot.dto.impl.UserDTO;
import lk.ijse.notecollectorspringbooot.entity.impl.UserEntity;
import lk.ijse.notecollectorspringbooot.exception.DataPersistException;
import lk.ijse.notecollectorspringbooot.exception.UserNotFoundException;
import lk.ijse.notecollectorspringbooot.service.UserService;
import lk.ijse.notecollectorspringbooot.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser =
                userDao.save(mapping.toUserEntity(userDTO));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDTOList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDao.existsById(userId)){
            UserEntity selectedUser = userDao.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2, "User with id " + userId + " not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existedUser = userDao.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }

    @Override
    public UserDetailsService userDetailService() {
        return String userName ->
                userDao.findByEmail(userName)
                        .orElseThrow(() -> new UserNotFoundException("user with email " + userName + " not found"));
    }
}

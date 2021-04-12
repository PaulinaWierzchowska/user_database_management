package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
        userRepository.save(User.fromDTO(userDTO));
    }

    public UserDTO findUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(e -> e.toDTO())
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<UserDTO> allUsers() {
        return userRepository.findAll().stream()
                .map(e -> e.toDTO())
                .collect(Collectors.toList());
    }


}

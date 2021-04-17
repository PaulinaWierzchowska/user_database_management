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

    public List<UserDTO> findUserById(Integer userId) {
        if(userId!= null && userId!=0 ){
            return userRepository.findUserById(userId).stream()
                    .map(e -> e.toDTO())
                    .collect(Collectors.toList());
        } else {
            return allUsers();
        }
    }

    public List<UserDTO> findUsersByPharse(String userPharse) {
        if (userPharse!= null && !userPharse.isBlank()) {
            return userRepository.findUsersByPharse(userPharse).stream()
                    .map(e -> e.toDTO())
                    .collect(Collectors.toList());
        } else {
            return allUsers();
        }
    }

    public List<UserDTO> allUsers() {
        return userRepository.findAll().stream()
                .map(e -> e.toDTO())
                .collect(Collectors.toList());
    }


}

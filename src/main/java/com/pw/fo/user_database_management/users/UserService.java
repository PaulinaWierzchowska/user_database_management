package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO){
        userRepository.save(User.fromDTO(userDTO));
    }

}

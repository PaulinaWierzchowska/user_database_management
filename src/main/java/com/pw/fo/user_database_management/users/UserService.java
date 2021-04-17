package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> allUsers() {
        return userRepository.findAll().stream()
                .map(e -> e.toDTO())
                .collect(Collectors.toList());
    }

    public void addUser(UserDTO userDTO) {
        userRepository.save(User.fromDTO(userDTO));
    }

    public void editUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new UserNotFoundException(userDTO.getId()));
        user.apply(userDTO);
        userRepository.save(user);
    }

    public void removeUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new UserNotFoundException(userDTO.getId()));
        userRepository.delete(user);
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

    public UserDTO findUserDTOById(Integer userId) {
        return userRepository.findById(userId)
                .map(p -> p.toDTO())
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<UserDTO> findUsersByPhrase(String userPhrase) {
        if (userPhrase!= null && !userPhrase.isBlank()) {
            return userRepository.findUsersByPhrase(userPhrase).stream()
                    .map(e -> e.toDTO())
                    .collect(Collectors.toList());
        } else {
            return allUsers();
        }
    }

    public List<UserDTO> findUsersByNick(String userNick) {
        if (userNick!= null && !userNick.isBlank()) {
            return userRepository.findUsersByNick(userNick).stream()
                    .map(e -> e.toDTO())
                    .collect(Collectors.toList());
        } else {
            return allUsers();
        }
    }
}

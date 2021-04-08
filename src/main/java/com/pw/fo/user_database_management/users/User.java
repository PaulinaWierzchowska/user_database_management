package com.pw.fo.user_database_management.users;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private String nick;
    private String email;

    public static User fromDTO(UserDTO userDTO){
        User newUser = new User();
        newUser.firstName = userDTO.getFirstName();
        newUser.lastName = userDTO.getLastName();
        newUser.nick = userDTO.getNick();
        newUser.email = userDTO.getEmail();
        return newUser;
    }

}

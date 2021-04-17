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

    public User(String firstName, String lastName, String nick, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.email = email;
    }

    public User() {
    }

    public static User fromDTO(UserDTO userDTO){
        User newUser = new User();
        newUser.firstName = userDTO.getFirstName();
        newUser.lastName = userDTO.getLastName();
        newUser.nick = userDTO.getNick();
        newUser.email = userDTO.getEmail();
        return newUser;
    }

    public UserDTO toDTO() {
        return  new UserDTO(
                id,
                firstName,
                lastName,
                nick,
                email);
    }

    public void apply(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.nick = userDTO.getNick();
        this.email = userDTO.getEmail();
    }
}

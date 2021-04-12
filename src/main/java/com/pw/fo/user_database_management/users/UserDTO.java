package com.pw.fo.user_database_management.users;

public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String nick;
    private String email;

    public UserDTO(String firstName, String lastName, String nick, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.email = email;
    }
    public UserDTO(Integer id, String firstName, String lastName, String nick, String email) {
        this(firstName, lastName, nick, email);
        this.id = id;
    }

    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

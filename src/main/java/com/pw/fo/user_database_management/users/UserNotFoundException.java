package com.pw.fo.user_database_management.users;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer userId) {
        super("User with ID: " + userId + " not found");
    }
}

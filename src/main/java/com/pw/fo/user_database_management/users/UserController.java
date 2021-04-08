package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public String addUsers( @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String nick,
                            @RequestParam String email){
        userService.addUser(new UserDTO(firstName, lastName, nick,email));
        return "redirect:/users";
    }
}

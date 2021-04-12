package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/addUser")
    public String addUsers(){
        return "addUserPage";
    }

    @PostMapping(value = "/addUser")
    public String addUsers( @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String nick,
                            @RequestParam String email){
        userService.addUser(new UserDTO(firstName, lastName, nick,email));
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String usersList(Model model){
        model.addAttribute("usersList", userService.allUsers());
        return "usersPage";
    }

    @GetMapping("/userById")
    public String usersIdList(){
        return "findByIdPage";
    }

    @PostMapping("/userById")
    public String userFindById(Model model,
                               @RequestParam Integer userId){
        model.addAttribute("userById", userService.findUserById(userId));
        return "redirect:/userById";
    }
}

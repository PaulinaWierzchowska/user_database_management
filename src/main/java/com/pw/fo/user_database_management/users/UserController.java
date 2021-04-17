package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String usersIdList(Model model,
                              @RequestParam(required = false) Integer userId){
        model.addAttribute("userId", userId);
        model.addAttribute("usersByIdList", userService.findUserById(userId));
        return "findByIdPage";
    }

    @GetMapping("/userByPharse")
    public String usersPharseList(Model model,
                                  @RequestParam(required = false) String userPharse){
        model.addAttribute("userPharse", userPharse);
        model.addAttribute("usersByPharse", userService.findUsersByPharse(userPharse));
        return "findByPharsePage";
    }

}

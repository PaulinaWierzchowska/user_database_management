package com.pw.fo.user_database_management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String usersList(Model model){
        model.addAttribute("usersList", userService.allUsers());
        return "usersPage";
    }

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

    @GetMapping("/usersEdit")
    public String usersEditList(Model model,
                                @RequestParam(required = false) Integer userEditId){
        model.addAttribute("userId", userEditId);
        model.addAttribute("usersEditList", userService.allUsers());
        return "editUsersPage";
    }

    @GetMapping("/usersEdit/{id}")
    public String editForm(@PathVariable(name = "id") Integer userEditId, Model model){
        model.addAttribute("usersEdit", userService.findUserDTOById(userEditId));
        return "userEditPage";
    }

    @PostMapping("/usersEdit/{id}")
    public String editUser (@ModelAttribute UserDTO user, @PathVariable(name = "id") Integer userEditId){
        userService.editUser(user);
        return "redirect:/usersEdit";
    }

    @GetMapping("/usersRemove")
    public String usersRemoveList(Model model,
                                @RequestParam(required = false) Integer userRemoveId){
        model.addAttribute("userId", userRemoveId);
        model.addAttribute("usersRemoveList", userService.allUsers());
        return "usersRemovePage";
    }

    @GetMapping("/usersRemove/{id}")
    public String removeForm(@PathVariable(name = "id") Integer userRemoveId){
        userService.removeUser(userService.findUserDTOById(userRemoveId));
        return "redirect:/usersRemove";
    }

    @GetMapping("/userById")
    public String usersIdList(Model model,
                              @RequestParam(required = false) Integer userId){
        model.addAttribute("userId", userId);
        model.addAttribute("usersByIdList", userService.findUserById(userId));
        return "findByIdPage";
    }

    @GetMapping("/userByPhrase")
    public String usersPharseList(Model model,
                                  @RequestParam(required = false) String userPhrase){
        model.addAttribute("userPhrase", userPhrase);
        model.addAttribute("usersByPhraseList", userService.findUsersByPhrase(userPhrase));
        return "findByPhrasePage";
    }

    @GetMapping("/userByNick")
    public String usersNickList(Model model,
                                  @RequestParam(required = false) String userNick){
        model.addAttribute("userNick", userNick);
        model.addAttribute("usersByNickList", userService.findUsersByNick(userNick));
        return "findByNickPage";
    }



}

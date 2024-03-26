package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/people")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getListUser(Model model) {
        model.addAttribute("user", userService.getAll());
        return "all";
    }

    @GetMapping("/user")
    public String getUserPage(@ModelAttribute("user") User user, @RequestParam("id") Long id, Model model) {
        user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user";

    }

    @GetMapping("/new")
    public String getNewUserPage(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/people";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/people";
    }

    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
        userService.update(user, id);
        return "redirect:/people";
    }

}

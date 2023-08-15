package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {

  private final UserService userService;

  private static final String REDIRECT_MAIN_PAGE = "redirect:/";

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/")
  public String printWelcome(Model model) {
    model.addAttribute("users", userService.listUsers());
    return "index";
  }

  @GetMapping(value = "/adduser_form")
  public String printAddUser(Model model) {
    model.addAttribute("user", new User());
    return "add_user";
  }

  @GetMapping(value = "/update_user_form/{id}")
  public String printUpdateUser(Model model, @PathVariable("id") long id) {
    model.addAttribute("user", userService.getUserById(id));
    return "update_user";
  }

  @PostMapping(value = "/add_user")
  public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "redirect:/adduser_form";
    }

    userService.addUser(user);
    return REDIRECT_MAIN_PAGE;
  }

  @PatchMapping(value = "/update_user/{id}")
  public String updateUser(@ModelAttribute("user") User user) {
    userService.updateUser(user);
    return REDIRECT_MAIN_PAGE;
  }

  @DeleteMapping(value = "/remove_user/{id}")
  public String removeUser(@PathVariable("id") long id) {
    userService.removeUser(id);
    return REDIRECT_MAIN_PAGE;
  }
}

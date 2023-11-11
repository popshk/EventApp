package com.event.app.controller;

import com.event.app.model.User;
import com.event.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String AddPerson(@Valid User user,
                            BindingResult bindingResult,
                            Model model, @RequestParam("confirm-password") String confirmPassword) {
        boolean hasErrors = false;
        if (bindingResult.getFieldError("username") != null) {
            model.addAttribute("errorUsername", "User name can't be empty");
            hasErrors = true;
        }
        if (bindingResult.getFieldError("email") != null) {
            model.addAttribute("errorEmail", "Email is not valid or already exists");
            hasErrors = true;
        }
        final Optional<User> byEmail = userService.getUserByEmail(user.getEmail());
        if (byEmail.isPresent()) {
            model.addAttribute("errorEmail", "Email is not valid or already exists");
            hasErrors = true;
        }
        if (bindingResult.getFieldError("password") != null) {
            model.addAttribute("errorPassword", "Password can't be empty");
            hasErrors = true;
        }
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("errorPasswordConfirmation", "Passwords do not match");
            hasErrors = true;
        }
        if (hasErrors) {
            model.addAttribute("user", user);
            return "registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
}

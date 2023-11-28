package com.event.app.controller;

import com.event.app.model.User;
import com.event.app.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserInfo(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping
    public String saveProfileChanges(@ModelAttribute User updatedUser, @AuthenticationPrincipal User currentUser) {
        String username = StringUtils.isNotBlank(updatedUser.getUsername()) ? updatedUser.getUsername() : currentUser.getUsername();
        String email = StringUtils.isNotBlank(updatedUser.getEmail()) ? updatedUser.getEmail() : currentUser.getEmail();
        String firstName = StringUtils.isNotBlank(updatedUser.getFirstName()) ? updatedUser.getFirstName() : currentUser.getFirstName();
        String lastName = StringUtils.isNotBlank(updatedUser.getLastName()) ? updatedUser.getLastName() : currentUser.getLastName();
        userService.updateUserProfile(currentUser, username, email, firstName, lastName);
        return "redirect:/profile";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("confirm-password") String confirmPassword,
                                 @AuthenticationPrincipal User user) {
        userService.changePassword(currentPassword, newPassword, confirmPassword, user);
        return "redirect:/profile";
    }
}

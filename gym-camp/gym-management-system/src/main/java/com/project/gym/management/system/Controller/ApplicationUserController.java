package com.project.gym.management.system.Controller;

import com.project.gym.management.system.Models.ApplicationUser;
import com.project.gym.management.system.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;


@Controller
public class ApplicationUserController {


    @Autowired
    ApplicationUserRepository appUserRepository;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }


    @PostMapping("/signup")
    public RedirectView signUpUser(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "firstname") String firstName,
                                   @RequestParam(value = "lastname") String lastName,
                                   @RequestParam(value = "dob") String dob,
                                   @RequestParam(value = "bio") String bio) {
        ApplicationUser newAppUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName, dob, bio);
//        System.out.println(newAppUser.toString());
        appUserRepository.save(newAppUser);
        return new RedirectView("/login");
    }


    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/profile")
    public String getProfile(Model m, Principal principal) {
        try {
            ApplicationUser user = appUserRepository.findByUsername(principal.getName());
            m.addAttribute("user", user);
            return "profile";
        } catch (Exception e) {
            return "error";
        }
    }
}

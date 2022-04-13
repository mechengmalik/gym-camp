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
    public RedirectView signUpUser(Model model,
                                   @RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "firstname") String firstName,
                                   @RequestParam(value = "lastname") String lastName,
                                   @RequestParam(value = "dob") String dob,
                                   @RequestParam(value = "email") String email,
                                   @RequestParam(value = "type") String type) {
        ApplicationUser newAppUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName, dob, email, type);
//        System.out.println(newAppUser.toString());
        appUserRepository.save(newAppUser);
        model.addAttribute("user",newAppUser);
        return new RedirectView("/login");
    }


    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/profile")
    public String getProfile(Model m, Principal principal) {
        try {
            ApplicationUser profile = appUserRepository.findByUsername(principal.getName());
            m.addAttribute("profile", profile);
            return "profile";
        } catch (Exception e) {
            return "error";
        }
    }


    @GetMapping("/logout")
    public String logout() {

        return "index";
    }
}

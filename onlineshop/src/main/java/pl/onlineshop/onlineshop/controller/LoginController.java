package pl.onlineshop.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.onlineshop.onlineshop.entities.CustomUserDetails;
import pl.onlineshop.onlineshop.entities.Role;
import pl.onlineshop.onlineshop.entities.User;
import pl.onlineshop.onlineshop.repository.UserRepository;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/login")
    public String showLogin()
    {

            return "login";

    }


//    @PostMapping("/admin/login")
//    public String admin(@ModelAttribute("user") User user, Model model)
//    {
//        User adminUser= userRepository.findByEmail(user.getEmail());
//        System.out.println("Rola użytkownika: " + adminUser.getRole());
//        if(adminUser.getRole() == Role.ADMIN){
//            return "redirect:/admin";
//        }
//        else{
//            model.addAttribute("error", "Nieprawidłowe dane logowania lub brak uprawnień");
//            return "redirect:/";
//        }
//
//
//    }

    @GetMapping("/admin/login")
    public String viewAdmin(){
        return "admin_login";
    }

    @GetMapping("/admin")
    public String viewAdminPage(){
        return "admin";
    }
}

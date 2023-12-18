package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.onlineshop.onlineshop.entities.Role;
import pl.onlineshop.onlineshop.entities.User;
import pl.onlineshop.onlineshop.repository.UserRepository;

import java.util.List;

@Controller
public class AdminController {

    private UserRepository userRepository;
    @GetMapping("/admin")
    public String admin()
    {


        return "/admin";
    }
}

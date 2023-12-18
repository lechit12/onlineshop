package pl.onlineshop.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


//    @PostMapping("/loginForm")
//    public String admin(User user)
//    {
//        Optional<User> adminUser= userRepository.findByRole(Role.ADMIN);
//
//        if(user.getRole() == Role.ADMIN){
//            return "redirect:/admin";
//        }
//        else{
//            return "redirect:/";
//        }
//
//
//    }
    @GetMapping("/admin/login")
    public String viewAdmin(){
        return "admin_login";
    }
    @GetMapping("/admin/home")
    public String viewAdminPage(){
        return "admin";
    }
}

package pl.onlineshop.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.onlineshop.onlineshop.entities.User;
import pl.onlineshop.onlineshop.repository.UserRepository;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
@GetMapping("/rejestracja")
    public String showRegister(Model model)
{
    model.addAttribute("user",new User());

    return "rejestracja";
}

@PostMapping("/process_register")
    public String processRegistration(User user)
{
    userRepository.save(user);
    return "index";
}

}

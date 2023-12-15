package pl.onlineshop.onlineshop.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.onlineshop.onlineshop.repository.UserRepository;

@Controller
public class HomeController {
    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(RedirectAttributes redirectAttributes)
{
    redirectAttributes.addFlashAttribute("message", "Rejestracja udana! Możesz się teraz zalogować.");
    redirectAttributes.addFlashAttribute("messageType", "success");
    return "index";
}


}

package pl.onlineshop.onlineshop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.onlineshop.onlineshop.entities.Role;
import pl.onlineshop.onlineshop.entities.User;
import pl.onlineshop.onlineshop.repository.UserRepository;

import java.util.Optional;

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

//@PostMapping("/process_register")
//    public String processRegistration(User user)
//{
//    userRepository.save(user);
//    return "index";
//}
    @PostMapping("/rejestracjaForm")
    public String processRegistration(@ModelAttribute("user") @Valid User user,
                                      BindingResult result,BindingResult resultEmail,
                                      Model model)  {
        User existingUser=userRepository.findByEmail(user.getEmail());
        // Walidacja czy hasło i potwierdzenie hasła są takie same
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.user", "Hasło i potwierdzenie hasła nie są identyczne.");
        }

// nie dziala bledy walidacji
//        if (existingUser != null && existingUser.getRole() == Role.USER) {
//            resultEmail.rejectValue("email", "error.user", "Email już zajęty");
//        }
//        if (result.hasErrors() || resultEmail.hasErrors()) {
//            return "rejestracja"; // Zwróć do formularza rejestracji z komunikatem o błędzie
//        }
        user.setRole(Role.USER);
        userRepository.save(user);
        model.addAttribute("messageType", "success");
        model.addAttribute("message", "Rejestracja przebiegła pomyślnie. Możesz teraz się zalogować.");

        return "redirect:/?registered=true";
    }

}

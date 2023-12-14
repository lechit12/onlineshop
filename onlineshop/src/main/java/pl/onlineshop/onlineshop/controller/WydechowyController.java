package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WydechowyController {

    @GetMapping("/wydechowy")
    public String wydechowy() {
        return "wydechowy";
    }
}

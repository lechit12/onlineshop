package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/koszyk")
    public String cart()
    {
        return "koszyk";
    }
}

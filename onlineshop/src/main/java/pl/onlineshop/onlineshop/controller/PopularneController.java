package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PopularneController {


    @GetMapping("/popularne")
    public String home() {
        return "popularne";
    }
}

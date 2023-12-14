package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HamulcowyController {

    @GetMapping("/hamulcowy")
    public String hamulcowy()
    {
        return "hamulcowy";
    }
}

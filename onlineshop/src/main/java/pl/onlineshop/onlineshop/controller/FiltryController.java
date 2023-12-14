package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FiltryController {

    @GetMapping("/filtry")
    public String filtry()
    {
        return "filtry";
    }
}

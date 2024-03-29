package pl.onlineshop.onlineshop.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.onlineshop.onlineshop.entities.Item;
import pl.onlineshop.onlineshop.entities.User;
import pl.onlineshop.onlineshop.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HamulcowyController {
    private final ItemRepository itemRepository;

     static List<Item> items=new ArrayList<>();
     static {
//         items.add(new Item("Eventuri Audi S1 2.0tfsi Black Carbon Intake", new BigDecimal("23412.23"), "img"));
//         items.add(new Item("Eventuri Audi S1 2.0tfsi Black Carbon Intake", new BigDecimal("23412.23"), "img"));
//         items.add(new Item("Eventuri Audi S1 2.0tfsi Black Carbon Intake", new BigDecimal("23412.23"), "img"));
     }

    public HamulcowyController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/hamulcowy")
    public String hamulcowy( Model model)
    {
        //Item existingItem = itemRepository.findItemById(items.getId());
        //th:each="item: ${items}"
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "hamulcowy";
    }
}

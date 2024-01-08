package pl.onlineshop.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.onlineshop.onlineshop.entities.Item;
import pl.onlineshop.onlineshop.repository.ItemRepository;
import pl.onlineshop.onlineshop.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserRepository userRepository;
    private final ItemRepository itemRepository;

    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String admin()
    {
        return "admin";
    }
    @PostMapping
    private String addItem(Item item)
    {
        itemRepository.save(item);
        HamulcowyController.items.add(item);
        return "redirect:/hamulcowy";
    }
}

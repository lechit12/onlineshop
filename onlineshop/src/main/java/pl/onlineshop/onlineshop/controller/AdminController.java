package pl.onlineshop.onlineshop.controller;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.onlineshop.onlineshop.entities.Item;
import pl.onlineshop.onlineshop.repository.ItemRepository;
import pl.onlineshop.onlineshop.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserRepository userRepository;
    private final ItemRepository itemRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String admin(@RequestParam(name = "editing", required = false) Long editingId, Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);

        if (editingId != null) {
            Item itemToEdit = itemRepository.findItemById(editingId);
            model.addAttribute("editingItem", itemToEdit);
        }

        return "admin";
    }
    @PostMapping
    private String addItem(Item item)
    {
        itemRepository.save(item);
        HamulcowyController.items.add(item);
        return "redirect:/hamulcowy";
    }
    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        Item item = itemRepository.findItemById(id);
        model.addAttribute("item", item);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String processEditItem(@PathVariable Long id, @ModelAttribute Item editedItem) {
        Item item = itemRepository.findItemById(id);
        item.updateFields(editedItem.getName(), editedItem.getPrice(), editedItem.getImg());
        itemRepository.save(item);
        return "redirect:/admin";
    }
}

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
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
            Optional<Item> itemToEdit = itemRepository.findById(editingId);
            itemToEdit.ifPresent(item -> model.addAttribute("editingItem", item));
        }

        return "admin";
    }

    @PostMapping("/add")
    private String addItem(Item item) {
        itemRepository.save(item);
        return "redirect:/hamulcowy";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(value -> model.addAttribute("editingItem", value));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditItem(@PathVariable Long id, @ModelAttribute Item editedItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setName(editedItem.getName());
            item.setPrice(editedItem.getPrice());
            item.setImg(editedItem.getImg());

            itemRepository.save(item);

            return "redirect:/admin";
        } else {

            return "redirect:/admin";
        }
    }
}

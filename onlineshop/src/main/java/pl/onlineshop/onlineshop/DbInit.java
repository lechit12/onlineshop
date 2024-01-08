package pl.onlineshop.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.onlineshop.onlineshop.entities.Item;
import pl.onlineshop.onlineshop.repository.ItemRepository;
import pl.onlineshop.onlineshop.repository.UserRepository;

import java.math.BigDecimal;

@Configuration
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    @Autowired
    public DbInit(UserRepository userRepository, ItemRepository itemRepository)
    {
        this.userRepository=userRepository;
        this.itemRepository = itemRepository;
    }
    @Override
    public void run(String... args) throws Exception {
            //itemRepository.save(new Item("Eventuri Audi S1 2.0tfsi Black Carbon Intake",new BigDecimal("122.20"),"img"));


    }
}

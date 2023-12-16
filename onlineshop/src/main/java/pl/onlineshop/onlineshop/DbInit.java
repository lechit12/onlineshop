package pl.onlineshop.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.onlineshop.onlineshop.repository.UserRepository;

@Configuration
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    @Autowired
    public DbInit(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public void run(String... args) throws Exception {

    }
}

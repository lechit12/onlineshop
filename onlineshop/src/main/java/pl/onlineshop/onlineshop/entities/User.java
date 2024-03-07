package pl.onlineshop.onlineshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 64)
    private String password;
    @Column(unique = true,nullable = false,length = 45)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Transient
    private String confirmPassword;

    @Transient
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User(String name, String password,String email, Role role) {
        this.name = name;
        //this.password=password;
        setPassword(password);
        this.email = email;
        this.role = role;
    }
    public void setPassword(String rawPassword) {
        this.password = passwordEncoder.encode(rawPassword);
    }
}

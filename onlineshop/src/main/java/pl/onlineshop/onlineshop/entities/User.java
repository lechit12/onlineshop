package pl.onlineshop.onlineshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Enumerated
    private Gender gender;
    private String userna;

    public User(String name, String password,String email, Gender gender) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }
}

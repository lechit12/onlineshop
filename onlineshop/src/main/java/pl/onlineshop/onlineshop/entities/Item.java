package pl.onlineshop.onlineshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Getter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String img;


    public Item(String name, BigDecimal price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Item() {

    }
    public void updateFields(String name, BigDecimal price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }


    public void setId(Long id) {
        this.id = id;
    }


}

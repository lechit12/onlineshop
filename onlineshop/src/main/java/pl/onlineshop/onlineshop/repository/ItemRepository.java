package pl.onlineshop.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.onlineshop.onlineshop.entities.Item;

import java.math.BigDecimal;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}

package pl.onlineshop.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.onlineshop.onlineshop.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}

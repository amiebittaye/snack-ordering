package javaproject.snack.ordering.Repository;


import javaproject.snack.ordering.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
}


package javaproject.snack.ordering.Repository;



import javaproject.snack.ordering.Model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepository extends JpaRepository<Snack, Long> {

}


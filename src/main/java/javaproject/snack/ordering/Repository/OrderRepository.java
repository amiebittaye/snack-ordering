package javaproject.snack.ordering.Repository;


import javaproject.snack.ordering.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}

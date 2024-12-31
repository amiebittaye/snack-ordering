package javaproject.snack.ordering.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
        @ManyToOne
        @JoinColumn(name = "snack_id")
        private Snack snack;

        private int quantity;


        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public User getUser() { return user; }
        public void setUser(User user) { this.user = user; }
        public Snack getSnack() { return snack; }
        public void setSnack(Snack snack) { this.snack = snack; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }


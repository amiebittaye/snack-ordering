package javaproject.snack.ordering.Controller;


import javaproject.snack.ordering.Model.Order;
import javaproject.snack.ordering.Model.Snack;
import javaproject.snack.ordering.Model.User;
import javaproject.snack.ordering.Repository.SnackRepository;
import javaproject.snack.ordering.Repository.OrderRepository;
import javaproject.snack.ordering.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SnackRepository snackRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @GetMapping("/snacks")
    public List<Snack> getAllSnacks() {
        return snackRepository.findAll();
    }

    @PostMapping("/order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }
}

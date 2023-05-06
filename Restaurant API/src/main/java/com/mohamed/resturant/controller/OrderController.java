package com.mohamed.resturant.controller;

import com.mohamed.resturant.model.User;
import com.mohamed.resturant.service.imp.UserServiceImp;
import com.mohamed.resturant.service.interfaces.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private UserOrderService userOrderService;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> getOrdersForUser(@PathVariable int userId) {
        User user = userServiceImp.getUserById(userId);

        return new ResponseEntity<>(user.getOrders(), HttpStatus.OK);
    }

    @PostMapping("/add/user/{userId}")
    public ResponseEntity<?> addOrderForUser(@PathVariable int userId) {


        return new ResponseEntity<>(userOrderService.addOrderForUserByUserId(userId), HttpStatus.CREATED);
    }
}

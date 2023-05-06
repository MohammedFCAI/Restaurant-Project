package com.mohamed.resturant.controller;

import com.mohamed.resturant.model.User;
import com.mohamed.resturant.service.imp.LoginService;
import com.mohamed.resturant.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody User user) {
        return userService.addUser(user);
    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>("Deleted Success. ", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllThatHaveOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsersThatHaveOrders() {
        return userService.getAllUsersThatAreHaveAOrder();
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}

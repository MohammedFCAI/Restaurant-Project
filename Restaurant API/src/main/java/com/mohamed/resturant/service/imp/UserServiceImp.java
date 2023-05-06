package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Cart;
import com.mohamed.resturant.model.User;
import com.mohamed.resturant.repository.UserRepository;
import com.mohamed.resturant.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        user.setRole("USER");
        // Dependency Injection
        user.setCart(new Cart());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        checkIfUserIsExistOrThrowException(user.getId());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int userId) {
        checkIfUserIsExistOrThrowException(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public User getUserById(int userId) {

        return userRepository.findById(userId).orElseThrow(
                () -> new NoSuchElementException("There Are No User With Id = " + userId)
        );
    }

    @Override
    public void checkIfUserIsExistOrThrowException(int userId) {
        getUserById(userId);
    }

    @Override
    public List<User> getAllUsersThatAreHaveAOrder() {
        ArrayList<User> usersThatHaveOrders = new ArrayList<>();
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            if (user.getOrders() != null && user.getOrders().size() > 0) usersThatHaveOrders.add(user);
        }
        return usersThatHaveOrders;
    }
}

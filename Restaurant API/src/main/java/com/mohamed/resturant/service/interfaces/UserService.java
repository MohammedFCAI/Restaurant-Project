package com.mohamed.resturant.service.interfaces;

import com.mohamed.resturant.model.Cart;
import com.mohamed.resturant.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public interface UserService {

    public User addUser(User user);

    public User updateUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(int userId);

    public User getUserByEmailAndPassword(String email, String password);

    public User getUserById(int userId);

    public void checkIfUserIsExistOrThrowException(int userId);


    public List<User> getAllUsersThatAreHaveAOrder();

}

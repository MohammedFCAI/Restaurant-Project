package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Food;
import com.mohamed.resturant.model.Order;
import com.mohamed.resturant.model.User;
import com.mohamed.resturant.service.interfaces.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserOrderServiceImp implements UserOrderService {

    @Autowired
    private UserServiceImp userServiceImp;

    @Override
    public User addOrderForUserByUserId(int userId) {
        User user = userServiceImp.getUserById(userId);
        user.addOrder(getNewOrder(user));

        return userServiceImp.updateUser(user);
    }

    private List<Food> getFoodsThatAreInUserCart(User user) {
        return user.getCart().getFoods();
    }

    private Order getNewOrder(User user) {
        Order order = new Order();
        order.setFoods(getFoodsThatAreInUserCart(user));
        System.out.println(order.getFoods().size()+"*****************************************************");
        return order;
    }

}

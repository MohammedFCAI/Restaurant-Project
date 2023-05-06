package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Cart;
import com.mohamed.resturant.model.Food;
import com.mohamed.resturant.repository.CartRepository;
import com.mohamed.resturant.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCartById(int id) {

        return cartRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("There Are No Cart With Id = " + id)
        );
    }

    public void checkIfCartIsExistOrThrowException(int cartId) {
        getCartById(cartId);
    }

    public Cart deleteFoodFromCart(int foodId, Cart cart) {
        checkIfCartIsExistOrThrowException(cart.getId());
        List<Food> foods = cart.getFoods();
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getId() == foodId) {
                foods.remove(i);
                break;
            }
        }
        cart.setFoods(foods);
        return cart;
    }
    public void refreshCart(Cart cart){
        cart = new Cart();
    }
}

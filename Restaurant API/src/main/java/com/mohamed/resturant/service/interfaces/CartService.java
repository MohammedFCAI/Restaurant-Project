package com.mohamed.resturant.service.interfaces;

import com.mohamed.resturant.model.Cart;
import com.mohamed.resturant.model.Food;

import java.util.List;
import java.util.NoSuchElementException;

public interface CartService {

    public Cart updateCart(Cart cart);

    public Cart getCartById(int id) ;

    public void checkIfCartIsExistOrThrowException(int cartId);

    public Cart deleteFoodFromCart(int foodId, Cart cart) ;

    public void refreshCart(Cart cart);

}

package com.mohamed.resturant.controller;

import com.mohamed.resturant.model.Cart;
import com.mohamed.resturant.model.Food;
import com.mohamed.resturant.model.User;
import com.mohamed.resturant.service.imp.FoodService;
import com.mohamed.resturant.service.imp.UserServiceImp;
import com.mohamed.resturant.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/carts")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private FoodService foodService;


    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable int userId) {
        User user = userServiceImp.getUserById(userId);

        return new ResponseEntity<>(userServiceImp.getUserById(userId).getCart(), HttpStatus.OK);
    }

    @PostMapping("/addFood/{foodId}/toCart/{cartId}")
    public ResponseEntity<?> addFoodToCart(@PathVariable int foodId, @PathVariable int cartId) {
        Food food = foodService.getFoodById(foodId);
        Cart cart = cartService.getCartById(cartId);

        cart.addFood(food);
        return new ResponseEntity<>(cartService.updateCart(cart), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteFood/{foodId}/fromCart/{cartId}")
    public ResponseEntity<?> deleteFoodFromCart(@PathVariable int foodId, @PathVariable int cartId) {
        // check if food is exist or not
        Food food = foodService.getFoodById(foodId);

        Cart cart = cartService.getCartById(cartId);

        cartService.deleteFoodFromCart(foodId, cart);

        return new ResponseEntity<>(cartService.updateCart(cart), HttpStatus.ACCEPTED);
    }


}

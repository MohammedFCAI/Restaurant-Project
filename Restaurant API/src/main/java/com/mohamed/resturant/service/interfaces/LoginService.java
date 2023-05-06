package com.mohamed.resturant.service.interfaces;

import com.mohamed.resturant.model.User;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    public ResponseEntity<?> login(String email, String password);
}

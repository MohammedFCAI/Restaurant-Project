package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Person;
import com.mohamed.resturant.model.User;
import com.mohamed.resturant.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements com.mohamed.resturant.service.interfaces.LoginService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserServiceImp userServiceImp;

    @Override
    public ResponseEntity<?> login(String email, String password) {
        Person person = personRepository.findByEmailAndPassword(email, password).orElse(null);
        // There Are No Admin Or User In Our DB.
        if (person == null)
            return new ResponseEntity<>("Error In Email Or Password ", HttpStatus.NOT_FOUND);
            // This Email And Password For Admin In Our DB.
        else if (person.getRole().equals("ADMIN"))
            return new ResponseEntity<>(person, HttpStatus.ACCEPTED);

        // At The End This Email And Password Are For User In our DB.
        return new ResponseEntity<>(getUser(email, password), HttpStatus.ACCEPTED);
    }

    private User getUser(String email, String password) {
        return userServiceImp.getUserByEmailAndPassword(email, password);
    }
}

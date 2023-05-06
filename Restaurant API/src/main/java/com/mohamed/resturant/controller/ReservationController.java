package com.mohamed.resturant.controller;

import com.mohamed.resturant.model.Reservation;
import com.mohamed.resturant.service.imp.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Reservation> getAllReservation()
    {

        return reservationService.getAllReservation();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED  )
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<?> deleteReservationById(@PathVariable int reservationId ) {
    Reservation reservation = reservationService.getReservationById(reservationId);
        reservationService.deleteReservationById(reservationId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteReservationByIdWithRequestParam(@RequestParam int reservationId) {

        reservationService.deleteReservationById(reservationId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);
    }
}

package com.mohamed.resturant.service.interfaces;

import com.mohamed.resturant.model.Reservation;

import java.util.List;
import java.util.NoSuchElementException;

public interface ReservationService {

    public Reservation addReservation(Reservation reservation);

    public void deleteReservationById(int reservationId) ;

    public List<Reservation> getAllReservation();


    public Reservation getReservationById(int reservationId) ;
    public void checkIfReservationIsExistOrThrowException(int reservationId);
}

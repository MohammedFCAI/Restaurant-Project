package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Reservation;
import com.mohamed.resturant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService implements com.mohamed.resturant.service.interfaces.ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservationById(int reservationId) {
        checkIfReservationIsExistOrThrowException(reservationId);
        reservationRepository.deleteById(reservationId);
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }


    public Reservation getReservationById(int reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow(
                () -> new NoSuchElementException("There Are No Reservation With Id = " + reservationId)
        );
    }

    public void checkIfReservationIsExistOrThrowException(int reservationId) {
        getReservationById(reservationId);
    }
}

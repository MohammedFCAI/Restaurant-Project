package com.mohamed.resturant.repository;

import com.mohamed.resturant.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


}

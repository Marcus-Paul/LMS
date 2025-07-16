package com.lms.DAO;

import com.lms.TableClassess.Reservation;

import java.util.List;

public interface ReservationDAO {
    void createReservation(Reservation reservation);
    List<Reservation> getAllReservation();
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);

}

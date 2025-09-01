package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Reservation;

public interface ReservationDAO {
    void createReservation(int membershipId, int bookId);
    List<Reservation> getAllReservation();
    void updateReservation(int membershipId, int bookId, String status);
    void deleteReservation(int membershipId, int bookId);

}

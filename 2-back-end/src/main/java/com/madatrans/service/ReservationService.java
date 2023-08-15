package com.madatrans.service;

import com.madatrans.entity.Reservation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.madatrans.repository.ReservationDAO;

@Service
public class ReservationService {
    private ReservationDAO reservationDAO;

    public ReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public Reservation insert(Reservation toAdd) {
        try {
            this.reservationDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Reservation> findAll() {
        try {
            return this.reservationDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Reservation getById(int reservationId) {
        try {
            return this.reservationDAO.getById(reservationId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Reservation update(int reservationId, Reservation updatedReservation) {
        try {
            Reservation existingReservation = this.reservationDAO.getById(reservationId);

            if (updatedReservation.getReservationDate() != null) {
                existingReservation.setReservationDate(updatedReservation.getReservationDate());
            }
            if (updatedReservation.getClientId() != 0) {
                existingReservation.setClientId(updatedReservation.getClientId());
            }
            if (updatedReservation.getVoyageId() != 0) {
                existingReservation.setVoyageId(updatedReservation.getVoyageId());
            }

            this.reservationDAO.update(existingReservation);

            return existingReservation;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int reservationId) {
        try {
            this.reservationDAO.delete(reservationId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

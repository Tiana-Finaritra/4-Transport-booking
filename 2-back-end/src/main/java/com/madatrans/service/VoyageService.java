package com.madatrans.service;

import com.madatrans.entity.Voyage;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.madatrans.repository.VoyageDAO;

@Service
public class VoyageService {
    private VoyageDAO voyageDAO;

    public VoyageService(VoyageDAO voyageDAO) {
        this.voyageDAO = voyageDAO;
    }

    public Voyage insert(Voyage toAdd) {
        try {
            this.voyageDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Voyage> findAll() {
        try {
            return this.voyageDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Voyage getById(int voyageId) {
        try {
            return this.voyageDAO.getById(voyageId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Voyage update(int voyageId, Voyage updatedVoyage) {
        try {
            Voyage existingVoyage = this.voyageDAO.getById(voyageId);

            if (updatedVoyage.getDestination() != null) {
                existingVoyage.setDestination(updatedVoyage.getDestination());
            }
            if (updatedVoyage.getDepartureDate() != null) {
                existingVoyage.setDepartureDate(updatedVoyage.getDepartureDate());
            }
            if (updatedVoyage.getAvailableSeats() != 0) {
                existingVoyage.setAvailableSeats(updatedVoyage.getAvailableSeats());
            }
            if (updatedVoyage.getFare() != 0) {
                existingVoyage.setFare(updatedVoyage.getFare());
            }

            this.voyageDAO.update(existingVoyage);

            return existingVoyage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int voyageId) {
        try {
            this.voyageDAO.delete(voyageId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

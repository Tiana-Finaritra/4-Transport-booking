package com.madatrans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.madatrans.entity.Reservation;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    // insertion
    public void insert(Reservation toAdd) throws SQLException {
        String sql = "INSERT INTO reservation (reservation_date, client_id, voyage_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, toAdd.getReservationDate());
            preparedStatement.setInt(2, toAdd.getClientId());
            preparedStatement.setInt(3, toAdd.getVoyageId());

            preparedStatement.executeUpdate();
        }
    }

    // lecture de toutes les réservations
    public List<Reservation> findAll() throws SQLException {
        String sql = "SELECT * FROM reservation";

        List<Reservation> allReservations = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allReservations.add(new Reservation(
                        result.getInt("id"),
                        result.getTimestamp("reservation_date"),
                        result.getInt("client_id"),
                        result.getInt("voyage_id")));
            }
        }

        return allReservations;
    }

    // recherche par ID
    public Reservation getById(int reservationId) throws SQLException {
        String sql = "SELECT * FROM reservation WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reservationId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Reservation(
                            result.getInt("id"),
                            result.getTimestamp("reservation_date"),
                            result.getInt("client_id"),
                            result.getInt("voyage_id"));
                }
                return null; // Aucune réservation trouvée avec cet ID
            }
        }
    }

    // mise à jour
    public void update(Reservation updatedReservation) throws SQLException {
        String sql = "UPDATE reservation SET reservation_date = ?, client_id = ?, voyage_id = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, updatedReservation.getReservationDate());
            preparedStatement.setInt(2, updatedReservation.getClientId());
            preparedStatement.setInt(3, updatedReservation.getVoyageId());
            preparedStatement.setInt(4, updatedReservation.getId());

            preparedStatement.executeUpdate();
        }
    }

    // suppression
    public void delete(int reservationId) throws SQLException {
        String sql = "DELETE FROM reservation WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reservationId);
            preparedStatement.executeUpdate();
        }
    }
}

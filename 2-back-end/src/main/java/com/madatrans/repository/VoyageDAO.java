package com.madatrans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.madatrans.entity.Voyage;

public class VoyageDAO {
    // Dependance
    private Connection connection;

    public VoyageDAO(Connection connection) {
        this.connection = connection;
    }

    // insertion
    public void insert(Voyage toAdd) throws SQLException {
        String sql = "INSERT INTO voyage (destination, departure_date, available_seats, fare) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getDestination());
            preparedStatement.setTimestamp(2, toAdd.getDepartureDate());
            preparedStatement.setInt(3, toAdd.getAvailableSeats());
            preparedStatement.setFloat(4, toAdd.getFare());

            preparedStatement.executeUpdate();
        }
    }

    // lecture de tous les voyages
    public List<Voyage> findAll() throws SQLException {
        String sql = "SELECT * FROM voyage";

        List<Voyage> allVoyages = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allVoyages.add(new Voyage(
                        result.getInt("id"),
                        result.getString("destination"),
                        result.getTimestamp("departure_date"),
                        result.getInt("available_seats"),
                        result.getFloat("fare")));
            }
        }

        return allVoyages;
    }

    // recherche par ID
    public Voyage getById(int voyageId) throws SQLException {
        String sql = "SELECT * FROM voyage WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, voyageId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Voyage(
                            result.getInt("id"),
                            result.getString("destination"),
                            result.getTimestamp("departure_date"),
                            result.getInt("available_seats"),
                            result.getFloat("fare"));
                }
                return null; // Aucun voyage trouvé avec cet ID
            }
        }
    }

    // mise à jour
    public void update(Voyage updatedVoyage) throws SQLException {
        String sql = "UPDATE voyage SET destination = ?, departure_date = ?, available_seats = ?, fare = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedVoyage.getDestination());
            preparedStatement.setTimestamp(2, updatedVoyage.getDepartureDate());
            preparedStatement.setInt(3, updatedVoyage.getAvailableSeats());
            preparedStatement.setFloat(4, updatedVoyage.getFare());
            preparedStatement.setInt(5, updatedVoyage.getId());

            preparedStatement.executeUpdate();
        }
    }

    // suppression
    public void delete(int voyageId) throws SQLException {
        String sql = "DELETE FROM voyage WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, voyageId);
            preparedStatement.executeUpdate();
        }
    }
}

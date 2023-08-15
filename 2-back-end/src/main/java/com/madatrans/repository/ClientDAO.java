package com.madatrans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.madatrans.entity.Client;

public class ClientDAO {
    // Dependance
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    // insertion
    public void insert(Client toAdd) throws SQLException {
        String sql = "INSERT INTO client (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getFirstName());
            preparedStatement.setString(2, toAdd.getLastName());
            preparedStatement.setString(3, toAdd.getEmail());
            preparedStatement.setString(4, toAdd.getPhone());

            preparedStatement.executeUpdate();
        }
    }

    // reading
    public List<Client> findAll() throws SQLException {
        String sql = "SELECT * FROM client";

        List<Client> allClients = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allClients.add(new Client(
                        result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("phone")));
            }
        }

        return allClients;
    }

    // recherche par ID
    public Client getById(int clientId) throws SQLException {
        String sql = "SELECT * FROM client WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, clientId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Client(
                            result.getInt("id"),
                            result.getString("first_name"),
                            result.getString("last_name"),
                            result.getString("email"),
                            result.getString("phone"));
                }
                return null; // Aucun client trouvé avec cet ID
            }
        }
    }

    // mise à jour
    public void update(Client updatedClient) throws SQLException {
        String sql = "UPDATE client SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedClient.getFirstName());
            preparedStatement.setString(2, updatedClient.getLastName());
            preparedStatement.setString(3, updatedClient.getEmail());
            preparedStatement.setString(4, updatedClient.getPhone());
            preparedStatement.setInt(5, updatedClient.getId());

            preparedStatement.executeUpdate();
        }
    }

    // deleting
    public void delete(int clientId) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();
        }
    }

}

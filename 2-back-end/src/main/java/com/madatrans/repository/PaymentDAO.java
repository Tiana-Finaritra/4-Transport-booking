package com.madatrans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.madatrans.entity.Payment;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    // insertion
    public void insert(Payment toAdd) throws SQLException {
        String sql = "INSERT INTO payment (reservation_id, payment_date, amount, payment_status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toAdd.getReservationId());
            preparedStatement.setTimestamp(2, toAdd.getPaymentDate());
            preparedStatement.setFloat(3, toAdd.getAmount());
            preparedStatement.setString(4, toAdd.getPaymentStatus());

            preparedStatement.executeUpdate();
        }
    }

    // lecture de tous les paiements
    public List<Payment> findAll() throws SQLException {
        String sql = "SELECT * FROM payment";

        List<Payment> allPayments = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allPayments.add(new Payment(
                        result.getInt("id"),
                        result.getInt("reservation_id"),
                        result.getTimestamp("payment_date"),
                        result.getFloat("amount"),
                        result.getString("payment_status")));
            }
        }

        return allPayments;
    }

    // recherche par ID
    public Payment getById(int paymentId) throws SQLException {
        String sql = "SELECT * FROM payment WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, paymentId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Payment(
                            result.getInt("id"),
                            result.getInt("reservation_id"),
                            result.getTimestamp("payment_date"),
                            result.getFloat("amount"),
                            result.getString("payment_status"));
                }
                return null; // Aucun paiement trouvé avec cet ID
            }
        }
    }

    // mise à jour
    public void update(Payment updatedPayment) throws SQLException {
        String sql = "UPDATE payment SET reservation_id = ?, payment_date = ?, amount = ?, payment_status = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, updatedPayment.getReservationId());
            preparedStatement.setTimestamp(2, updatedPayment.getPaymentDate());
            preparedStatement.setFloat(3, updatedPayment.getAmount());
            preparedStatement.setString(4, updatedPayment.getPaymentStatus());
            preparedStatement.setInt(5, updatedPayment.getId());

            preparedStatement.executeUpdate();
        }
    }

    // suppression
    public void delete(int paymentId) throws SQLException {
        String sql = "DELETE FROM payment WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, paymentId);
            preparedStatement.executeUpdate();
        }
    }
}

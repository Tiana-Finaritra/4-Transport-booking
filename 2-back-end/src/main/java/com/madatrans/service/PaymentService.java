package com.madatrans.service;

import com.madatrans.entity.Payment;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.madatrans.repository.PaymentDAO;

@Service
public class PaymentService {
    private PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public Payment insert(Payment toAdd) {
        try {
            this.paymentDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Payment> findAll() {
        try {
            return this.paymentDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Payment getById(int paymentId) {
        try {
            return this.paymentDAO.getById(paymentId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Payment update(int paymentId, Payment updatedPayment) {
        try {
            Payment existingPayment = this.paymentDAO.getById(paymentId);

            if (updatedPayment.getReservationId() != 0) {
                existingPayment.setReservationId(updatedPayment.getReservationId());
            }
            if (updatedPayment.getPaymentDate() != null) {
                existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
            }
            if (updatedPayment.getAmount() != 0) {
                existingPayment.setAmount(updatedPayment.getAmount());
            }
            if (updatedPayment.getPaymentStatus() != null) {
                existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
            }

            this.paymentDAO.update(existingPayment);

            return existingPayment;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int paymentId) {
        try {
            this.paymentDAO.delete(paymentId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

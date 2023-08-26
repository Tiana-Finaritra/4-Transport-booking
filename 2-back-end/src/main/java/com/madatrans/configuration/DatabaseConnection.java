package com.madatrans.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import com.madatrans.repository.ClientDAO;
import com.madatrans.repository.ReservationDAO;
import com.madatrans.repository.VoyageDAO;
import com.madatrans.repository.PaymentDAO;

@Configuration
public class DatabaseConnection {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    // @Bean
    // public Connection getDatabaseConnection() throws SQLException {
    // String dbUrl = ManualEnv.DB_URL;
    // String dbUsername = ManualEnv.DB_USERNAME;
    // String dbPassword = ManualEnv.DB_PASSWORD;

    // return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    // }

    @Bean
    public ClientDAO clientDAO(Connection connection) {
        return new ClientDAO(connection);
    }

    @Bean
    public VoyageDAO voyageDAO(Connection connection) {
        return new VoyageDAO(connection);
    }

    @Bean
    public ReservationDAO reservationDAO(Connection connection) {
        return new ReservationDAO(connection);
    }

    @Bean
    public PaymentDAO paymentDAO(Connection connection) {
        return new PaymentDAO(connection);
    }
}

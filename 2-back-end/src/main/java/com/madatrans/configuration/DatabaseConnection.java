package com.madatrans.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import com.madatrans.controller.ClientController;
import com.madatrans.repository.ClientDAO;

@Configuration
public class DatabaseConnection {
    @Bean
    public Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/madatrans", "postgres", "12345678");
    }

    @Bean
    public ClientDAO clientDAO(Connection connection) {
        return new ClientDAO(connection);
    }
}
package com.madatrans.repositoryTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.madatrans.entity.Client;
import com.madatrans.repository.ClientDAO;

public class ClientDAOTest {

    public static void main(String[] args) {
        // Configure the database connection
        String jdbcUrl = "jdbc:postgresql://localhost/madatrans";
        String username = "postgres";
        String password = "12345678";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Create an instance of ClientDAO with the connection
            ClientDAO clientDAO = new ClientDAO(connection);

            // Call the findAll() method to get all clients
            List<Client> allClients = clientDAO.findAll();

            // Print the information of each client
            for (Client client : allClients) {
                System.out.println("Client: " + client);
            }
        } catch (Exception e) {
            System.out.println("Error during database connection or query execution");
            e.printStackTrace();
        }
    }
}
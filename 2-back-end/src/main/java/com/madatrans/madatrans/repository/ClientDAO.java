package com.madatrans.madatrans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.madatrans.madatrans.entity.Client;

public class ClientDAO {
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Client toAdd) {

    }

    public List<Client> findAll() {
        String sql = "SELECT * FROM client";

        List<Client> allClients = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allClients.add(new Client(
                        result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("phone")));
            }
        } catch (Exception e) {
            System.out.println("Erreur durant la connection a la base");
        }
        return null;

    }

}

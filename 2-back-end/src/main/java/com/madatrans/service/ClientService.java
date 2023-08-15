package com.madatrans.service;

import com.madatrans.entity.Client;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.madatrans.repository.ClientDAO;

@Service
public class ClientService {
    // Dependance
    private ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Client insert(Client toAdd) {
        try {
            this.clientDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Client> findAll() {
        try {
            return this.clientDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Client getById(int clientId) {
        try {
            return this.clientDAO.getById(clientId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Client update(int clientId, Client updatedClient) {
        try {
            // Récupérer le client existant
            Client existingClient = this.clientDAO.getById(clientId);

            // Mettre à jour les champs si le champ correspondant n'est pas null
            if (updatedClient.getFirstName() != null) {
                existingClient.setFirstName(updatedClient.getFirstName());
            }
            if (updatedClient.getLastName() != null) {
                existingClient.setLastName(updatedClient.getLastName());
            }
            if (updatedClient.getEmail() != null) {
                existingClient.setEmail(updatedClient.getEmail());
            }
            if (updatedClient.getPhone() != null) {
                existingClient.setPhone(updatedClient.getPhone());
            }

            this.clientDAO.update(existingClient);

            return existingClient;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int clientId) {
        try {
            this.clientDAO.delete(clientId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    

}

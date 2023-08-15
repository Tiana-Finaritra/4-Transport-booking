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

    public void update(Client updatedClient) {
        try {
            this.clientDAO.update(updatedClient);
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

package com.madatrans.controller;

import com.madatrans.repository.ClientDAO;
import com.madatrans.entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientDAO clientDAO;

    // Constructeur pour injecter manuellement ClientDAO
    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientDAO.findAll();
    }
}

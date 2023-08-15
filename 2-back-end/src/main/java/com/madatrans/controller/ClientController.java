package com.madatrans.controller;

import com.madatrans.repository.ClientDAO;
import com.madatrans.service.ClientService;
import com.madatrans.entity.Client;

import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    // Constructeur pour injecter manuellement ClientDAO
   
    public ClientController(ClientDAO clientDAO, ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.insert(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable int clientId) {
        return clientService.getById(clientId);
    }

    @PutMapping("/{clientId}")
    public void updateClient(@PathVariable int clientId, @RequestBody Client updatedClient) {
        updatedClient.setId(clientId);
        clientService.update(updatedClient);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable int clientId) {
        clientService.delete(clientId);
    }
    
}

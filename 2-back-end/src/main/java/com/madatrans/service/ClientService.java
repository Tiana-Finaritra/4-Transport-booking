// package com.madatrans.service;

// import com.madatrans.entity.Client;
// import com.madatrans.repository.ClientDAO;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class ClientService {

//     private final ClientDAO clientDAO;

//     @Autowired
//     public ClientService(ClientDAO clientDAO) {
//         this.clientDAO = clientDAO;
//     }

//     public List<Client> getAllClients() {
//         return clientDAO.findAll();
//     }

//     // Méthode de pagination
//     public List<Client> getClientsByPage(int pageNumber, int pageSize) {
//         // Calculer l'index de début pour la pagination
//         int startIndex = (pageNumber - 1) * pageSize;

//         // Récupérer les clients en fonction de la page et de la taille
//         return clientDAO.findClientsByPage(startIndex, pageSize);
//     }
// }

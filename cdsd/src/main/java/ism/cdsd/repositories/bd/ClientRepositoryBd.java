package ism.cdsd.repositories.bd;

import ism.cdsd.entities.Client;
import java.util.List;

public interface ClientRepositoryBd {
    // Méthode pour créer un client
    void createClient(Client client);

    // Méthode pour récupérer un client par ID
    Client findClientById(int id);

    // Méthode pour lister tous les clients
    List<Client> findAllClients();

    // Méthode pour mettre à jour un client
    void updateClient(Client client);

    // Méthode pour supprimer un client
    void deleteClient(int id);
}

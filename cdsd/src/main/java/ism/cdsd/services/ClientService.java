package ism.cdsd.services;

import ism.cdsd.entities.Client;
import java.util.List;

public interface ClientService {
    void createClient(Client client);
    void updateClient(Client client);
    void deleteClient(Long id);
    Client getClientById(Long id);
    List<Client> getAllClients();
}

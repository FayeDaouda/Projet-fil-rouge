package ism.cdsd.services.impl;

import ism.cdsd.entities.Client;
import ism.cdsd.repositories.bd.RepositoryBdImpl; // Importer la bonne classe
import ism.cdsd.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private RepositoryBdImpl clientRepository;

    // Constructeur qui prend un RepositoryBdImpl
    public ClientServiceImpl(RepositoryBdImpl clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(Client client) {
        clientRepository.createClient(client); // Appel de la méthode createClient de RepositoryBdImpl
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.updateClient(client); // Vous devez ajouter cette méthode dans RepositoryBdImpl
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(id); // Vous devez également ajouter cette méthode dans RepositoryBdImpl
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findClientById(id.intValue()); // Conversion de Long à int si nécessaire
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAllClients(); // Appel de la méthode findAllClients de RepositoryBdImpl
    }
}

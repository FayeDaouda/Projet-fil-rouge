package ism.cdsd.services.impl;

import ism.cdsd.entities.Client;
import ism.cdsd.repositories.ClientRepository;
import ism.cdsd.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    // Constructeur qui prend un ClientRepository
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.update(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

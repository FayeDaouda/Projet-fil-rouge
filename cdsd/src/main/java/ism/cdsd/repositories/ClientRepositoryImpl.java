package ism.cdsd.repositories;

import ism.cdsd.entities.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {
    private List<Client> clients = new ArrayList<>();

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public void update(Client client) {
        Client existingClient = findById(client.getId());
        if (existingClient != null) {
            existingClient.setSurname(client.getSurname());
            existingClient.setTelephone(client.getTelephone());
            existingClient.setAddress(client.getAddress());
        }
    }

    @Override
    public void delete(Long id) {
        clients.removeIf(client -> client.getId().equals(id));
    }

    @Override
    public Client findById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }
}

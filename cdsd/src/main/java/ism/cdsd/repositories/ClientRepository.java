package ism.cdsd.repositories;

import ism.cdsd.entities.Client;
import java.util.List;

public interface ClientRepository {
    void save(Client client);
    void update(Client client);
    void delete(Long id);
    Client findById(Long id);
    List<Client> findAll();
}

package ism.cdsd.services;

import ism.cdsd.entities.User;
import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user); // Ajouté ici
    void deleteUser(Long id); // Ajouté ici
    User getUserById(Long id);
    List<User> getAllUsers();
}

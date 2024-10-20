package ism.cdsd.repositories.bd;

import ism.cdsd.entities.User;
import java.util.List;

public interface UserRepositoryBd {
    // Méthode pour créer un utilisateur
    void createUser(User user);

    // Méthode pour récupérer un utilisateur par ID
    User findUserById(int id);

    // Méthode pour lister tous les utilisateurs
    List<User> findAllUsers();

    // Autres méthodes spécifiques à la gestion des utilisateurs peuvent être ajoutées ici
}

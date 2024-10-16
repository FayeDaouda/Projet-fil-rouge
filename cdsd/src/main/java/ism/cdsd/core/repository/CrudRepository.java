package ism.cdsd.core.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    T save(T entity); // Crée ou met à jour une entité
    Optional<T> findById(ID id); // Recherche une entité par son ID
    List<T> findAll(); // Retourne la liste de toutes les entités
    void deleteById(ID id); // Supprime une entité par son ID
    void delete(T entity); // Supprime une entité spécifique
}

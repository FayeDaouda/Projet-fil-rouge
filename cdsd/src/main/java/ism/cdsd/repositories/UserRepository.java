package ism.cdsd.repositories;

import ism.cdsd.entities.User;
import java.util.List;

public interface UserRepository {
    void save(User user);
    void update(User user);
    void delete(Long id);
    User findById(Long id);
    List<User> findAll();
}

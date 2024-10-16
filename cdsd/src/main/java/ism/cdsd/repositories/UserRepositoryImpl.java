package ism.cdsd.repositories;

import ism.cdsd.entities.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        User existingUser = findById(user.getId());
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setLogin(user.getLogin());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
        }
    }

    @Override
    public void delete(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}

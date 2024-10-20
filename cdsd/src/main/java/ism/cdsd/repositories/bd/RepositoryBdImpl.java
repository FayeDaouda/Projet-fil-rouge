package ism.cdsd.repositories.bd;

import ism.cdsd.PostgreSQLConnection;
import ism.cdsd.entities.Client;
import ism.cdsd.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryBdImpl implements ClientRepositoryBd, UserRepositoryBd {

    @Override
    public void createClient(Client client) {
        String query = "INSERT INTO clients (surname, telephone, address) VALUES (?, ?, ?)";

        try (Connection connection = PostgreSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, client.getSurname());
            preparedStatement.setString(2, client.getTelephone());
            preparedStatement.setString(3, client.getAddress());

            preparedStatement.executeUpdate();
            System.out.println("Client ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    @Override
    public Client findClientById(int id) {
        String query = "SELECT * FROM clients WHERE id = ?";
        Client client = null;

        try (Connection connection = PostgreSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("telephone"),
                        resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du client : " + e.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> findAllClients() {
        String query = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();

        try (Connection connection = PostgreSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("telephone"),
                        resultSet.getString("address")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }
        return clients;
    }

    @Override
    public void createUser(User user) {
        String query = "INSERT INTO users (email, login, password, role) VALUES (?, ?, ?, ?)";

        try (Connection connection = PostgreSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());

            preparedStatement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public User findUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection connection = PostgreSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = PostgreSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
        return users;
    }
    @Override
public void updateClient(Client client) {
    String query = "UPDATE clients SET surname = ?, telephone = ?, address = ? WHERE id = ?";

    try (Connection connection = PostgreSQLConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setString(1, client.getSurname());
        preparedStatement.setString(2, client.getTelephone());
        preparedStatement.setString(3, client.getAddress());
        preparedStatement.setLong(4, client.getId()); // Assurez-vous que la méthode getId() existe dans Client

        preparedStatement.executeUpdate();
        System.out.println("Client mis à jour avec succès !");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la mise à jour du client : " + e.getMessage());
    }
}

@Override
public void deleteClient(int id) {
    String query = "DELETE FROM clients WHERE id = ?";

    try (Connection connection = PostgreSQLConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Client supprimé avec succès !");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression du client : " + e.getMessage());
    }
}

    
}

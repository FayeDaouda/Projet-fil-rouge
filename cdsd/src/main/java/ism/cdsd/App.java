package ism.cdsd;

import ism.cdsd.entities.Client;
import ism.cdsd.entities.User;
import ism.cdsd.repositories.bd.RepositoryBdImpl; // Importer la bonne classe
import ism.cdsd.repositories.UserRepository; // Assurez-vous d'importer UserRepository
import ism.cdsd.repositories.UserRepositoryImpl; // Assurez-vous que UserRepositoryImpl est bien défini
import ism.cdsd.services.ClientService;
import ism.cdsd.services.UserService;
import ism.cdsd.services.impl.ClientServiceImpl;
import ism.cdsd.services.impl.UserServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Utiliser le RepositoryBdImpl pour les clients
        RepositoryBdImpl clientRepository = new RepositoryBdImpl();
        UserRepository userRepository = new UserRepositoryImpl(); // Assurez-vous que UserRepositoryImpl est bien défini

        // Passer clientRepository et userRepository aux services
        ClientService clientService = new ClientServiceImpl(clientRepository);
        UserService userService = new UserServiceImpl(userRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une option :");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Lister tous les clients");
            System.out.println("3. Ajouter un utilisateur");
            System.out.println("4. Lister tous les utilisateurs");
            System.out.println("5. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1: // Ajouter un client
                    try {
                        System.out.print("Nom du client : ");
                        String surname = scanner.nextLine();
                        System.out.print("Téléphone : ");
                        String phone = scanner.nextLine();
                        System.out.print("Adresse : ");
                        String address = scanner.nextLine();

                        // Assurez-vous que les champs ne sont pas vides
                        if (surname.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                            System.out.println("Tous les champs sont obligatoires !");
                            break;
                        }

                        Client client = new Client(null, surname, phone, address);
                        clientService.createClient(client);
                        System.out.println("Client ajouté avec succès !");
                    } catch (Exception e) {
                        System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
                    }
                    break;

                case 2: // Lister tous les clients
                    try {
                        clientService.getAllClients().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de la récupération des clients : " + e.getMessage());
                    }
                    break;

                case 3: // Ajouter un utilisateur
                    try {
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        System.out.print("Login : ");
                        String login = scanner.nextLine();
                        System.out.print("Mot de passe : ");
                        String password = scanner.nextLine();
                        System.out.print("Rôle (Boutiquier/Admin) : ");
                        String role = scanner.nextLine();

                        // Validation des champs
                        if (email.isEmpty() || login.isEmpty() || password.isEmpty() || role.isEmpty()) {
                            System.out.println("Tous les champs sont obligatoires !");
                            break;
                        }

                        User user = new User(null, email, login, password, role);
                        userService.createUser(user);
                        System.out.println("Utilisateur ajouté avec succès !");
                    } catch (Exception e) {
                        System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
                    }
                    break;

                case 4: // Lister tous les utilisateurs
                    try {
                        userService.getAllUsers().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
                    }
                    break;

                case 5: // Quitter
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix non valide. Réessayez.");
            }
        }
    }
}

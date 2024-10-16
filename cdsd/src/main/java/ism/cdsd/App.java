package ism.cdsd;

import ism.cdsd.entities.Client;
import ism.cdsd.entities.User;
import ism.cdsd.repositories.ClientRepository;
import ism.cdsd.repositories.ClientRepositoryImpl;
import ism.cdsd.repositories.UserRepository;
import ism.cdsd.repositories.UserRepositoryImpl;
import ism.cdsd.services.ClientService;
import ism.cdsd.services.UserService;
import ism.cdsd.services.impl.ClientServiceImpl;
import ism.cdsd.services.impl.UserServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();

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
                    System.out.print("Nom du client : ");
                    String surname = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String phone = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String address = scanner.nextLine();
                    Client client = new Client(null, surname, phone, address);
                    clientService.createClient(client);
                    break;

                case 2: // Lister tous les clients
                    clientService.getAllClients().forEach(System.out::println);
                    break;

                case 3: // Ajouter un utilisateur
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Login : ");
                    String login = scanner.nextLine();
                    System.out.print("Mot de passe : ");
                    String password = scanner.nextLine();
                    System.out.print("Rôle (Boutiquier/Admin) : ");
                    String role = scanner.nextLine();
                    User user = new User(null, email, login, password, role);
                    userService.createUser(user);
                    break;

                case 4: // Lister tous les utilisateurs
                    userService.getAllUsers().forEach(System.out::println);
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

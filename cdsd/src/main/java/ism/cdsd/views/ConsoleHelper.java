package ism.cdsd.views;

import java.util.Scanner;

public class ConsoleHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Méthode pour afficher un message
    public static void afficherMessage(String message) {
        System.out.println(message);
    }

    // Méthode pour lire une entrée de chaîne de caractères
    public static String lireTexte(String invite) {
        afficherMessage(invite);
        return scanner.nextLine();
    }

    // Méthode pour lire une entrée de nombre entier
    public static int lireEntier(String invite) {
        afficherMessage(invite);
        while (!scanner.hasNextInt()) {
            afficherMessage("Veuillez entrer un nombre valide.");
            scanner.next(); // Consomme l'entrée invalide
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la fin de ligne après l'entrée
        return valeur;
    }

    // Méthode pour lire une entrée de nombre long
    public static long lireLong(String invite) {
        afficherMessage(invite);
        while (!scanner.hasNextLong()) {
            afficherMessage("Veuillez entrer un nombre valide.");
            scanner.next(); // Consomme l'entrée invalide
        }
        long valeur = scanner.nextLong();
        scanner.nextLine(); // Pour consommer la fin de ligne après l'entrée
        return valeur;
    }
}

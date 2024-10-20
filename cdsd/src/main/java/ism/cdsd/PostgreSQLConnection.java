package ism.cdsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/javabbd";
    private static final String USER = "mon_utilisateur";
    private static final String PASSWORD = "votre_mot_de_passe";

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

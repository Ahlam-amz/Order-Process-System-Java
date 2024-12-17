package org.example.BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/DataMembre"; // Remplacez localhost si nécessaire
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            throw new RuntimeException("Impossible de se connecter à la base de données", e);
        }
    }
}

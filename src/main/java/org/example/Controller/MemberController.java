package org.example.Controller;
import org.example.BD.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import java.awt.*;

public class MemberController {
    @FXML
    private TextField textNom;

    @FXML
    private TextField textPrenom;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textPhone;

    @FXML
    private Button buttonInserer;

    // Méthode pour gérer le clic sur le bouton "Insérer"
    @FXML
    void handleInserer(ActionEvent event) throws SQLException {
        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String email = textEmail.getText();
        String phone = textPhone.getText();

        // Vérification des champs
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            showAlert(AlertType.WARNING, "Champs vides", "Veuillez remplir tous les champs !");
            return;
        }

        // Générer un identifiant unique
        String identifiant = UUID.randomUUID().toString();

        // Insérer les données dans la base
        if (insererMembreDansBD(identifiant, nom, prenom, email, phone)) {
            showAlert(AlertType.INFORMATION, "Succès", "Membre ajouté avec succès !");
            clearFields();
        } else {
            showAlert(AlertType.ERROR, "Erreur", "Une erreur s'est produite lors de l'insertion.");
        }
    }

   private boolean insererMembreDansBD(String identifiant, String nom, String prenom, String email, String phone) throws SQLException {
       String query= "INSERT INTO Membre (identifiant, nom, prenom, email, phone) VALUES (?,?,?,?,?)";

       try(Connection conn = DbConnection.getConnection();
           PreparedStatement pstmt= conn.prepareStatement(query)){

           pstmt.setString(1, identifiant);
           pstmt.setString(2, nom);
           pstmt.setString(3, prenom);
           pstmt.setString(4, email);
           pstmt.setString(5, phone);

           pstmt.executeUpdate();
           return true;
       }catch(SQLException e){
           e.printStackTrace();
           return false;
       }
   }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode pour vider les champs de texte
    private void clearFields() {
        textNom.clear();
        textPrenom.clear();
        textEmail.clear();
        textPhone.clear();
    }
}

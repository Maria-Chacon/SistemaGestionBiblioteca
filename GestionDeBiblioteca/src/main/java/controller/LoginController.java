/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Conexion.Conexion;
import com.mycompany.gestiondebiblioteca.App;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Verification;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023


public class LoginController implements Initializable {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonNewAccount;
    
    Verification verification;
    @FXML
    private PasswordField passwordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean autenticarUsuarioEnBaseDeDatos(String email, String password) {
        Conexion connection = new Conexion();
        try {
            connection.connect(); 

            
            PreparedStatement statement = connection.preparedStatement("SELECT * FROM tbl_users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery(); 

            return result.next(); 
        } catch (SQLException ex) {

            
            System.err.println("Error al autenticar al usuario: " + ex.getMessage());
            return false;
        } finally {
            connection.disconnect(); 
        }
    }

    private void mostrarMensajeDeError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR); 
        alert.setTitle("Error"); 
        alert.setHeaderText(null); 
        alert.setContentText(mensaje); 

        alert.showAndWait();
    }

    @FXML
    private void ActionNewAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonNewAccount.getScene().getWindow();
        stage.close();
        App.setRoot("register", 610, 391);
    }

    @FXML
    private void ActionLogin(ActionEvent event) throws IOException {
        String email = textFieldEmail.getText(); 
        String password = passwordField.getText(); 
        String userType = null;

        boolean isAuthenticated = autenticarUsuarioEnBaseDeDatos(email, password);

        if (isAuthenticated) {
            userType = getUserType(email);
            
            Verification.setId(email);
            Verification.setId(Verification.verifyUserAndGetUserName(email));
            System.out.println(Verification.getId());
            System.out.println(Verification.getName());

        }
        if (userType != null) {
            
            switch (userType) {
                case "ad":
                    {
                        Stage stage = (Stage) buttonLogin.getScene().getWindow();
                        stage.close();
                        App.setRoot("homeAdministrator", 712, 630);
                        break;
                    }
                case "us":
                    {
                        Stage stage = (Stage) buttonLogin.getScene().getWindow();
                        stage.close();
                        App.setRoot("home", 768, 624);
                        break;
                    }
                default:
                    mostrarMensajeDeError("Tipo de usuario desconocido.");
                    break;
            }
        } else {
            
            mostrarMensajeDeError("Credenciales inválidas. Verifica tu correo y contraseña.");
        }
    }

    private String getUserType(String email) {
        Conexion connection = new Conexion();
        try {
            connection.connect(); 

            
            PreparedStatement statement = connection.preparedStatement("SELECT type FROM tbl_users WHERE email = ?");
            statement.setString(1, email);

            ResultSet result = statement.executeQuery(); 

            if (result.next()) {
                return result.getString("type");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el tipo de usuario: " + ex.getMessage());
        } finally {
            connection.disconnect(); 
        }

        return null; 
    }

}

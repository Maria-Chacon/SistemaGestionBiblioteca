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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class LoginController implements Initializable {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonNewAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private boolean autenticarUsuarioEnBaseDeDatos(String email, String password) {
        Conexion connection = new Conexion();
        try {
            connection.conectar(); // Conecta a la base de datos

            // Crea una sentencia preparada con la consulta SQL para verificar las credenciales del usuario
            PreparedStatement statement = connection.preparedStatement("SELECT * FROM bd_user WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery(); // Ejecuta la consulta SQL

            return result.next(); // Si se encuentra un usuario con las credenciales, retorna true
        } catch (SQLException ex) {

            // Maneja las excepciones, por ejemplo, imprime el error
            System.err.println("Error al autenticar al usuario: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar(); // Desconecta de la base de datos
        }
    }

    @FXML
    private void mostrarMensajeDeError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR); // Crear una instancia de Alert con tipo ERROR
        alert.setTitle("Error"); // Establecer el título del mensaje de error
        alert.setHeaderText(null); // Dejar el encabezado en null (puedes personalizarlo si es necesario)
        alert.setContentText(mensaje); // Establecer el mensaje de error

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
        String email = textFieldEmail.getText(); // Obtener el correo electrónico ingresado
        String password = textFieldPassword.getText(); // Obtener la contraseña ingresada
        String userType = null;

        boolean isAuthenticated = autenticarUsuarioEnBaseDeDatos(email, password);

        if (isAuthenticated) {
            userType = getUserType(email);

        }
        if (userType != null) {
            // Verificar el tipo de usuario y abrir la ventana correspondiente
            switch (userType) {
                case "ad":
                    {
                        Stage stage = (Stage) buttonLogin.getScene().getWindow();
                        stage.close();
                        App.setRoot("homeAdministrator", 600, 400);
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
            // Si la autenticación falla o el tipo de usuario es nulo, mostrar un mensaje de error al usuario
            mostrarMensajeDeError("Credenciales inválidas. Verifica tu correo y contraseña.");
        }
    }

    private String getUserType(String email) {
        Conexion connection = new Conexion();
        try {
            connection.conectar(); // Conecta a la base de datos

            // Crea una sentencia preparada con la consulta SQL para obtener el tipo de usuario
            PreparedStatement statement = connection.preparedStatement("SELECT type FROM bd_user WHERE email = ?");
            statement.setString(1, email);

            ResultSet result = statement.executeQuery(); // Ejecuta la consulta SQL

            if (result.next()) {
                return result.getString("type");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el tipo de usuario: " + ex.getMessage());
        } finally {
            connection.desconectar(); // Desconecta de la base de datos
        }

        return null; // Si ocurre un error, retorna nulo
    }

}

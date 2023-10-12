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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Equipment;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class RegisterEquipmentController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private TextField textFieldQuantity;
    @FXML
    private Button btnRegister;
    @FXML
    private Button bntRegisterBooks;
    @FXML
    private Button bntRegisterEquipment;
    @FXML
    private Button btnRegisterUsers;
    @FXML
    private Button btnRegisterAuthor;
    @FXML
    private TextField textFieldDescription;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldDisponible;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("login", 768, 574);
    }

    @FXML
    private void ActionRegister(ActionEvent event) {
        Conexion connection = new Conexion();

        // Parse the quantity as an integer
        int quantity;
        try {
            quantity = Integer.parseInt(textFieldQuantity.getText());
        } catch (NumberFormatException e) {
            System.err.println("Error: Quantity must be a valid integer.");
            return;  // Stop processing if quantity is not a valid integer
        }

        String description = textFieldDescription.getText();
        String name = textFieldName.getText();
        // Parse availability as a boolean (assuming "true" or "false" as valid input)
        boolean availability;
        try {
            availability = Boolean.parseBoolean(textFieldDisponible.getText());
        } catch (NumberFormatException e) {
            System.err.println("Error: Availability must be 'true' or 'false'.");
            return;  // Stop processing if availability is not a valid boolean
        }

        Equipment newEquipment = new Equipment();
        newEquipment.setQuantity(quantity);
        newEquipment.setDescription(description);
        newEquipment.setName(name);
        newEquipment.setAvailability(availability);

        String insertUserQuery = "INSERT INTO tbl_equipments (quantity, description, name, availability) VALUES (?, ?, ?, ?)";

        try {
            connection.conectar();

            PreparedStatement statement = connection.preparedStatement(insertUserQuery);
            statement.setInt(1, newEquipment.getQuantity());
            statement.setString(2, newEquipment.getDescription());
            statement.setString(3, newEquipment.getName());
            statement.setBoolean(4, newEquipment.isAvailability());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Equipo registrado con éxito.");
            } else {
                System.out.println("Error al registrar el equipo.");
            }
        } catch (SQLException ex) {
            System.err.println("Error al insertar el equipo: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }
    }

    @FXML
    private void actionRegisterBooks(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("homeAdministrator", 768, 574);
    }

    @FXML
    private void actionRegisterEquipment(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("registerEquipment", 768, 574);
    }

    @FXML
    private void actionRegisterUsers(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("registerUser", 768, 574);
    }

    @FXML
    private void actionRegisterAuthors(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("registerAuthor", 768, 574);
    }

}

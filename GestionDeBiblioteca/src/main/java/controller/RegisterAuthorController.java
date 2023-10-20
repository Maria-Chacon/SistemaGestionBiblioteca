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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Author;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class RegisterAuthorController implements Initializable {

    @FXML
    private Button bntRegisterBooks;
    @FXML
    private Button bntRegisterEquipment;
    @FXML
    private Button btnRegisterUsers;
    @FXML
    private Button btnRegisterAuthor;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnRegister;
    @FXML
    private TextField textFieldIdentification;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldLastName;
    @FXML
    private TextField textFieldPhone;
    @FXML
    private DatePicker datePickerBirthDay;
    @FXML
    private Label labelUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionRegisterBooks(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("homeAdministrator", 712, 630);
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
        App.setRoot("registerAuthor", 712, 632);
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
        String name = textFieldName.getText();
        String lastName = textFieldLastName.getText();
        String identification = textFieldIdentification.getText();
        String phone = textFieldPhone.getText();
        LocalDate birthDay = datePickerBirthDay.getValue();

        java.sql.Date sqlBirthDay = java.sql.Date.valueOf(birthDay);

        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setLastName(lastName);
        newAuthor.setIdentification(identification);
        newAuthor.setPhone(phone);
        newAuthor.setBirthDay(sqlBirthDay); // Convierte LocalDate a java.sql.Date

        String insertUserQuery = "INSERT INTO tbl_authors (name, lastName, identification, birthDay, phone) VALUES (?, ?, ?, ?, ?)";

        try {
            connection.conectar();

            PreparedStatement statement = connection.preparedStatement(insertUserQuery);
            statement.setString(1, newAuthor.getName());
            statement.setString(2, newAuthor.getLastName());
            statement.setString(3, newAuthor.getIdentification());
            statement.setDate(4, new java.sql.Date(newAuthor.getBirthDay().getTime()));
            statement.setString(5, newAuthor.getPhone());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {

                showWarningMessage("Autor registrado con éxito.");
                textFieldName.setText("");
                textFieldLastName.setText("");
                textFieldIdentification.setText("");
                textFieldPhone.setText("");
            } else {

                showWarningMessage("Error al registrar el autor.");
            }
        } catch (SQLException ex) {

            System.err.println("Error al insertar el autor: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }
    }

    private void showWarningMessage(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

}

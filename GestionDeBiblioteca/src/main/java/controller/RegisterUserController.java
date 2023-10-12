/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Conexion.Conexion;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.User;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class RegisterUserController implements Initializable {

    @FXML
    private Button bntBookLoan;
    @FXML
    private Button bntEquipmentLoan;
    @FXML
    private Button btnSearchEquipment;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnRegister;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPassword;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void bookLoan(ActionEvent event) {
    }

    @FXML
    private void equipmentLoan(ActionEvent event) {
    }

    @FXML
    private void searchEquipment(ActionEvent event) {
    }

    @FXML
    private void close(ActionEvent event) {
    }

    @FXML
    private void ActionRegister(ActionEvent event) {
        Conexion connection = new Conexion();
        String name = textFieldName.getText();
        String lastName = textFieldLastName.getText();
        String email = textFieldEmail.getText();
        String password = textFieldPassword.getText();
        String identification = textFieldIdentification.getText();
        String phone = textFieldPhone.getText();
        LocalDate birthDay = datePickerBirthDay.getValue(); // Obtén la fecha de nacimiento
        
        java.sql.Date sqlBirthDay = java.sql.Date.valueOf(birthDay);

        // Determina el tipo de usuario (puedes tener tu propia lógica)
        String userType = "us"; // Por defecto, asumamos que es un usuario regular

      
        User newUser = new User();
        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setIdentification(identification);
        newUser.setPhone(phone);
        newUser.setBirthDay(sqlBirthDay); // Convierte LocalDate a java.sql.Date
        newUser.setType(userType);
        
        String insertUserQuery = "INSERT INTO bd_user (name, lastName, identification, birthDay, phone, email, password, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection.conectar(); // Conecta a la base de datos

            // Crea una sentencia preparada con la consulta SQL de inserción
            PreparedStatement statement = connection.preparedStatement(insertUserQuery);
            statement.setString(1, newUser.getName());
            statement.setString(2, newUser.getLastName());
            statement.setString(3, newUser.getIdentification());
            statement.setDate(4, new java.sql.Date(newUser.getBirthDay().getTime()));
            statement.setString(5, newUser.getPhone());
            statement.setString(6, newUser.getEmail());
            statement.setString(7, newUser.getPassword());
            statement.setString(8, newUser.getType());

            int rowsAffected = statement.executeUpdate(); // Ejecuta la consulta de inserción

            if (rowsAffected > 0) {
                
                System.out.println("Usuario registrado con éxito.");
            } else {
                
                System.out.println("Error al registrar el usuario.");
            }
        } catch (SQLException ex) {
            
            System.err.println("Error al insertar el usuario: " + ex.getMessage());
        } finally {
            connection.desconectar(); 
        }
    }

}

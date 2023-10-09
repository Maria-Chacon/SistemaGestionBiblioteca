/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import com.mycompany.gestiondebiblioteca.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonExistAccount;
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
    private void ActionExistingAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonExistAccount.getScene().getWindow();
        stage.close();
        App.setRoot("login", 600, 372);
    }
    
}

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class HomeAdministratorController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private TextField textFieldQuantity;
    @FXML
    private TextField textFieldGenre;
    @FXML
    private TextField textFieldTitle;
    @FXML
    private Button btnRegister;
    @FXML
    private ComboBox<?> ComboBoxAuthor;
    @FXML
    private Button bntRegisterBooks;
    @FXML
    private Button bntRegisterEquipment;
    @FXML
    private Button btnRegisterUsers;
    @FXML
    private Button btnRegisterAuthor;

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
    private void ActionRegister(ActionEvent event) throws IOException {
        
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

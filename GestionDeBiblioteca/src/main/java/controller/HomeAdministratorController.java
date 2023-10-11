/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class HomeAdministratorController implements Initializable {

    @FXML
    private Button bntBookLoan;
    @FXML
    private Button bntEquipmentLoan;
    @FXML
    private Button btnSearchEquipment;
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
    }
    
}

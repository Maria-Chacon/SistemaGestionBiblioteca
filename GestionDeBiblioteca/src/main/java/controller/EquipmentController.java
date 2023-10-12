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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class EquipmentController implements Initializable {

    @FXML
    private Button bntBookLoan;
    @FXML
    private Button bntEquipmentLoan;
    @FXML
    private Button btnSearchEquipment;
    @FXML
    private Button btnClose;
    @FXML
    private ComboBox<?> filter;
    @FXML
    private TextField name;
    @FXML
    private Button search;
    @FXML
    private TableView<?> searchBook;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> author;
    @FXML
    private TableColumn<?, ?> genre;
    @FXML
    private TableColumn<?, ?> quantity;
    @FXML
    private Button btnSearchBook;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void bookLoan(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("home", 760, 576);
    }

    @FXML
    private void equipmentLoan(ActionEvent event) {
    }

    @FXML
    private void searchEquipment(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSearchEquipment.getScene().getWindow();
        stage.close();
        App.setRoot("equipment", 600, 372);
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("login", 600, 372);
    }

    @FXML
    private void ActionSearch(ActionEvent event) {
    }

    @FXML
    private void searchBook(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSearchBook.getScene().getWindow();
        stage.close();
        App.setRoot("home", 768, 624);
    }

}

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class LogBookController implements Initializable {

    @FXML
    private Label labelUser;
    @FXML
    private Button bntLogBokk;
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
    private TableView<?> searchBook;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> idBookLoan;
    @FXML
    private TableColumn<?, ?> dateLoan;
    @FXML
    private TableColumn<?, ?> devolutionDate;
    @FXML
    private TableColumn<?, ?> identificationUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogBokk(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("logBook", 978, 642);
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
        App.setRoot("registerUser", 717, 631);
    }

    @FXML
    private void actionRegisterAuthors(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("registerAuthor", 717, 631);
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("login", 768, 574);
    }
    
}

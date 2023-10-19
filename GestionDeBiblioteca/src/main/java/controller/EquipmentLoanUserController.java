/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Conexion.Conexion;
import com.mycompany.gestiondebiblioteca.App;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.EquipmentLoan;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class EquipmentLoanUserController implements Initializable {

    @FXML
    private Button bntBookLoan;
    @FXML
    private Button bntEquipmentLoan;
    @FXML
    private Button btnSearchEquipment;
    @FXML
    private Button btnClose;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private Button btnSearchBook;
    @FXML
    private Button btnReturnEquipment;
    @FXML
    private TableColumn<?, ?> loanDate;
    @FXML
    private TableColumn<?, ?> devolutionDate;
    @FXML
    private TableView<EquipmentLoan> equipmentLoans;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConfigTableView();
    }

    private void ConfigTableView() {
        equipmentLoans.getColumns().clear();

        TableColumn<EquipmentLoan, String> titleCol = new TableColumn<>("Título");
        titleCol.setMinWidth(130);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<EquipmentLoan, Date> loanDateCol = new TableColumn<>("Fecha de Prestamo");
        loanDateCol.setMinWidth(118);
        loanDateCol.setCellValueFactory(new PropertyValueFactory<>("loanDate"));

        TableColumn<EquipmentLoan, Date> devolutionDateCol = new TableColumn<>("Fecha Devolucion");
        devolutionDateCol.setMinWidth(125);
        devolutionDateCol.setCellValueFactory(new PropertyValueFactory<>("devolutionDate"));

        equipmentLoans.getColumns().addAll(titleCol, loanDateCol, devolutionDateCol);

    }

    @FXML
    private void bookLoan(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("bookLoanUser", 768, 574);
    }

    @FXML
    private void equipmentLoan(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("equipmentLoanUser", 768, 574);
    }

    @FXML
    private void searchEquipment(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("equipment", 768, 574);
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("login", 600, 372);
    }

    @FXML
    private void searchBook(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("home", 768, 574);
    }

    @FXML
    private void actionReturnEquipment(ActionEvent event) {
    }

    public ObservableList<EquipmentLoan> getUserEquipmentLoans(String userIdentification) {
        ObservableList<EquipmentLoan> userLoans = FXCollections.observableArrayList();
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String query = "SELECT nameEquipment, loanDate, devolutionDate FROM tbl_equipmentLoan WHERE identificationUser = ?";
            PreparedStatement statement = connection.preparedStatement(query);
            statement.setString(1, userIdentification);

            ResultSet resultSet = statement.executeQuery();

//            processResults(resultSet, userLoans);
        } catch (SQLException ex) {
            System.err.println("Error al obtener préstamos del usuario: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return userLoans;
    }

//    private void processResults(ResultSet resultSet, ObservableList<EquipmentLoan> userLoans) throws SQLException {
//        if (resultSet.next()) {
//            EquipmentLoan loan = new EquipmentLoan();
//            loan.setNameEquipment(resultSet.getString("nameEquipment"));
//            loan.setLoanDate(resultSet.getDate("loanDate").toLocalDate());
//            loan.setDevolutionDate(resultSet.getDate("devolutionDate").toLocalDate());
//
//            userLoans.add(loan);
//
//            // Llamada recursiva para procesar el siguiente resultado
//            processResults(resultSet, userLoans);
//        }
//    }

}

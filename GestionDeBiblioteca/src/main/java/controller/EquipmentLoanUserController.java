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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.EquipmentLoan;
import model.User;
import model.Verification;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
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
    private TableColumn<EquipmentLoan, String> title;
    @FXML
    private Button btnSearchBook;
    @FXML
    private Button btnReturnEquipment;
    @FXML
    private TableColumn<EquipmentLoan, Date> loanDate;
    @FXML
    private TableColumn<EquipmentLoan, Date> devolutionDate;
    @FXML
    private TableView<EquipmentLoan> equipmentLoans;

    String identification = "";
    @FXML
    private Label labelUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        identification = User.getUserIdentificationByEmail(Verification.getId());

        equipmentLoans.setItems(getUserEquipmentLoans(identification));
        ConfigTableView();
    }

    private void ConfigTableView() {
        equipmentLoans.getColumns().clear();

        TableColumn<EquipmentLoan, String> titleCol = new TableColumn<>("Nombre");
        titleCol.setMinWidth(130);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("nameEquipment"));

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
        App.setRoot("equipment", 767, 640);
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
        EquipmentLoan selectedLoan = equipmentLoans.getSelectionModel().getSelectedItem();

        if (selectedLoan != null) {
            String equipmentName = selectedLoan.getNameEquipment();
            Date loanDate = (Date) selectedLoan.getLoanDate();
            Date returnedDate = new Date(System.currentTimeMillis());

            if (returnEquipmentToInventory(equipmentName) && deleteEquipmentLoan(identification, equipmentName, loanDate)) {
                if (saveEquipmentDevolution(identification, equipmentName, returnedDate)) {
                    equipmentLoans.getItems().remove(selectedLoan);
                } else {
                    System.err.println("Error al guardar el registro de devolución de equipo.");
                }
            } else {
                System.err.println("Error al devolver el equipo.");
            }
        }
    }

    private boolean returnEquipmentToInventory(String equipmentName) {
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String updateQuery = "UPDATE tbl_equipments SET quantity = quantity + 1 WHERE name = ?";
            PreparedStatement updateStatement = connection.preparedStatement(updateQuery);
            updateStatement.setString(1, equipmentName);

            int rowsAffected = updateStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar la cantidad de equipo: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar();
        }
    }

    private boolean deleteEquipmentLoan(String userIdentification, String equipmentName, Date loanDate) {
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String deleteQuery = "DELETE FROM tbl_equipmentLoan WHERE identificationUser = ? AND nameEquipment = ? AND loanDate = ?";
            PreparedStatement deleteStatement = connection.preparedStatement(deleteQuery);
            deleteStatement.setString(1, userIdentification);
            deleteStatement.setString(2, equipmentName);
            deleteStatement.setDate(3, loanDate);

            int rowsAffected = deleteStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar el préstamo de equipo: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar();
        }
    }

    private boolean saveEquipmentDevolution(String userIdentification, String equipmentName, Date returnedDate) {
        Conexion connection = new Conexion();

        String insertUserQuery = "INSERT INTO tbl_equipmentdevolution (returnedEquipment, returnedDate, identificationUser) VALUES (?, ?, ?)";

        try {
            connection.conectar();

            PreparedStatement statement = connection.preparedStatement(insertUserQuery);
            statement.setString(1, equipmentName);
            statement.setDate(2, returnedDate);
            statement.setString(3, userIdentification);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Equipo devuelto con éxito.");
                showMessage("Equipo devuelto con éxito.", "Éxito");
                return true;
            } else {
                System.out.println("Error al registrar la devolución del equipo.");
                showMessage("Error al registrar la devolución del equipo.", "Error");
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("Error al guardar el registro de devolución de equipo: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar();
        }
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

            processResults(resultSet, userLoans);
        } catch (SQLException ex) {
            System.err.println("Error al obtener préstamos del usuario: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return userLoans;
    }

    private void processResults(ResultSet resultSet, ObservableList<EquipmentLoan> userLoans) throws SQLException {
        if (resultSet.next()) {
            EquipmentLoan loan = new EquipmentLoan();
            loan.setNameEquipment(resultSet.getString("nameEquipment"));
            loan.setLoanDate(resultSet.getDate("loanDate"));
            loan.setDevolutionDate(resultSet.getDate("devolutionDate"));

            userLoans.add(loan);

            // Llamada recursiva para procesar el siguiente resultado
            processResults(resultSet, userLoans);
        }
    }
    
    private void showMessage(String message, String typeMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(typeMessage);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

}

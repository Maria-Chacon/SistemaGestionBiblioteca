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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Book;
import model.Equipment;
import model.EquipmentLoan;
import model.Person;
import model.User;
import model.Verification;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
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
    private ComboBox<String> filter;
    @FXML
    private Button search;
    @FXML
    private Button btnSearchBook;
    @FXML
    private TableView<Equipment> searchEquipment;
    @FXML
    private TableColumn<Equipment, String> description;
    @FXML
    private TableColumn<Equipment, Boolean> availability;
    @FXML
    private TableColumn<Equipment, String> idEquipment;
    @FXML
    private TableColumn<Equipment, Integer> quantity;
    @FXML
    private TableColumn<Equipment, String> name;
    @FXML
    private TextField nameSearch;
    @FXML
    private Button btnLoan;

    String userIdentification;
    @FXML
    private Label labelUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = FXCollections.observableArrayList(
                "Nombre",
                "Descripción"
        );
        filter.getItems().addAll(options);
        ConfigTableView();
        labelUser.setText(Verification.getName());

    }

    private void ConfigTableView() {
        searchEquipment.getColumns().clear();

        TableColumn<Equipment, Boolean> availabilityCol = new TableColumn<>("Disponible");
        availabilityCol.setMinWidth(88);
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));

        TableColumn<Equipment, String> nameCol = new TableColumn<>("Nombre");
        nameCol.setMinWidth(112);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Equipment, String> descriptionCol = new TableColumn<>("Descripción");
        descriptionCol.setMinWidth(132);
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Equipment, String> idEquipmentCol = new TableColumn<>("Id");
        idEquipmentCol.setMinWidth(72);
        idEquipmentCol.setCellValueFactory(new PropertyValueFactory<>("idEquipment"));

        TableColumn<Equipment, Integer> quantityCol = new TableColumn<>("Cantidad");
        quantityCol.setMinWidth(120);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        searchEquipment.getColumns().addAll(availabilityCol, nameCol, descriptionCol, idEquipmentCol, quantityCol);
    }

    @FXML
    private void bookLoan(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("bookLoanUser", 760, 576);
    }

    @FXML
    private void equipmentLoan(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("equipmentLoanUser", 760, 576);
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

    private void processResults(ResultSet resultSet, ObservableList<Equipment> searchResults) throws SQLException {

        // Si no hay más resultados, termina la recursión
        if (!resultSet.next()) {
            return;
        }

        Equipment equipment = new Equipment();
        equipment.setAvailability(resultSet.getBoolean("availability"));
        equipment.setQuantity(resultSet.getInt("quantity"));
        equipment.setDescription(resultSet.getString("description"));
        equipment.setIdEquipment(resultSet.getString("id"));
        equipment.setName(resultSet.getString("name"));

        searchResults.add(equipment);

        System.out.println("Quantity: " + quantity + ", Description: " + description
                + ", Name: " + name + ", Availability: " + availability);

        processResults(resultSet, searchResults);
    }

    @FXML
    private void searchBook(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("home", 768, 624);
    }

    @FXML
    private void ActionSearch(ActionEvent event) {
        String searchTerm = nameSearch.getText();
        String searchFilter = filter.getValue();

        String baseQuery = "SELECT * FROM tbl_equipments WHERE ";

        String searchQuery;
        if ("Nombre".equals(searchFilter)) {
            searchQuery = baseQuery + "name LIKE ?";
        } else if ("Descripción".equals(searchFilter)) {
            searchQuery = baseQuery + "description LIKE ?";
        } else {
            System.err.println("Invalid search filter.");
            return;
        }
        ObservableList<Equipment> searchResults = FXCollections.observableArrayList();

        Conexion connection = new Conexion();

        try {
            connection.connect();
//REVISAR

            PreparedStatement statement = connection.preparedStatement(searchQuery);
            statement.setString(1, "%" + searchTerm + "%");

            ResultSet resultSet = statement.executeQuery();

            processResults(resultSet, searchResults);
        } catch (SQLException ex) {
            System.err.println("Error al buscar equipos: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }

        searchEquipment.setItems(searchResults);
    }

    @FXML
    private void loan(ActionEvent event) {
        userIdentification = getUserIdentificationByEmail(Verification.getId());
        System.out.println("Identificación del usuario: " + userIdentification);
        Equipment selectedEquipment = searchEquipment.getSelectionModel().getSelectedItem();
        if (selectedEquipment == null) {
            System.err.println("No se seleccionó ningún equipo.");
            return;
        }

        int updatedQuantity = selectedEquipment.getQuantity() - 1;
        if (updatedQuantity < 0) {
            System.err.println("No hay suficiente cantidad disponible para el equipo seleccionado.");
            return;
        }

        Conexion connection = new Conexion();
        try {

            connection.connect();

            String updateQuery = "UPDATE tbl_equipments SET quantity = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.preparedStatement(updateQuery);
            updateStatement.setInt(1, updatedQuantity);
            updateStatement.setString(2, selectedEquipment.getIdEquipment());
            updateStatement.executeUpdate();

            LocalDate loanDate = LocalDate.now();
            LocalDate devolutionDate = loanDate.plusDays(7);

            java.sql.Date sqlLoanDate = java.sql.Date.valueOf(loanDate);
            java.sql.Date sqlDevolutionDate = java.sql.Date.valueOf(devolutionDate);

            String insertQuery = "INSERT INTO tbl_equipmentLoan (nameEquipment, devolutionDate, loanDate, penalty, identificationUser) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.preparedStatement(insertQuery);
            insertStatement.setString(1, selectedEquipment.getName());
            insertStatement.setDate(2, sqlDevolutionDate);
            insertStatement.setDate(3, sqlLoanDate);
            insertStatement.setString(4, "Sin penalización");

            insertStatement.setString(5, userIdentification);

            insertStatement.executeUpdate();

            searchEquipment.getItems().remove(selectedEquipment);

            System.out.println("Préstamo realizado con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error al realizar el préstamo: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }
    }

    private String getUserIdentificationByEmail(String email) {
        String userIdentification = "";

        Conexion connection = Conexion.getInstance();
        try {
            connection.connect();

            PreparedStatement statement = connection.preparedStatement("SELECT * FROM tbl_users WHERE email = ?");
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                userIdentification = result.getString("identification");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la identificación del usuario por correo electrónico: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }

        return userIdentification;
    }

}

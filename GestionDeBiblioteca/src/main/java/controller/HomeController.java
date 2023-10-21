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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Book;
import model.Equipment;
import model.Library;
import model.LogBook;
import static model.User.getUserIdentificationByEmail;
import model.Verification;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class HomeController implements Initializable {

    @FXML
    private TableColumn<Book, String> title;
    @FXML
    private TableColumn<Book, String> author;
    @FXML
    private TableColumn<Book, String> genre;
    @FXML
    private Button btnSearchEquipment;
    @FXML
    private Button btnClose;
    @FXML
    private TableView<Book> searchBook;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnLoan;
    @FXML
    private Button btnSearchBook;
    @FXML
    private ComboBox<String> filter;
    @FXML
    private TextField name;
    @FXML
    private TableColumn<Book, String> quantity;

    Library bookCatalog = new Library();
    @FXML
    private Button btnBookLoan;
    @FXML
    private Button btnEquipmentLoan;

    String userIdentification;
    @FXML
    private Label labelUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Autor",
                "Titulo",
                "Género"
        );
        filter.getItems().addAll(options);
        ConfigTableView();
        labelUser.setText(Verification.getName());
    }

    private void ConfigTableView() {
        searchBook.getColumns().clear();

        TableColumn<Book, String> titleCol = new TableColumn<>("Título");
        titleCol.setMinWidth(130);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorCol = new TableColumn<>("Autor");
        authorCol.setMinWidth(118);
        authorCol.setCellValueFactory(new PropertyValueFactory<>("nameAuthor"));

        TableColumn<Book, String> genreCol = new TableColumn<>("Género");
        genreCol.setMinWidth(125);
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Book, String> quantityCol = new TableColumn<>("Disponibilidad");
        quantityCol.setMinWidth(144);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        searchBook.getColumns().addAll(titleCol, authorCol, genreCol, quantityCol);

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
    private void search(ActionEvent event) {
        String searchTerm = name.getText();
        String selectedFilter = filter.getValue();

        if (selectedFilter != null && searchTerm != null && !searchTerm.isEmpty()) {
            ArrayList<Book> searchResults = bookCatalog.searchBooks(selectedFilter, searchTerm);
            ObservableList<Book> observableSearchResults = FXCollections.observableArrayList(searchResults);

            searchBook.setItems(observableSearchResults);
        }
    }

    @FXML
    private void loan(ActionEvent event) {
        userIdentification = getUserIdentificationByEmail(Verification.getId());
        System.out.println("Identificación del usuario: " + userIdentification);
        Book selectedBook = searchBook.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            System.err.println("No se seleccionó ningún libro.");
            return;
        }

        int updatedQuantity = Integer.parseInt(selectedBook.getQuantity()) - 1;
        if (updatedQuantity < 0) {
            System.err.println("No hay suficiente cantidad disponible para el libro seleccionado.");
            return;
        }

        Conexion connection = new Conexion();
        try {
            connection.connect();

            String updateQuery = "UPDATE tbl_books SET quantity = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.preparedStatement(updateQuery);
            updateStatement.setInt(1, updatedQuantity);
            updateStatement.setString(2, selectedBook.getIdBook());
            updateStatement.executeUpdate();

            LocalDate loanDate = LocalDate.now();
            LocalDate devolutionDate = loanDate.plusDays(7);

            java.sql.Date sqlLoanDate = java.sql.Date.valueOf(loanDate);
            java.sql.Date sqlDevolutionDate = java.sql.Date.valueOf(devolutionDate);

            String insertQuery = "INSERT INTO tbl_bookLoan (title, devolutionDate, loanDate, penalty, identificationUser) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.preparedStatement(insertQuery);
            insertStatement.setString(1, selectedBook.getTitle());
            insertStatement.setDate(2, sqlDevolutionDate);
            insertStatement.setDate(3, sqlLoanDate);
            insertStatement.setString(4, "Sin penalización");

            insertStatement.setString(5, userIdentification);

            insertStatement.executeUpdate();

            int bookLoanId = getLastBookLoanId(connection);

            if (bookLoanId != -1) {
                LogBook logBook = new LogBook(selectedBook, bookLoanId, sqlLoanDate, sqlDevolutionDate, userIdentification);
                LogBook.insertLogBookIntoDatabase(logBook);
            } else {
                System.err.println("No se pudo obtener el ID del último préstamo.");
            }

            searchBook.getItems().remove(selectedBook);

            showWarningMessage("Préstamo de libro realizado con éxito.");
            System.out.println("Préstamo de libro realizado con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error al realizar el préstamo: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }
    }

    @FXML
    private void searchBook(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("home", 768, 624);
    }

    private void showWarningMessage(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

    private int getLastBookLoanId(Conexion connection) {
        int bookLoanId = -1;

        try {
            String query = "SELECT id FROM tbl_bookLoan ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = connection.preparedStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                bookLoanId = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el ID del último préstamo: " + ex.getMessage());
        }

        return bookLoanId;
    }

}

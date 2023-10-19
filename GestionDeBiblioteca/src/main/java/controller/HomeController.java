/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import com.mycompany.gestiondebiblioteca.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Book;
import model.Equipment;
import model.Library;

/**
 * FXML Controller class
 *
 * @author monge
 */
public class HomeController implements Initializable {

    @FXML
    private TableColumn<Book, String> title;
    @FXML
    private TableColumn<Book, String> author;
    @FXML
    private TableColumn<Book, String> genre;
    @FXML
    private Button bntBookLoan;
    @FXML
    private Button bntEquipmentLoan;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Autor",
                "Titulo",
                "Genero"
        );
        filter.getItems().addAll(options);
        ConfigTableView();
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
        App.setRoot("equipment", 768, 574);
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
            searchBook.setItems(FXCollections.observableArrayList(searchResults));

        }

    }

    @FXML
    private void loan(ActionEvent event) {
    }

    @FXML
    private void searchBook(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("home", 768, 574);
    }

}

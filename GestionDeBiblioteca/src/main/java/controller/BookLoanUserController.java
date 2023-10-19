/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Conexion.Conexion;
import com.mycompany.gestiondebiblioteca.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.BookLoan;
import model.User;
import model.Verification;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class BookLoanUserController implements Initializable {

    @FXML
    private Button bntBookLoan;
    @FXML
    private Button bntEquipmentLoan;
    @FXML
    private Button btnSearchEquipment;
    @FXML
    private Button btnSearchEquipment1;
    @FXML
    private Button btnClose;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> author;
    @FXML
    private TableColumn<?, ?> genre;
    @FXML
    private Button btnReturnBook;
    String identification = "";
    @FXML
    private TableView<BookLoan> bookLoans;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        identification = User.getUserIdentificationByEmail(Verification.getId());

        bookLoans.setItems(getUserBookLoans(identification));
        ConfigTableView();
    }

    private void ConfigTableView() {
        bookLoans.getColumns().clear();

        TableColumn<BookLoan, String> titleCol = new TableColumn<>("Título");
        titleCol.setMinWidth(130);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<BookLoan, Date> loanDateCol = new TableColumn<>("Fecha de Préstamo");
        loanDateCol.setMinWidth(118);
        loanDateCol.setCellValueFactory(new PropertyValueFactory<>("loanDate"));

        TableColumn<BookLoan, Date> devolutionDateCol = new TableColumn<>("Fecha Devolución");
        devolutionDateCol.setMinWidth(125);
        devolutionDateCol.setCellValueFactory(new PropertyValueFactory<>("devolutionDate"));

        bookLoans.getColumns().addAll(titleCol, loanDateCol, devolutionDateCol);
    }

    public ObservableList<BookLoan> getUserBookLoans(String userIdentification) {
        ObservableList<BookLoan> userLoans = FXCollections.observableArrayList();
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String query = "SELECT title, loanDate, devolutionDate FROM tbl_bookloan WHERE identificationUser = ?";
            PreparedStatement statement = connection.preparedStatement(query);
            statement.setString(1, userIdentification);

            ResultSet resultSet = statement.executeQuery();

            processResults(resultSet, userLoans);
        } catch (SQLException ex) {
            System.err.println("Error al obtener préstamos de libros del usuario: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return userLoans;
    }

    private void processResults(ResultSet resultSet, ObservableList<BookLoan> userLoans) throws SQLException {
        if (resultSet.next()) {
            BookLoan loan = new BookLoan();
            loan.setTitle(resultSet.getString("title"));
            loan.setLoanDate(resultSet.getDate("loanDate"));
            loan.setDevolutionDate(resultSet.getDate("devolutionDate"));

            userLoans.add(loan);

            // Llamada recursiva para procesar el siguiente resultado
            processResults(resultSet, userLoans);
        }
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
    private void actionReturnBook(ActionEvent event) {
    }

}

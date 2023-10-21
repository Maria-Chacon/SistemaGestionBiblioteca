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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Book;
import model.BookLoan;
import model.LogBook;

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
    private TableColumn<LogBook, String> title;
    @FXML
    private TableColumn<LogBook, Integer> idBookLoan;
    @FXML
    private TableColumn<LogBook, Date> dateLoan;
    @FXML
    private TableColumn<LogBook, Date> devolutionDate;
    @FXML
    private TableColumn<LogBook, String> identificationUser;
    @FXML
    private TableView<LogBook> tableLogBook;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tableLogBook.setItems(getLogBook());
        ConfigTableView();
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

    private void ConfigTableView() {
        tableLogBook.getColumns().clear();

        TableColumn<LogBook, String> titleCol = new TableColumn<>("Nombre libro");
        titleCol.setMinWidth(101);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("book"));

        TableColumn<LogBook, Integer> idBookLoanCol = new TableColumn<>("ID Libro prestado");
        idBookLoanCol.setMinWidth(127);
        idBookLoanCol.setCellValueFactory(new PropertyValueFactory<>("bookLoan"));

        TableColumn<LogBook, Date> dateLoanCol = new TableColumn<>("Fecha de Prestamo");
        dateLoanCol.setMinWidth(133);
        dateLoanCol.setCellValueFactory(new PropertyValueFactory<>("registerDate"));

        TableColumn<LogBook, Date> devolutionDateCol = new TableColumn<>("Fecha de Devolución");
        devolutionDateCol.setMinWidth(145);
        devolutionDateCol.setCellValueFactory(new PropertyValueFactory<>("devolution"));

        TableColumn<LogBook, Date> identificationUserCol = new TableColumn<>("Identificación de Usuario");
        identificationUserCol.setMinWidth(184);
        identificationUserCol.setCellValueFactory(new PropertyValueFactory<>("identificationUser"));

        tableLogBook.getColumns().addAll(titleCol, idBookLoanCol, dateLoanCol, devolutionDateCol, identificationUserCol);
    }

    public ObservableList<LogBook> getLogBook() {
        ObservableList<LogBook> logBook = FXCollections.observableArrayList();
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String query = "SELECT * FROM tbl_logBook";
            PreparedStatement statement = connection.preparedStatement(query);

            ResultSet resultSet = statement.executeQuery();

            processResults(resultSet, logBook);
        } catch (SQLException ex) {
            System.err.println("Error al obtener Bitácora: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return logBook;
    }

    private void processResults(ResultSet resultSet, ObservableList<LogBook> logBook) throws SQLException {
        if (resultSet.next()) {
            LogBook log = new LogBook();
            log.setBookLoan(resultSet.getInt("idBookLoan"));
            log.setBook(new Book(resultSet.getString("title")));
            log.setRegisterDate(resultSet.getDate("loanDate"));
            log.setDevolution(resultSet.getDate("devolutionDate"));
            log.setIdentificationUser(resultSet.getString("identificationUser"));

            logBook.add(log);

            // Llamada recursiva para procesar el siguiente resultado
            processResults(resultSet, logBook);
        }
    }

}

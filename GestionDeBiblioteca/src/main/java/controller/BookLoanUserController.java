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
import javafx.scene.control.Label;
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
    @FXML
    private Label labelUser;

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
        BookLoan selectedLoan = bookLoans.getSelectionModel().getSelectedItem();

        if (selectedLoan != null) {
            String bookTitle = selectedLoan.getTitle();
            Date loanDate = (Date) selectedLoan.getLoanDate();
            Date returnedDate = new Date(System.currentTimeMillis());

            if (returnBookToInventory(bookTitle) && deleteBookLoan(identification, bookTitle, loanDate)) {
                if (saveBookDevolution(identification, bookTitle, returnedDate)) {
                    bookLoans.getItems().remove(selectedLoan);
                } else {
                    System.err.println("Error al guardar el registro de devolución del libro.");
                }
            } else {
                System.err.println("Error al devolver el libro.");
            }
        }
    }

    private boolean returnBookToInventory(String bookTitle) {
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String updateQuery = "UPDATE tbl_books SET quantity = quantity + 1 WHERE title = ?";
            PreparedStatement updateStatement = connection.preparedStatement(updateQuery);
            updateStatement.setString(1, bookTitle);

            int rowsAffected = updateStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar la cantidad de libros en inventario: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar();
        }
    }

    private boolean deleteBookLoan(String userIdentification, String bookTitle, Date loanDate) {
        Conexion connection = new Conexion();

        try {
            connection.conectar();

            String deleteQuery = "DELETE FROM tbl_bookloan WHERE identificationUser = ? AND title = ? AND loanDate = ?";
            PreparedStatement deleteStatement = connection.preparedStatement(deleteQuery);
            deleteStatement.setString(1, userIdentification);
            deleteStatement.setString(2, bookTitle);
            deleteStatement.setDate(3, loanDate);

            int rowsAffected = deleteStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar el préstamo de libro: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar();
        }
    }

    private boolean saveBookDevolution(String userIdentification, String bookTitle, Date returnedDate) {
        Conexion connection = new Conexion();

        String insertDevolutionQuery = "INSERT INTO tbl_bookdevolution (returnedBook, returnedDate, identificationUser) VALUES (?, ?, ?)";

        try {
            connection.conectar();

            PreparedStatement statement = connection.preparedStatement(insertDevolutionQuery);
            statement.setString(1, bookTitle);
            statement.setDate(2, returnedDate);
            statement.setString(3, userIdentification);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Libro devuelto con éxito.");
                return true;
            } else {
                System.err.println("Error al registrar la devolución del libro.");
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("Error al guardar el registro de devolución de libro: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar();
        }
    }

}

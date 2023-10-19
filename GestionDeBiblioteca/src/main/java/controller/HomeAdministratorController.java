package controller;

import com.mycompany.gestiondebiblioteca.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Author;
import model.Book;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class HomeAdministratorController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private TextField textFieldQuantity; // Cambiado a String
    @FXML
    private TextField textFieldGenre;
    @FXML
    private TextField textFieldTitle;
    @FXML
    private Button btnRegister;
    @FXML
    private ComboBox<Author> ComboBoxAuthor;
    @FXML
    private Button bntRegisterBooks;
    @FXML
    private Button bntRegisterEquipment;
    @FXML
    private Button btnRegisterUsers;
    @FXML
    private Button btnRegisterAuthor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Author> authors = Author.getAuthorsFromDatabase();
        ComboBoxAuthor.getItems().addAll(authors);
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("login", 768, 574);
    }

    @FXML
    private void ActionRegister(ActionEvent event) throws IOException {
        String quantity = textFieldQuantity.getText();
        String genre = textFieldGenre.getText();
        String title = textFieldTitle.getText();

        // Validación para evitar ingreso duplicado basado en el título
//        if (isBookDuplicate(title)) {
//            System.out.println("El libro con el título '" + title + "' ya está ingresado en la base de datos.");
//            return;
//        }

        Author selectedAuthor = ComboBoxAuthor.getValue();

        // Crear un nuevo objeto Book
        Book newBook = new Book(quantity, selectedAuthor.getName(), genre, "", "", title, "", "", "", "");

        // Insertar el libro en la base de datos
        Book.insertBookIntoDatabase(newBook);
        ArrayList<Book> booksFromDatabase = Book.getBooksFromDatabase();
        ArrayList<Book> sortedBooks = Book.sortBooksByTitle(booksFromDatabase);
        Book.updateBooksInDatabase(sortedBooks);
    }

    @FXML
    private void actionRegisterBooks(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("homeAdministrator", 768, 574);
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
        App.setRoot("registerUser", 768, 574);
    }

    @FXML
    private void actionRegisterAuthors(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        App.setRoot("registerAuthor", 768, 574);
    }

//    private boolean isBookDuplicate(String title) {
//        ArrayList<Book> booksFromDatabase = Book.getBooksFromDatabase();
//
//        // Utilizamos Java Streams para hacer la validación
//        return booksFromDatabase.stream()
//            .anyMatch(book -> book.getTitle().equalsIgnoreCase(title) && book.getNameAuthor().equalsIgnoreCase(book.getNameAuthor()));
//    }
}

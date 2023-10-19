/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author monge
 */
public class Library {

    private BookCatalog bookCatalog;
    private EquipmentCatalog equipmentCatalog;
    private ArrayList<LogBook> logBook;
    private ArrayList<User> users;

    public Library() {
        // Inicializa bookCatalog y otros campos si es necesario
        bookCatalog = new BookCatalog(); // Ejemplo de inicialización
        equipmentCatalog = new EquipmentCatalog(); // Ejemplo de inicialización
        logBook = new ArrayList<>(); // Ejemplo de inicialización
        users = new ArrayList<>(); // Ejemplo de inicialización
    }

    public Library(BookCatalog bookCatalog, EquipmentCatalog equipmentCatalog, ArrayList<LogBook> logBook, ArrayList<User> users) {
        this.bookCatalog = bookCatalog;
        this.equipmentCatalog = equipmentCatalog;
        this.logBook = logBook;
        this.users = users;
    }

    public BookCatalog getBookCatalog() {
        return bookCatalog;
    }

    public void setBookCatalog(BookCatalog bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public EquipmentCatalog getEquipmentCatalog() {
        return equipmentCatalog;
    }

    public void setEquipmentCatalog(EquipmentCatalog equipmentCatalog) {
        this.equipmentCatalog = equipmentCatalog;
    }

    public ArrayList<LogBook> getLogBook() {
        return logBook;
    }

    public void setLogBook(ArrayList<LogBook> logBook) {
        this.logBook = logBook;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void registerDevolution(Devolution devolution) {

    }

    public void registerBookLoan(BookLoan bookLoan) {

    }

    public void addUser(User user) {

    }

    public void removeUser(User user) {

    }

    public void updateUser(User user) {

    }

    public ArrayList<Book> searchBooks(String searchBy, String searchTerm) {
        ArrayList<Book> searchResults = new ArrayList<>();
        bookCatalog.loadBooksFromDatabase();

        if (bookCatalog != null) {
            // Ordena la lista de libros según el criterio de búsqueda
            if ("Autor".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getNameAuthor));
            } else if ("Género".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getGenre));
            } else if ("Título".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getTitle));
            }

            // Realiza la búsqueda binaria
            Book bookToSearch = new Book();
            bookToSearch.setTitle(searchTerm);
            int index = Collections.binarySearch(bookCatalog.getBooks(), bookToSearch, Comparator.comparing(Book::getTitle));

            if (index >= 0) {
                // Se encontró un libro con el título buscado
                searchResults.add(bookCatalog.getBooks().get(index));

                // Busca otros libros con el mismo título
                int leftIndex = index - 1;
                int rightIndex = index + 1;

                while (leftIndex >= 0 && searchBy.equals("Título") && bookCatalog.getBooks().get(leftIndex).getTitle().equalsIgnoreCase(searchTerm)) {
                    searchResults.add(bookCatalog.getBooks().get(leftIndex));
                    leftIndex--;
                }
                while (rightIndex < bookCatalog.getBooks().size() && searchBy.equals("Título") && bookCatalog.getBooks().get(rightIndex).getTitle().equalsIgnoreCase(searchTerm)) {
                    searchResults.add(bookCatalog.getBooks().get(rightIndex));
                    rightIndex++;
                }
            }
            else{
                System.out.println("Es nulo");
            }
        }

        return searchResults;
    }

    @Override
    public String toString() {
        return "Library{" + "bookCatalog=" + bookCatalog + ", equipmentCatalog=" + equipmentCatalog + ", logBook=" + logBook + ", users=" + users + '}';
    }

}

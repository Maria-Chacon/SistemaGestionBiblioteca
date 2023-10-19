/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
        System.out.println(searchBy);
        System.out.println(searchTerm);

        if (bookCatalog != null) {
            // Ordena la lista de libros según el criterio de búsqueda
            if ("Autor".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getNameAuthor));
            } else if ("Género".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getGenre));
            } else if ("Titulo".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getTitle));
            }

            // Realiza la búsqueda usando recursión
            recursiveSearch(bookCatalog.getBooks(), searchResults, searchBy, searchTerm, 0, bookCatalog.getBooks().size() - 1);
        }

        return searchResults;
    }

    private void recursiveSearch(List<Book> books, List<Book> searchResults, String searchBy, String searchTerm, int left, int right) {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;

        if (searchBy.equals("Titulo")) {
            System.out.println("entro en titulo");
            int titleComparison = books.get(mid).getTitle().compareToIgnoreCase(searchTerm);
            if (titleComparison == 0) {
                System.out.println("entro en if");
                searchResults.add(books.get(mid));
                // Busca en la izquierda y derecha
                System.out.println("entro en 1");
                recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);
                System.out.println("entro en 12");
                recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);
                System.out.println("entro en 13");
            } else if (titleComparison < 0) {
                System.out.println("entro en 2");
                recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);
                System.out.println("entro en 21");
            } else {
                System.out.println("entro en 3");
                recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);
                System.out.println("entro en 31");
            }
        } else {
            if ("Autor".equals(searchBy)) {
                System.out.println("entro en autor");
                int authorComparison = books.get(mid).getNameAuthor().compareToIgnoreCase(searchTerm);
                if (authorComparison == 0) {
                    System.out.println("entro en if");
                    searchResults.add(books.get(mid));
                    // Busca en la izquierda y derecha
                    recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);
                    recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);
                } else if (authorComparison < 0) {
                    recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);
                } else {
                    recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);
                }
            } else if ("Género".equals(searchBy)) {
                System.out.println("entro en genero");
                int genreComparison = books.get(mid).getGenre().compareToIgnoreCase(searchTerm);
                if (genreComparison == 0) {
                    searchResults.add(books.get(mid));
                    System.out.println("entro en if");
                }

                // Ahora, realiza la búsqueda en la parte izquierda y derecha
                recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);
                recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);
            }
        }
    }

    @Override
    public String toString() {
        return "Library{" + "bookCatalog=" + bookCatalog + ", equipmentCatalog=" + equipmentCatalog + ", logBook=" + logBook + ", users=" + users + '}';
    }

}

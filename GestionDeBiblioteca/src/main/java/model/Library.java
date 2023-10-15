/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
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

//    public static  ArrayList<Book> searchBooks(String searchBy, String searchTerm) {
//        ArrayList<Book> searchResults = new ArrayList<>();
//        
//        ArrayList<Book> sortedBooks = new ArrayList<>(bookCatalog.getBooks());
//
//        // Ordena la lista de libros según el criterio de búsqueda
//        if ("Autor".equals(searchBy)) {
//            sortedBooks.sort(Comparator.comparing(Book::getAuthor));
//        } else if ("Género".equals(searchBy)) {
//            sortedBooks.sort(Comparator.comparing(Book::getGenre));
//        } else if ("Título".equals(searchBy)) {
//            sortedBooks.sort(Comparator.comparing(Book::getTitle));
//        }
//
//        // Realiza la búsqueda binaria
//        int left = 0;
//        int right = sortedBooks.size() - 1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            Book book = sortedBooks.get(mid);
//
//            if (("Género".equals(searchBy) && book.getGenre().equalsIgnoreCase(searchTerm))
//                    || ("Título".equals(searchBy) && book.getTitle().equalsIgnoreCase(searchTerm))) {
//                searchResults.add(book);
//
//                // Busca otros libros con el mismo criterio
//                int leftIndex = mid - 1;
//                int rightIndex = mid + 1;
//
//                while (leftIndex >= 0 && searchBy.equals("Título") && book.getTitle().equalsIgnoreCase(sortedBooks.get(leftIndex).getTitle())) {
//                    searchResults.add(sortedBooks.get(leftIndex));
//                    leftIndex--;
//                }
//                while (rightIndex < sortedBooks.size() && searchBy.equals("Título") && book.getTitle().equalsIgnoreCase(sortedBooks.get(rightIndex).getTitle())) {
//                    searchResults.add(sortedBooks.get(rightIndex));
//                    rightIndex++;
//                }
//
//                return searchResults;
//            }
//
//            if (("Género".equals(searchBy) && book.getGenre().compareToIgnoreCase(searchTerm) < 0)
//                    || ("Título".equals(searchBy) && book.getTitle().compareToIgnoreCase(searchTerm) < 0)) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return searchResults;
//    }

    @Override
    public String toString() {
        return "Library{" + "bookCatalog=" + bookCatalog + ", equipmentCatalog=" + equipmentCatalog + ", logBook=" + logBook + ", users=" + users + '}';
    }

}

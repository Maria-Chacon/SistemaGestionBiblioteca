/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class Library {

    private BookCatalog bookCatalog;
    private EquipmentCatalog equipmentCatalog;
    private ArrayList<LogBook> logBook;
    private ArrayList<User> users;

    public Library() {

        bookCatalog = new BookCatalog();
        equipmentCatalog = new EquipmentCatalog();
        logBook = new ArrayList<>();
        users = new ArrayList<>();
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

    public ArrayList<Book> searchBooks(String searchBy, String searchTerm) {
        ArrayList<Book> searchResults = new ArrayList<>();
        bookCatalog.loadBooksFromDatabase();

        if (bookCatalog != null) {

            if ("Autor".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getNameAuthor));
            } else if ("Género".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getGenre));
            } else if ("Titulo".equals(searchBy)) {
                Collections.sort(bookCatalog.getBooks(), Comparator.comparing(Book::getTitle));
            }

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

            int titleComparison = books.get(mid).getTitle().compareToIgnoreCase(searchTerm);
            if (titleComparison == 0) {

                searchResults.add(books.get(mid));

                recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);

                recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);

            } else if (titleComparison < 0) {

                recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);

            } else {

                recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);

            }
        } else {
            if ("Autor".equals(searchBy)) {
                System.out.println("entro en autor");
                int authorComparison = books.get(mid).getNameAuthor().compareToIgnoreCase(searchTerm);
                if (authorComparison == 0) {

                    searchResults.add(books.get(mid));

                }

                recursiveSearch(books, searchResults, searchBy, searchTerm, left, mid - 1);
                recursiveSearch(books, searchResults, searchBy, searchTerm, mid + 1, right);
            } else if ("Género".equals(searchBy)) {

                int genreComparison = books.get(mid).getGenre().compareToIgnoreCase(searchTerm);
                if (genreComparison == 0) {
                    searchResults.add(books.get(mid));

                }
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class LibraryTest {

    public LibraryTest() {
    }
 @Test
    public void testGetAndSetBookCatalog() {
        Library library = new Library();
        BookCatalog testBookCatalog = new BookCatalog();
        library.setBookCatalog(testBookCatalog);

        BookCatalog bookCatalogFromLibrary = library.getBookCatalog();
        assertNotNull(bookCatalogFromLibrary);
        assertEquals(testBookCatalog, bookCatalogFromLibrary);
    }

    @Test
    public void testGetAndSetLogBook() {
        Library library = new Library();
        ArrayList<LogBook> testLogBook = new ArrayList<>();
        library.setLogBook(testLogBook);

        ArrayList<LogBook> logBookFromLibrary = library.getLogBook();
        assertNotNull(logBookFromLibrary);
        assertEquals(testLogBook, logBookFromLibrary);
    }

    @Test
    public void testGetAndSetUsers() {
        Library library = new Library();
        ArrayList<User> testUsers = new ArrayList<>();
        library.setUsers(testUsers);

        ArrayList<User> usersFromLibrary = library.getUsers();
        assertNotNull(usersFromLibrary);
        assertEquals(testUsers, usersFromLibrary);
    }

    @Test
    public void testSearchBooks() {
        Library library = new Library();
        BookCatalog bookCatalog = new BookCatalog();
        ArrayList<Book> testBooks = new ArrayList<>();
        
        testBooks.add(new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml"));
        testBooks.add(new Book("5", "Author 2", "Genre 2", "loaned", "B2", "Book 2", "repro", "publ", "url", "perml"));
        testBooks.add(new Book("5", "Author 3", "Genre 3", "loaned", "B3", "Book 3", "repro", "publ", "url", "perml"));
        bookCatalog.setBooks(testBooks);
        library.setBookCatalog(bookCatalog);

        
        ArrayList<Book> searchResults = library.searchBooks("Titulo", "Book 1");
        assertEquals(0, searchResults.size());

        
        searchResults = library.searchBooks("Autor", "Author 2");
        assertEquals(0, searchResults.size());

        
        searchResults = library.searchBooks("Género", "Genre 1");
        assertEquals(0, searchResults.size());
    }
}
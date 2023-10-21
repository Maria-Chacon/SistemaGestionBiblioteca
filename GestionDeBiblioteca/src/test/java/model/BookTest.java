/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class BookTest {

    public BookTest() {
    }

    @Test
    public void testIsLoaned() {
        Book instance = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        String expResult = "loaned";
        String result = instance.getLoaned();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetQuantity() {
        Book instance = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        int expResult = 5;
        int result = Integer.parseInt(instance.getQuantity());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAuthor() {
        Book instance = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        String expResult = "Author 1";
        String result = instance.getNameAuthor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenre() {
        Book instance = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        String expResult = "Genre 1";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdBook() {
        Book instance = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        String expResult = "B1";
        String result = instance.getIdBook();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTitle() {
        Book instance = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        String expResult = "Book 1";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBooksFromDatabase() {
        ArrayList<Book> books = Book.getBooksFromDatabase();
        assertTrue(books.size() > 0);
    }

    @Test
    public void testInsertBookIntoDatabase() {
        Book book = new Book("10", "Author X", "Genre Y", "not loaned", "B2", "Book 2", "repro", "publ", "url", "perml");
        Book.insertBookIntoDatabase(book);

    }
    @Test
    public void testSortBooksByTitle() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("1", "Author 1", "Genre 1", "not loaned", "B1", "Book B", "repro", "publ", "url", "perml"));
        books.add(new Book("2", "Author 2", "Genre 2", "not loaned", "B2", "Book A", "repro", "publ", "url", "perml"));
        books.add(new Book("3", "Author 3", "Genre 3", "not loaned", "B3", "Book C", "repro", "publ", "url", "perml"));
        
        ArrayList<Book> sortedBooks = Book.sortBooksByTitle(books);
        
        assertEquals("Book A", sortedBooks.get(0).getTitle());
        assertEquals("Book B", sortedBooks.get(1).getTitle());
        assertEquals("Book C", sortedBooks.get(2).getTitle());
    }
    
}

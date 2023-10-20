/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class BookCatalogTest {
    
    public BookCatalogTest() {
    }

private ArrayList<Book> books;
    private BookCatalog catalog;

    @Before
    public void setUp() {
     
        books = new ArrayList<>();
        books.add(new Book("5", "Author 1", "Genre 1","s", "B1", "Book 1","repro","publ","url","perml"));
        books.add(new Book("6", "Author 2", "Genre 2","s", "B2", "Book 2","repro","publ","url","perml"));
        books.add(new Book("4", "Author 3", "Genre 3","s", "B3", "Book 3","repro","publ","url","perml"));
        
        catalog = new BookCatalog(books);
    }

    @Test
    public void testGetBooks() {
        ArrayList<Book> catalogBooks = catalog.getBooks();
        assertEquals(3, catalogBooks.size());
        
        assertEquals(books, catalogBooks);
    }

    
}

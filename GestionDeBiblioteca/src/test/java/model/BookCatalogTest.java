/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author monge
 */
public class BookCatalogTest {
    
    public BookCatalogTest() {
    }

private ArrayList<Book> books;
    private BookCatalog catalog;

    @Before
    public void setUp() {
     
        books = new ArrayList<>();
        books.add(new Book(true, 2, "author1", "genero1", "1", "title1"));
        books.add(new Book(false, 5, "author2", "genero2", "2", "title2"));
        books.add(new Book(true, 3, "author3", "genero3", "3", "title3"));
        
        catalog = new BookCatalog(books);
    }

    @Test
    public void testGetBooks() {
        ArrayList<Book> catalogBooks = catalog.getBooks();
        assertEquals(3, catalogBooks.size());
        
        assertEquals(books, catalogBooks);
    }

    
}

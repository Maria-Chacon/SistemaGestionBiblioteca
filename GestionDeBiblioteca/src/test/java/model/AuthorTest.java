/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class AuthorTest {
    
    public AuthorTest() {
    }

    @Test
    public void testGetBooks() {
        Book book1 = new Book(false, 5, "Author 1", "Genre 1", "B1", "Book 1");
        Book book2 = new Book(true, 3, "Author 2", "Genre 2", "B2", "Book 2");

        
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        
        Author author = new Author(books, 1,new Date(), "123456789", "De Cervantes", "Miguel", "123456789");

        
        ArrayList<Book> resultBooks = author.getBooks();

        assertEquals(books, resultBooks);
    }
    
}

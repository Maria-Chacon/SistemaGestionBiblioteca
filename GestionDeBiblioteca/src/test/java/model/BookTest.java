/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monge
 */
public class BookTest {
    
    public BookTest() {
    }

    @Test
    public void testIsLoaned() {
        System.out.println("isLoaned");
        boolean loan = true;
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");
        boolean expResult = true;
        boolean result = instance.isLoaned();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetLoaned() {
        System.out.println("setLoaned");
        boolean loaned = false;
        Book instance = null;
        instance.setLoaned(loaned);
    }

    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Book instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        Book instance = null;
        instance.setQuantity(quantity);
    }

    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = null;
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        Book instance = null;
        instance.setAuthor(author);
    }

    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        Book instance = null;
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        String genre = "";
        Book instance = null;
        instance.setGenre(genre);
    }

    @Test
    public void testGetIdBook() {
        System.out.println("getIdBook");
        Book instance = null;
        String expResult = "";
        String result = instance.getIdBook();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetIdBook() {
        System.out.println("setIdBook");
        String idBook = "";
        Book instance = null;
        instance.setIdBook(idBook);
    }

    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Book instance = null;
        instance.setTitle(title);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Book instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
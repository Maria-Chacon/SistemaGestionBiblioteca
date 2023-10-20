/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

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
}
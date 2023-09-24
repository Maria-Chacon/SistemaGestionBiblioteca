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
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");
        boolean expResult = true;
        boolean result = instance.isLoaned();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        int expResult = 5;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        String expResult = "Dayana";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        String expResult = "Miedo";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetIdBook() {
        System.out.println("getIdBook");
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        String expResult = "1";
        String result = instance.getIdBook();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");
        String expResult = "oscuridad";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    
}
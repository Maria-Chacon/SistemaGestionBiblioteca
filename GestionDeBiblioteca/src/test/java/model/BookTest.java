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
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");
        boolean expResult = true;
        boolean result = instance.isLoaned();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetQuantity() {
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        int expResult = 5;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetAuthor() {
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        String expResult = "Dayana";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetGenre() {
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        String expResult = "Miedo";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetIdBook() {
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");;
        String expResult = "1";
        String result = instance.getIdBook();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTitle() {
        Book instance = new Book(true, 5, "Dayana", "Miedo","1","oscuridad");
        String expResult = "oscuridad";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    
}
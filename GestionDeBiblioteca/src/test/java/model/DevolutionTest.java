/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author monge
 */
public class DevolutionTest {
    
    public DevolutionTest() {
    }

private Devolution devolution;

    @Before
    public void setUp() {
        
        Book book = new Book(true, 3, "author3", "genero3", "3", "title3");
        User user = new User(); 
        Date returnDate = new Date(); 

        devolution = new Devolution("ID123", book, returnDate, user);
    }

    @Test
    public void testGetIdDevolution() {
        assertEquals("ID123", devolution.getIdDevolution());
    }

    @Test
    public void testGetReturnedBook() {
        Book returnedBook = devolution.getReturnedBook();
        assertNotNull(returnedBook);
    }

    @Test
    public void testGetReturnDate() {
        Date returnDate = devolution.getReturnDate();
        assertNotNull(returnDate);
        }

    @Test
    public void testGetUser() {
        User user = devolution.getUser();
        assertNotNull(user);
    }
}

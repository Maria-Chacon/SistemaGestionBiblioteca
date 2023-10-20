/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class BookLoanTest {
    
    public BookLoanTest() {
    }
 private BookLoan bookLoan;

    @Before
    public void setUp() {
        Book book = new Book("5", "Author 1", "Genre 1", "loaned1", "idBook 1", "title 1", "reproduction 1", "publication 1", "url 1", "permanenLink1");
        Date devolutionDate = new Date();
        Date loanedDate = new Date();
        Suspension suspension = new Suspension(true, 500, 3, "1", "fecha");
        User user = new User();

        bookLoan = new BookLoan(1, book.getTitle(), devolutionDate, loanedDate, suspension, user);
    }

    @Test
    public void testGetIdBookLoan() {
        assertEquals(1, bookLoan.getIdBookLoan());
    }

    @Test
    public void testGetTitle() {
        String title = bookLoan.getTitle();
        assertNotNull(title);
        assertEquals("title 1", title);
    }

    @Test
    public void testGetDevolutionDate() {
        Date devolutionDate = bookLoan.getDevolutionDate();
        assertNotNull(devolutionDate);
    }

    @Test
    public void testGetLoanDate() {
        Date loanedDate = bookLoan.getLoanDate();
        assertNotNull(loanedDate);
    }

    @Test
    public void testGetSuspension() {
        Suspension suspension = bookLoan.getSuspension();
        assertNotNull(suspension);
        assertTrue(suspension.isEnable()); 
        assertEquals(500.0f, suspension.getAmount(), 0.0f);
        assertEquals(3, suspension.getDaysLate());
        assertEquals("1", suspension.getIdSuspension());
        assertEquals("fecha", suspension.getReason());
    }

    @Test
    public void testGetUser() {
        User user = bookLoan.getUser();
        assertNotNull(user);
    }
}
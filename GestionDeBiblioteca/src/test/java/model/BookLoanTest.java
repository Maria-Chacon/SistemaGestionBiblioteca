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
        
        Book book = new Book(true, 3, "author3", "genero3", "3", "title3");
        Date devolutionDate = new Date(); 
        Date loanedDate = new Date();
        Suspension suspension = new Suspension(true,500, 3, "1", "fecha");
        User user = new User();

        bookLoan = new BookLoan(1, book, devolutionDate, loanedDate, suspension, user);
    }

    @Test
    public void testGetIdBookLoan() {
        assertEquals(1, bookLoan.getIdBookLoan());
    }

    @Test
    public void testGetBook() {
        Book book = bookLoan.getBook();
        assertNotNull(book);
        assertTrue(book.isLoaned());
        assertEquals(3, book.getQuantity());
        assertEquals("author3", book.getAuthor());
        assertEquals("genero3", book.getGenre());
        assertEquals("3", book.getIdBook());
        assertEquals("title3", book.getTitle());
    }

    @Test
    public void testGetDevolutionDate() {
        Date devolutionDate = bookLoan.getDevolutionDate();
        assertNotNull(devolutionDate);
        }

    @Test
    public void testGetLoanedDate() {
        Date loanedDate = bookLoan.getLoanedDate();
        assertNotNull(loanedDate);
        }

    @Test
    public void testGetSuspension() {
        Suspension suspension = bookLoan.getSuspension();
        assertNotNull(suspension);
        assertEquals("1", suspension.getIdSuspension()); }

    @Test
    public void testGetUser() {
        User user = bookLoan.getUser();
        assertNotNull(user);
    }
}

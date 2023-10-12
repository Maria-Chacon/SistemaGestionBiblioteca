/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author monge
 */
public class LogBookTest {

    public LogBookTest() {
    }
    private LogBook logBook;
    private Book book;
    private BookLoan bookLoan;
    private Date registerDate;
    private Devolution devolution;
    private User user;

    @Before
    public void setUp() {
        book = new Book(true, 5, "J.K. Rowling", "Fantasia", "B001", "Harry Potter");
        bookLoan = new BookLoan(1, book, new Date(), new Date(), null, null);
        registerDate = new Date();
        devolution = new Devolution("D001", book, new Date(), null);
        user = new User("maria@gmail.com", "password","Estudiante", new ArrayList<>(),1, new Date(), "ID001", "chacon", "maria", "88888888");
        logBook = new LogBook("LB001", book, bookLoan, registerDate, devolution, user);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("LB001", logBook.getIdLogBook());
        assertEquals(book, logBook.getBook());
        assertEquals(bookLoan, logBook.getBookLoan());
        assertEquals(registerDate, logBook.getRegisterDate());
        assertEquals(devolution, logBook.getDevolution());
        assertEquals(user, logBook.getUser());

        Book newBook = new Book(false, 3, "George", "susto", "B002", "1984");
        BookLoan newBookLoan = new BookLoan(2, newBook, new Date(), new Date(), null, null);
        Date newRegisterDate = new Date();
        Devolution newDevolution = new Devolution("D002", newBook, new Date(), null);
        User newUser = new User("dayana@gmail.com", "password","Estudiante", new ArrayList<>(),1, new Date(), "ID002", "monge", "dayana", "88888888");

        logBook.setIdLogBook("LB002");
        logBook.setBook(newBook);
        logBook.setBookLoan(newBookLoan);
        logBook.setRegisterDate(newRegisterDate);
        logBook.setDevolution(newDevolution);
        logBook.setUser(newUser);

        assertEquals("LB002", logBook.getIdLogBook());
        assertEquals(newBook, logBook.getBook());
        assertEquals(newBookLoan, logBook.getBookLoan());
        assertEquals(newRegisterDate, logBook.getRegisterDate());
        assertEquals(newDevolution, logBook.getDevolution());
        assertEquals(newUser, logBook.getUser());
    }
}

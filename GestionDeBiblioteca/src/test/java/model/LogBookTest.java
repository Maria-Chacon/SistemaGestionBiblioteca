package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class LogBookTest {


    private LogBook logBook;
    private Book book;
    private Date registerDate;
    private Date devolution;
    private User user;

    @Before
    public void setUp() {
        book = new Book("5", "Author 1", "Genre 1", "loaned", "B1", "Book 1", "repro", "publ", "url", "perml");
        registerDate = new Date();
        devolution = new Date();
        user = new User("maria@gmail.com", "password", "Estudiante", new ArrayList<>(), 1,new Date(), "ID001", "chacon", "maria", "88888888");
        logBook = new LogBook(book, 1, registerDate, devolution, user.getIdentification());
    }

    @Test
    public void testGettersAndSetters() {
        // Test getters
        assertEquals(book, logBook.getBook());
        assertEquals(1, logBook.getBookLoan());
        assertEquals(registerDate, logBook.getRegisterDate());
        assertEquals(devolution, logBook.getDevolution());
        assertEquals(user.getIdentification(), logBook.getIdentificationUser());

        // Test setters
        Book newBook = new Book("6", "Author 2", "Genre 2", "available", "B2", "Book 2", "repro", "publ", "url", "perml");
        Date newRegisterDate = new Date();
        Date newDevolution = new Date();
        User newUser = new User("dayana@gmail.com", "password", "Estudiante", new ArrayList<>(), 1, new Date(),"ID002", "monge", "dayana", "88888888");
        logBook.setBook(newBook);
        logBook.setBookLoan(2);
        logBook.setRegisterDate(newRegisterDate);
        logBook.setDevolution(newDevolution);
        logBook.setIdentificationUser(newUser.getIdentification());

        // Verify the changes
        assertEquals(newBook, logBook.getBook());
        assertEquals(2, logBook.getBookLoan());
        assertEquals(newRegisterDate, logBook.getRegisterDate());
        assertEquals(newDevolution, logBook.getDevolution());
        assertEquals(newUser.getIdentification(), logBook.getIdentificationUser());
    }
}
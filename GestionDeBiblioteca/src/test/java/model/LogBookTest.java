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

    public void setup() {
        
        Book book = new Book("1", "Author 1", "Genre 1", "available", "B1", "Book 1", "repro", "publ", "url", "perml");
        int bookLoan = 1;
        Date registerDate = new Date();
        Date devolution = new Date();
        String identificationUser = "User1";

        logBook = new LogBook(book, bookLoan, registerDate, devolution, identificationUser);
    }

    @Test
    public void testGettersAndSetters() {
        
        assertEquals(book, logBook.getBook());
        assertEquals(1, logBook.getBookLoan());
        assertEquals(registerDate, logBook.getRegisterDate());
        assertEquals(devolution, logBook.getDevolution());
        assertEquals(user.getIdentification(), logBook.getIdentificationUser());

        
        Book newBook = new Book("6", "Author 2", "Genre 2", "available", "B2", "Book 2", "repro", "publ", "url", "perml");
        Date newRegisterDate = new Date();
        Date newDevolution = new Date();
        User newUser = new User("dayana@gmail.com", "password", "Estudiante", new ArrayList<>(), 1, new Date(), "ID002", "monge", "dayana", "88888888");
        logBook.setBook(newBook);
        logBook.setBookLoan(2);
        logBook.setRegisterDate(newRegisterDate);
        logBook.setDevolution(newDevolution);
        logBook.setIdentificationUser(newUser.getIdentification());

        
        assertEquals(newBook, logBook.getBook());
        assertEquals(2, logBook.getBookLoan());
        assertEquals(newRegisterDate, logBook.getRegisterDate());
        assertEquals(newDevolution, logBook.getDevolution());
        assertEquals(newUser.getIdentification(), logBook.getIdentificationUser());
    }

    @Test
    public void testInsertLogBookIntoDatabase() {
        try {
            java.sql.Date sqlRegisterDate = new java.sql.Date(logBook.getRegisterDate().getTime());
            java.sql.Date sqlDevolution = new java.sql.Date(logBook.getDevolution().getTime());
            logBook.setRegisterDate(sqlRegisterDate);
            logBook.setDevolution(sqlDevolution);
            
            LogBook.insertLogBookIntoDatabase(logBook);

        } catch (Exception e) {
            fail("Error al insertar en la base de datos: " + e.getMessage());
        }
    }

}

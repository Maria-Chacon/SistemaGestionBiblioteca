package model;


import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class LogBookTest {

    private LogBook logBook;
    private Book book;

    @Before

    public void setup() {

        book = new Book("1", "Author 1", "Genre 1", "available", "B1", "Book 1", "repro", "publ", "url", "perml");
        int bookLoan = 1;
        Date registerDate = new Date();
        Date devolution = new Date();
        String identificationUser = "User1";
        logBook = new LogBook(book, bookLoan, registerDate, devolution, identificationUser);
    }

    @Test
    public void testGetAndSetBook() {
        LogBook logBook = new LogBook();
        Book testBook = new Book();
        logBook.setBook(testBook);

        Book bookFromLogBook = logBook.getBook();
        assertNotNull(bookFromLogBook);
        assertEquals(testBook, bookFromLogBook);
    }

    @Test
    public void testGetAndSetBookLoan() {
        LogBook logBook = new LogBook();
        int testBookLoan = 123;
        logBook.setBookLoan(testBookLoan);

        int bookLoanFromLogBook = logBook.getBookLoan();
        assertEquals(testBookLoan, bookLoanFromLogBook);
    }

    @Test
    public void testGetAndSetRegisterDate() {
        LogBook logBook = new LogBook();
        Date testRegisterDate = new Date();
        logBook.setRegisterDate(testRegisterDate);

        Date registerDateFromLogBook = logBook.getRegisterDate();
        assertNotNull(registerDateFromLogBook);
        assertEquals(testRegisterDate, registerDateFromLogBook);
    }

    @Test
    public void testGetAndSetDevolution() {
        LogBook logBook = new LogBook();
        Date testDevolution = new Date();
        logBook.setDevolution(testDevolution);

        Date devolutionFromLogBook = logBook.getDevolution();
        assertNotNull(devolutionFromLogBook);
        assertEquals(testDevolution, devolutionFromLogBook);
    }

    @Test
    public void testGetAndSetIdentificationUser() {
        LogBook logBook = new LogBook();
        String testIdentificationUser = "12345";
        logBook.setIdentificationUser(testIdentificationUser);

        String identificationUserFromLogBook = logBook.getIdentificationUser();
        assertNotNull(identificationUserFromLogBook);
        assertEquals(testIdentificationUser, identificationUserFromLogBook);
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

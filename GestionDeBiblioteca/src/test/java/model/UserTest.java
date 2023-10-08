/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monge
 */
public class UserTest {
    
    public UserTest() {
    }

     @Test
    public void testGetEmail() {
        ArrayList<Book> loanedBooks = new ArrayList<>();
        User instance = new User("maria@gmail.com", "password123", loanedBooks, new Date(), "12345", "chacon", "maria", "123456789");
        String expResult = "maria@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPassword() {
        ArrayList<Book> loanedBooks = new ArrayList<>();
        User instance = new User("dayana@gmail.com", "password123", loanedBooks, new Date(), "12345", "monge", "dayana", "123456789");
        String expResult = "password123";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLoanedBooks() {
        ArrayList<Book> loanedBooks = new ArrayList<>();
        loanedBooks.add(new Book(true, 1, "Author1", "Genre1", "2", "Title1"));
        User instance = new User("maria@gmail.com", "password123", loanedBooks, new Date(), "12345", "chacon", "maria", "123456789");
        ArrayList<Book> expResult = loanedBooks;
        ArrayList<Book> result = instance.getLoanedBooks();
        assertEquals(expResult, result);
    }

   

}
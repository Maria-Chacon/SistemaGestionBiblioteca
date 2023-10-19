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


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class LibraryTest {

    public LibraryTest() {
    }

    private Library library;
    private BookCatalog bookCatalog;
    private EquipmentCatalog equipmentCatalog;
    private ArrayList<LogBook> logBook;
    private ArrayList<User> users;

    @Before
    public void setUp() {

        Book book1 = new Book(false, 5, "Author 1", "Genre 1", "B1", "Book 1");
        Book book2 = new Book(true, 3, "Author 2", "Genre 2", "B2", "Book 2");
        Book book3 = new Book(false, 2, "Author 3", "Genre 3", "B3", "Book 3");

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        bookCatalog = new BookCatalog(bookList);

        SchoolEquipment schoolEquipment1 = new SchoolEquipment("Physics Lab", "Microscope", true, 10, "High-quality microscope", "E1", "Microscope 1");
        TechnologicalEquipment techEquipment1 = new TechnologicalEquipment("Laptop", false, 5, "High-performance laptop", "E2", "Laptop 1");

        ArrayList<SchoolEquipment> schoolEquipmentList = new ArrayList<>();
        schoolEquipmentList.add(schoolEquipment1);

        ArrayList<TechnologicalEquipment> techEquipmentList = new ArrayList<>();
        techEquipmentList.add(techEquipment1);

        equipmentCatalog = new EquipmentCatalog(schoolEquipmentList, techEquipmentList);

        LogBook log1 = new LogBook("L1", book1, null, new Date(), null, null);
        LogBook log2 = new LogBook("L2", book2, null, new Date(), null, null);

        logBook = new ArrayList<>();
        logBook.add(log1);
        logBook.add(log2);

        ArrayList<Book> loanedBooks1 = new ArrayList<>();
        ArrayList<Book> loanedBooks2 = new ArrayList<>();
        User user1 = new User("maria@gmail.com", "password1","Estudiante", loanedBooks1,1, new Date(), "ID001", "chacon", "maria", "88888888");
        User user2 = new User("dayana@gmail.com", "password2", "Estudiante",loanedBooks2,2, new Date(), "ID002", "gamboa", "dayana", "77777777");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        library = new Library(bookCatalog, equipmentCatalog, logBook, users);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(bookCatalog, library.getBookCatalog());
        assertEquals(equipmentCatalog, library.getEquipmentCatalog());
        assertEquals(logBook, library.getLogBook());
        assertEquals(users, library.getUsers());

        BookCatalog newBookCatalog = new BookCatalog(new ArrayList<>());
        EquipmentCatalog newEquipmentCatalog = new EquipmentCatalog(new ArrayList<>(), new ArrayList<>());
        ArrayList<LogBook> newLogBook = new ArrayList<>();
        ArrayList<User> newUsers = new ArrayList<>();

        library.setBookCatalog(newBookCatalog);
        library.setEquipmentCatalog(newEquipmentCatalog);
        library.setLogBook(newLogBook);
        library.setUsers(newUsers);

        assertEquals(newBookCatalog, library.getBookCatalog());
        assertEquals(newEquipmentCatalog, library.getEquipmentCatalog());
        assertEquals(newLogBook, library.getLogBook());
        assertEquals(newUsers, library.getUsers());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author monge
 */
public class LogBook {
    private String idLogBook;
    private Book book;
    private BookLoan bookLoan;
    private Date registerDate;
    private Devolution devolution;
    private User user;

    public LogBook(String idLogBook, Book book, BookLoan bookLoan, Date registerDate, Devolution devolution, User user) {
        this.idLogBook = idLogBook;
        this.book = book;
        this.bookLoan = bookLoan;
        this.registerDate = registerDate;
        this.devolution = devolution;
        this.user = user;
    }

    public String getIdLogBook() {
        return idLogBook;
    }

    public void setIdLogBook(String idLogBook) {
        this.idLogBook = idLogBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookLoan getBookLoan() {
        return bookLoan;
    }

    public void setBookLoan(BookLoan bookLoan) {
        this.bookLoan = bookLoan;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Devolution getDevolution() {
        return devolution;
    }

    public void setDevolution(Devolution devolution) {
        this.devolution = devolution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LogBook{" + "idLogBook=" + idLogBook + ", book=" + book + ", bookLoan=" + bookLoan + ", registerDate=" + registerDate + ", devolution=" + devolution + ", user=" + user + '}';
    }
    
}

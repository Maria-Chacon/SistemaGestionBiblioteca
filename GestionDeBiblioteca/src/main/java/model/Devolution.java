/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class Devolution {
    private String idDevolution;
    private Book returnedBook;
    private Date returnDate;
    private User user;

    public Devolution(String idDevolution, Book returnedBook, Date returnDate, User user) {
        this.idDevolution = idDevolution;
        this.returnedBook = returnedBook;
        this.returnDate = returnDate;
        this.user = user;
    }

    public String getIdDevolution() {
        return idDevolution;
    }

    public void setIdDevolution(String idDevolution) {
        this.idDevolution = idDevolution;
    }

    public Book getReturnedBook() {
        return returnedBook;
    }

    public void setReturnedBook(Book returnedBook) {
        this.returnedBook = returnedBook;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Devolution{" + "idDevolution=" + idDevolution + ", returnedBook=" + returnedBook + ", returnDate=" + returnDate + ", user=" + user + '}';
    }
    
}

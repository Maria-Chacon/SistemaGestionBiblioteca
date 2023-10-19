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

public class BookLoan {
    private int idBookLoan;
    private Book book;
    private Date devolutionDate;
    private Date loanedDate;
    private Suspension suspension;
    private User user;

    public BookLoan(int idBookLoan, Book book, Date devolutionDate, Date loanedDate, Suspension suspension, User user) {
        this.idBookLoan = idBookLoan;
        this.book = book;
        this.devolutionDate = devolutionDate;
        this.loanedDate = loanedDate;
        this.suspension = suspension;
        this.user = user;
    }

    public int getIdBookLoan() {
        return idBookLoan;
    }

    public void setIdBookLoan(int idBookLoan) {
        this.idBookLoan = idBookLoan;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Date getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(Date loanedDate) {
        this.loanedDate = loanedDate;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookLoan{" + "idBookLoan=" + idBookLoan + ", book=" + book + ", devolutionDate=" + devolutionDate + ", loanedDate=" + loanedDate + ", suspension=" + suspension + ", user=" + user + '}';
    }
    
}

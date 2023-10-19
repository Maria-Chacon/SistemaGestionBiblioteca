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
public class BookLoan {
    private int idBookLoan;
    private String title;
    private Date devolutionDate;
    private Date loanDate;
    private Suspension suspension;
    private User user;

    public BookLoan() {
    }

    public BookLoan(int idBookLoan, String title, Date devolutionDate, Date loanDate, Suspension suspension, User user) {
        this.idBookLoan = idBookLoan;
        this.title = title;
        this.devolutionDate = devolutionDate;
        this.loanDate = loanDate;
        this.suspension = suspension;
        this.user = user;
    }

    public int getIdBookLoan() {
        return idBookLoan;
    }

    public void setIdBookLoan(int idBookLoan) {
        this.idBookLoan = idBookLoan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
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
        return "BookLoan{" + "idBookLoan=" + idBookLoan + ", title=" + title + ", devolutionDate=" + devolutionDate + ", loanDate=" + loanDate + ", suspension=" + suspension + ", user=" + user + '}';
    }
    
}

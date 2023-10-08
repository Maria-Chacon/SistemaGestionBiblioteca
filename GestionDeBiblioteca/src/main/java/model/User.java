/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author monge
 */
public class User extends Person{
   
    private String email;
    private String password;
    private ArrayList<Book> loanedBooks;

    public User() {
    }

    public User(String email, String password, ArrayList<Book> loanedBooks, Date birthDay, String identification, String lastName, String name, String phone) {
        super(birthDay, identification, lastName, name, phone);
        this.email = email;
        this.password = password;
        this.loanedBooks = loanedBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(ArrayList<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", loanedBooks=" + loanedBooks + '}';
    }

    
}

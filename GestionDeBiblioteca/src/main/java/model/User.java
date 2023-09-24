/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author monge
 */
public class User {
    private int age;
    private String email;
    private String identification;
    private String lastName;
    private String name;
    private String phone;
    private ArrayList<Book> loanedBooks;

    public User(int age, String email, String identification, String lastName, String name, String phone, ArrayList<Book> loanedBooks) {
        this.age = age;
        this.email = email;
        this.identification = identification;
        this.lastName = lastName;
        this.name = name;
        this.phone = phone;
        this.loanedBooks = loanedBooks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(ArrayList<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", email=" + email + ", identification=" + identification + ", lastName=" + lastName + ", name=" + name + ", phone=" + phone + ", loanedBooks=" + loanedBooks + '}';
    }
    
    
}

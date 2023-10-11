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
public class Author extends Person {
    
    private ArrayList<Book> books;

    public Author() {
    }

    public Author(ArrayList<Book> books, Date birthDay, String identification, String lastName, String name, String phone) {
        super(birthDay, identification, lastName, name, phone);
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" + "books=" + books + '}';
    }
    
    
    
    
}

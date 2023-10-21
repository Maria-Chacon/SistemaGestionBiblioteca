/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class BookCatalog {
    private ArrayList<Book> books;

    public BookCatalog() {
        this.books = new ArrayList<>();
    }
    
    

    public BookCatalog(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    public void loadBooksFromDatabase() {
        this.books = Book.getBooksFromDatabase();
    }

    @Override
    public String toString() {
        return "BookCatalog{" + "books=" + books + '}';
    }
    
}

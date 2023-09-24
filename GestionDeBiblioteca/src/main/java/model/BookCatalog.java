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
public class BookCatalog {
    private ArrayList<Book> books;

    public BookCatalog(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    public ArrayList<Book> getBookLoaned(){
        
        return null;  
    }
    public ArrayList<Book> SearchBookByTitle(String title){
        
        return null;
        
    }
    public ArrayList<Book> SearchBookByAuthor(String author){
        
        return null;
        
    }
    public ArrayList<Book> SearchBookByGenre(String genre){
        
        return null;
        
    }

    @Override
    public String toString() {
        return "BookCatalog{" + "books=" + books + '}';
    }
    
}

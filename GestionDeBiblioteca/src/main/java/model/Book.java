/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maria
 */
public class Book {
    private boolean loaned;
    private int quantity;
    private String author;
    private String genre;
    private String idBook;
    private String title;

    public Book() {
    }

    
    public Book(boolean loaned, int quantity, String author, String genre, String idBook, String title) {
        this.loaned = loaned;
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
        this.idBook = idBook;
        this.title = title;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "loaned=" + loaned + ", quantity=" + quantity + ", author=" + author + ", genre=" + genre + ", idBook=" + idBook + ", title=" + title + '}';
    }
    
}

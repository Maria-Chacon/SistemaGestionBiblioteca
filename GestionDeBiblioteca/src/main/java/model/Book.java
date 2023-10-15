/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author maria
 */
public class Book {

    private int quantity;
    private int author;
    private String genre;
    private String loaned;
    private String idBook;
    private String title;
    private String reproduction;
    private String publication;
    private String url;
    private String permanenLink;

    public Book() {
    }

    public Book(int quantity, int author, String genre, String loaned, String idBook, String title, String reproduction, String publication, String url, String permanenLink) {
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
        this.loaned = loaned;
        this.idBook = idBook;
        this.title = title;
        this.reproduction = reproduction;
        this.publication = publication;
        this.url = url;
        this.permanenLink = permanenLink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLoaned() {
        return loaned;
    }

    public void setLoaned(String loaned) {
        this.loaned = loaned;
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

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermanenLink() {
        return permanenLink;
    }

    public void setPermanenLink(String permanenLink) {
        this.permanenLink = permanenLink;
    }

    @Override
    public String toString() {
        return "Book{" + "quantity=" + quantity + ", author=" + author + ", genre=" + genre + ", loaned=" + loaned + ", idBook=" + idBook + ", title=" + title + ", reproduction=" + reproduction + ", publication=" + publication + ", url=" + url + ", permanenLink=" + permanenLink + '}';
    }

    public static ArrayList<Book> getBooksFromDatabase() {
        ArrayList<Book> books = new ArrayList<>();

        Conexion connection = Conexion.getInstance();

        try {
            connection.conectar();
            PreparedStatement statement = connection.preparedStatement("SELECT * FROM tbl_books");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Book book = new Book();
                book.setLoaned(result.getString("loaned"));
                book.setQuantity(result.getInt("quantity"));
                book.setAuthor(result.getInt("idAuthor"));
                book.setGenre(result.getString("genre"));
                book.setIdBook(result.getString("id"));
                book.setTitle(result.getString("title"));
                book.setReproduction(result.getString("reproduction"));
                book.setPublication(result.getString("publication"));
                book.setUrl(result.getString("url"));
                book.setPermanenLink(result.getString("permanenLink"));

                books.add(book);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener libros desde la base de datos: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return books;
    }

    public static void insertBookIntoDatabase(Book book) {
        Conexion connection = Conexion.getInstance();
        try {
            connection.conectar();

            // Inserta el libro en la base de datos
            String query = "INSERT INTO tbl_books (title, reproduction, publication, url,permanenLink, loaned, quantity, idAuthor, genre) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.preparedStatement(query);

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getReproduction());
            statement.setString(3, book.getPublication());
            statement.setString(4, book.getUrl());
            statement.setString(5, book.getPermanenLink());
            statement.setString(6, book.getLoaned());
            statement.setInt(7, book.getQuantity());
            statement.setInt(8, book.getAuthor());
            statement.setString(9, book.getGenre());

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al insertar el libro en la base de datos: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }
    }

    public static ArrayList<Book> sortBooksByTitle(ArrayList<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    public static void updateBooksInDatabase(ArrayList<Book> books) {
        Conexion connection = Conexion.getInstance();

        try {
            connection.conectar();

            // Utiliza TRUNCATE para eliminar todos los datos de la tabla de libros
            String truncateQuery = "TRUNCATE TABLE tbl_books";
            PreparedStatement truncateStatement = connection.preparedStatement(truncateQuery);
            truncateStatement.executeUpdate();

            // Inserta la lista de libros ordenada en la base de datos
            for (Book book : books) {
                insertBookIntoDatabase(book);
            }
        } catch (SQLException ex) {
            System.err.println("Error al actualizar la base de datos: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }
    }

}

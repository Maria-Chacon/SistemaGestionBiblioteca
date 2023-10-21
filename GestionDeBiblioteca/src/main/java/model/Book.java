package model;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class Book {

    private String quantity; // Cambiado a String
    private String nameAuthor;
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

    public Book(String title) {
        this.title = title;
    }

    public Book(String quantity, String nameAuthor, String genre, String loaned,
            String idBook, String title, String reproduction,
            String publication, String url, String permanenLink) {
        this.quantity = quantity;
        this.nameAuthor = nameAuthor;
        this.genre = genre;
        this.loaned = loaned;
        this.idBook = idBook;
        this.title = title;
        this.reproduction = reproduction;
        this.publication = publication;
        this.url = url;
        this.permanenLink = permanenLink;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
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
        return title;
    }

    public static ArrayList<Book> getBooksFromDatabase() {
        Conexion connection = Conexion.getInstance();

        try {
            connection.connect();
            PreparedStatement statement = connection.preparedStatement("SELECT * FROM tbl_books");
            ResultSet result = statement.executeQuery();

            return StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(
                            new Iterator<Book>() {
                        @Override
                        public boolean hasNext() {
                            try {
                                return result.next();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        @Override
                        public Book next() {
                            Book book = new Book();
                            try {
                                book.setTitle(result.getString("title"));
                                book.setReproduction(result.getString("reproduction"));
                                book.setPublication(result.getString("publication"));
                                book.setUrl(result.getString("url"));
                                book.setPermanenLink(result.getString("permanenLink"));
                                book.setLoaned(result.getString("loaned"));
                                book.setQuantity(result.getString("quantity"));
                                book.setNameAuthor(result.getString("nameAuthor"));
                                book.setGenre(result.getString("genre"));
                                book.setIdBook(result.getString("id"));
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            return book;
                        }
                    },
                            Spliterator.ORDERED
                    ),
                    false
            ).collect(Collectors.toCollection(ArrayList::new));
        } catch (SQLException ex) {
            System.err.println("Error al obtener libros desde la base de datos: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }

        return new ArrayList<>();
    }

    public static void insertBookIntoDatabase(Book book) {
        Conexion connection = Conexion.getInstance();
        try {
            connection.connect();

            String query = "INSERT INTO tbl_books (title, reproduction, publication, url, permanenLink, loaned, quantity, nameAuthor, genre) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.preparedStatement(query);

            statement.setString(1, book.getTitle());
            statement.setString(2, (book.getReproduction() == null || book.getReproduction().isEmpty()) ? "indefinido" : book.getReproduction());
            statement.setString(3, (book.getPublication() == null || book.getPublication().isEmpty()) ? "indefinido" : book.getPublication());
            statement.setString(4, (book.getUrl() == null || book.getUrl().isEmpty()) ? "indefinido" : book.getUrl());
            statement.setString(5, (book.getPermanenLink() == null || book.getPermanenLink().isEmpty()) ? "indefinido" : book.getPermanenLink());
            statement.setString(6, (book.getLoaned() == null || book.getLoaned().isEmpty()) ? "indefinido" : book.getLoaned());

            statement.setString(7, book.getQuantity());

            statement.setString(8, book.getNameAuthor());
            statement.setString(9, book.getGenre());

            statement.executeUpdate();
            System.out.println("Registro de libro exitoso");
        } catch (SQLException ex) {
            System.err.println("Error al insertar el libro en la base de datos: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }
    }

    public static ArrayList<Book> sortBooksByTitle(ArrayList<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    public static void updateBooksInDatabase(ArrayList<Book> books) {
        Conexion connection = Conexion.getInstance();

        try {
            connection.connect();

            String truncateQuery = "TRUNCATE TABLE tbl_books";
            PreparedStatement truncateStatement = connection.preparedStatement(truncateQuery);
            truncateStatement.executeUpdate();

            insertBooksRecursively(connection, books, 0);
        } catch (SQLException ex) {
            System.err.println("Error al actualizar la base de datos: " + ex.getMessage());
        } finally {
            connection.disconnect();
        }
    }

    private static void insertBooksRecursively(Conexion connection, ArrayList<Book> books, int index) {
        if (index < books.size()) {
            Book book = books.get(index);
            insertBookIntoDatabase(book);
            insertBooksRecursively(connection, books, index + 1);
        }
    }

}

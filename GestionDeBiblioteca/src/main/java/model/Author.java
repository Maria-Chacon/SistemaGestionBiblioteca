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
import java.util.Date;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class Author extends Person {

    private ArrayList<Book> books;

    public Author() {
    }

    public Author(ArrayList<Book> books, int id, Date birthDay, String identification, String lastName, String name, String phone) {
        super(id, birthDay, identification, lastName, name, phone);
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public static ArrayList<Author> getAuthorsFromDatabase() {
        ArrayList<Author> authors = new ArrayList<>();

        Conexion connection = Conexion.getInstance();

        try {
            connection.conectar();

            PreparedStatement statement = connection.preparedStatement("SELECT * FROM tbl_authors");
            ResultSet result = statement.executeQuery();

            
            getAuthorsRecursive(result, authors);
        } catch (SQLException ex) {
            System.err.println("Error al obtener autores desde la base de datos: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return authors;
    }

    private static void getAuthorsRecursive(ResultSet result, ArrayList<Author> authors) throws SQLException {
        if (result.next()) {
            Author author = new Author();
            author.setId(result.getInt("id"));
            author.setName(result.getString("name"));
            author.setLastName(result.getString("lastName"));
            author.setBirthDay(result.getDate("birthDay"));
            author.setIdentification(result.getString("identification"));
            author.setPhone(result.getString("phone"));

            authors.add(author);

            getAuthorsRecursive(result, authors);
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getLastName();
    }

}

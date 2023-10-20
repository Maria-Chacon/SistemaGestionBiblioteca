/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javafx.scene.control.Alert;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class LogBook {

    private Book book;
    private int bookLoan;
    private Date registerDate;
    private Date devolution;
    private String identificationUser;

    public LogBook(Book book, int bookLoan, Date registerDate, Date devolution, String identificationUser) {

        this.book = book;
        this.bookLoan = bookLoan;
        this.registerDate = registerDate;
        this.devolution = devolution;
        this.identificationUser = identificationUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBookLoan() {
        return bookLoan;
    }

    public void setBookLoan(int bookLoan) {
        this.bookLoan = bookLoan;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getDevolution() {
        return devolution;
    }

    public void setDevolution(Date devolution) {
        this.devolution = devolution;
    }

    public String getIdentificationUser() {
        return identificationUser;
    }

    public void setIdentificationUser(String identificationUser) {
        this.identificationUser = identificationUser;
    }

    @Override
    public String toString() {
        return "LogBook{" + ", book=" + book + ", bookLoan=" + bookLoan + ", registerDate=" + registerDate + ", devolution=" + devolution + ", user=" + identificationUser + '}';
    }

    public static void insertLogBookIntoDatabase(LogBook logBook) {
        Conexion connection = Conexion.getInstance();

        try {
            connection.conectar();

            String insertLogBookQuery = "INSERT INTO tbl_logBook (title, idBookLoan, loanDate, devolutionDate, identificationUser)"
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.preparedStatement(insertLogBookQuery);

            statement.setString(1, logBook.getBook().getTitle()); 
            statement.setInt(2, logBook.getBookLoan());
            statement.setDate(3, (java.sql.Date) logBook.getRegisterDate());
            statement.setDate(4, (java.sql.Date) logBook.getDevolution());
            statement.setString(5, logBook.getIdentificationUser());

            statement.executeUpdate();
            System.out.println("Registro de prestamo de libro en bitácora éxitoso.");
        } catch (SQLException ex) {
            System.err.println("Error al insertar el prestamo de libro en bitácora: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }
    }

}

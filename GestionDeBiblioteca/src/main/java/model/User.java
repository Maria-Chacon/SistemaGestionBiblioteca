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

public class User extends Person{
   
    private String email;
    private String password;
    private String type;
    private ArrayList<Book> loanedBooks;
    

    public User() {
    }

    public User(String email, String password, String type, ArrayList<Book> loanedBooks, int id, Date birthDay, String identification, String lastName, String name, String phone) {
        super(id, birthDay, identification, lastName, name, phone);
        this.email = email;
        this.password = password;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(ArrayList<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }
    
    public static String getUserIdentificationByEmail(String email) {
        String userIdentification = "";

        // Realizar la consulta a la base de datos para obtener la identificación del usuario
        Conexion connection = Conexion.getInstance(); 
        try {
            connection.conectar();

            PreparedStatement statement = connection.preparedStatement("SELECT * FROM tbl_users WHERE email = ?");
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                userIdentification = result.getString("identification");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la identificación del usuario por correo electrónico: " + ex.getMessage());
        } finally {
            connection.desconectar();
        }

        return userIdentification;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", type=" + type + ", loanedBooks=" + loanedBooks + '}';
    }
    
    


    
}

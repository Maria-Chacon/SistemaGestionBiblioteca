/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//Universidad Nacional, Coto
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023
public class Verification {

    private static String id;
    private static String name;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        if (Verification.id == null) {
            Verification.id = id;
        }

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        if (Verification.name == null) {
            Verification.name = name;
        }

    }

    public static String verifyUserAndGetUserName(String email) {
        Conexion connection = Conexion.getInstance();
        try {
            connection.connect();

            String query = "SELECT name FROM tbl_users WHERE email = ?";
            PreparedStatement statement = connection.preparedStatement(query);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                name = resultSet.getString("name");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el nombre del usuario por correo electrónico: " + ex.getMessage());

        } finally {
            connection.disconnect();
        }

        return name;
    }

}

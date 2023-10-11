/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Administrator;
import model.Student;
import model.Teacher;
import model.User;

/**
 *
 * @author usuario
 */
public class UserBD {

    private final static Conexion connection = Conexion.getInstance();
    private final static String createUserQuery = "INSERT INTO usuarios (name, lastName, identification, birthDay, phone, email, password) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final static String updateUserQuery = "UPDATE usuarios SET name = ?, lastName = ?, identification = ?, birthDay = ?, phone = ?, email = ?, password = ? WHERE id = ?;";
    private final static String deleteUserQuery = "DELETE FROM usuarios WHERE id = ?;";
    private final static String getUserByIdQuery = "SELECT id, name, lastName, identification, birthDay, phone, email, password FROM usuarios WHERE id = ?;";

    // Métodos para obtener usuarios por ID, nombre de usuario, etc.
    public User getUser(int id) {
        try {
            connection.conectar(); // Conecta a la base de datos

            // Crea una sentencia preparada con la consulta SQL para obtener un usuario por ID
            PreparedStatement statement = connection.preparedStatement(getUserByIdQuery);
            statement.setInt(1, id); // Asigna el valor del ID como parámetro

            ResultSet result = statement.executeQuery(); // Ejecuta la consulta SQL

            if (result.next()) {
                // Crea un objeto User o una subclase específica a partir de los resultados de la consulta
                User user = createUserFromResultSet(result);
                return user;
            }
            return null; // Si no se encuentra el usuario, retorna null
        } catch (SQLException ex) {
            // Maneja las excepciones, por ejemplo, imprime el error
            System.err.println("Error al obtener el usuario por ID: " + ex.getMessage());
            return null;
        } finally {
            connection.desconectar(); // Desconecta de la base de datos
        }
    }

//    // Métodos para obtener una lista de usuarios (pueden ser de cualquier tipo).
//    public static ArrayList<User> getAllUsers() {
//        // Implementa la lógica para obtener una lista de usuarios.
//    }
    // Métodos para crear y actualizar usuarios.
    public static boolean createUser(User user) {
        try {
            connection.conectar(); // Conecta a la base de datos

            // Crea una sentencia preparada con la consulta SQL de inserción
            PreparedStatement statement = connection.preparedStatement(createUserQuery);

            // Establece los valores de los parámetros en la sentencia preparada
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getIdentification());
            // Establece otros atributos de Person

            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            // Establece otros atributos de User

            int rowsAffected = statement.executeUpdate(); // Ejecuta la consulta de inserción

            return rowsAffected > 0; // Si se insertó al menos una fila, retorna true
        } catch (SQLException ex) {
            System.err.println("Error al crear un usuario: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar(); // Desconecta de la base de datos
        }
    }

    public static boolean updateUser(User user) {
        try {
            connection.conectar(); // Conecta a la base de datos

            // Crea una sentencia preparada con la consulta SQL de actualización
            PreparedStatement statement = connection.preparedStatement(updateUserQuery);

            // Establece los valores de los parámetros en la sentencia preparada
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getIdentification());
            // Establece otros atributos de Person

            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            // Establece otros atributos de User

            statement.setInt(6, user.getId()); // El ID del usuario que se va a actualizar

            int rowsAffected = statement.executeUpdate(); // Ejecuta la consulta de actualización

            return rowsAffected > 0; // Si se actualizó al menos una fila, retorna true
        } catch (SQLException ex) {
            System.err.println("Error al actualizar un usuario: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar(); // Desconecta de la base de datos
        }
    }

    // Método para eliminar un usuario por ID.
    public static boolean deleteUser(int id) {
        try {
            connection.conectar(); // Conecta a la base de datos
            // Crea una sentencia preparada con la consulta SQL de eliminación
            PreparedStatement statement = connection.preparedStatement(deleteUserQuery);
            // Establece el valor del parámetro en la sentencia preparada
            statement.setInt(1, id); // ID del usuario que se va a eliminar

            int rowsAffected = statement.executeUpdate(); // Ejecuta la consulta de eliminación

            return rowsAffected > 0; // Si se eliminó al menos una fila, retorna true
        } catch (SQLException ex) {
            System.err.println("Error al eliminar un usuario: " + ex.getMessage());
            return false;
        } finally {
            connection.desconectar(); // Desconecta de la base de datos
        }
    }

//    // Métodos específicos para las subclases de User (Student, Administrator, Teacher).
//    public static Student getStudent(String studentId) {
//        // Implementa la lógica para obtener un estudiante por su identificador.
//    }
//
//    public static Administrator getAdministrator(String adminId) {
//        // Implementa la lógica para obtener un administrador por su identificador.
//    }
//
//    public static Teacher getTeacher(String teacherId) {
//        // Implementa la lógica para obtener un profesor por su identificador.
//    }
//
//    // Otros métodos específicos para cada tipo de usuario, si es necesario.
//    // Métodos para manejar libros prestados, si es relevante para tu aplicación.
//    public static ArrayList<Book> getLoanedBooks(User user) {
//        // Implementa la lógica para obtener la lista de libros prestados a un usuario.
//    }
//
//    public static boolean loanBook(User user, Book book) {
//        // Implementa la lógica para prestar un libro a un usuario.
//    }
//
//    public static boolean returnBook(User user, Book book) {
//        // Implementa la lógica para devolver un libro prestado por un usuario.
//    }

    public User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String lastName = resultSet.getString("lastName");
        String identification = resultSet.getString("identification");
        // Otros atributos de Person

        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        // Otros atributos de User

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLastName(lastName);
        user.setIdentification(identification);
        // Establecer otros atributos de Person

        user.setEmail(email);
        user.setPassword(password);
        // Establecer otros atributos de User

        return user;
    }
}

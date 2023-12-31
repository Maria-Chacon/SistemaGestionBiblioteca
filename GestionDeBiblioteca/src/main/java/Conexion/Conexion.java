/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author usuario
 */
public class Conexion {
    private static Conexion INSTANCE;
    private static MysqlDataSource dataSource;
    private static Connection connection;
    
    public Conexion(){
        dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/bd_biblioteca");
        dataSource.setUser("root");
        dataSource.setPassword("");
    }
    
    public static Conexion getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Conexion();
        return INSTANCE;
    }
    
    public void connect()  {
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_biblioteca", "root", "");
       }catch(Exception ex ){
             ex.printStackTrace();
       }
    }
    
    public void disconnect(){
        try {
            connection.close();
        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }
    
    public Statement createStatement() throws SQLException{
        return connection.createStatement();
    }
    
    public PreparedStatement preparedStatement(String sql) throws SQLException{
        return connection.prepareStatement(sql);
    }
}

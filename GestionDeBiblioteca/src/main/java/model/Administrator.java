/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author monge
 */
public class Administrator extends User{
    
    private String idAdmin;

    public Administrator() {
    }


    public Administrator(String idAdmin, String email, String password, ArrayList<Book> loanedBooks, Date birthDay, String identification, String lastName, String name, String phone) {
        super(email, password, loanedBooks, birthDay, identification, lastName, name, phone);
        this.idAdmin = idAdmin;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Administrator{" + "idAdmin=" + idAdmin + '}';
    }
    
    
    
    
}

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
public class Teacher extends User{
    private String idTeacher;

    public Teacher() {
    }

    public Teacher(String idTeacher, String email, String password, ArrayList<Book> loanedBooks, int id, Date birthDay, String identification, String lastName, String name, String phone) {
        super(email, password, loanedBooks, id, birthDay, identification, lastName, name, phone);
        this.idTeacher = idTeacher;
    }

   

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" + "idTeacher=" + idTeacher + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class Teacher extends User{
    private String idTeacher;

    public Teacher() {
    }


    public Teacher(String idTeacher, String email, String password, String type, ArrayList<Book> loanedBooks, int id, Date birthDay, String identification, String lastName, String name, String phone) {
        super(email, password, type, loanedBooks, id, birthDay, identification, lastName, name, phone);
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

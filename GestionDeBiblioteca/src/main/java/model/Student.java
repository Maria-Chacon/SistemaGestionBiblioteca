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
public class Student extends User{
    
    
    private String idStudent;

    public Student() {
    }

   
    public Student(String idStudent, String email, String password, ArrayList<Book> loanedBooks, Date birthDay, String identification, String lastName, String name, String phone) {
        super(email, password, loanedBooks, birthDay, identification, lastName, name, phone);
        this.idStudent = idStudent;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + '}';
    }
    
}

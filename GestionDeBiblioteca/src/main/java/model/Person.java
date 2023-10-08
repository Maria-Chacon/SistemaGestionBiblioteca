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
public class Person {
    private Date birthDay;
    private String identification;
    private String lastName;
    private String name;
    private String phone;

    public Person() {
    }

    
    public Person(Date birthDay, String identification, String lastName, String name, String phone) {
        this.birthDay = birthDay;
        this.identification = identification;
        this.lastName = lastName;
        this.name = name;
        this.phone = phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" + "birthDay=" + birthDay + ", identification=" + identification + ", lastName=" + lastName + ", name=" + name + ", phone=" + phone + '}';
    }
    
    
}

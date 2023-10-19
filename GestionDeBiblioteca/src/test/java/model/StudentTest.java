/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class StudentTest {
    
    public StudentTest() {
    }

    @Test
    public void testGetIdStudent() {
        Student instance = new Student("S123", "student@gmail.com", "password123","Estudiante", new ArrayList<>(),1, new Date(), "12345", "Mora", "Maria", "123456789");
        String expResult = "S123";
        String result = instance.getIdStudent();
        assertEquals(expResult, result);
    }   
}

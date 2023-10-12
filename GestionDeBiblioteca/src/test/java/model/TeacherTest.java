/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monge
 */
public class TeacherTest {
    
    public TeacherTest() {
    }

   @Test
    public void testGetIdTeacher() {
        Teacher instance = new Teacher("T123", "teacher@gmail.com", "password123","Teacher", new ArrayList<>(),1, new Date(), "12345", "Noguera", "Jose", "123456789");
        String expResult = "T123";
        String result = instance.getIdTeacher();
        assertEquals(expResult, result);
    }
    
}

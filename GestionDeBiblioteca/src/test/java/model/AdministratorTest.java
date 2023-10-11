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
public class AdministratorTest {
    
    public AdministratorTest() {
    }

        @Test
    public void testGetIdAdmin() {
        Administrator instance = new Administrator("A123", "admin@gmail.com", "password123", new ArrayList<>(),1, new Date(), "12345", "noguera", "pablo", "123456789");
        String expResult = "A123";
        String result = instance.getIdAdmin();
        assertEquals(expResult, result);
    }



}

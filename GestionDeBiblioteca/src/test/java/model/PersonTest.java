/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monge
 */
public class PersonTest {
    
    public PersonTest() {
    }

    @Test
    public void testGetBirthDay() {
        Date birthDay = new Date();
        Person instance = new Person(1, birthDay, "12345", "chacon", "maria", "123456789");
        assertEquals(birthDay, instance.getBirthDay());
    }

    @Test
    public void testGetIdentification() {
        Person instance = new Person(1,new Date(), "12345", "gamboa", "dayana", "123456789");
        String expResult = "12345";
        String result = instance.getIdentification();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLastName() {
        Person instance = new Person(1,new Date(), "12345", "chacon", "maria", "123456789");
        String expResult = "chacon";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        Person instance = new Person(1, new Date(), "12345", "chacon", "maria", "123456789");
        String expResult = "maria";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPhone() {
        Person instance = new Person(1,new Date(), "12345", "monge", "dayana", "123456789");
        String expResult = "123456789";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

}

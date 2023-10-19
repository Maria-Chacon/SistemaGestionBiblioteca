/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class EquipmentTest {
    
    public EquipmentTest() {
    }

    @Test
    public void testIsAvailability() {
        Equipment instance = new Equipment(true,2,"equipo1","1","tec");
        boolean expResult = true;
        boolean result = instance.isAvailability();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetQuantity() {
        Equipment instance = new Equipment(true,2,"equipo1","1","tec");
        int expResult = 2;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetDescription() {
        Equipment instance = new Equipment(true,2,"equipo1","1","tec");
        String expResult = "equipo1";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdEquipment() {
        Equipment instance = new Equipment(true,2,"equipo1","1","tec");
        String expResult = "1";
        String result = instance.getIdEquipment();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetName() {
        Equipment instance = new Equipment(true,2,"equipo1","1","tec");
        String expResult = "tec";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    
}

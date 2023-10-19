/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class SchoolEquipmentTest {
    
    public SchoolEquipmentTest() {
    }

     private SchoolEquipment schoolEquipment;

    @Before
    public void setUp() {
        schoolEquipment = new SchoolEquipment("Science Lab", "Metal", true, 10, "Microscope", "SE001", "Advanced Microscope");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Science Lab", schoolEquipment.getArea());
        assertEquals("Metal", schoolEquipment.getMaterial());
        assertTrue(schoolEquipment.isAvailability());
        assertEquals(10, schoolEquipment.getQuantity());
        assertEquals("Microscope", schoolEquipment.getDescription());
        assertEquals("SE001", schoolEquipment.getIdEquipment());
        assertEquals("Advanced Microscope", schoolEquipment.getName());

        schoolEquipment.setArea("Chemistry Lab");
        schoolEquipment.setMaterial("Glass");
        schoolEquipment.setAvailability(false);
        schoolEquipment.setQuantity(5);
        schoolEquipment.setDescription("Beakers");
        schoolEquipment.setIdEquipment("SE002");
        schoolEquipment.setName("Chemistry Glassware");

        assertEquals("Chemistry Lab", schoolEquipment.getArea());
        assertEquals("Glass", schoolEquipment.getMaterial());
        assertFalse(schoolEquipment.isAvailability());
        assertEquals(5, schoolEquipment.getQuantity());
        assertEquals("Beakers", schoolEquipment.getDescription());
        assertEquals("SE002", schoolEquipment.getIdEquipment());
        assertEquals("Chemistry Glassware", schoolEquipment.getName());
    }



    
}

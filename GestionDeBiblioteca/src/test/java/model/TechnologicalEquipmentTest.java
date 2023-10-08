/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author monge
 */
public class TechnologicalEquipmentTest {
    
    public TechnologicalEquipmentTest() {
    }
private TechnologicalEquipment techEquipment;

    @Before
    public void setUp() {
        
        techEquipment = new TechnologicalEquipment("Tipo1", true, 5, "Descripción1", "ID1", "Equipo1");
    }

    @Test
    public void testGetTypeTechnologicalEquipment() {
        assertEquals("Tipo1", techEquipment.getTypeTechnologicalEquipment());
    }

    @Test
    public void testInheritance() {
       
        assertTrue(techEquipment.isAvailability());
        assertEquals(5, techEquipment.getQuantity());
        assertEquals("Descripción1", techEquipment.getDescription());
        assertEquals("ID1", techEquipment.getIdEquipment());
        assertEquals("Equipo1", techEquipment.getName());
    }
}
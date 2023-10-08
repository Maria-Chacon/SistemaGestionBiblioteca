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
public class SuspensionTest {
    
    public SuspensionTest() {
    }

    private Suspension suspension;

    @Before
    public void setUp() {
        
        suspension = new Suspension(true, 50, 7, "2","fecha");
    }

    @Test
    public void testGettersAndSetters() {
        
        assertTrue(suspension.isEnable());
        assertEquals(50, suspension.getAmount(), 0.01);
        assertEquals(7, suspension.getDaysLate());
        assertEquals("fecha", suspension.getReason());

        
        suspension.setEnable(false);
        suspension.setAmount(75.0f);
        suspension.setDaysLate(14);
        suspension.setReason("fecha atrasada");

        
        assertFalse(suspension.isEnable());
        assertEquals(75.0f, suspension.getAmount(), 0.01);
        assertEquals(14, suspension.getDaysLate());
        assertEquals("fecha atrasada", suspension.getReason());
    }

}

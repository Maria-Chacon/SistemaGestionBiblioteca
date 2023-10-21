/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monge
 */
public class VerificationTest {
    
    public VerificationTest() {
    }
    @Test
    public void testGetId() {
        String idValue = Verification.getId();
        assertNull(idValue); 
    }

    @Test
    public void testSetId() {
        String testId = "123456";
        Verification.setId(testId);

        String idValue = Verification.getId();
        assertEquals(testId, idValue);
    }

    @Test
    public void testSetIdOnce() {
        String firstId = "123456";
        String secondId = "789012";

        Verification.setId(firstId);

        Verification.setId(secondId);

        String idValue = Verification.getId();
        assertEquals(firstId, idValue);
    }
}

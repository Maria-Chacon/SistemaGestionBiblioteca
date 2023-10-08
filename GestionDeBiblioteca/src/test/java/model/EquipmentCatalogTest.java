/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author monge
 */
public class EquipmentCatalogTest {
    
    public EquipmentCatalogTest() {
    }
private EquipmentCatalog equipmentCatalog;

    @Before
    public void setUp() {
        
        ArrayList<SchoolEquipment> schoolEquipment = new ArrayList<>();
        ArrayList<TechnologicalEquipment> technologicalEquipment = new ArrayList<>();

        
        schoolEquipment.add(new SchoolEquipment("Área1", "Material1", true, 10, "Descripción1", "ID1", "Equipo1"));
        technologicalEquipment.add(new TechnologicalEquipment("Tipo1", true, 5, "Descripción2", "ID2", "Equipo2"));

        equipmentCatalog = new EquipmentCatalog(schoolEquipment, technologicalEquipment);
    }

    @Test
    public void testGetSchoolEquipment() {
        ArrayList<SchoolEquipment> schoolEquipment = equipmentCatalog.getSchoolEquipment();
        assertNotNull(schoolEquipment);
        assertEquals(1, schoolEquipment.size()); 
    }

    @Test
    public void testGetTechnologicalEquipment() {
        ArrayList<TechnologicalEquipment> technologicalEquipment = equipmentCatalog.getTechnologicalEquipment();
        assertNotNull(technologicalEquipment);
        assertEquals(1, technologicalEquipment.size());
    }

}

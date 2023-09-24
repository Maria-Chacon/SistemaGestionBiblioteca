/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author monge
 */
public class TechnologicalEquipment extends Equipment{
    private String typeTechnologicalEquipment;

    public TechnologicalEquipment(String typeTechnologicalEquipment, boolean availability, int quantity, String description, String idEquipment, String name) {
        super(availability, quantity, description, idEquipment, name);
        this.typeTechnologicalEquipment = typeTechnologicalEquipment;
    }

    public String getTypeTechnologicalEquipment() {
        return typeTechnologicalEquipment;
    }

    public void setTypeTechnologicalEquipment(String typeTechnologicalEquipment) {
        this.typeTechnologicalEquipment = typeTechnologicalEquipment;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
/**
 *
 * @author monge
 */
public class EquipmentCatalog {
    private ArrayList<SchoolEquipment> schoolEquipment;
    private ArrayList<TechnologicalEquipment> technologicalEquipment;

    public EquipmentCatalog(ArrayList<SchoolEquipment> schoolEquipment, ArrayList<TechnologicalEquipment> technologicalEquipment) {
        this.schoolEquipment = schoolEquipment;
        this.technologicalEquipment = technologicalEquipment;
    }

    public ArrayList<SchoolEquipment> getSchoolEquipment() {
        return schoolEquipment;
    }

    public void setSchoolEquipment(ArrayList<SchoolEquipment> schoolEquipment) {
        this.schoolEquipment = schoolEquipment;
    }

    public ArrayList<TechnologicalEquipment> getTechnologicalEquipment() {
        return technologicalEquipment;
    }

    public void setTechnologicalEquipment(ArrayList<TechnologicalEquipment> technologicalEquipment) {
        this.technologicalEquipment = technologicalEquipment;
    }

    
    public void addEquipment(Equipment equipment){
        
    }
    public void removeEquipment(Equipment equipment){
        
    }

    @Override
    public String toString() {
        return "EquipmentCatalog{" + "schoolEquipment=" + schoolEquipment + ", technologicalEquipment=" + technologicalEquipment + '}';
    }
    
}

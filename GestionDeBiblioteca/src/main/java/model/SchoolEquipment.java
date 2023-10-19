/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class SchoolEquipment extends Equipment {
    
    private String area;
    private String material;

    public SchoolEquipment(String area, String material, boolean availability, int quantity, String description, String idEquipment, String name) {
        super(availability, quantity, description, idEquipment, name);
        this.area = area;
        this.material = material;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    
    
}

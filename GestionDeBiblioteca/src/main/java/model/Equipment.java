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

public class Equipment {
    private boolean availability;
    private int quantity;
    private String description;
    private String idEquipment;
    private String name;

    public Equipment() {
    }


    public Equipment(boolean availability, int quantity, String description, String idEquipment, String name) {
        this.availability = availability;
        this.quantity = quantity;
        this.description = description;
        this.idEquipment = idEquipment;
        this.name = name;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(String idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Equipment{" + "availability=" + availability + ", quantity=" + quantity + ", description=" + description + ", idEquipment=" + idEquipment + ", name=" + name + '}';
    }
    
    
    
}

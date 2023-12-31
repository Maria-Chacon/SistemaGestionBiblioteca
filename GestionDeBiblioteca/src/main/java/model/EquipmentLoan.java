/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


//Universidad Nacional, Coto
//Desarrollado por:
//María José Chacón Mora
//Dayana Gamboa Monge
//2023

public class EquipmentLoan {
    private int idEquipmentLoan;
    private String nameEquipment;
    private Date devolutionDate;
    private Date loanDate;
    private Suspension suspension;
    private User identificationUser;

    public EquipmentLoan() {
    }

    public EquipmentLoan(int idEquipmentLoan, String nameEquipment, Date devolutionDate, Date loanDate, Suspension suspension, User identificationUser) {
        this.idEquipmentLoan = idEquipmentLoan;
        this.nameEquipment = nameEquipment;
        this.devolutionDate = devolutionDate;
        this.loanDate = loanDate;
        this.suspension = suspension;
        this.identificationUser = identificationUser;
    }

    public int getIdEquipmentLoan() {
        return idEquipmentLoan;
    }

    public void setIdEquipmentLoan(int idEquipmentLoan) {
        this.idEquipmentLoan = idEquipmentLoan;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    public User getIdentificationUser() {
        return identificationUser;
    }

    public void setIdentificationUser(User identificationUser) {
        this.identificationUser = identificationUser;
    }

    @Override
    public String toString() {
        return "EquipmentLoan{" + "idEquipmentLoan=" + idEquipmentLoan + ", nameEquipment=" + nameEquipment + ", devolutionDate=" + devolutionDate + ", loanDate=" + loanDate + ", suspension=" + suspension + ", identificationUser=" + identificationUser + '}';
    }
    
    
    
}

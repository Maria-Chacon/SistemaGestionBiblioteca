/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author monge
 */
public class Suspension {
    private boolean enable;
    private float amount;
    private int daysLate;
    private String reason;


    public Suspension(boolean enable, float amount, int daysLate, String reason) {
        this.enable = enable;
        this.amount = amount;
        this.daysLate = daysLate;
        this.reason = reason;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) {
        this.daysLate = daysLate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    
    
    @Override
    public String toString() {
        return "Suspension{" + "enable=" + enable + ", amount=" + amount + ", daysLate=" + daysLate + ", reason=" + reason + '}';
    }
    
    
}

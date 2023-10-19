/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usuario
 */
public class Verification {  
    private static String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        if(Verification.id == null){
            Verification.id = id;
        }
        
    }
    
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Dell
 */
public class Rol {
    
    private int RolID;
    private String RolDescripcion;

    public Rol(int RolID, String RolDescripcion) {
        this.RolID = RolID;
        this.RolDescripcion = RolDescripcion;
    }
    
    public Rol(){
        
    
    }

    public int getRolID() {
        return RolID;
    }

    public void setRolID(int RolID) {
        this.RolID = RolID;
    }

    public String getRolDescripcion() {
        return RolDescripcion;
    }

    public void setRolDescripcion(String RolDescripcion) {
        this.RolDescripcion = RolDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.RolID;
        hash = 53 * hash + Objects.hashCode(this.RolDescripcion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if (this.RolID != other.RolID) {
            return false;
        }
        return Objects.equals(this.RolDescripcion, other.RolDescripcion);
    }

    
}

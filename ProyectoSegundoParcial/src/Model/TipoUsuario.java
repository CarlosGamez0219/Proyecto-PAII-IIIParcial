/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class TipoUsuario {
 
//Declaracion de variables de la clase.    
private int TipoUsuarioID;
private String DescripcionUsuario;
    
    //Constructor. 

    public TipoUsuario(int TipoUsuarioID, String DescripcionUsuario) {
        this.TipoUsuarioID = TipoUsuarioID;
        this.DescripcionUsuario = DescripcionUsuario;
    }

    public TipoUsuario(){
        
    }
    
    public int getTipoUsuarioID() {
        return TipoUsuarioID;
    }

    public void setTipoUsuarioID(int TipoUsuarioID) {
        this.TipoUsuarioID = TipoUsuarioID;
    }

    public String getDescripcionUsuario() {
        return DescripcionUsuario;
    }

    public void setDescripcionUsuario(String DescripcionUsuario) {
        this.DescripcionUsuario = DescripcionUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.TipoUsuarioID;
        hash = 41 * hash + Objects.hashCode(this.DescripcionUsuario);
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
        final TipoUsuario other = (TipoUsuario) obj;
        if (this.TipoUsuarioID != other.TipoUsuarioID) {
            return false;
        }
        return Objects.equals(this.DescripcionUsuario, other.DescripcionUsuario);
    }
    
    
}

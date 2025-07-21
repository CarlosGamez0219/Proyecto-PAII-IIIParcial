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
public class Categorias {
    
    private int CategoriaID;
    private String CategoriaDescripcion;
    

    public Categorias(int CategoriaID, String CategoriaDescripcion) {
        this.CategoriaID = CategoriaID;
        this.CategoriaDescripcion = CategoriaDescripcion;
    }
    
    public Categorias(){
        
    
    }

    public int getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(int CategoriaID) {
        this.CategoriaID = CategoriaID;
    }

    public String getCategoriaDescripcion() {
        return CategoriaDescripcion;
    }

    public void setCategoriaDescripcion(String CategoriaDescripcion) {
        this.CategoriaDescripcion = CategoriaDescripcion;
    }

    


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.CategoriaID;
        hash = 37 * hash + Objects.hashCode(this.CategoriaDescripcion);
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
        final Categorias other = (Categorias) obj;
        if (this.CategoriaID != other.CategoriaID) {
            return false;
        }
        return Objects.equals(this.CategoriaDescripcion, other.CategoriaDescripcion);
    }
}

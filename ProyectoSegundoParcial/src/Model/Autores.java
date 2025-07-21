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
public class Autores {
    
     private int AutorID;
    private String NombreAutor;
    private String ApellidoAutor;
    

    public Autores(int AutorID, String NombreAutor, String ApellidoAutor ) {
        this.AutorID = AutorID;
        this.NombreAutor = NombreAutor;
        this.ApellidoAutor = ApellidoAutor;
    }
    
    public Autores(){
       
    }

    public int getAutorID() {
        return AutorID;
    }

    public void setAutorID(int AutorID) {
        this.AutorID = AutorID;
    }

    public String getNombreAutor() {
        return NombreAutor;
    }

    public void setNombreAutor(String NombreAutor) {
        this.NombreAutor = NombreAutor;
    }

    public String getApellidoAutor() {
        return ApellidoAutor;
    }

    public void setApellidoAutor(String ApellidoAutor) {
        this.ApellidoAutor = ApellidoAutor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.AutorID;
        hash = 67 * hash + Objects.hashCode(this.NombreAutor);
        hash = 67 * hash + Objects.hashCode(this.ApellidoAutor);
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
        final Autores other = (Autores) obj;
        if (this.AutorID != other.AutorID) {
            return false;
        }
        if (!Objects.equals(this.NombreAutor, other.NombreAutor)) {
            return false;
        }
        return Objects.equals(this.ApellidoAutor, other.ApellidoAutor);
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class Ejemplares {
    private int EjemplarID;
    private int LibroID;
    private Date FechaIngreso;
    private int Estado;

    public Ejemplares(int EjemplarID, int LibroID, Date FechaIngreso, int Estado) {
        this.EjemplarID = EjemplarID;
        this.LibroID = LibroID;
        this.FechaIngreso = FechaIngreso;
        this.Estado = Estado;
    }

   
    
    public Ejemplares(){
        
    
    }
    

    public int getEjemplarID() {
        return EjemplarID;
    }

    public void setEjemplarID(int EjemplarID) {
        this.EjemplarID = EjemplarID;
    }

    public int getLibroID() {
        return LibroID;
    }

    public void setLibroID(int LibroID) {
        this.LibroID = LibroID;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.EjemplarID;
        hash = 31 * hash + this.LibroID;
        hash = 31 * hash + Objects.hashCode(this.FechaIngreso);
        hash = 31 * hash + this.Estado;
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
        final Ejemplares other = (Ejemplares) obj;
        if (this.EjemplarID != other.EjemplarID) {
            return false;
        }
        if (this.LibroID != other.LibroID) {
            return false;
        }
        if (this.Estado != other.Estado) {
            return false;
        }
        return Objects.equals(this.FechaIngreso, other.FechaIngreso);
    }
    
    
    
    
}

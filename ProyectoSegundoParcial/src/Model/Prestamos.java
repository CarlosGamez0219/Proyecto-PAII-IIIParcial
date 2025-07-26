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
public class Prestamos {
     private int PrestamoID;
     private int UsuarioID;
     private int EjemplarID;
     private Date FechaEgreso;
     private Date FechaDevolucionEstimada;
     private int EmpleadoID;

    public Prestamos(int PrestamoID, int UsuarioID, int EjemplarID, Date FechaEgreso, Date FechaDevolucionEstimada, int EmpleadoID) {
        this.PrestamoID = PrestamoID;
        this.UsuarioID = UsuarioID;
        this.EjemplarID = EjemplarID;
        this.FechaEgreso = FechaEgreso;
        this.FechaDevolucionEstimada = FechaDevolucionEstimada;
        this.EmpleadoID = EmpleadoID;
    }

    public Prestamos(){
        
    
    }

    public int getPrestamoID() {
        return PrestamoID;
    }

    public void setPrestamoID(int PrestamoID) {
        this.PrestamoID = PrestamoID;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public int getEjemplarID() {
        return EjemplarID;
    }

    public void setEjemplarID(int EjemplarID) {
        this.EjemplarID = EjemplarID;
    }

    public Date getFechaEgreso() {
        return FechaEgreso;
    }

    public void setFechaEgreso(Date FechaEgreso) {
        this.FechaEgreso = FechaEgreso;
    }

    public Date getFechaDevolucionEstimada() {
        return FechaDevolucionEstimada;
    }

    public void setFechaDevolucionEstimada(Date FechaDevolucionEstimada) {
        this.FechaDevolucionEstimada = FechaDevolucionEstimada;
    }

    public int getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.PrestamoID;
        hash = 97 * hash + this.UsuarioID;
        hash = 97 * hash + this.EjemplarID;
        hash = 97 * hash + Objects.hashCode(this.FechaEgreso);
        hash = 97 * hash + Objects.hashCode(this.FechaDevolucionEstimada);
        hash = 97 * hash + this.EmpleadoID;
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
        final Prestamos other = (Prestamos) obj;
        if (this.PrestamoID != other.PrestamoID) {
            return false;
        }
        if (this.UsuarioID != other.UsuarioID) {
            return false;
        }
        if (this.EjemplarID != other.EjemplarID) {
            return false;
        }
        if (this.EmpleadoID != other.EmpleadoID) {
            return false;
        }
        if (!Objects.equals(this.FechaEgreso, other.FechaEgreso)) {
            return false;
        }
        return Objects.equals(this.FechaDevolucionEstimada, other.FechaDevolucionEstimada);
    }
    
    
    
     
}

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
public class Empleados {
   
    //Declaracion de las variables de la clase.
    private int EmpleadoID;
    private String NombreEmpleado;
    private String Contraseña;
    private int RolID;
    private String RolDescripcion;
    private int Status;

    public Empleados(int EmpleadoID, String NombreEmpleado, String Contraseña, int RolID, int Status) {
        this.EmpleadoID = EmpleadoID;
        this.NombreEmpleado = NombreEmpleado;
        this.Contraseña = Contraseña;
        this.RolID = RolID;
        this.Status = Status;
    }

    
    public Empleados() {
        
    }

    public int getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
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

    
    
    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.EmpleadoID;
        hash = 59 * hash + Objects.hashCode(this.NombreEmpleado);
        hash = 59 * hash + Objects.hashCode(this.Contraseña);
        hash = 59 * hash + this.RolID;
        hash = 59 * hash + this.Status;
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
        final Empleados other = (Empleados) obj;
        if (this.EmpleadoID != other.EmpleadoID) {
            return false;
        }
        if (this.RolID != other.RolID) {
            return false;
        }
        if (this.Status != other.Status) {
            return false;
        }
        if (!Objects.equals(this.NombreEmpleado, other.NombreEmpleado)) {
            return false;
        }
        return Objects.equals(this.Contraseña, other.Contraseña);
    }

    
    }

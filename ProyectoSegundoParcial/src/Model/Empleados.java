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
    private String RolDescripcion;
    private byte Status;

    public Empleados(int EmpleadoID, String NombreEmpleado, String RolDescripcion, byte Status) {
        this.EmpleadoID = EmpleadoID;
        this.NombreEmpleado = NombreEmpleado;
        this.RolDescripcion = RolDescripcion;
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

    public String getRolDescripcion() {
        return RolDescripcion;
    }

    public void setRolDescripcion(String RolDescripcion) {
        this.RolDescripcion = RolDescripcion;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte Status) {
        this.Status = Status;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.EmpleadoID;
        hash = 31 * hash + Objects.hashCode(this.NombreEmpleado);
        hash = 31 * hash + Objects.hashCode(this.RolDescripcion);
        hash = 31 * hash + this.Status;
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
        if (this.Status != other.Status) {
            return false;
        }
        if (!Objects.equals(this.NombreEmpleado, other.NombreEmpleado)) {
            return false;
        }
       /* if (!Objects.equals(this.Contraseña, other.Contraseña)) {
            return false;
        }*/
        return Objects.equals(this.RolDescripcion, other.RolDescripcion);
    }

     
}

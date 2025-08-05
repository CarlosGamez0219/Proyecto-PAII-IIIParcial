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
public class Usuarios {
    
    private int UsuarioID;
    private String Correo;
    private String Telefono;
    private String Direccion;
    private String Nombre;
    private String Apellido;
    private int TipoUsuarioID =1;
    private int Status;
    private String Contraseña ="s";

    public Usuarios(int UsuarioID, String Correo, String Telefono, String Direccion, String Nombre, String Apellido, int TipoUsuarioID, int Status, String Contraseña) {
        this.UsuarioID = UsuarioID;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.TipoUsuarioID = TipoUsuarioID;
        this.Status = Status;
        this.Contraseña = Contraseña;
    }
    
    public Usuarios(){
        
    
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getTipoUsuarioID() {
        return TipoUsuarioID;
    }

    public void setTipoUsuarioID(int TipoUsuarioID) {
        this.TipoUsuarioID = TipoUsuarioID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.UsuarioID;
        hash = 53 * hash + Objects.hashCode(this.Correo);
        hash = 53 * hash + Objects.hashCode(this.Telefono);
        hash = 53 * hash + Objects.hashCode(this.Direccion);
        hash = 53 * hash + Objects.hashCode(this.Nombre);
        hash = 53 * hash + Objects.hashCode(this.Apellido);
        hash = 53 * hash + this.TipoUsuarioID;
        hash = 53 * hash + this.Status;
        hash = 53 * hash + Objects.hashCode(this.Contraseña);
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
        final Usuarios other = (Usuarios) obj;
        if (this.UsuarioID != other.UsuarioID) {
            return false;
        }
        if (this.TipoUsuarioID != other.TipoUsuarioID) {
            return false;
        }
        if (this.Status != other.Status) {
            return false;
        }
        if (!Objects.equals(this.Correo, other.Correo)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellido, other.Apellido)) {
            return false;
        }
        return Objects.equals(this.Contraseña, other.Contraseña);
    }
    
}

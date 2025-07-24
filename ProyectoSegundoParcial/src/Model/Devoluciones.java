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
public class Devoluciones {
    private int DevolucionID;
    private int EjemplarID;
    private int PrestamoID;
    private Date FechaDevolucion;
    private String Comentario;
    private int EmpleadoID;

    public Devoluciones(int DevolucionID, int EjemplarID, int PrestamoID, Date FechaDevolucion, String Comentario, int EmpleadoID) {
        this.DevolucionID = DevolucionID;
        this.EjemplarID = EjemplarID;
        this.PrestamoID = PrestamoID;
        this.FechaDevolucion = FechaDevolucion;
        this.Comentario = Comentario;
        this.EmpleadoID = EmpleadoID;
    }
    
    public Devoluciones(){
        
    
    }

    public int getDevolucionID() {
        return DevolucionID;
    }

    public void setDevolucionID(int DevolucionID) {
        this.DevolucionID = DevolucionID;
    }

    public int getEjemplarID() {
        return EjemplarID;
    }

    public void setEjemplarID(int EjemplarID) {
        this.EjemplarID = EjemplarID;
    }

    public int getPrestamoID() {
        return PrestamoID;
    }

    public void setPrestamoID(int PrestamoID) {
        this.PrestamoID = PrestamoID;
    }

    public Date getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(Date FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
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
        hash = 89 * hash + this.DevolucionID;
        hash = 89 * hash + this.EjemplarID;
        hash = 89 * hash + this.PrestamoID;
        hash = 89 * hash + Objects.hashCode(this.FechaDevolucion);
        hash = 89 * hash + Objects.hashCode(this.Comentario);
        hash = 89 * hash + this.EmpleadoID;
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
        final Devoluciones other = (Devoluciones) obj;
        if (this.DevolucionID != other.DevolucionID) {
            return false;
        }
        if (this.EjemplarID != other.EjemplarID) {
            return false;
        }
        if (this.PrestamoID != other.PrestamoID) {
            return false;
        }
        if (this.EmpleadoID != other.EmpleadoID) {
            return false;
        }
        if (!Objects.equals(this.Comentario, other.Comentario)) {
            return false;
        }
        return Objects.equals(this.FechaDevolucion, other.FechaDevolucion);
    }
    
}

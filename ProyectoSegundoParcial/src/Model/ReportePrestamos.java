/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
/**
 *
 * @author Dell
 */
public class ReportePrestamos {
   
    private int PrestamoID;
    private String Usuario;
    private String Libro;
    private Date FechaEgreso;
    private Date FechaDevolucionEstimada;
    private Date FechaDevolucion;
    private String Comentario;
    private String EmpleadoPrestamo;
    private String EmpleadoDevolucion;

    public ReportePrestamos(int PrestamoID, String Usuario, String Libro, Date FechaEgreso, Date FechaDevolucionEstimada, Date FechaDevolucion, String Comentario, String EmpleadoPrestamo, String EmpleadoDevolucion) {
        this.PrestamoID = PrestamoID;
        this.Usuario = Usuario;
        this.Libro = Libro;
        this.FechaEgreso = FechaEgreso;
        this.FechaDevolucionEstimada = FechaDevolucionEstimada;
        this.FechaDevolucion = FechaDevolucion;
        this.Comentario = Comentario;
        this.EmpleadoPrestamo = EmpleadoPrestamo;
        this.EmpleadoDevolucion = EmpleadoDevolucion;
    }

    public ReportePrestamos(){
        
    }
    
    
    public int getPrestamoID() {
        return PrestamoID;
    }

    public void setPrestamoID(int PrestamoID) {
        this.PrestamoID = PrestamoID;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getLibro() {
        return Libro;
    }

    public void setLibro(String Libro) {
        this.Libro = Libro;
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

    public String getEmpleadoPrestamo() {
        return EmpleadoPrestamo;
    }

    public void setEmpleadoPrestamo(String EmpleadoPrestamo) {
        this.EmpleadoPrestamo = EmpleadoPrestamo;
    }

    public String getEmpleadoDevolucion() {
        return EmpleadoDevolucion;
    }

    public void setEmpleadoDevolucion(String EmpleadoDevolucion) {
        this.EmpleadoDevolucion = EmpleadoDevolucion;
    }
    
    

    
}

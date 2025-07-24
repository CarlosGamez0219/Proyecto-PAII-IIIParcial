/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Bd.ConnectionBD;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Model.Devoluciones;
import java.sql.PreparedStatement;
/**
 *
 * @author Dell
 */
public class DevolucionesDAO {
    
     public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Devoluciones;";
        try (Connection con = ConnectionBD.geConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Devoluciones(resultado.getInt("DevolucionID"), resultado.getInt("EjemplarID"), resultado.getInt("PrestamoID"), resultado.getDate("FechaDevolucion"), resultado.getString("Comentario"), resultado.getInt("EmpleadoID")));
            }
            
             }catch(SQLException ex){
            System.err.println("Error al listar Devoluciones: " + ex.getMessage());
        
            }
        
            return listado;
        
     }
     
     public boolean insert(Object object){
        Devoluciones devoluciones = (Devoluciones) object;
        String sql = "INSERT INTO Devoluciones (EjemplarID, PrestamoID, FechaDevolucion, Comentario, EmpleadoID ) VALUES (?, ?, ?, ?, ?);";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, devoluciones.getEjemplarID());
             pst.setInt(2, devoluciones.getPrestamoID());
             pst.setDate(3, new java.sql.Date(devoluciones.getFechaDevolucion().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setString(4, devoluciones.getComentario());
             pst.setInt(5, devoluciones.getEmpleadoID());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Devoluciones: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
        Devoluciones devoluciones = (Devoluciones) object;
        String sql = "UPDATE Devoluciones SET EjemplarID = ?, PrestamoID = ?, FechaDevolucion = ?, Comentario = ?, EmpleadoID = ? WHERE DevolucionID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, devoluciones.getEjemplarID());
             pst.setInt(2, devoluciones.getPrestamoID());
             pst.setDate(3, new java.sql.Date(devoluciones.getFechaDevolucion().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setString(4, devoluciones.getComentario());
             pst.setInt(5, devoluciones.getEmpleadoID());
             pst.setInt(6, devoluciones.getDevolucionID());  // Aquí es importante usar el ID para actualizar la devolución correcta
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar DEvoluciones: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int DevolucionID){
        String sql = "DELETE FROM DEvoluciones WHERE DevolucionID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,DevolucionID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Devoluciones: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByLibrosID(int DevolucionID){
        String sql = "SELECT * FROM Devoluciones WHERE DevolucionID = ?;";
        Devoluciones devoluciones = new Devoluciones();
        try (Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, DevolucionID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                devoluciones.setDevolucionID(resultado.getInt("DevolucionID"));
                devoluciones.setEjemplarID(resultado.getInt("EjemplarID"));
                devoluciones.setPrestamoID(resultado.getInt("PrestamoID"));
                devoluciones.setFechaDevolucion(resultado.getDate("FechaDevolucion"));
                devoluciones.setComentario(resultado.getString("Comentario"));
                devoluciones.setEmpleadoID(resultado.getInt("EmpleadoID"));
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Devoluciones: " + ex.getMessage());
        
        }
        
        return devoluciones;
    }
}

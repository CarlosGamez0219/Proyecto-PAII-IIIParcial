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
import Model.Prestamos;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class PrestamosDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos;";
        try (Connection con = ConnectionBD.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Prestamos(resultado.getInt("PrestamoID"), resultado.getInt("UsuarioID"), resultado.getInt("EjemplarID"), resultado.getDate("FechaEgreso"), resultado.getDate("FechaDevolucionEstimada"), resultado.getInt("EmpleadoID")));
            }
            
             }catch(SQLException ex){
            System.err.println("Error al listar Prestamos: " + ex.getMessage());
        
            }
        
            return listado;
        
     }
     
     public boolean insert(Object object){
        Prestamos prestamos = (Prestamos) object;
        String sql = "INSERT INTO Prestamos (UsuarioID, EjemplarID, FechaEgreso, FechaDevolucionEstimada, EmpleadoID ) VALUES (?, ?, ?, ?, ?);";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, prestamos.getUsuarioID());
             pst.setInt(2, prestamos.getEjemplarID());
             pst.setDate(3, new java.sql.Date(prestamos.getFechaEgreso().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setDate(4, new java.sql.Date(prestamos.getFechaDevolucionEstimada().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setInt(5, prestamos.getEmpleadoID());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Prestamo: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
        Prestamos prestamos = (Prestamos) object;
        String sql = "UPDATE Prestamos SET UsuarioID = ?, EjemplarID = ?, FechaEgreso = ?, FechaDevolucionEstimada = ?, EmpleadoID = ? WHERE PrestamoID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, prestamos.getUsuarioID());
             pst.setInt(2, prestamos.getEjemplarID());
             pst.setDate(3, new java.sql.Date(prestamos.getFechaEgreso().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setDate(4, new java.sql.Date(prestamos.getFechaDevolucionEstimada().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setInt(5, prestamos.getEmpleadoID());
             pst.setInt(6, prestamos.getPrestamoID());  // Aquí es importante usar el ID para actualizar la devolución correcta
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Prestamos: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int PrestamoID){
        String sql = "DELETE FROM Prestamos WHERE PrestamoID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,PrestamoID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Prestamo: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByLibrosID(int PrestamoID){
        String sql = "SELECT * FROM Prestamos WHERE PrestamoID = ?;";
        Prestamos prestamos = new Prestamos();
        try (Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, PrestamoID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                prestamos.setPrestamoID(resultado.getInt("PrestamoID"));
                prestamos.setUsuarioID(resultado.getInt("UsuarioID"));
                prestamos.setEjemplarID(resultado.getInt("EjemplarID"));
                prestamos.setFechaEgreso(resultado.getDate("FechaEgreso"));
                prestamos.setFechaDevolucionEstimada(resultado.getDate("FechaDevolucionEstimada"));
                prestamos.setEmpleadoID(resultado.getInt("EmpleadoID"));
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Prestamos: " + ex.getMessage());
        
        }
        
        return prestamos;
    }
    
}

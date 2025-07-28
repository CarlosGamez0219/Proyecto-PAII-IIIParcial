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
import Model.Ejemplares;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class EjemplaresDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Ejemplares;";
        try (Connection con = ConnectionBD.geConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Ejemplares(resultado.getInt("EjemplarID"), resultado.getInt("LibroID"), resultado.getDate("FechaIngreso"), resultado.getInt("Estado")));
            }
            
             }catch(SQLException ex){
            System.err.println("Error al listar Ejemplares: " + ex.getMessage());
        
            }
        
            return listado;
        
     }
     
     public boolean insert(Object object){
        Ejemplares ejemplares = (Ejemplares) object;
        String sql = "INSERT INTO Ejemplares (LibroID, FechaIngreso, Estado) VALUES (?, ?, ?);";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, ejemplares.getLibroID());
             pst.setDate(2, new java.sql.Date(ejemplares.getFechaIngreso().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setInt(3, ejemplares.getEstado());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Ejemplares: " + ex.getMessage());
            return false;
        }
    }
    
     public boolean update(Object object){
        Ejemplares ejemplares = (Ejemplares) object;
        String sql = "UPDATE Ejemplares SET LibroID = ?, FechaIngreso = ?, Estado = ? WHERE EjemplarID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, ejemplares.getLibroID());
             pst.setDate(2, new java.sql.Date(ejemplares.getFechaIngreso().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setInt(3, ejemplares.getEstado());
             pst.setInt(4, ejemplares.getEjemplarID());  // Aquí es importante usar el ID para actualizar la devolución correcta
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Ejemplares: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int EjemplarID){
        String sql = "DELETE FROM Ejemplares WHERE EjemplarID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, EjemplarID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Ejemplares: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByEjemplarID(int EjemplarID){
        String sql = "SELECT * FROM Ejemplares WHERE EjemplarID = ?;";
        Ejemplares ejemplares = new Ejemplares();
        try (Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, EjemplarID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                ejemplares.setEjemplarID(resultado.getInt("EjemplarID"));
                ejemplares.setLibroID(resultado.getInt("LibroID"));
                ejemplares.setFechaIngreso(resultado.getDate("FechaIngreso"));
                ejemplares.setEstado(resultado.getInt("Estado"));
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Ejemplares: " + ex.getMessage());
        
        }
        
        return ejemplares;
    }
    
}

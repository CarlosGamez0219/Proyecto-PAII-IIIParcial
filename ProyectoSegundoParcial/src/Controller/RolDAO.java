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
import Model.Rol;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class RolDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Rol;";
        try (Connection con = ConnectionBD.geConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Rol(resultado.getInt("RolID"), resultado.getString("RolDescripcion")));
            }
        }catch(SQLException ex){
            System.err.println("Error al listar Rol: " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        Rol rol = (Rol) object;
        String sql = "INSERT INTO Rol (RolDescripcion) VALUES (?);";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, rol .getRolDescripcion());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Rol: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
       Rol rol = (Rol) object;
        String sql = "UPDATE rol SET RolDescripcion = ? WHERE RolID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, rol .getRolDescripcion());
             pst.setInt(2, rol.getRolID());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Rol: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int RolID){
        String sql = "DELETE FROM Rol WHERE RolID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, RolID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Rol: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByRolID(int RolID){
        String sql = "SELECT * FROM Rol WHERE RolID = ?;";
        Rol rol = new Rol();
        try (Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, RolID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                rol.setRolID(resultado.getInt("RolID"));
                rol.setRolDescripcion(resultado.getString("RolDescripcion"));
               
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Rol: " + ex.getMessage());
        
        }
        
        return rol;
    }
    
}

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
import Model.Autores;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class AutoresDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Autores;";
        try (Connection con = ConnectionBD.geConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Autores(resultado.getInt("AutorID"), resultado.getString("NombreAutor"), resultado.getString("ApellidoAutor")));
            }
        }catch(SQLException ex){
            System.err.println("Error al listar Autores: " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        Autores autores = (Autores) object;
        String sql = "INSERT INTO Autores (NombreAutor, ApellidoAutor) VALUES (?, ?);";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, autores .getNombreAutor());
             pst.setString(2, autores .getApellidoAutor());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Autores: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
       Autores autores = (Autores) object;
        String sql = "UPDATE Autores SET NombreAutor = ?, ApellidoAutor = ? WHERE AutorID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, autores .getNombreAutor());
             pst.setString(2, autores .getApellidoAutor());
             pst.setInt(3, autores.getAutorID());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Autores: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int AutorID){
        String sql = "DELETE FROM Autores WHERE AutorID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, AutorID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Autores: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByAutorID(int AutorID){
        String sql = "SELECT * FROM Autores WHERE AutorID = ?;";
        Autores autores = new Autores();
        try (Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, AutorID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                autores.setAutorID(resultado.getInt("AutorID"));
                autores.setNombreAutor(resultado.getString("NombreAutor"));
                autores.setApellidoAutor(resultado.getString("ApellidoAutor"));
               
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Autores: " + ex.getMessage());
        
        }
        
        return autores;
    }
    
}

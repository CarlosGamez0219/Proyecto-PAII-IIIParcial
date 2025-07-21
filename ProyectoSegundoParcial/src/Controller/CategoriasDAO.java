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
import Model.Categorias;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class CategoriasDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Categorias;";
        try (Connection con = ConnectionBD.geConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Categorias(resultado.getInt("CategoriaID"), resultado.getString("CategoriaDescripcion")));
            }
        }catch(SQLException ex){
            System.err.println("Error al listar Categorias: " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        Categorias categorias = (Categorias) object;
        String sql = "INSERT INTO Categorias (CategoriaDescripcion) VALUES (?);";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, categorias.getCategoriaDescripcion());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Categorias: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
        Categorias categorias = (Categorias) object;
        String sql = "UPDATE Categorias SET CategoriaDescripcion = ? WHERE CategoriaID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, categorias.getCategoriaDescripcion());
             pst.setInt(2, categorias.getCategoriaID());  // Aquí es importante usar el ID para actualizar el libro correcto
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Categorias: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int CategoriaID){
        String sql = "DELETE FROM Categorias WHERE CategoriaID = ?";
        try(Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,CategoriaID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Categorias: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByCategoriaID(int CategoriaID){
        String sql = "SELECT * FROM Categorias WHERE CategoriaID = ?;";
        Categorias categorias = new Categorias();
        try (Connection con = ConnectionBD.geConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, CategoriaID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                categorias.setCategoriaID(resultado.getInt("CategoriaID"));
                categorias.setCategoriaDescripcion(resultado.getString("CategoriaDescripcion"));
               
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Categorias: " + ex.getMessage());
        
        }
        
        return categorias;
    }
    
}

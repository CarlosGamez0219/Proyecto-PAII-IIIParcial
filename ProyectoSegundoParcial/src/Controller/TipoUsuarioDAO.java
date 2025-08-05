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
import Model.TipoUsuario;
import java.sql.PreparedStatement;
/**
 *
 * @author Carlos
 */
public class TipoUsuarioDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM TipoUsuario;";
        try (Connection con = ConnectionBD.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new TipoUsuario(resultado.getInt("TipoUsuarioID"), resultado.getString("DescripcionUsuario")));
            }
        }catch(SQLException ex){
            System.err.println("Error al listar Tipos de Usuarios: " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        TipoUsuario tipousuario = (TipoUsuario) object;
        String sql = "INSERT INTO tipousuario (DescripcionUsuario) VALUES (?);";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, tipousuario.getDescripcionUsuario());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar un nuevo Tipo de Usuario: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
       TipoUsuario tipousuario = (TipoUsuario) object;
        String sql = "UPDATE TipoUsuario SET DescripcionUsuario= ? WHERE TipoUsuarioID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, tipousuario.getDescripcionUsuario());
             pst.setInt(2, tipousuario.getTipoUsuarioID());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Tipo Usuario: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int TipoUsuarioID){
        String sql = "DELETE FROM TipoUsuario WHERE TipoUsuarioID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, TipoUsuarioID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Tipo Usuario: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByTipoUsuarioID(int TipoUsuarioID){
        String sql = "SELECT * FROM TipoUsuario WHERE TipoUsuarioID = ?;";
        TipoUsuario tipousuario = new TipoUsuario();
        try (Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, TipoUsuarioID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                tipousuario.setTipoUsuarioID(resultado.getInt("TipoUsuarioID"));
                tipousuario.setDescripcionUsuario(resultado.getString("DescripcionUsuario"));
               
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Tipo Usuario: " + ex.getMessage());
        
        }
        
        return tipousuario;
    }

}

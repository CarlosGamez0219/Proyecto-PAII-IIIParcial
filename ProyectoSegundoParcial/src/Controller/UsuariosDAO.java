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
import Model.Usuarios;
import java.sql.PreparedStatement;


public class UsuariosDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios;";
        try (Connection con = ConnectionBD.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Usuarios(resultado.getInt("UsuarioID"), resultado.getString("Correo"), resultado.getString("Telefono"), resultado.getString("Direccion"), resultado.getString("Nombre"), resultado.getString("Apellido"), resultado.getInt("TipoUsuarioID"), resultado.getInt("Status"),resultado.getString("Contraseña")));
            }
            
             }catch(SQLException ex){
            System.err.println("Error al listar Usuarios: " + ex.getMessage());
        
            }
        
            return listado;
        
     }
     
     public boolean insert(Object object){
        Usuarios usuarios = (Usuarios) object;
        String sql = "INSERT INTO Usuarios (Correo, Telefono, Direccion, Nombre, Apellido, TipoUsuarioID, Status, Contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, usuarios.getCorreo());
             pst.setString(2, usuarios.getTelefono());
             pst.setString(3, usuarios.getDireccion());
             pst.setString(4, usuarios.getNombre());
             pst.setString(5, usuarios.getApellido());
             pst.setInt(6, usuarios.getTipoUsuarioID());
             pst.setInt(7, usuarios.getStatus());
             pst.setString(8, usuarios.getContraseña());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al regirtrar Usuarios: " + ex.getMessage());
            return false;
        }
    }
    
     public boolean update(Object object){
        Usuarios usuarios = (Usuarios) object;
        String sql = "UPDATE Usuarios SET Correo = ?, Telefono = ?, Direccion = ?, Nombre = ?, Apellido = ?, TipoUsuarioID = ?, Status = ?, Contraseña = ?  WHERE UsuarioID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, usuarios.getCorreo());
             pst.setString(2, usuarios.getTelefono());
             pst.setString(3, usuarios.getDireccion());
             pst.setString(4, usuarios.getNombre());
             pst.setString(5, usuarios.getApellido());
             pst.setInt(6, 1);
             pst.setInt(7, usuarios.getStatus());
             pst.setString(8, "s");
             pst.setInt(9, usuarios.getUsuarioID());  // Aquí es importante usar el ID para actualizar la devolución correcta
             //return pst.executeUpdate()>0;
             
             System.out.println("DEBUG UsuarioID: " + usuarios.getUsuarioID());
        
            int filas = pst.executeUpdate();
            return filas > 0;
          } catch (Exception e) {
          e.printStackTrace();
            return false;
            }
             
        /*}catch(SQLException ex){
            System.err.println("Error al actualizar Usuarios: " + ex.getMessage());
            return false;
        }*/
    }
    
    public boolean delete(int UsuarioID){
            String sql = "DELETE FROM Usuarios WHERE UsuarioID = ?";
            try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, UsuarioID);
             return pst.executeUpdate()>0;
        
            }catch(SQLException ex){
            System.err.println("Error al eliminar Usuario: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByUsuarioID(int UsuarioID){
            String sql = "SELECT * FROM Usuarios WHERE UsuarioID = ?;";
            Usuarios usuarios = new Usuarios();
            try (Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, UsuarioID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                usuarios.setUsuarioID(resultado.getInt("UsuarioID"));
                usuarios.setCorreo(resultado.getString("Correo"));
                usuarios.setTelefono(resultado.getString("Telefono"));
                usuarios.setDireccion(resultado.getString("Direccion"));
                usuarios.setNombre(resultado.getString("Nombre"));
                usuarios.setApellido(resultado.getString("Apellido"));
                usuarios.setTipoUsuarioID(resultado.getInt("TipoUsuarioID"));
                usuarios.setStatus(resultado.getInt("Status"));
                usuarios.setContraseña(resultado.getString("Contraseña"));
            }   
            }catch(SQLException ex){
            System.err.println("Error al listar Usuarios: " + ex.getMessage());
        
        }
        
        return usuarios;
    }
    
}

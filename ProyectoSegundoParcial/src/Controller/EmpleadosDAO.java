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
import Model.Empleados;
import java.sql.PreparedStatement;
/**
 *
 * @author Carlos
 */
public class EmpleadosDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT e.EmpleadoID, e.NombreEmpleado, e.Status, r.RolDescripcion " +
                     "FROM Empleados e " +
                     "JOIN Rol r ON e.RolID = r.RolID;";
        try (Connection con = ConnectionBD.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Empleados(resultado.getInt("EmpleadoID"), resultado.getString("NombreEmpleado"), resultado.getString("RolDescripcion"), resultado.getByte("Status")));
            }
        }catch(SQLException ex){
            System.err.println("Error al cargar la lista de empleados. " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        Empleados empleados = (Empleados) object;
        String sql = "INSERT INTO Empleados (EmpleadoID, NombreEmpleado, RolDescripcion, Status) VALUES (?, ?, ?, ?);";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, empleados.getEmpleadoID());
             pst.setString(2, empleados.getNombreEmpleado());
             pst.setString(3, empleados.getRolDescripcion());
             pst.setByte(4, empleados.getStatus());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Empleados: " + ex.getMessage());
            return false;
        }
    }
    public boolean update(Object object){
        Empleados empleados = (Empleados) object;
        String sql = "UPDATE Empleados SET EmpleadoID = ?, NombreEmpleado = ?, RolDescripcion = ?, Status = ? WHERE EmpleadoID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, empleados.getEmpleadoID());
             pst.setString(2, empleados.getNombreEmpleado());
             pst.setString(3, empleados.getRolDescripcion());
             pst.setByte(5, empleados.getStatus());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Empleados: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int EmpleadoID){
        String sql = "DELETE FROM Empleados WHERE EmpleadoID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,EmpleadoID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar al empleado: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByEmpleadoID(int EmpleadoID){
        String sql = "SELECT * FROM Empleados WHERE EmpleadoID = ?;";
        Empleados empleados = new Empleados();
        try (Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, EmpleadoID);
            
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                empleados.setEmpleadoID(resultado.getInt("EmpleadoID"));
                empleados.setNombreEmpleado(resultado.getString("NombreEmpleado"));
                empleados.setRolDescripcion(resultado.getString("RolDescripcion"));
                empleados.setStatus(resultado.getByte("Status"));
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Empleados: " + ex.getMessage());
        
        }
        
        return empleados;
    }
}
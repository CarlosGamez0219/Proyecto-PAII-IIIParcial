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
import org.mindrot.jbcrypt.BCrypt;
import java.sql.PreparedStatement;
/**
 *
 * @author Carlos
 */
public class EmpleadosDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Empleados;";
        try (Connection con = ConnectionBD.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Empleados(resultado.getInt("EmpleadoID"), resultado.getString("NombreEmpleado"), resultado.getString("Contraseña"), resultado.getInt("RolID"), resultado.getInt("Status")));
            }
        }catch(SQLException ex){
            System.err.println("Error al cargar la lista de empleados. " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        Empleados empleados = (Empleados) object;
        String sql = "INSERT INTO Empleados (NombreEmpleado, Contraseña, RolID, Status) VALUES (?, ?, ?, ?);";
        try(Connection con = ConnectionBD.getConnection()){
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, empleados.getNombreEmpleado());
             pst.setString(2, empleados.getContraseña());
             pst.setInt(3, empleados.getRolID());
             pst.setInt(4, empleados.getStatus());
             return pst.executeUpdate()>0;
        
            }catch(SQLException ex){
            System.err.println("Error al insertar Empleados: " + ex.getMessage());
            return false;
        }
    }
    public boolean update(Object object){
        Empleados empleados = (Empleados) object;
        String sql = "UPDATE Empleados SET EmpleadoID = ?, NombreEmpleado = ?, Contraseña = ?, RolID = ?, Status = ? WHERE EmpleadoID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, empleados.getNombreEmpleado());
             pst.setString(2, empleados.getContraseña());
             pst.setInt(3, empleados.getRolID());
             pst.setInt(4, empleados.getStatus());
             pst.setInt(5, empleados.getEmpleadoID());
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
                empleados.setContraseña(resultado.getString("Contraseña"));
                empleados.setRolID(resultado.getInt("RolID"));
                empleados.setStatus(resultado.getInt("Status"));
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Empleados: " + ex.getMessage());
        
        }
        
        return empleados;
    }
    
    
 
    public Empleados validarCredenciales(String nombreUsuario, String contraseñaIngresada) {
        Empleados empleado = null;
        String sql = "SELECT * FROM Empleados WHERE NombreEmpleado = ? AND Status = 1";

        try (Connection conn = ConnectionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashAlmacenado = rs.getString("Contraseña");

                System.out.println("Hash recuperado de la BD: " + hashAlmacenado);

                if (hashAlmacenado != null && !hashAlmacenado.isEmpty()) {
                    boolean esValido = BCrypt.checkpw(contraseñaIngresada, hashAlmacenado);

                    if (esValido) {
                        empleado = new Empleados();
                        empleado.setEmpleadoID(rs.getInt("EmpleadoID"));
                        empleado.setNombreEmpleado(rs.getString("NombreEmpleado"));
                        empleado.setRolID(rs.getInt("RolID"));
                        empleado.setStatus(rs.getInt("Status"));
                    } else {
                        System.out.println("❌ Contraseña incorrecta.");
                    }
                } else {
                    System.out.println("❌ Hash de contraseña vacío o nulo.");
                }
            } else {
                System.out.println("❌ Usuario no encontrado o inactivo.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al validar credenciales:");
            e.printStackTrace();
        }

        return empleado;
    }

}


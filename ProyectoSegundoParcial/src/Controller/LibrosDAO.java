package Controller;

import Bd.ConnectionBD;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Model.Libros;
import java.sql.PreparedStatement;

/**
 *
 * Creado Por Zenia Pascual y Carlos Gamez
 */
public class LibrosDAO {
    
    public List<Object> getAll(){
        List<Object> listado = new ArrayList<>();
        String sql = "SELECT * FROM Libros;";
        try (Connection con = ConnectionBD.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                listado.add(new Libros(resultado.getInt("LibrosID"), resultado.getString("Titulo"), resultado.getDate("FechaPublicacion"), resultado.getInt("CategoriaId"), resultado.getString("Edicion")));
            }
            
            
        }catch(SQLException ex){
            System.err.println("Error al listar Libros: " + ex.getMessage());
        
        }
        
        return listado;
    }
    
    public boolean insert(Object object){
        Libros libros = (Libros) object;
        String sql = "INSERT INTO Libros (Titulo, FechaPublicacion, CategoriaID, Edicion) VALUES (?, ?, ?, ?);";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, libros.getTitulo());
             pst.setDate(2, new java.sql.Date(libros.getFechaPublicacion().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setInt(3, libros.getCategoriaID());
             pst.setString(4, libros.getEdicion());
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al insertar Libros: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Object object){
        Libros libros = (Libros) object;
        String sql = "UPDATE Libros SET Titulo = ?, FechaPublicacion = ?, CategoriaID = ?, Edicion = ? WHERE LibrosID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, libros.getTitulo());
             pst.setDate(2, new java.sql.Date(libros.getFechaPublicacion().getTime())); // Convertir java.util.Date a java.sql.Date
             pst.setInt(3, libros.getCategoriaID());
             pst.setString(4, libros.getEdicion());
             pst.setInt(5, libros.getLibrosID());  // Aquí es importante usar el ID para actualizar el libro correcto
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al actualizar Libros: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean delete(int LibrosID){
        String sql = "DELETE FROM Libros WHERE LibrosID = ?";
        try(Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,LibrosID);
             return pst.executeUpdate()>0;
        
        }catch(SQLException ex){
            System.err.println("Error al eliminar Libros: " + ex.getMessage());
            return false;
        }
    }
    
    public Object getByLibrosID(int LibrosID){
        String sql = "SELECT * FROM Libros WHERE LibrosID = ?;";
        Libros libros = new Libros();
        try (Connection con = ConnectionBD.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, LibrosID);
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                libros.setLibrosID(resultado.getInt("LibrosID"));
                libros.setTitulo(resultado.getString("Titulo"));
                libros.setFechaPublicacion(resultado.getDate("FechaPublicacion"));
                libros.setCategoriaID(resultado.getInt("CategoriaID"));
                libros.setEdicion(resultado.getString("Edicion"));
            }   
        }catch(SQLException ex){
            System.err.println("Error al listar Libros: " + ex.getMessage());
        
        }
        
        return libros;
    }
}

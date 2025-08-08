/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Bd.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.ReportePrestamos;


/**
 *
 * @author Dell
 */
public class ReportePrestamosDAO {
    
    public List<ReportePrestamos> obtenerReporte() {
        List<ReportePrestamos> lista = new ArrayList<>();

        String sql = "SELECT p.PrestamoID, CONCAT(u.Nombre, ' ', u.Apellido) AS Usuario, l.Titulo AS Libro, " +
             "p.FechaEgreso, p.FechaDevolucionEstimada, d.FechaDevolucion, d.Comentario, " +
             "e1.NombreEmpleado AS EmpleadoPrestamo, e2.NombreEmpleado AS EmpleadoDevolucion " +
             "FROM Prestamos p " +
             "INNER JOIN Usuarios u ON p.UsuarioID = u.UsuarioID " +
             "INNER JOIN Ejemplares ej ON p.EjemplarID = ej.EjemplarID " +
             "INNER JOIN Libros l ON ej.LibroID = l.LibrosID " +
             "LEFT JOIN Devoluciones d ON p.PrestamoID = d.PrestamoID " +
             "LEFT JOIN Empleados e1 ON p.EmpleadoID = e1.EmpleadoID " +
             "LEFT JOIN Empleados e2 ON d.EmpleadoID = e2.EmpleadoID " +
             "ORDER BY p.FechaEgreso DESC";

        try (Connection conn = ConnectionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ReportePrestamos r = new ReportePrestamos();
                r.setPrestamoID(rs.getInt("PrestamoID"));
                r.setUsuario(rs.getString("Usuario"));
                r.setLibro(rs.getString("Libro"));
                r.setFechaEgreso(rs.getDate("FechaEgreso"));
                r.setFechaDevolucionEstimada(rs.getDate("FechaDevolucionEstimada"));
                r.setFechaDevolucion(rs.getDate("FechaDevolucion"));
                r.setComentario(rs.getString("Comentario"));
                r.setEmpleadoPrestamo(rs.getString("EmpleadoPrestamo"));
                r.setEmpleadoDevolucion(rs.getString("EmpleadoDevolucion"));
                lista.add(r);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
}

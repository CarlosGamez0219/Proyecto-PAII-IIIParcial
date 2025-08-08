/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Bd.ConnectionBD;
import Model.LibroPopular;
import Model.PrestamoMes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class ReportesDAO {
  
    // Método para generar reportes de Libros más populares
    public List<LibroPopular> obtenerLibrosMasPopulares() {
        List<LibroPopular> lista = new ArrayList<>();
        String sql ="SELECT Titulo, TotalPrestamos FROM LibroMasPopulares";

        try (Connection conn = ConnectionBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
        String titulo = rs.getString("Titulo");
        int total = rs.getInt("TotalPrestamos");
        lista.add(new LibroPopular(titulo, total));
        }

        } catch (SQLException e) {
        e.printStackTrace(); 
        }

        return lista;
    }
    
    public List<PrestamoMes> obtenerPrestamosPorMes() {
        List<PrestamoMes> lista = new ArrayList<>();

        String sql = "SELECT Mes, TotalPrestamos FROM PrestamosMensuales ORDER BY Mes DESC";

        try (Connection conn = ConnectionBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
        String mes = rs.getString("Mes");
        int total = rs.getInt("TotalPrestamos"); // ← aquí cambió

        lista.add(new PrestamoMes(mes, total));
        }

        } catch (Exception e) {
        e.printStackTrace();
        }

        return lista;
    }
    
}

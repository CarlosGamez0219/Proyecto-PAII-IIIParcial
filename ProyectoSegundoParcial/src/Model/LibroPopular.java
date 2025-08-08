/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class LibroPopular {
    
       private String titulo;
        private int totalPrestamos;

        public LibroPopular(String titulo, int totalPrestamos) {
            this.titulo = titulo;
            this.totalPrestamos = totalPrestamos;
        }

        public String getTitulo() {
            return titulo;
        }

        public int getTotalPrestamos() {
            return totalPrestamos;
        }

        @Override
        public String toString() {
            return "LibroPopular{titulo='" + titulo + "', totalPrestamos=" + totalPrestamos + '}';
        }
    
}

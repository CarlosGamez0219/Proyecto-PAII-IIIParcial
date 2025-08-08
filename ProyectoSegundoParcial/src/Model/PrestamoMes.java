/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class PrestamoMes {
      private String mes;
    private int totalPrestado;

    public PrestamoMes(String mes, int totalPrestado) {
        this.mes = mes;
        this.totalPrestado = totalPrestado;
    }

    public String getMes() {
        return mes;
    }

    public int getTotalPrestado() {
        return totalPrestado;
    }

    @Override
    public String toString() {
        return "PrestamoMes{mes='" + mes + "', totalPrestado=" + totalPrestado + '}';
    }
    
}

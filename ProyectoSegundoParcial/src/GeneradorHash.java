/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.mindrot.jbcrypt.BCrypt;

public class GeneradorHash {
    public static void main(String[] args) {
        String contraseña = "gabrielaM409"; // ← Cambia aquí si quieres otra clave
        String hash = BCrypt.hashpw(contraseña, BCrypt.gensalt(12));
        System.out.println("Hash generado: " + hash);
    }
}

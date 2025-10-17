/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import javax.swing.JOptionPane;
/**
 *
 * @author migue
 */
public class UtilidadesBanco {
    
    public static String solicitarString(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public static double solicitarDouble(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje);
            if (input == null) { 
                return Double.NaN; 
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número decimal válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static int solicitarInt(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje);
            if (input == null) { 
                return -1; 
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número entero válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

    public static int mostrarOpciones(String mensaje, String titulo, String[] opciones) {
        return JOptionPane.showOptionDialog(
                null,                       
                mensaje,                 
                titulo,                   
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null,                       
                opciones,                  
                opciones[0]                 
        );
    }
}

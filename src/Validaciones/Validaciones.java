/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author joelb
 */
public class Validaciones {

    public static void desactivar_boton(JComboBox combo, JButton boton) {
        if (combo.getSelectedIndex() == 0) {
            boton.setEnabled(false);
        } else {
            boton.setEnabled(true);
        }
    }

    public static void desactivar_campotexto(JComboBox combo, JTextField campo) {
        if (combo.getSelectedIndex() == 0) {
            campo.setEnabled(false);
            campo.setText("");
        } else {
            campo.setEnabled(true);
        }
    }

    //CONVIERTE LOS CARACTERES INGRESADOS A MINUSCULAS
    public static void cambiarLetraMinus(KeyEvent evt) {
        evt.setKeyChar(Character.toLowerCase(evt.getKeyChar()));
    }

    //CONVIERTE LOS CARACTERES INGRESADOS A MAYUSCULAS
    public static void cambiarLetraMayus(KeyEvent evt) {
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }

    //VALIDA QUE LOS CARACTERES INGRESADOS EN TEXT SEAN SOLO LETRAS
    public static void validarIngresoLetras(KeyEvent evt) {
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    //VALIDA QUE LOS CARACTERES INGRESADOS EN TEXT SEAN SOLO NÚMEROS
    private void validarIngresoNumeros(KeyEvent evt) {
        int limite = 10;
        JTextField txtAux = (JTextField) evt.getSource();
        if (!Character.isDigit(evt.getKeyChar()) || txtAux.getText().length() >= limite) {
            evt.consume();
        } else {
        }
    }

    //VALIDA QUE LOS CARACTERES INGRESADOS EN TEXT NO ESTE VACIO
    public static void resaltarVacio(KeyEvent evt) {
        JTextField txtAux = (JTextField) evt.getSource();
        if (txtAux.getText().equals("")) {
            txtAux.setBackground(Color.yellow);
        } else {
            txtAux.setBackground(Color.WHITE);
        }
    }//fin de metodo
}

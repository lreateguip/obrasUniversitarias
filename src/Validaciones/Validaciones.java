/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author joelb
 */
public class Validaciones {
    
    public static void desactivar_boton(JComboBox combo, JButton boton){
        if(combo.getSelectedIndex()==0){
            boton.setEnabled(false);
        }
        else{
            boton.setEnabled(true);
        }
    }
}
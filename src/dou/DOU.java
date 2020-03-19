/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dou;

import vista.Principal;
import javax.swing.JFrame;
/**
 *
 * @author Ricky
 */
public class DOU extends JFrame {


    public static void main(String[] args) {
        // TODO code application logic here
       Principal P = Principal.getFrame();
       P.setVisible(true);
    }
    
}

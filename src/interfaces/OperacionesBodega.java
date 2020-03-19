/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.bodegaDTO.Ikardex;

/**
 *
 * @author Ricky
 */
public class OperacionesBodega {
    ArrayList <Ikardex> lista =new ArrayList();

    public ArrayList<Ikardex> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Ikardex> lista) {
        this.lista = lista;
    }
    
     public Ikardex buscar(String codigo){
        for(Ikardex I : lista){
            if(I.getId().equals(codigo)){
                JOptionPane.showInputDialog(null,I.toString());
                return I;
            }
            else{
                JOptionPane.showMessageDialog(null,"No existe");
            }
        }
        return null;
        }
    
}

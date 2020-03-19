/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bodegaDTO;

/**
 *
 * @author Ricky
 */
public class Archivo {

    protected int numreq;
    protected String descripcion;
    protected int cant;
    protected double valorU;
    protected double tot;

    public Archivo() {
    }

    public Archivo(int numreq, String descripcion, int cant, double valorU, double tot) {
        this.numreq = numreq;
        this.descripcion = descripcion;
        this.cant = cant;
        this.valorU = valorU;
        this.tot = tot;
        
    }

    public int getNumreq() {
        return numreq;
    }

    public void setNumreq(int numreq) {
        this.numreq = numreq;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getValorU() {
        return valorU;
    }

    public void setValorU(double valorU) {
        this.valorU = valorU;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    @Override
    public String toString() {
        return numreq + descripcion + cant+ valorU+ tot;
    }
    
    
}

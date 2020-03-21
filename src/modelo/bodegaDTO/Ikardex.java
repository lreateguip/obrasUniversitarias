/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bodegaDTO;

import java.util.ArrayList;

/**
 *
 * @author Ricky
 */
public class Ikardex {
   
 protected int id;
    protected String numreq;
    protected String descripcion;
    protected String fecha;
    /*protected int cant;
    protected double valorU;
    protected double tot;*/
    protected ArrayList <DetalleIngresoProducto> listaing;
    protected String estado;

    public Ikardex() {
    }

    public Ikardex(int id, String numreq, String descripcion,String fecha/*, int cant, double valorU, double tot*/) {
        this.id=id;
        this.numreq = numreq;
        this.descripcion = descripcion;
        this.fecha=fecha;
       /* this.cant = cant;
        this.valorU = valorU;
        this.tot = tot;*/
        
    }

    public String getNumreq() {
        return numreq;
    }

    public void setNumreq(String numreq) {
        this.numreq = numreq;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  /*  public int getCant() {
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
*/
    @Override
    public String toString() {
        return numreq + descripcion /*+ cant+ valorU+ tot*/;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the listaegre
     */
    public ArrayList <DetalleIngresoProducto> getListaing() {
        return listaing;
    }

    /**
     * @param listaegre the listaegre to set
     */
    public void setListaing(ArrayList <DetalleIngresoProducto> listaing) {
        this.listaing = listaing;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
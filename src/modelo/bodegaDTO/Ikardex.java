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
public class Ikardex {
    protected String id;
    protected String fecha;
    protected String casacom;
    protected String tipo;
    protected String desc;
    protected int cantidad;
    protected double precioU;
    protected double total;
    public Ikardex(){}
    
    public Ikardex(String id, String fecha, String casacom, String tipo, 
            String desc, int cantidad, double precioU, double total){
        this.id=id;
        this.fecha=fecha;
        this.casacom=casacom;
        this.tipo=tipo;
        this.desc=desc;
        this.cantidad=cantidad;
        this.precioU=precioU;
        this.total=total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCasacom() {
        return casacom;
    }

    public void setCasacom(String casacom) {
        this.casacom = casacom;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString(){
        return id + fecha+casacom+tipo+desc+cantidad+precioU+total;
    }
}

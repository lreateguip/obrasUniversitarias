/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bodegaDTO;

/**
 *
 * @author joelb
 */
public class DetalleIngresoProducto {
    protected int id_ingpro;
    protected String no_orden;
    protected int id_pro;
    protected int cantidad;
    private Double valoru;
    private Double total;
    
    public DetalleIngresoProducto(int id_ingpro, String no_orden, int id_pro, int cantidad, Double valoru, Double total) {
        this.id_ingpro=id_ingpro;
        this.no_orden=no_orden;
        this.id_pro=id_pro;
        this.cantidad=cantidad;
        this.valoru=valoru;
        this.total=total;
        
    }
    public DetalleIngresoProducto(String no_orden){
        this.no_orden=no_orden;
    }
    
    public DetalleIngresoProducto(){
        
    }

    /**
     * @return the id_egrepro
     */
    public int getId_ingpro() {
        return id_ingpro;
    }

    /**
     * @param id_egrepro the id_egrepro to set
     */
    public void setId_ingpro(int id_ingpro) { 
        this.id_ingpro = id_ingpro;
    }

    /**
     * @return the no_orden
     */
    public String getNo_orden() {
        return no_orden;
    }

    /**
     * @param no_orden the no_orden to set
     */
    public void setNo_orden(String no_orden) {
        this.no_orden = no_orden;
    }

    /**
     * @return the id_pro
     */
    public int getId_pro() {
        return id_pro;
    }

    /**
     * @param id_pro the id_pro to set
     */
    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the valoru
     */
    public Double getValoru() {
        return valoru;
    }

    /**
     * @param valoru the valoru to set
     */
    public void setValoru(Double valoru) {
        this.valoru = valoru;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }
}

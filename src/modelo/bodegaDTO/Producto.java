/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bodegaDTO;

/**
 *
 * @author Usuario
 */
public class Producto {
    private int id;
    private String descripcion;
    private String tipo_producto;
    private int cantidad;
    private String casa_comercial;
    private Double valor_unitario;

    /**
     * @return the id
     */
    public Producto(){
        
    }
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipo_producto
     */
    public String getTipo_producto() {
        return tipo_producto;
    }

    /**
     * @param tipo_producto the tipo_producto to set
     */
    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
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
     * @return the casa_comercial
     */
    public String getCasa_comercial() {
        return casa_comercial;
    }

    /**
     * @param casa_comercial the casa_comercial to set
     */
    public void setCasa_comercial(String casa_comercial) {
        this.casa_comercial = casa_comercial;
    }

    /**
     * @return the valor_unitario
     */
    public Double getValor_unitario() {
        return valor_unitario;
    }

    /**
     * @param valor_unitario the valor_unitario to set
     */
    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    @Override
    public String toString() {
        return id+"-"+descripcion /*+ cant+ valorU+ tot*/;
    }
    
    
}

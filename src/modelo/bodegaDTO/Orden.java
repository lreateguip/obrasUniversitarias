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
public class Orden {

    protected int id;
    protected int dia;
    protected int mes;
    protected int anio;
    protected String salida;
    protected String llegada;
    protected String tecnico;
    protected String sup;
    protected String facultad;
    protected String bloque;
    protected String diagnostico;
    protected String detalle;
    protected String materiales;
    protected String estado;
    public Orden() {
    }

    public Orden(int id, int dia, int mes, int anio, String salida, String llegada, String tecnico,
            String sup, String facultad, String bloque, String diagnostico, String detalle
            , String materiales, String estado) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.salida = salida;
        this.llegada = llegada;
        this.tecnico = tecnico;
        this.sup = sup;
        this.facultad = facultad;
        this.bloque = bloque;
        this.diagnostico = diagnostico;
        this.detalle = detalle;
        this.materiales = materiales;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
   
    @Override
    public String toString() {
        return  id + dia + mes +
                 anio +  salida + llegada 
                 + tecnico + sup +  facultad +
                 bloque +  diagnostico 
               + detalle + materiales + estado;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planificacionDTO;

import java.io.InputStream;
import java.sql.Timestamp;

/**
 *
 * @author Luis Reategui
 */
public class Archivo {

    final short MB = 1024;

    int id;
    String titulo;
    String extension;
    long tamañoBytes;
    String usuario;
    Timestamp fecha;
    String ruta;
    String imagen;
    InputStream imput;

    public Archivo(int id, String titulo, String extension, long tamaño, String usuario, Timestamp fecha, String ruta) {
        this.id = id;
        this.titulo = titulo;
        this.extension = extension;
        this.tamañoBytes = tamaño;
        this.usuario = usuario;
        this.fecha = fecha;
        this.ruta = ruta;
    }

    public Archivo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getRuta() {
        return ruta;
    }

    public void setDocumento(String ruta) {
        this.ruta = ruta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public double getTamañoBytes() {
        return tamañoBytes;
    }

    public void setTamañoBytes(long tamañoBytes) {
        this.tamañoBytes = tamañoBytes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    //bloque de bloque para recuperar el archivo
    public InputStream getImput() {
        return imput;
    }

    public void setImput(InputStream imput) {
        this.imput = imput;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public long getTamañoMB(){
        return (tamañoBytes/MB);
    }

    @Override
    public String toString() {
        return "id: " + id + "\nTítulo: " + titulo + "\nExtensión: " + extension + "\nTamaño: " + getTamañoMB() + "\nPropietario: " + usuario + "\nFecha guardado: " + fecha + "\nRuta original: " + ruta;
    }

}

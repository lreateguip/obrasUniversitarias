/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planificacionDTO;

/**
 *
 * @author Luis Reategui
 */
public class UsuarioPla {

    private int id;
    private String usuario;
    private String clave;
    private String nombre;
    private String estado;
    private String imagen;

    public UsuarioPla(int id, String usuario, String clave, String nombre, String estado, String imagen) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.estado = estado;
        this.imagen = imagen;
    }

    

    public UsuarioPla() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

    @Override
    public String toString() {
        return "UsuarioPla{" + "id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
}

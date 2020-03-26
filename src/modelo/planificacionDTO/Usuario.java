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
public class Usuario {

    private int id;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String estado;
    private String rol;

    public Usuario(int id, String usuario, String clave, String nombre, String estado, String rol) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = clave;
        this.nombre = nombre;
        this.estado = estado;
        this.rol = rol;
    }

    public Usuario() {
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public Object[] getFila(){
        Object fila [] = {id, usuario, contraseña, nombre, rol, estado};
        return fila;
    }
    
    

    @Override
    public String toString() {
        return "UsuarioPla{" + "id=" + id + ", usuario=" + usuario + ", clave=" + contraseña + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
}

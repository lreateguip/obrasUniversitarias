/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planificacionDAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.planificacionDTO.Usuario;

/**
 *
 * @author Ricky
 */
public class UsuarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion micon;

    public Usuario consulta_usuario(String pusuario, String pclave) {
        micon = new Conexion();
        Usuario usuLog = null;
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "call P_CONSULTAR_USUARIO(?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pusuario);
            ps.setString(2, pclave);

            rs = ps.executeQuery();
            if (rs.next()) {
                usuLog = new Usuario();
                usuLog.setId(rs.getInt("id"));
                usuLog.setUsuario(rs.getString("usuario"));
                usuLog.setContraseña(rs.getString("clave"));
                usuLog.setNombre(rs.getString("nombre"));
                usuLog.setRol(rs.getString("rol"));
                usuLog.setEstado(rs.getString("estado"));
            }
        } catch (SQLException sqle) {
            System.out.println("Error en consulta");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consulta");
                System.out.println(sqle.getMessage());
            }
        }
        return usuLog;
    }
    
    public ArrayList<Usuario> consulta_usuarios() {
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        micon = new Conexion();
        
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "call P_CONSULTAR_USUARIOS()";
        try {
            ps = con.prepareStatement(query);
          

            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContraseña(rs.getString("clave"));
                usu.setNombre(rs.getString("nombre"));
                usu.setRol(rs.getString("rol"));
                usu.setEstado(rs.getString("estado"));
                
                lstUsuarios.add(usu);
            }
        } catch (SQLException sqle) {
            System.out.println("Error en consulta");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consulta");
                System.out.println(sqle.getMessage());
            }
        }
        return lstUsuarios;
    }
}

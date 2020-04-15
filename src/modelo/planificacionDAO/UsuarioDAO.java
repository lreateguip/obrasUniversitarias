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

    public Usuario consulta_usuario(String pusuario, String pcontraseña) {
        micon = new Conexion();
        con = micon.getConection();
        Usuario usuLog = null;

        String query = "call P_USUARIO_CONSULTAR_FILTRO(?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pusuario);
            ps.setString(2, pcontraseña);

            rs = ps.executeQuery();
            if (rs.next()) {
                usuLog = new Usuario();
                usuLog.setId(rs.getInt("id"));
                usuLog.setUsuario(rs.getString("usuario"));
                usuLog.setContraseña(rs.getString("contraseña"));
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

        String query = "call P_USUARIO_CONSULTAR()";
        try {
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContraseña(rs.getString("contraseña"));
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

    public int insertar_usuario(Usuario u) {
        int res = 0;
        micon = new Conexion();
        con = micon.getConection();

        //sentencia de inserción
        String sql = "call P_USUARIO_INSERTAR(?,?,?,?,?)";

        try {
            //crear la sentencia preparada
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContraseña());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getRol());
            ps.setString(5, u.getEstado());
            res = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en insertar ");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion");
                System.out.println(sqle.getMessage());
            }
        }
        return res;
    }

    public int actualizar_usuario(Usuario u) {
        int res = 0;
        micon = new Conexion();
        con = micon.getConection();

        //sentencia de inserción
        String sql = "call P_USUARIO_ACTUALIZAR(?,?,?,?,?,?)";

        try {
            //crear la sentencia preparada
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContraseña());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getRol());
            ps.setString(5, u.getEstado());
            ps.setInt(6, u.getId());
            res = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en actualizar ");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion");
                System.out.println(sqle.getMessage());
            }
        }
        return res;
    }

    public int eliminar_usuario(int id) {
        int res = 0;
        micon = new Conexion();
        con = micon.getConection();

        //sentencia de inserción
        String sql = "call P_USUARIO_ELIMINAR(?)";

        try {
            //crear la sentencia preparada
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en eliminar ");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion");
                System.out.println(sqle.getMessage());
            }
        }
        return res;
    }

    public int cambiarContraseña(Usuario usuLog) {
        int res = 0;
        micon = new Conexion();
        con = micon.getConection();
        
        //sentencia de inserción
        String sql = "call P_USUARIO_CAMBIAR_CONTRASEÑA(?,?)";

        try {
            //crear la sentencia preparada
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuLog.getId());
            ps.setString(2, usuLog.getContraseña());
            res = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en actualizar contraseña");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion");
                System.out.println(sqle.getMessage());
            }
        }
        return res;
    }
}

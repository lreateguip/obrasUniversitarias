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
import modelo.planificacionDTO.UsuarioPla;

/**
 *
 * @author Ricky
 */
public class Consulta {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion micon;

    public UsuarioPla consulta_usuarios_jefatura(String pusuario, String pclave) {
        ArrayList<UsuarioPla> listar = null;
        micon = new Conexion();
        UsuarioPla usuLog = null;
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "Select *from usuarios_jefatura WHERE usuario =? AND clave =? AND estado = 'A'";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pusuario);
            ps.setString(2, pclave);

            rs = ps.executeQuery();
            if (rs.next()) {
                usuLog = new UsuarioPla();
                usuLog.setId(rs.getInt("id"));
                usuLog.setUsuario(rs.getString("usuario"));
                usuLog.setClave(rs.getString("clave"));
                usuLog.setNombre(rs.getString("nombre"));
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
}

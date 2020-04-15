/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planificacionDAO;

import conexion.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.planificacionDTO.Archivo;

/**
 *
 * @author Luis Reategui
 */
public class ArchivoDAO {

    private Connection con;
    private Conexion micon;

    public int insertarArchivo(Archivo archivo) {
        int res = 0;

        micon = new Conexion();
        con = micon.getConection();

        //sentencia de inserción
        String sql = "CALL P_ARCHIVO_INSERTAR(?,?,?,?,?,?)";

        try {
            File file = new File(archivo.getRuta());
            FileInputStream fis = new FileInputStream(file);

            //crear la sentencia preparada
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, archivo.getTitulo());
            ps.setDouble(2, archivo.getTamañoMB());
            ps.setString(3, archivo.getExtension());
            ps.setBinaryStream(4, fis, (int) archivo.getTamañoBytes());
            ps.setString(5, archivo.getRuta());
            ps.setString(6, archivo.getUsuario());
            res = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public int eliminarArchivo(int id) {
        int res = 0;
        micon = new Conexion();
        con = micon.getConection();

        //sentencia de inserción
        String sql = "CALL P_ARCHIVO_ELIMINAR(?)";

        try {
            //PREPARAR LA SENTENCIA Y PARAMETROA A EJECUTAR
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

    public ArrayList<Archivo> consultarArchivos() throws FileNotFoundException {
        InputStream input = null;
        FileOutputStream output = null;

        ArrayList<Archivo> lstArchivos = new ArrayList<>();

        micon = new Conexion();
        con = micon.getConection();

        try {
            String sql = "CALL P_ARCHIVO_CONSULTAR()";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            //ps.setString(1, "A");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Archivo archivoSel = new Archivo();
                archivoSel.setId(rs.getInt("id"));
                archivoSel.setTitulo(rs.getString("titulo"));
                archivoSel.setTamañoBytes(rs.getLong("peso"));
                archivoSel.setFecha(rs.getTimestamp("fecha_guardado"));
                archivoSel.setExtension(rs.getString("extension"));
                archivoSel.setUsuario(rs.getString("usuario"));
                //archivoSel.setImput(rs.getBinaryStream("archivo"));
                archivoSel.setRuta(rs.getString("ruta"));
                //agregamos a la lista de archivos
                lstArchivos.add(archivoSel);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return lstArchivos;
    }

    public ArrayList<Archivo> consultarArchivosPorCriterio(String criterio) {
        InputStream input = null;
        FileOutputStream output = null;
        
        micon = new Conexion();
        con = micon.getConection();

        ArrayList<Archivo> lstArchivos = new ArrayList<>();

        try {
            String sql = "CALL P_ARCHIVO_CONSULTAR_FILTRO(?)";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, criterio);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Archivo archivoSel = new Archivo();
                archivoSel.setId(rs.getInt("id"));
                archivoSel.setTitulo(rs.getString("titulo"));
                archivoSel.setTamañoBytes(rs.getLong("peso"));
                archivoSel.setFecha(rs.getTimestamp("fecha_guardado"));
                archivoSel.setExtension(rs.getString("extension"));
                archivoSel.setUsuario(rs.getString("usuario"));
                //archivoSel.setImput(rs.getBinaryStream("archivo"));
                archivoSel.setRuta(rs.getString("ruta"));
                //agregamos a la lista de archivos
                lstArchivos.add(archivoSel);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return lstArchivos;
    }
}

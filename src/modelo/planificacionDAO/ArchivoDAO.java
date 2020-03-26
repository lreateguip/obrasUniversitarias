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

    public ArchivoDAO() {
        micon = new Conexion();
        //obtener la Conexion a la bdd
        con = micon.getConection();

    }

    public int guardarArchivo(Archivo archivo) {
        int res = 0;

        //sentencia de inserción
        String sql = "INSERT INTO archivo (titulo, peso, fecha_guardado, extension, archivo,ruta, usuario) VALUES (?,?,?,?,?,?,?)";

        try {
            File file = new File(archivo.getRuta());
            FileInputStream fis = new FileInputStream(file);

            //crear la sentencia preparada
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, archivo.getTitulo());
            ps.setDouble(2, archivo.getTamañoMB());
            ps.setString(3, archivo.getFecha());
            ps.setString(4, archivo.getExtension());
            ps.setBinaryStream(5, fis, (int) archivo.getTamañoBytes());
            ps.setString(6, archivo.getRuta());
            ps.setString(7, archivo.getUsuario());
            res = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println(archivo.getTitulo());
            System.out.println("Error en guardar ");
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
        
        //sentencia de inserción
        String sql = "DELETE from archivo WHERE id = ?";

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

        try {
            String sql = "SELECT *FROM archivo";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            //ps.setString(1, "A");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Archivo archivoSel = new Archivo();
                archivoSel.setId(rs.getInt("id"));
                archivoSel.setTitulo(rs.getString("titulo"));
                archivoSel.setTamañoBytes(rs.getLong("peso"));
                archivoSel.setFecha(rs.getString("fecha_guardado"));
                archivoSel.setExtension(rs.getString("extension"));
                archivoSel.setUsuario(rs.getString("usuario"));
                archivoSel.setImput(rs.getBinaryStream("archivo"));
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

        ArrayList<Archivo> lstArchivos = new ArrayList<>();

        try {
            String sql = "CALL P_CONSULTAR_POR_CRITERIO(?)";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, criterio);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Archivo archivoSel = new Archivo();
                archivoSel.setId(rs.getInt("id"));
                archivoSel.setTitulo(rs.getString("titulo"));
                archivoSel.setTamañoBytes(rs.getLong("peso"));
                archivoSel.setFecha(rs.getString("fecha_guardado"));
                archivoSel.setExtension(rs.getString("extension"));
                archivoSel.setUsuario(rs.getString("usuario"));
                archivoSel.setImput(rs.getBinaryStream("archivo"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.operacionesDAO;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.bodegaDTO.DetalleEgresoProducto;
import modelo.bodegaDTO.Ekardex;

/**
 *
 * @author Martha Marcillo
 */
public class KEgreso {

    private Connection con;
    private PreparedStatement sentenciaPreparada;
    private Conexion micon;

    public int guardar(Ekardex regreso) {
        int res = 0;
        micon = new Conexion();
        //obtener la conexion a la bdd
        con = micon.getConection();
        //sentencia de inserción
        String sql = "insert into kardexegreso "
                  + "(No_orden,descripcion,Fecha,Estado)"
                + "values (?,?,?,?)";

        try {
            //crear la sentencia preparada
            sentenciaPreparada = con.prepareStatement(sql);
            sentenciaPreparada.setString(1, regreso.getNumreq());
            sentenciaPreparada.setString(2, regreso.getDescripcion());
            sentenciaPreparada.setString(3, regreso.getFecha());
            sentenciaPreparada.setString(4, regreso.getEstado());
            res = sentenciaPreparada.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en guardar ");
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
    
    public int guardarDetalle(DetalleEgresoProducto regreso) {
        int res = 0;
        micon = new Conexion();
        //obtener la conexion a la bdd
        con = micon.getConection();
        //sentencia de inserción
        String sql = "insert into egreso_producto "
                  + "(No_orden,id_producto,cantidad)"
                + "values (?,?,?)";

        try {
            //crear la sentencia preparada
            sentenciaPreparada = con.prepareStatement(sql);
            sentenciaPreparada.setString(1, regreso.getNo_orden());
            sentenciaPreparada.setInt(2, regreso.getId_pro());
            sentenciaPreparada.setInt(3, regreso.getCantidad());
            res = sentenciaPreparada.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en guardar ");
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

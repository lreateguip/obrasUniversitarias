/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.operacionesDAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.bodegaDTO.DetalleEgresoProducto;
import modelo.bodegaDTO.DetalleIngresoProducto;
import modelo.bodegaDTO.Ekardex;
import modelo.bodegaDTO.Ikardex;

/**
 *
 * @author Ricky
 */
public class KIngreso {
    
    private Connection con;
    private PreparedStatement sentenciaPreparada;
    private Conexion micon;

    public int guardar(Ikardex regreso) {
        int res = 0;
        micon = new Conexion();
        //obtener la conexion a la bdd
        con = micon.getConection();
        //sentencia de inserción
        String sql = "insert into kardexingreso "
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
    
    public int guardarDetalle(DetalleIngresoProducto regreso) {
        int res = 0;
        micon = new Conexion();
        //obtener la conexion a la bdd
        con = micon.getConection();
        //sentencia de inserción
        String sql = "insert into ingreso_producto "
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
    
    public int actualizarInventario( DetalleIngresoProducto regreso){
        int res=0;
        micon = new Conexion();
        //obtener la conexion a la bdd
        con = micon.getConection();
        //sentencia de inserción
        String sql = "update producto set cantidad=cantidad+? where id_producto=?";
                  

        try {
            //crear la sentencia preparada
            sentenciaPreparada = con.prepareStatement(sql);
            sentenciaPreparada.setInt(1, regreso.getCantidad());
            sentenciaPreparada.setInt(2, regreso.getId_pro());
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
      
      
      
    /*  public int guardar(Ikardex kardex) throws SQLException{
          int res = 0;
          micon = new Conexion();
          con = micon.getConection();
          
          String sql="INSERT INTO kardexIngreso(id,fecha,casacomercial,tipo"
                  + "descripcion, cantidad, valorunitario, total) values"
                  + "(?,?,?,?,?,?,?,?)";
          
          try{
              sentenciaPreparada=con.prepareStatement(sql);
              sentenciaPreparada.setString(1, kardex.getId());
              sentenciaPreparada.setString(2, kardex.getFecha());
              sentenciaPreparada.setString(3, kardex.getCasacom());
               sentenciaPreparada.setString(4, kardex.getTipo());
              sentenciaPreparada.setString(5, kardex.getDesc());
              sentenciaPreparada.setInt(6, kardex.getCantidad());
              sentenciaPreparada.setDouble(7, kardex.getPrecioU());
              sentenciaPreparada.setDouble(8, kardex.getTotal());
              res=sentenciaPreparada.executeUpdate();
          }catch(SQLException ex){
            System.out.println("Error al guardar");
         System.out.println(ex.getMessage());
     }finally{
         try{
             con.close();
         }catch(SQLException sqle){
             System.out.println("Error al cerrar conexion");
             System.out.println(sqle.getMessage());
         }
     }
     return res;
     
      }*/
}

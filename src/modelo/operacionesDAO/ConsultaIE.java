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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.bodegaDTO.DetalleEgresoProducto;
import modelo.bodegaDTO.DetalleIngresoProducto;
import modelo.bodegaDTO.Ekardex;
import modelo.bodegaDTO.Ikardex;
import modelo.bodegaDTO.Producto;

/**
 *
 * @author joelb
 */
public class ConsultaIE {
    private Connection con;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultset;
    private Conexion micon;
    
    public ArrayList<Ekardex> consulta_egresos(){
        ArrayList <Ekardex> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select No_orden, descripcion, Fecha, Estado from kardexegreso";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Ekardex reserv = null;
            while(resultset.next()){
                reserv=new Ekardex();
                reserv.setNumreq(resultset.getString("kardexegreso.No_orden"));
                reserv.setDescripcion(resultset.getString("kardexegreso.descripcion"));
                reserv.setFecha(resultset.getString("kardexegreso.Fecha"));
                reserv.setEstado(resultset.getString("kardexegreso.Estado"));
                listar.add(reserv);
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return listar;
    }
    
    public ArrayList<Ikardex> consulta_ingresos(){
        ArrayList <Ikardex> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select No_orden, descripcion, Fecha, Estado from kardexingreso";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Ikardex reserv = null;
            while(resultset.next()){
                reserv=new Ikardex();
                reserv.setNumreq(resultset.getString("kardexingreso.No_orden"));
                reserv.setDescripcion(resultset.getString("kardexingreso.descripcion"));
                reserv.setFecha(resultset.getString("kardexingreso.Fecha"));
                reserv.setEstado(resultset.getString("kardexingreso.Estado"));
                listar.add(reserv);
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return listar;
    }
    
    public ArrayList<DetalleIngresoProducto> llenar_detalleI(String No_Orden){ 
        ArrayList <DetalleIngresoProducto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_ingpro, No_orden, id_producto, cantidad from ingreso_producto where No_orden=?";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, No_Orden);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            DetalleIngresoProducto reserv = null;
            while(resultset.next()){
                reserv=new DetalleIngresoProducto();
                reserv.setId_ingpro(resultset.getInt("ingreso_producto.id_ingpro"));
                reserv.setNo_orden(resultset.getString("ingreso_producto.No_orden"));
                reserv.setId_pro(resultset.getInt("ingreso_producto.id_producto"));
                reserv.setCantidad(resultset.getInt("ingreso_producto.cantidad"));
                listar.add(reserv);
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return listar;
    }
    
    public ArrayList<DetalleEgresoProducto> llenar_detalleE(String No_Orden){ 
        ArrayList <DetalleEgresoProducto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_egrepro, No_orden, id_producto, cantidad from egreso_producto where No_orden=?";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, No_Orden);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            DetalleEgresoProducto reserv = null;
            while(resultset.next()){
                reserv=new DetalleEgresoProducto();
                reserv.setId_egrepro(resultset.getInt("egreso_producto.id_egrepro"));
                reserv.setNo_orden(resultset.getString("egreso_producto.No_orden"));
                reserv.setId_pro(resultset.getInt("egreso_producto.id_producto"));
                reserv.setCantidad(resultset.getInt("egreso_producto.cantidad"));
                listar.add(reserv);
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return listar;
    }
    
    public Producto llenar_detalleIP(int id_producto){ 
        //ArrayList <DetalleIngresoProducto> listar = null;
        Producto reserv = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_producto, descripcion, valor_uni from producto where id_producto=?";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setInt(1, id_producto);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                //listar = new ArrayList();
                reserv = new Producto();
            } else {
                return null;
            }
            //reserv=new Producto();
            while(resultset.next()){
                reserv.setId(resultset.getInt("producto.id_producto"));
                reserv.setDescripcion(resultset.getString("producto.descripcion"));
                reserv.setValor_unitario(resultset.getDouble("producto.valor_uni"));
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return reserv;
    }
    
    public ArrayList<Ikardex> filtrar_vivo_cabezeraI(String No_orden){ 
        ArrayList <Ikardex> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String filtro=""+No_orden+"_%";
        String query = "select id, No_orden, descripcion, Fecha, Estado from kardexingreso where No_orden like"+'"'+filtro+'"';
        try{
            sentenciaPreparada = con.prepareStatement(query);
            //sentenciaPreparada.setString(1, nombre_Producto);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null; 
            }
            Ikardex reserv = null;
            while(resultset.next()){
                reserv=new Ikardex();
                
                reserv.setId(resultset.getInt("kardexingreso.id"));
                reserv.setNumreq(resultset.getString("kardexingreso.No_orden"));
                reserv.setDescripcion(resultset.getString("kardexingreso.descripcion"));
                reserv.setFecha(resultset.getString("kardexingreso.Fecha"));
                reserv.setEstado(resultset.getString("kardexingreso.Estado"));
                listar.add(reserv);
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return listar;
    }
    
    public ArrayList<Ekardex> filtrar_vivo_cabezeraE(String No_orden){ 
        ArrayList <Ekardex> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String filtro=""+No_orden+"_%";
        String query = "select id, No_orden, descripcion, Fecha, Estado from kardexegreso where No_orden like"+'"'+filtro+'"';
        try{
            sentenciaPreparada = con.prepareStatement(query);
            //sentenciaPreparada.setString(1, nombre_Producto);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null; 
            }
            Ekardex reserv = null;
            while(resultset.next()){
                reserv=new Ekardex();
                
                reserv.setId(resultset.getInt("kardexegreso.id"));
                reserv.setNumreq(resultset.getString("kardexegreso.No_orden"));
                reserv.setDescripcion(resultset.getString("kardexegreso.descripcion"));
                reserv.setFecha(resultset.getString("kardexegreso.Fecha"));
                reserv.setEstado(resultset.getString("kardexegreso.Estado"));
                listar.add(reserv);
            }
        }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
        }
        return listar;
    }
    
    public void eliminar_DetalleE(JTable tabla){
        int fila = tabla.getSelectedRow();
        String valor = tabla.getValueAt(fila, 0).toString();
        if(fila>=0){
            micon = new Conexion();
            con = micon.getConection();
            String query = "delete from egreso_producto where id_egrepro='"+valor+"'";
            try{
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
            } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
            }
        }
    }
    
    public void eliminar_DetalleI(JTable tabla){
        int fila = tabla.getSelectedRow();
        String valor = tabla.getValueAt(fila, 0).toString();
        if(fila>=0){
            micon = new Conexion();
            con = micon.getConection();
            String query = "delete from ingreso_producto where id_ingpro='"+valor+"'";
            try{
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            }catch (SQLException sqle) {
            System.out.println("Error en consultar");
            System.out.println(sqle.getMessage());
            } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar conexion en consultar");
                System.out.println(sqle.getMessage());
            }
            }
        }
    }
    
}

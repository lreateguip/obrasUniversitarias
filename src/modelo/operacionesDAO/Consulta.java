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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.bodegaDTO.Ikardex;
import modelo.bodegaDTO.Orden;
import modelo.bodegaDTO.Producto;

/**
 *
 * @author Ricky
 */
public class Consulta {

    private Connection con;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultset;
    private Conexion micon;

   /* public ArrayList<Ikardex> consulta_inv() {
        ArrayList<Ikardex> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "Select id, descripcion, cantidad from kardexingreso ";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Ikardex reserv = null;
            while (resultset.next()) {
                reserv = new Ikardex();
                reserv.setId(resultset.getString("kardexingreso.id"));
                reserv.setDesc(resultset.getString("kardexingreso.descripcion"));
                reserv.setCantidad(resultset.getInt("kardexingreso.cantidad"));

                listar.add(reserv);
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
        return listar;
    }
*/
    public ArrayList<Orden> consulta_ord() {
        ArrayList<Orden> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "Select No_Orden, hora_llegada, hora_salida, detalle, estado from orden_trabajo";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Orden reserv = null;
            while (resultset.next()) {
                reserv = new Orden();
                reserv.setId(resultset.getInt("orden_trabajo.No_Orden"));
                reserv.setLlegada(resultset.getString("orden_trabajo.hora_llegada"));
                reserv.setSalida(resultset.getString("orden_trabajo.hora_salida"));
                reserv.setDetalle(resultset.getString("orden_trabajo.detalle"));
                reserv.setEstado(resultset.getString("orden_trabajo.estado"));

                listar.add(reserv);
            }
        } catch (SQLException sqle) {
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
    public ArrayList<Producto> llenar_combo(){
        ArrayList <Producto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_producto, descripcion from producto";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Producto reserv = null;
            while(resultset.next()){
                reserv=new Producto();
                reserv.setId(resultset.getInt("producto.id_producto"));
                reserv.setDescripcion(resultset.getString("producto.descripcion"));
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
    
    public ArrayList<Producto> llenar_valores(){
        ArrayList <Producto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_producto, cantidad, valor_uni from producto";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Producto reserv = null;
            while(resultset.next()){
                reserv=new Producto();
                reserv.setId(resultset.getInt("producto.id_producto"));
                reserv.setCantidad(resultset.getInt("producto.cantidad"));
                reserv.setValor_unitario(resultset.getDouble("producto.valor_uni"));
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
    
    public ArrayList<Producto> consulta_productos(){
        ArrayList <Producto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_producto, descripcion, tipo_producto, cantidad, casa_comercial, valor_uni from producto";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Producto reserv = null;
            while(resultset.next()){
                reserv=new Producto();
                reserv.setId(resultset.getInt("producto.id_producto"));
                reserv.setDescripcion(resultset.getString("producto.descripcion"));
                reserv.setTipo_producto(resultset.getString("producto.tipo_producto"));
                reserv.setCantidad(resultset.getInt("producto.cantidad"));
                reserv.setCasa_comercial(resultset.getString("producto.casa_comercial"));
                reserv.setValor_unitario(resultset.getDouble("producto.valor_uni"));
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
    
    public ArrayList<Producto> filtrar_productos(String nombre_Producto){ 
        ArrayList <Producto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "select id_producto, descripcion, tipo_producto, cantidad, casa_comercial, valor_uni from producto where descripcion=?";
        try{
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, nombre_Producto);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Producto reserv = null;
            while(resultset.next()){
                reserv=new Producto();
                reserv.setId(resultset.getInt("producto.id_producto"));
                reserv.setDescripcion(resultset.getString("producto.descripcion"));
                reserv.setTipo_producto(resultset.getString("producto.tipo_producto"));
                reserv.setCantidad(resultset.getInt("producto.cantidad"));
                reserv.setCasa_comercial(resultset.getString("producto.casa_comercial"));
                reserv.setValor_unitario(resultset.getDouble("producto.valor_uni"));
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
    
    public ArrayList<Producto> filtrar_vivo_productos(String nombre_Producto){ 
        ArrayList <Producto> listar = null;
        micon = new Conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String filtro=""+nombre_Producto+"_%";
        String query = "select id_producto, descripcion, tipo_producto, cantidad, casa_comercial, valor_uni from producto where descripcion like"+'"'+filtro+'"';
        try{
            sentenciaPreparada = con.prepareStatement(query);
            //sentenciaPreparada.setString(1, nombre_Producto);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listar = new ArrayList();
            } else {
                return null;
            }
            Producto reserv = null;
            while(resultset.next()){
                reserv=new Producto();
                reserv.setId(resultset.getInt("producto.id_producto"));
                reserv.setDescripcion(resultset.getString("producto.descripcion"));
                reserv.setTipo_producto(resultset.getString("producto.tipo_producto"));
                reserv.setCantidad(resultset.getInt("producto.cantidad"));
                reserv.setCasa_comercial(resultset.getString("producto.casa_comercial"));
                reserv.setValor_unitario(resultset.getDouble("producto.valor_uni"));
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
    
    public void eliminar_productos(JTable tabla){
        int fila = tabla.getSelectedRow();
        String valor = tabla.getValueAt(fila, 0).toString();
        if(fila>=0){
            micon = new Conexion();
            con = micon.getConection();
            String query = "delete from producto where id_producto='"+valor+"'";
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
    
    /*public ArrayList<Dkardex> consulta_egresos() {
        ArrayList<Dkardex> listaegresos = null;
        micon = new conexion();
        con = micon.getConection();
        if (con == null) {
            return null;
        }
        String query = "Select No_Orden, descripcion, cantidad, valorU, total from kardexegreso";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset = sentenciaPreparada.executeQuery();
            if (resultset != null) {
                listaegresos = new ArrayList();
            } else {
                return null;
            }
            Dkardex reserv = null;
            while (resultset.next()) {
                reserv = new Dkardex();
                reserv.setNumreq(resultset.getInt("kardexegreso.No_Orden"));
                reserv.setDescripcion(resultset.getString("kardexegreso.descripcion"));
                reserv.setCant(resultset.getInt("kardexegreso.cantidad"));
                reserv.setValorU(resultset.getDouble("kardexegreso.valorU"));
                reserv.setTot(resultset.getDouble("kardexegreso.total"));

                listaegresos.add(reserv);
            }
        } catch (SQLException sqle) {
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
        return listaegresos;
    }*/
}

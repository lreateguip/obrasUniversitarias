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
import modelo.bodegaDTO.Orden;



/**
 *
 * @author Olimpo
 */
public class OrdenDAO {
     private Connection con;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultset;
    private Conexion micon;
   // private final SimpleDateFormat FORMATO = new SimpleDateFormat("yyyy-MM-dd");
     public int guardar(Orden ord){
         int res=0;
         micon=new Conexion();
         con=micon.getConection();
         String sql="insert into ordenfac"+
                 "(No.Orden, dia, mes, anio, hora_llegada, hora_salida, tecnico,"
                 + "supervisor,facultad, bloque, diagnostico, detalle,lista_materiales, estado)"
                 +" values(?,?,?,?,?,?,?,?,?,?)";
         try{
             sentenciaPreparada=con.prepareStatement(sql);
             sentenciaPreparada.setInt(1, ord.getId());
             sentenciaPreparada.setInt(2, ord.getDia());
             sentenciaPreparada.setInt(3, ord.getMes());
             sentenciaPreparada.setInt(4, ord.getAnio());
             sentenciaPreparada.setString(5, ord.getLlegada());
             sentenciaPreparada.setString(6, ord.getSalida());
             sentenciaPreparada.setString(7, ord.getTecnico());
             sentenciaPreparada.setString(8, ord.getSup());
             sentenciaPreparada.setString(9, ord.getFacultad());
             sentenciaPreparada.setString(10, ord.getBloque());
             sentenciaPreparada.setString(11, ord.getDiagnostico());
             sentenciaPreparada.setString(12, ord.getDetalle());
             sentenciaPreparada.setString(13, ord.getMateriales());
              sentenciaPreparada.setString(14, ord.getEstado());
              res=sentenciaPreparada.executeUpdate();
              
         }catch(SQLException sqle){
             System.out.println("Error en guardar");
         System.out.println(sqle.getMessage());
     }finally{
         try{
             con.close();
         }catch(SQLException sqle){
             System.out.println("Error al cerrar conexion");
             System.out.println(sqle.getMessage());
         }
     }
     return res;
     }
      
}

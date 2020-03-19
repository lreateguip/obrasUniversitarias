/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.operacionesDAO;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.bodegaDTO.Ikardex;

/**
 *
 * @author Ricky
 */
public class KIngreso {
      private Connection con;
      private PreparedStatement sentenciaPreparada;
      private ResultSet resultSet;
      private Conexion micon;
      
      public int guardar(Ikardex kardex) throws SQLException{
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
     
      }
}

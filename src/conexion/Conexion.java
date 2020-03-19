package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private  Connection conection;
        //Parametros de Conexion servidor
        //final String BD = "bd_diou";
	//final String User="us_obras";
        //final String password="Un1v3rs1t@r1@s";
        
        //parametros de conexión local
        final String BD = "diou";
	final String User="root";
	final String password="";

        //final String cadenaConexion="jdbc:mysql://db4free.net:3306/"+BD;
        final String cadenaConexion="jdbc:mysql://localhost:3306/"+BD;
	//constructor para la clase
	public Conexion(){
		this.conection=null;
	}
	//metodo para obtener la Conexion
	public Connection getConection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class mysql no encontrada");
		}
		try {
			this.conection= DriverManager.getConnection(cadenaConexion,this.User,this.password);
		}
                catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "NO se encontró ninguna conexión", "CONEXIÓN A BASE", JOptionPane.ERROR_MESSAGE);
		}
		return this.conection;
	}
}
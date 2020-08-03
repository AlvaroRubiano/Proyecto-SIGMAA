
package Modelo;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alvaro Rubiano
 */
public class Conexion {        
    
    private Connection con;
    
    //Conexión a la base de datos mysql server
    private String username = "root";
    private String password = "";
    private String hots = "localhost";
    private String port = "3306";
    private String database = "bd_sigmaa";
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+hots+":"+port+"/"+database;
    
    public Conexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, username, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
    }
    
    //Conexión a la base de datos en sql server
//    public Conexion(){
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");            
//            //con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=bd_sigmaa","sa","123"); 
//            con = DriverManager.getConnection("jdbc:sqlserver://rubiano124.database.windows.net:1433;database=bd_sigmaa;user=administrador@rubiano124;password=M4r14n42014;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=90");
//            System.out.println("Conexion exitosa");
//            
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Error en la conexion" + e);
//        }
//    }
    
    public Connection getConexion(){
        return con;
    }
    
    //Metodo para probar la conexion a la base de datos
    
//    public static void main(String[] args) {
//        Conexion con = new Conexion();
//    }
    
}

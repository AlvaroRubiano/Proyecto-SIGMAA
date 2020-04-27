
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
    private String username = "root";
    private String password = "";
    private String hots = "localhost";
    private String port = "3306";
    private String database = "bd_sigmaa";
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+hots+":"+port+"/"+database;
    private Connection con;
    
    public Conexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, username, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la conexion" + e);
        }catch (SQLException sql){
            System.out.println("Error en la conexion" + sql);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    //Metodo para probar la conexion a la base de datos
    /*
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
    */
}

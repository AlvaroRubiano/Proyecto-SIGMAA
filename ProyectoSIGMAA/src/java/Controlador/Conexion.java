/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alvaro
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
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
    
}

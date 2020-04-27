
package Modelo;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesAdministrador extends Conexion{
    
    //Metodo de autenticación para el administrador
    public boolean autenticacion (String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "select * from administrador where Email = ? and Clave = ?";
            //Obtener la conexion
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error 1: " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                System.out.println("Error 2: " + e);
            }
        }
        
        return false;
    }
    
    //Metodo para crear administradores
    public boolean registrarAdministrador (int identificacion, String nombres, String email, String password){
        PreparedStatement pst = null;
        
        try {
            String consulta = "insert into administrador (Id_administrador, Nombres, Email, Clave) values(?,?,?,?)";
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setInt(1, identificacion);
            pst.setString(2, nombres);
            pst.setString(3, email);
            pst.setString(4, password);
            
            if(pst.executeUpdate() ==1){
                return true;
            }          
           
        } catch (Exception e) {
            System.out.println("Error 3: " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();                
            } catch (Exception e) {
                System.out.println("Error 4: " + e);
            }
        }
        return false;
    }
    
    
    
    
    /*Main para verificar el metodo de autenticación para el administrador.
    public static void main(String[] args) {
        Consultas co = new Consultas();
        System.out.println(co.autenticacion("arubiano20@estudiantes.areandina.edu.co", "12345"));
    }
    */
    
    /*Main para verificar el metodo para crear administradores
    public static void main(String[] args) {
        Consultas co = new Consultas();
        System.out.println(co.registrar(127238221,"Andres Felipe Rubiano Marrugo", "andres.rubiano@gmail.com", "12345"));
    }
    */
    
    
    
    
    
    
}

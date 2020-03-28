/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alvaro
 */
public class Consultas extends Conexion{
    
    public boolean autenticacion (String usuario, String contrasena){
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "select * from users where Mail_users = ? and Pass_users = ?";
            //Obtener la conexion
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Consultas co = new Consultas();
        System.out.println(co.autenticacion("arubiano20@estudianes.areandina.edu.co", "12345"));
    }
}

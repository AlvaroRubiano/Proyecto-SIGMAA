/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesUsuarios extends Conexion{
    
    //Metodo de autenticación para el administrador
    public boolean autenticacion (String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "select * from usuarios WHERE Mail_users = ? and Pass_users = ?";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error 1: " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error 2: " + e);
            }
        }        
        return false;
    }
    
    //Metodo para mostrar la lista de campus registrados
    public ArrayList<Usuarios> getUsuarios(){
        
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
               
        try {
            String consulta = "SELECT * FROM usuarios";
            pst = pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                usuarios.add(new Usuarios(
                        rs.getInt("Id_usuario"),
                        rs.getString("Name_users"),                        
                        rs.getString("Mail_users"),
                        rs.getString("Pass_users"),
                        rs.getString("Phone_users"),
                        rs.getInt("Type_users")                        
                ));
            }
        } catch (Exception e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        
        return usuarios;
    }
    
    
}

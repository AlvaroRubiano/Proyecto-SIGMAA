/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



import Clases.Factor;
import Clases.Semestre;
import Clases.TipoMonitor;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesListas extends Conexion {
    
    //Metodo para mostrar la lista de factores
    public ArrayList<Factor> getFactor(){
        
        ArrayList<Factor> factores = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "SELECT * FROM factor_asociado";
            pst = pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                factores.add(new Factor(
                        rs.getInt("Id_factor"),
                        rs.getString("Name_factor"),
                        rs.getString("Observaciones")
                ));                
            }  
        } catch (SQLException e) {
                System.out.println("Error de cierre" + e );
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        return factores;
    }
    
    //Metodo para mostrar la lista de semestres
    public ArrayList<Semestre> getSemestre(){
        
        ArrayList<Semestre> semestre = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "SELECT * FROM semestre";
            pst = pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                semestre.add(new Semestre(
                        rs.getInt("Id_semestre"),
                        rs.getString("nombre")                        
                ));                
            }  
        } catch (SQLException e) {
                System.out.println("Error de cierre" + e );
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        return semestre;
    }
    
    //Metodo para mostrar la lista de semestres
    public ArrayList<TipoMonitor> getMonitor(){
        
        ArrayList<TipoMonitor> monitor = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "SELECT * FROM tipotutor";
            pst = pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                monitor.add(new TipoMonitor(
                        rs.getInt("Id_tipo"),
                        rs.getString("nombre")                        
                ));                
            }  
        } catch (SQLException e) {
                System.out.println("Error de cierre" + e );
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        return monitor;
    }
    
//Prueba de funcionamiento del Metodo para mostrar la lista de facultades y campus registrados.
    
//    public static void main(String[] args ){        
//        GestionesListas gl = new GestionesListas();
//        for(Factor c : gl.getFactor()){ 
//            System.out.println(c.getCodigo()+" / "+ c.getNombre()); 
//        }
//    }
    
       
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.ReporteResultado;
import Clases.Resultado;
import Clases.Tutorias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesTutorias extends Conexion{
    
    //Metodo para mostrar la lista de campus registrados
    public ArrayList<Tutorias> getTutorias(){
        
        ArrayList<Tutorias> tutorias = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
               
        try {
            String consulta = "SELECT tutorias.Id_tutorias, tutorias.fecha, estudiantes.Name_users, tutorias.Id_programa, tutorias.semestre, tutorias.Id_factor, tutorias.Id_tutor, tutorias.obervaciones, tutorias.estado "
                    + "FROM tutorias, estudiantes "
                    + "WHERE tutorias.Id_estudiante=estudiantes.Id_estudiante";
            pst = pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                tutorias.add(new Tutorias(
                        rs.getInt("tutorias.Id_tutorias"),
                        rs.getDate("tutorias.fecha"),                        
                        rs.getString("estudiantes.Name_users"),
                        rs.getInt("tutorias.Id_programa"),
                        rs.getInt("tutorias.semestre"),
                        rs.getInt("tutorias.Id_factor"),
                        rs.getInt("tutorias.Id_tutor"),   
                        rs.getString("tutorias.obervaciones"), 
                        rs.getString("tutorias.estado") 
                ));
            }
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        
        return tutorias;
    }
        
    public int actualizarTutorias(Resultado r){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int resultado = 0;
        
            try {
                String consulta = "INSERT INTO resultado (Id_resultado, fecha, asignatura, observaciones, nombre, ruta) VALUES(?,?,?,?,?,?)";
                pst = (PreparedStatement) getConexion().prepareStatement(consulta);
                                
                pst.setInt(1, r.getId());
                pst.setDate(2, r.getFecha());
                pst.setInt(3, r.getAsignatura());
                 pst.setString(4, r.getObservaciones());
                pst.setString(5, r.getNombre());
                pst.setString(6, r.getRuta());
                
                pst.executeUpdate();                

            } catch (SQLException e) {
                System.out.print("Error: " + e);                
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                        
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    
                }
            }        
        return resultado;
    }
    
    
    //Metodo para mostrar la lista de campus registrados
    public ArrayList<ReporteResultado> getResultadoTutorias(){
        
        ArrayList<ReporteResultado> tutorias = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
               
        try {
            String consulta = "SELECT tutorias.Id_tutorias, estudiantes.Name_users, factor_asociado.Name_factor, usuarios.Name_users, tutorias.obervaciones, resultado.observaciones, resultado.nombre, resultado.ruta "
                    + "FROM tutorias, estudiantes, factor_asociado, usuarios, resultado "
                    + "WHERE tutorias.Id_estudiante=estudiantes.Id_estudiante AND tutorias.Id_factor=factor_asociado.Id_factor AND tutorias.Id_tutor=usuarios.Id_usuario AND resultado.Id_resultado=tutorias.Id_tutorias;";
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                tutorias.add(new ReporteResultado(
                        rs.getInt("tutorias.Id_tutorias"),
                        rs.getString("estudiantes.Name_users"),                        
                        rs.getString("factor_asociado.Name_factor"),
                        rs.getString("usuarios.Name_users"),
                        rs.getString("tutorias.obervaciones"),
                        rs.getString("resultado.observaciones"),
                        rs.getString("resultado.nombre"),   
                        rs.getString("resultado.ruta")                        
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
        return tutorias;
    }
    
    
     //Prueba de funcionamiento del Metodo para mostrar la lista
    
//    public static void main(String[] args ){
//        GestionesTutorias mc = new GestionesTutorias();
//        for(Tutorias c : mc.getTutorias()){
//            System.out.println(c.getFecha()+" "+ c.getEstudiante());
//        }
//    }
    
    //Metodo para probar el Metodo para crear las facultades
    
//    public static void main(String[] args) {
//        GestionesTutorias gt = new GestionesTutorias();
//        System.out.println(gt.actualizarTutorias(r));
//    }
    
    
}

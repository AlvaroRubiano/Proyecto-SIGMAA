/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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

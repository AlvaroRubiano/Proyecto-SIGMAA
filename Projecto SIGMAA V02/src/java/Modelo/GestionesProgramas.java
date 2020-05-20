
package Modelo;

import Clases.FacultadCampus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesProgramas extends Conexion{
    
    //Metodo para crear las facultades
    public boolean registraProgramas (String nombre, String modalidad, int idFacultad){
        PreparedStatement pst = null;
        
        try {
            String consulta = "insert into programa (Name_program, Modalidad, Id_faculty) values(?,?,?)";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            
            pst.setString(1, nombre);
            pst.setString(2, modalidad);
            pst.setInt(3, idFacultad);
                        
            if(pst.executeUpdate() ==1){
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error 1" + e);
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
         
        return false;
    }
    
    //Metodo para mostrar la lista de campus registrados
    public ArrayList<FacultadCampus> getFacultadCampus(){
        
        ArrayList<FacultadCampus> facultadescampus = new ArrayList<>();
        com.mysql.jdbc.PreparedStatement pst = null;
        ResultSet rs = null;
               
        try {
            String consulta = "SELECT campus.Id_campus, campus.Name_campus, facultad.Id_faculty, facultad.Name_faculty FROM facultad, campus WHERE facultad.Id_campus  = campus.Id_campus";
            pst = pst =(com.mysql.jdbc.PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                facultadescampus.add(new FacultadCampus(
                        rs.getInt("campus.Id_campus"),
                        rs.getString("campus.Name_campus"),
                        rs.getInt("facultad.Id_faculty"),
                        rs.getString("facultad.Name_faculty")
                ));
            }
            
        } catch (Exception e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        
        return facultadescampus;
    }    
    
    
    //Prueba de funcionamiento del Metodo para mostrar la lista de facultades y campus registrados.
    /*
    public static void main(String[] args ){
        
        GestionesProgramas gfc = new GestionesProgramas();
       
        for(FacultadCampus c : gfc.getFacultadCampus()){
            
            if(c.getId_campus()== 3){
                System.out.println(c.getId_facultad()+" / "+ c.getNombre_facultad());
        
            }
        }
    }
    
    */
    
    
    //Metodo para probar el Metodo para crear las facultades
    /*
    public static void main(String[] args) {
        GestionesProgramas gp = new GestionesProgramas();
        System.out.println(gp.registraProgramas("Prueba2", "Virtual", 1));
    }
    */
    
}

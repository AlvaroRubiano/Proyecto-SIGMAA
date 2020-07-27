
package Modelo;

import Clases.FacultadCampus;
import Clases.Programas;
import Clases.ProgramaEstudainte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesProgramas extends Conexion{
    
    //Metodo para crear los programas
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
    public ArrayList<FacultadCampus> getFacultadCampus(int x){
        
        ArrayList<FacultadCampus> facultadescampus = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "SELECT * FROM faculta WHERE faculta.IdCampus="+x;
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                facultadescampus.add(new FacultadCampus(
                        rs.getInt("faculta.Id"),
                        rs.getString("faculta.Name"),
                        rs.getInt("faculta.IdCampus")
                )                        
                        );
                        }
            
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        
        return facultadescampus;
    }    
    
    //Metodo para mostrar la lista de programas registrados
    public ArrayList<Programas> getProgramas(int x){
        
        ArrayList<Programas> programas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;               
        try {
            String consulta = "SELECT * FROM programa WHERE programa.Id_faculty="+x;
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                programas.add(new Programas(
                        rs.getInt("Id_program"),
                        rs.getString("Name_program"),
                        rs.getString("Modalidad"),
                        rs.getInt("Id_faculty")
                ));
            }            
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }        
        return programas;
    }
    
    //Metodo para mostrar la lista de programas asociados a los estudiantes
    public ArrayList<ProgramaEstudainte> getProgramasEstudiantes(int x){
        
        ArrayList<ProgramaEstudainte> programas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;               
        try {
            String consulta = "SELECT programa.Id_program, programa.Name_program FROM programa, estudiantes WHERE estudiantes.Id_program=programa.Id_program AND estudiantes.Id_estudiante="+x;
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                programas.add(new ProgramaEstudainte(
                        rs.getInt("programa.Id_program"),
                        rs.getString("programa.Name_program")
                ));
            }            
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }        
        return programas;
    }
    
    
    //Metodo para mostrar la lista de programas registrados
    public ArrayList<Programas> getListaProgramas(){
        
        ArrayList<Programas> programas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
               
        try {
            String consulta = "SELECT * FROM programa";
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                programas.add(new Programas(
                        rs.getInt("Id_program"),
                        rs.getString("Name_program"),
                        rs.getString("Modalidad"),
                        rs.getInt("Id_faculty")
                ));
            }
            
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }        
        return programas;
    }
    //Prueba de funcionamiento del Metodo para mostrar la lista de programas.
    
//    public static void main(String[] args ){
//        
//        GestionesProgramas gfc = new GestionesProgramas();
//       
//        for(Programas c : gfc.getProgramas(9)){
//            
//            System.out.println(c.getNombre_Programa()+" / "+ c.getModalidad()+" / "+c.getId_facultad());
//        
//        }
//    }
    
    
    
    
    //Prueba de funcionamiento del Metodo para mostrar la lista de facultades y campus registrados.
//    
//    public static void main(String[] args ){
//        
//        GestionesProgramas gfc = new GestionesProgramas();
//       
//        for(FacultadCampus c : gfc.getFacultadCampus(2)){
//            
//                System.out.println(c.getId_facultad()+" / "+ c.getNombre_facultad());
//                           
//        }
//    }
    
    
    
    
    //Metodo para probar el Metodo para crear las facultades
    /*
    public static void main(String[] args) {
        GestionesProgramas gp = new GestionesProgramas();
        System.out.println(gp.registraProgramas("Prueba2", "Virtual", 1));
    }
    */
    
}


package Modelo;

import Clases.Materias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesMaterias extends Conexion{
    
    //metodo para crear las materias
    public boolean registarMaterias(String nombre, int id){
        PreparedStatement pst = null;
        
        try {
            String consulta ="insert into materia (Nombre_clase, Id_programa) values(?,?)";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            
            pst.setString(1, nombre);
            pst.setInt(2, id);
            
            if(pst.executeUpdate() == 1){
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
    
    //Metodo para borrar registros
    public boolean borrarMaterias(){
        PreparedStatement pst = null;
        
        try {
            String consulta = "DELETE FROM materia WHERE Id_clase = ?";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            
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
    
       
    //Metodo para consulta de registros en materia
    public ArrayList<Materias> getMaterias(){
        
        ArrayList<Materias> materias = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try {
            String consulta = "select Id_clase, Nombre_clase, Id_programa from materia";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                materias.add(new Materias(
                        rs.getInt("Id_clase"),
                        rs.getString("Nombre_clase"),
                        rs.getInt("Id_programa")
                ));
                
            }
        } catch (Exception e) {
                System.out.println("Error de cierre" + e );
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        return materias;
    }
    
    
    //Prueba de funcionamiento del Metodo para mostrar la lista materias.
    /*
    public static void main(String[] args ){
        
        GestionesMaterias gm = new GestionesMaterias();
       
        for(Materias c : gm.getMaterias()){
                       
            System.out.println(c.getNombre_materia()+" / "+ c.getId_programa());
            
        }
    }
    */
    
    
    //Metodo para probar el Metodo para crear materias
    /*
    public static void main(String[] args) {
        GestionesMaterias gp = new GestionesMaterias();
        System.out.println(gp.registarMaterias("Matemáticas Especiales", 1));
    }
    */
        
    
    
}

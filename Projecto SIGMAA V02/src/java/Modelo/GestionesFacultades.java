
package Modelo;

import java.sql.PreparedStatement;

/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesFacultades extends Conexion{
    
    //Metodo para crear las facultades
    public boolean registraFacultades (String nombre, int id){
        PreparedStatement pst = null;
        
        try {
            String consulta = "insert into facultad (Name_faculty, Id_campus) values(?,?)";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            
            pst.setString(1, nombre);
            pst.setInt(2, id);
            
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
    
    //Metodo para probar el Metodo para crear las facultades
    /*
    public static void main(String[] args) {
        GestionesFacultades rf = new GestionesFacultades();
        System.out.println(rf.registraFacultades("Prueba 24Abril2020", 25));
    }
    */
    
    
}

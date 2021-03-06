
package Modelo;

import Clases.Facultad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvaro Rubiano
 */
public class GestionesFacultades extends Conexion{
    
    //Metodo para crear las facultades
    public boolean registraFacultades (String nombre, int id){
        PreparedStatement pst = null;
        
        try {
            String consulta = "INSERT INTO faculta (Name, IdCampus) values(?,?)";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            
            pst.setString(1, nombre);
            pst.setInt(2, id);
            
            if(pst.executeUpdate() ==1){
                return true;
            }
            
        } catch (SQLException e) {
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
    public ArrayList<Facultad> getFacultad(int x){
        
        ArrayList<Facultad> facultades = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
                        
        try {            
            String consulta = "SELECT * FROM faculta WHERE faculta.IdCampus="+x;
            pst =(PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
                        
            //Ahora con el while se recorre la consulta.
            while(rs.next()){
                facultades.add(new Facultad(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getInt("IdCampus") 
                    )
                );
            } 
            
        } catch (SQLException e) {
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close(); 
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error 4: " + e);
            }
        }
        
        
        return facultades;
    }
    
   
    //Prueba de funcionamiento del Metodo para mostrar la lista de facultades registrados.
    /*
    public static void main(String[] args ){
        
        GestionesFacultades gf = new GestionesFacultades();
        for(Facultad c : gf.getFacultad()){
            System.out.println(c.getIdentificador()+" "+ c.getNombre_facultad());
        }
    }
    */
    
    //Metodo para probar el Metodo para crear las facultades
    /*
    public static void main(String[] args) {
        GestionesFacultades rf = new GestionesFacultades();
        System.out.println(rf.registraFacultades("Prueba xxxxxx", 25));
    };
    */   
    
    
}

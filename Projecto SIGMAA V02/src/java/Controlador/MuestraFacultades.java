
package Controlador;

import Clases.FacultadCampus;
import Modelo.GestionesProgramas;

/**
 *
 * @author Alvaro Rubiano
 */
public class MuestraFacultades {
    
    //Metodo para enviar el nombre y el id de los campus para la vista de crear las facultades
    public String getNombreCampus(int x){
        
        String htmlcode1 = "";
        
        GestionesProgramas glf = new GestionesProgramas();
        
        for (FacultadCampus fc : glf.getFacultadCampus(x)) {
            htmlcode1 += "<option value='"+fc.getId_facultad()+"'>"+fc.getNombre_facultad()+"</option> ";
        
        }return htmlcode1;
    }
    
    
    
    public String getListaFacultades(int campus){
        
        String htmlcode2 = "";
        
        GestionesProgramas glf = new GestionesProgramas();
        
        for(FacultadCampus f : glf.getFacultadCampus(campus)) {
            if(f.getId_campus() == campus ){
               htmlcode2 += "<option value='"+f.getId_facultad()+"'>"+f.getNombre_facultad()+"</option> "; 
            }
        }
        return htmlcode2;
        
    }
    
    
    
    
    
}

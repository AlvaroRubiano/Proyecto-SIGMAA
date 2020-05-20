
package Controlador;

import Clases.FacultadCampus;
import Modelo.GestionesProgramas;

/**
 *
 * @author Alvaro Rubiano
 */
public class MuestraFacultades {
    
    //Metodo para enviar el nombre y el id de los campus para la vista de crear las facultades
    public String getNombreCampus(){
        
        String htmlcode1 = "";
        
        GestionesProgramas glf = new GestionesProgramas();
        
        for (FacultadCampus fc : glf.getFacultadCampus()) {
            htmlcode1 += "<option value='"+fc.getId_campus()+"'>"+fc.getNombre_campus()+"</option> ";
        
        }return htmlcode1;
    }
    
    
    //Metodo para enviar el nombre y el id de los campus para la vista de crear las facultades
    public String getListaFacultades(int campus){
        
        String htmlcode2 = "";
        
        GestionesProgramas glf = new GestionesProgramas();
        
        for(FacultadCampus f : glf.getFacultadCampus()) {
            if(f.getId_campus() == campus ){
               htmlcode2 += "<option value='"+f.getId_facultad()+"'>"+f.getNombre_facultad()+"</option> "; 
            }
        }
        return htmlcode2;
        
    }
    
    
    
    
    
}

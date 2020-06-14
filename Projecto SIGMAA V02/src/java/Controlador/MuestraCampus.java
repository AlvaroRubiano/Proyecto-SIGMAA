
package Controlador;

import Clases.Campus;
import Modelo.GestionesCampus;

/**
 *
 * @author Alvaro Rubiano
 * Este controlador esta diseñado para enviar información al módulo de consulta
 * de campus del módulo del administrador.
 */
public class MuestraCampus {
    
    //Metodo para realizar la consulta de los campus.
    public String getVistaCampus(){
        String htmlcode = "";
        String htmlcode2 = "";
        GestionesCampus mc = new GestionesCampus();
        
        for (Campus c : mc.getCampus()) {            
            htmlcode += "<div class=\"container\">\n" +                    
"                           <div class=\"row\">\n" +
"                               <div class=\"col-sm\">\n" +
"                                   "+c.getNombre_campus()+
"                                </div>\n" +
"                               <div class=\"col-sm\">\n" +
"                                "+c.getTipo_campus()+
"                               </div>\n" +
"                               <div class=\"col-sm\">\n" +
"                                "+c.getDireccion_campus()+
"                               </div>\n" +                               
"                               </div>\n" +
"                           </div>    \n" +
"                       </div>";  
        }
        return htmlcode + htmlcode2;
    }
    
       
    //Metodo para enviar el nombre y el id de los campus para la vista de crear las facultades
    public String getNombreCampus(){
        
        String htmlcode = "";
        
        GestionesCampus mnc = new GestionesCampus();
        
        for (Campus c : mnc.getCampus()) {
                       
            htmlcode += "<option value='"+c.getIdentificador()+"'>"+c.getNombre_campus()+"</option> ";
            
        }return htmlcode;
        
    }
    
}

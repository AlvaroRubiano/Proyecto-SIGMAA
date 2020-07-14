/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Materias;
import Modelo.GestionesMaterias;

/**
 *
 * @author Alvaro Rubiano
 */
public class MuestraMaterias {
     public String getVistaMaterias(){
          String htmlcode = "";
          GestionesMaterias gm =  new GestionesMaterias();
          for(Materias m : gm.getMaterias()){
              htmlcode += "<div class=\"container\">\n" +                    
"                           <div class=\"row\">\n" +
"                               <div class=\"col-sm\">\n" +
"                                   "+m.getId_materia()+
"                                </div>\n" +
"                               <div class=\"col-sm\">\n" +
"                                "+m.getNombre_materia()+
"                               </div>\n" +
"                               <div class=\"col-sm\">\n" +
"                                "+m.getId_programa()+
"                               </div>\n" +
"                               <div class=\"col-sm\">\n" +
"                               <a href=\"\">Modificar</a>"+
"                               </div>\n" +
"                               <div class=\"col-sm\">\n" +
"                               <a href=\"\">Eliminar</a>"+
"                               </div>\n" +                      
"                           </div>    \n" +
"                       </div>";
          }
                    
         return htmlcode;
     }
}

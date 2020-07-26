/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Estudiante;
import Modelo.GestionesEstudiantes;
/**
 *
 * @author Alvaro Rubiano
 */
public class MuestraEstudiantes {
    
    
    public String getListaEstudiantes(){
        
        String htmlcode = "";
        
        GestionesEstudiantes le = new GestionesEstudiantes();
        
        for (Estudiante e : le.getEstudiantes()) {
            htmlcode += "<option value='"+e.getIdentificacion()+"'>"+e.getNombres()+"</option> ";        
        }return htmlcode;
    }
    
}

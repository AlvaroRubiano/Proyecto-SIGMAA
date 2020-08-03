/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Factor;
import Clases.Semestre;
import Clases.TipoMonitor;
import Clases.Programas;
import Modelo.GestionesListas;
import Modelo.GestionesProgramas;

/**
 *
 * @author Alvaro Rubiano
 */
public class MuestraListas {
    
   public String getListaFactores(){        
        String htmlcode = "";        
        GestionesListas gl = new GestionesListas();        
        for (Factor f : gl.getFactor()) {                       
            htmlcode += "<option value='"+f.getCodigo()+"'>"+f.getNombre()+"</option> ";            
        }return htmlcode;        
    }
   
    public String getListaSemestres(){        
        String htmlcode = "";        
        GestionesListas gl = new GestionesListas();        
        for (Semestre f : gl.getSemestre()) {                       
            htmlcode += "<option value='"+f.getId()+"'>"+f.getNombre()+"</option> ";            
        }return htmlcode;        
    }
    
    public String getListaTipoMonitor(){        
        String htmlcode = "";        
        GestionesListas gl = new GestionesListas();        
        for (TipoMonitor f : gl.getMonitor()) {                       
            htmlcode += "<option value='"+f.getId()+"'>"+f.getNombre()+"</option> ";            
        }return htmlcode;        
    }
    
    public String getListaTipoUsuario(){        
        String htmlcode = "";        
        GestionesListas gl = new GestionesListas();        
        for (TipoMonitor f : gl.getUsuario()) {                       
            htmlcode += "<option value='"+f.getId()+"'>"+f.getNombre()+"</option> ";            
        }return htmlcode;        
    }

    public String getListaProgramas(){        
        String htmlcode = "";        
        GestionesProgramas gl = new GestionesProgramas();        
        for (Programas f : gl.getListaProgramas()) {                       
            htmlcode += "<option value='"+f.getId_programa()+"'>"+f.getNombre_Programa()+"</option> ";            
        }return htmlcode;        
    }

}





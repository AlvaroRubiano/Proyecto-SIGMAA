
package Servlets;

import Clases.FacultadCampus;
import Modelo.GestionesProgramas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alvaro Rubiano
 * Con este servlet se realiza la selección del indice del campus seleccionado
 * en el formulario de creaar programas. Se hace de esta forma para poder enviar
 * la lista de las facultades asociadas al campus.
 */
public class SeleccinaCampus extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("codigocampus");
        int cd_campus = Integer.parseInt(request.getParameter("codigocampus"));
        
        String htmlcode2 = "";
        
        GestionesProgramas glf = new GestionesProgramas();
        
        for(FacultadCampus f : glf.getFacultadCampus()) {
            if(f.getId_campus()== cd_campus){
               htmlcode2 += f.getId_facultad()+"-"+f.getNombre_facultad()+":";  
            }
            
        }
        
        out.write(htmlcode2.toString());
        
        
    }
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}

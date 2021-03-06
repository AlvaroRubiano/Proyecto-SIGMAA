/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Resultado;
import Modelo.GestionesTutorias;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.mail.internet.MailDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Alvaro
 */
public class ModificarTutorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String accion = request.getParameter("accion");
        Resultado r = new Resultado();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        GestionesTutorias gt = new GestionesTutorias();
                
        switch (accion){
            case "actualizar":
                ArrayList<String> lista = new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileitem = (FileItem)items.get(i);
                        if(!fileitem.isFormField()){
                            File f = new File("D:\\Universidad\\AREA ANDINA\\Projecto SIGMAA V02\\web\\evidencias\\"+fileitem.getName());
                            fileitem.write(f);
                            r.setRuta("http://localhost:8080/Projecto_SIGMAA_V02/evidencias/"+fileitem.getName());
                        }else{
                            lista.add(fileitem.getString());
                        }
                    }
                    r.setId(Integer.parseInt(lista.get(0)));
                    r.setFecha(Date.valueOf(lista.get(1)));
                    r.setAsignatura(Integer.parseInt(lista.get(2)));
                    r.setObservaciones(lista.get(3));
                    r.setNombre(lista.get(4));                    
                    
                    gt.actualizarTutorias(r);
                    
                } catch (Exception e) {
                    out.print("Error: "+ e);
                }   
                
                    response.sendRedirect("Tutores/Tutores.jsp");
                    break;
            default:
                throw new AssertionError();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

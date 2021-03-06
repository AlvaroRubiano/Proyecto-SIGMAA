/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Conexion;
import Modelo.GestionesUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Alvaro Rubiano
 */
public class ActualizarContrasena extends HttpServlet {

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
        Conexion conexion = new Conexion();
        PreparedStatement pst = null;
        ResultSet rs = null; 
        String actualizar = request.getParameter("actualizar");
        String usuario = request.getParameter("id");
        String pass = request.getParameter("password");
        String newpass = request.getParameter("nuevoPassword");
        String confirmar = request.getParameter("confirmarPassword");        
        
        GestionesUsuarios gu = new GestionesUsuarios();
        
        //out.print(actualizar+"usuario: "+usuario);
        switch(actualizar){
            case "monitor":
                if(newpass.equals(confirmar)){                      
                    try {                        
                        String consulta = "UPDATE usuarios SET Pass_users='"+gu.getEncriptacion(confirmar)+"' WHERE Pass_users='"+pass+"' AND Id_usuario='"+usuario+"';";
                        pst = (PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                        pst.executeUpdate();
                        response.sendRedirect("Tutores/Tutores.jsp");
                    } catch (SQLException e) {
                        out.print("Error 3: " + e);
                    } finally {
                        try {
                            if (pst != null) {
                            pst.close();
                            }
                        } catch (SQLException e) {
                            out.print("Error 4: " + e);
                        }
                    }
                }else{
                     response.sendRedirect("Tutores/Tutores.jsp");
                }
                break;
            
            case "administrativo":
                if(newpass.equals(confirmar)){                      
                    try {                        
                        String consulta = "UPDATE usuarios SET Pass_users='"+gu.getEncriptacion(confirmar)+"' WHERE Pass_users='"+pass+"' AND Id_usuario='"+usuario+"';";
                        pst = (PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                        pst.executeUpdate();
                        response.sendRedirect("OficinaOPE/AdministracionOPE.jsp");
                    } catch (SQLException e) {
                        out.print("Error 3: " + e);
                    } finally {
                        try {
                            if (pst != null) {
                            pst.close();
                            }
                        } catch (SQLException e) {
                            out.print("Error 4: " + e);
                        }
                    }
                }else{
                     response.sendRedirect("OficinaOPE/AdministracionOPE.jsp");
                }
                break;    
            default:    
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

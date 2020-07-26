/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Modelo.Conexion;
import Modelo.GestionesUsuarios;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alvaro Rubiano
 */


public class IngresoUsuarios extends HttpServlet {

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
        
        String nombre = request.getParameter("email");
        String contrasena = request.getParameter("password");
        GestionesUsuarios gu = new GestionesUsuarios();
        
        String pass = gu.getEncriptacion(contrasena);
        int tipo = 0;        
        
        try {
            String consulta = "Select * FROM usuarios WHERE Mail_users = '"+nombre+"' AND Pass_users='"+pass+"'";
            pst =(PreparedStatement) conexion.getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
                        
            while(rs.next()){
                tipo = rs.getInt("Type_users");                
            }
            //out.print(tipo);            
            GestionesUsuarios us = new GestionesUsuarios();            
            if(us.autenticacion(nombre, pass)){
                switch(tipo){
                    case 1:{
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Usuario", nombre);
                        response.sendRedirect("Tutores/Tutores.jsp"); 
                        break;
                    }
                    case 2:{
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Usuario", nombre);
                        response.sendRedirect("Tutores/Tutores.jsp");
                        break;
                    }
                    case 3:{
                        HttpSession objetoSesion = request.getSession(true);                        
                        objetoSesion.setAttribute("UsuarioAutenticado", nombre);
                        response.sendRedirect("OficinaOPE/AdministracionOPE.jsp");
                        break;
                    }
                    default:response.sendRedirect("index.jsp"); 
                }                
                
            }else{
                response.sendRedirect("index.jsp"); 
            }
            
        } catch (SQLException e) {
                out.println("Error 3: " + e);
        }finally{
            try {                
                if(pst != null) pst.close(); 
                if(rs != null) rs.close();
            } catch (SQLException e) {
                out.println("Error 4: " + e);
            }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ConsultaUsuario extends HttpServlet {

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
        
        try {
            String consulta = "SELECT usuarios.Id_usuario, usuarios.Name_users, usuarios.Mail_users, usuarios.Phone_users, tipotutor.nombre, campus.Name_campus, faculta.Name, programa.Name_program, usuarios.Semestre, usuarios.Modalidad FROM usuarios, campus, faculta, programa, tipotutor WHERE usuarios.Id_campus=campus.Id_campus AND usuarios.Id_faculty=faculta.Id AND usuarios.Id_program=programa.Id_program AND usuarios.Type_users=tipotutor.Id_tipo;";
            pst =(PreparedStatement) conexion.getConexion().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            
            com.google.gson.JsonObject elementos =  new com.google.gson.JsonObject();
            com.google.gson.JsonArray array = new com.google.gson.JsonArray();
            
            while(rs.next()){
                com.google.gson.JsonObject item = new com.google.gson.JsonObject();
                
                item.addProperty("codigo", rs.getString("usuarios.Id_usuario"));
                item.addProperty("nombre", rs.getString("usuarios.Name_users"));
                item.addProperty("correo", rs.getString("usuarios.Mail_users"));
                item.addProperty("telefono", rs.getString("usuarios.Phone_users"));
                item.addProperty("tipo", rs.getString("tipotutor.nombre"));
                item.addProperty("campus", rs.getString("campus.Name_campus"));
                item.addProperty("facultad", rs.getString("faculta.Name"));
                item.addProperty("programa", rs.getString("programa.Name_program"));
                item.addProperty("semestre", rs.getString("usuarios.Semestre"));
                item.addProperty("modalidad", rs.getString("usuarios.Modalidad"));                
               
                array.add(item);                
            }
            
            elementos.add("datos", array);
            
            out.print(elementos.toString());
            
        } catch (SQLException e) {
        }finally{
            try {                
                if(pst != null) pst.close(); 
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error 4: " + e);
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

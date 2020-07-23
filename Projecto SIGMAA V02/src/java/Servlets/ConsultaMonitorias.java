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
public class ConsultaMonitorias extends HttpServlet {

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
                String consulta = "SELECT tutorias.Id_tutorias, tutorias.fecha, estudiantes.Name_users, semestre.nombre, factor_asociado.Name_factor, usuarios.Name_users, obervaciones "
                        + "FROM tutorias, estudiantes, semestre, factor_asociado, usuarios "
                        + "WHERE tutorias.Id_estudiante=estudiantes.Id_estudiante AND tutorias.semestre=semestre.Id_semestre AND tutorias.Id_factor=factor_asociado.Id_factor AND tutorias.Id_tutor=usuarios.Id_usuario AND tutorias.estado=\"'Abierto'\" ";
                pst = (PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                rs = pst.executeQuery(consulta);

                com.google.gson.JsonObject elementos = new com.google.gson.JsonObject();
                com.google.gson.JsonArray array = new com.google.gson.JsonArray();

                while (rs.next()) {
                    com.google.gson.JsonObject item = new com.google.gson.JsonObject();
                    
                    item.addProperty("caso", rs.getString("Id_tutorias"));
                    item.addProperty("fecha", rs.getString("tutorias.fecha"));
                    item.addProperty("estudiante", rs.getString("estudiantes.Name_users"));
                    item.addProperty("semestre", rs.getString("semestre.nombre"));
                    item.addProperty("factor", rs.getString("factor_asociado.Name_factor"));
                    item.addProperty("tutor", rs.getString("usuarios.Name_users"));
                    item.addProperty("observaciones", rs.getString("obervaciones"));

                    array.add(item);
                }
                elementos.add("datos", array);
                out.print(elementos.toString());
                
            } catch (SQLException e) {
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Factor;
import Modelo.Conexion;
import Modelo.GestionesListas;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaFactor extends HttpServlet {

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
        
        ConsultaFactor factor = new ConsultaFactor();
        
        out.print(factor);
        //request.setAttribute("lista", factores);
        //request.getRequestDispatcher("OficinaOPE/CrearTutorias.jsp").forward(request, response);
        
        
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

    private ArrayList<Factor> lista() {
        ArrayList<Factor> factores = new ArrayList<>();
        
        Conexion conexion = new Conexion();
        com.mysql.jdbc.PreparedStatement pst = null;        
        ResultSet rs = null;        
        
        try {
            String consulta = "SELECT * FROM factor_asociado";
            pst =(com.mysql.jdbc.PreparedStatement) conexion.getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                factores.add(new Factor(
                        rs.getInt("Id_factor"),
                        rs.getString("Name_factor"),
                        rs.getString("Observaciones")
                ));                
            }  
        } catch (SQLException e) {
                System.out.println("Error de cierre" + e );
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        return factores;        
        
    }
    
    public String getFactores(){
        String htmlcode = "";
        ConsultaFactor cf = new ConsultaFactor();
        
        for(Factor f : cf.lista()){
            htmlcode = f.getNombre();
        }       
        
        return htmlcode;        
    }

}

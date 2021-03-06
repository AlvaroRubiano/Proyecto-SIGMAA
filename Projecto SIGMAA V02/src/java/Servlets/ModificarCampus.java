
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
public class ModificarCampus extends HttpServlet {

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
                
        String id= request.getParameter("identificadorCampus");
        String nombre= request.getParameter("nombreCampus");
        String direccion = request.getParameter("direccionCampus");
        String tipo = request.getParameter("tipoCampus");
        
        String editar = request.getParameter("btnModificarCampus");
        String borrar = request.getParameter("btnEliminarCampus");
        
        String action1 = "1"; 
        String action2 = "2"; 
        
        if (action1.equals(editar)) {
            try {
                String consulta = "UPDATE campus SET Name_campus='" + nombre + "', Tipo='" + tipo + "', Direccion='" + direccion + "' WHERE Id_campus=" + id;
                pst = (PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                pst.executeUpdate();

                if (pst.executeUpdate()== 1) {
                    response.sendRedirect("Administrador/ModificarCampus.jsp");
                } else {
                    response.sendRedirect("ups.jsp");
                }
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
                    System.out.println("Error 4: " + e);
                }
            }
        }
        
        if (action2.equals(borrar)) {
            try {
                String consulta = "DELETE FROM campus WHERE Id_campus=" + id;
                pst = (PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                pst.executeUpdate();

                if (pst.executeUpdate() == 0) {
                    response.sendRedirect("Administrador/ModificarCampus.jsp");
                } else {
                    response.sendRedirect("ups.jsp");
                }

            } catch (SQLException e) {
                out.print("Error: " + e);
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error 4: " + e);
                }
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

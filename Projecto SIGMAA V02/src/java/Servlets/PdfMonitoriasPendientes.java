/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.OutputStream;
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
public class PdfMonitoriasPendientes extends HttpServlet {

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
        
        OutputStream out = response.getOutputStream();
        //PrintWriter out1 = response.getWriter();
        Conexion conexion = new Conexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            try {
                String consulta = "SELECT usuarios.Name_users, tipotutor.nombre, COUNT(tutorias.Id_tutorias) FROM tutorias, usuarios, tipotutor WHERE tutorias.Id_tutor=usuarios.Id_usuario AND usuarios.Type_users=tipotutor.Id_tipo AND tutorias.estado=\"Abierto\" GROUP BY usuarios.Name_users";
                pst =(PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                rs = pst.executeQuery(consulta);
                
                try {
                    Document documento = new Document();
                    PdfWriter.getInstance(documento, out);
                    documento.open();
                
                    Paragraph encabezado = new Paragraph();                
                    encabezado.add(new Phrase("FUNDACIÓN UNIVERSITARIA DEL AREA ANDINA",FontFactory.getFont("Arial",12, Font.BOLD, BaseColor.BLACK)));                
                    encabezado.add(new Phrase(Chunk.NEWLINE));
                    encabezado.add(new Phrase(Chunk.NEWLINE));
                    encabezado.add(new Phrase("OFICINA DE ORIENTACIÓN Y PERMANENCIA UNIVERSITARIA", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    encabezado.add(new Phrase(Chunk.NEWLINE));
                    encabezado.add(new Phrase(Chunk.NEWLINE));
                    encabezado.add(new Phrase("FORMATO REPORTE DE MONITORIA", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));                
                    encabezado.add(new Phrase(Chunk.NEWLINE));
                
                    Paragraph version = new Paragraph();
                    version.add(new Phrase("Versión 1.0", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    version.add(new Phrase(Chunk.NEWLINE));

                    Image logo = Image.getInstance("D:\\Universidad\\AREA ANDINA\\Projecto SIGMAA V02\\web\\Imagenes\\Areandina.PNG");
                    logo.scaleToFit(60, 60);
                    //documento.add(logo);

                    PdfPTable tabla = new PdfPTable(3);
                    float[] medidaCeldas = {0.55f, 2.25f, 0.55f};
                    tabla.setWidths(medidaCeldas);

                    PdfPCell celdaLogo = new PdfPCell(logo);
                    celdaLogo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaLogo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celdaLogo.setRowspan(2);              

                    PdfPCell celdaEncabezado = new PdfPCell(encabezado);
                    celdaEncabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celdaEncabezado.setRowspan(2); 
                
                    PdfPCell celdaVersion = new PdfPCell(version);
                    celdaVersion.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaVersion.setHorizontalAlignment(Element.ALIGN_CENTER);

                    PdfPCell celdaVersion2 = new PdfPCell(new Phrase("COD_REPORTE REPORT242020G", FontFactory.getFont("Arial",8, Font.NORMAL, BaseColor.BLACK)));
                    celdaVersion2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaVersion2.setHorizontalAlignment(Element.ALIGN_CENTER);

                    tabla.addCell(celdaLogo);
                    tabla.addCell(celdaEncabezado);
                    tabla.addCell(celdaVersion);
                    tabla.addCell(celdaVersion2);                
                    documento.add(tabla);                
                
                    //Segunda parte de la tabla
                    PdfPTable tabla2 = new PdfPTable(4);
                    float[] medidaCeldas2 = {1f, 3f, 1f, 2f };
                    tabla2.setWidths(medidaCeldas2);


                    PdfPCell celdaReporte = new PdfPCell(new Phrase("NOMBRE REPORTE", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    celdaReporte.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaReporte.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                    PdfPCell celdaDatoReporte = new PdfPCell(new Phrase("Registro de Atención de Monitorias Pendientes por grupo", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    celdaDatoReporte.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaDatoReporte.setHorizontalAlignment(Element.ALIGN_CENTER);

                    PdfPCell celdaFechaR = new PdfPCell(new Phrase("FECHA REGISTRO", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    celdaFechaR.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaFechaR.setHorizontalAlignment(Element.ALIGN_CENTER);

                    PdfPCell celdaFecha = new PdfPCell(new Phrase(" ", FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    celdaFecha.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaFecha.setHorizontalAlignment(Element.ALIGN_CENTER);
               
                    tabla2.addCell(celdaReporte);                
                    tabla2.addCell(celdaDatoReporte);
                    tabla2.addCell(celdaFechaR);               
                    tabla2.addCell(celdaFecha); 
                
                    documento.add(tabla2);  

                    //Cuarta parte de la tabla
                    PdfPTable tabla4 = new PdfPTable(3);
                    float[] medidaCeldas4 = {3f, 2f, 1f };
                    tabla4.setWidths(medidaCeldas4);
                    PdfPCell celdaNombreMonitor = new PdfPCell(new Phrase("NOMBRE MONITOR", FontFactory.getFont("Arial",8, Font.NORMAL, BaseColor.BLACK)));
                    celdaNombreMonitor.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaNombreMonitor.setHorizontalAlignment(Element.ALIGN_CENTER);

                    PdfPCell celdaMonitoria = new PdfPCell(new Phrase("TIPO MONITOR", FontFactory.getFont("Arial",8, Font.NORMAL, BaseColor.BLACK)));
                    celdaMonitoria.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaMonitoria.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                    PdfPCell celdaTipo = new PdfPCell(new Phrase("PENDIENTES", FontFactory.getFont("Arial",8, Font.NORMAL, BaseColor.BLACK)));
                    celdaTipo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celdaTipo.setHorizontalAlignment(Element.ALIGN_CENTER);

                    tabla4.addCell(celdaNombreMonitor);
                    tabla4.addCell(celdaMonitoria);                
                    tabla4.addCell(celdaTipo);
                    documento.add(tabla4);
                                
                    //Quinta parte de la tabla
                    PdfPTable tabla5 = new PdfPTable(3);
                    float[] medidaCeldas5 = {3f, 2f, 1f };
                    tabla5.setWidths(medidaCeldas5);  
                    
                    while(rs.next()){
                        tabla5.addCell(new Phrase(rs.getString(1),FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                        tabla5.addCell(new Phrase(rs.getString(2),FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                        tabla5.addCell(new Phrase(rs.getString(3),FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK)));
                    }
                    
                    documento.add(tabla5);
                
                
                    documento.close();
                } catch (DocumentException e) {
                    e.getMessage();
                }
                
            } catch (SQLException e) {
                //out1.print("Error: "+e);
            }
            
            
            
        }finally{
            out.close();
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

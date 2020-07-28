package org.apache.jsp.OficinaOPE;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jfree.chart.ChartUtils;
import java.io.OutputStream;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import org.jfree.data.general.DefaultPieDataset;
import Modelo.GestionesListas;
import Modelo.Conexion;

public final class Grafica_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession objetoSession = request.getSession(false);
    String usuario = (String)objetoSession.getAttribute("UsuarioAutenticado");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    };
    
    GestionesListas gl = new GestionesListas();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>OPE - Gráficas</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-3.5.1.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/jquery.dataTables.min.css\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/datatables.min.js\"></script>            \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("  \n");
      out.write("    <div class=\"card-header\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-2\">\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <img src=\"../Imagenes/LogoUno.png\" class=\"img-fluid float-left\" alt=\"Responsive image\" width=\"100% \\9\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-7\">\n");
      out.write("                    <nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("                        \n");
      out.write("                        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                            <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                                <li class=\"nav-item active\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"AdministracionOPE.jsp\">Inicio<span class=\"sr-only\">(current)</span></a>\n");
      out.write("                                </li> \n");
      out.write("                            </ul>                            \n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <h6>Inicio de sesión como:</h6>\n");
      out.write("                    ");
 out.print(usuario); 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>                    \n");
      out.write("        </div> \n");
      out.write("    </div>\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <div class=\"card text-center\">\n");
      out.write("                    <h1>Resumen de Datos</h1>\n");
      out.write("                </div> \n");
      out.write("                <div class=\"container\">\n");
      out.write("                    ");

                        Conexion conexion = new Conexion();
                        PreparedStatement pst = null;
                        ResultSet rs = null;
                        String consulta = "SELECT factor_asociado.Name_factor, COUNT(tutorias.Id_tutorias) AS Cantidad "
                        + "FROM factor_asociado, tutorias "
                        + "WHERE tutorias.Id_factor=factor_asociado.Id_factor "
                        + "GROUP BY factor_asociado.Name_factor;";
                        pst =(PreparedStatement) conexion.getConexion().prepareStatement(consulta);
                        rs = pst.executeQuery(consulta);
                        
                        try {                            
                            DefaultPieDataset data = new DefaultPieDataset();
                            while (rs.next()) {
                                data.setValue(rs.getString(1), rs.getInt(2));
                            }
                            JFreeChart grafico = ChartFactory.createPieChart("Monitorias", data, true, true, true);
                            response.setContentType("Image/JPG");
                            OutputStream sa = response.getOutputStream();
                            ChartUtils.writeChartAsJPEG(sa, grafico, 600, 600);
                               
                        } catch (Exception e) {
                            out.print("Error: "+ e);
                        }
                    
      out.write("\n");
      out.write("                </div> \n");
      out.write("                \n");
      out.write("            </div>             \n");
      out.write("  \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        <div class=\"card text-center\">    \n");
      out.write("            <div class=\"card-footer text-muted\">\n");
      out.write("                <h3>Sistema de Información y Gestión de Monitoria Académica Andina - SIGMAA</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("  \n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

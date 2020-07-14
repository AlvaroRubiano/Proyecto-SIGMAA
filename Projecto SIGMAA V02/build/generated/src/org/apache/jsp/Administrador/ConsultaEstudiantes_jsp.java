package org.apache.jsp.Administrador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ConsultaEstudiantes_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession objetoSession = request.getSession(false);
    String usuario = (String)objetoSession.getAttribute("UsuarioLogeado");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    }  

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Consulta de Campus o sedes</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-3.5.1.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/jquery.dataTables.min.css\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/datatables.min.js\"></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            $(document).ready(function() {\n");
      out.write("                var tabla = $('#tablaEstudiantes').DataTable({\n");
      out.write("                        ajax:{\n");
      out.write("                            method: 'POST',\n");
      out.write("                            url: '../ConsultarEstudiantes',\n");
      out.write("                            dataSrc: 'datos'\n");
      out.write("                            },\n");
      out.write("                            columns: [\n");
      out.write("                                {data: \"codigo\"},\n");
      out.write("                                {data: \"nombre\"},\n");
      out.write("                                {data: \"correo\"},\n");
      out.write("                                {data: \"telefono\"},\n");
      out.write("                                {data: \"tipo\"},\n");
      out.write("                                {data: \"campus\"},\n");
      out.write("                                {data: \"facultad\"},\n");
      out.write("                                {data: \"programa\"},\n");
      out.write("                                {data: \"semestre\"},\n");
      out.write("                                {data: \"modalidad\"},\n");
      out.write("                                {data: \"materia\"}\n");
      out.write("                            ]                        \n");
      out.write("                });\n");
      out.write("              \n");
      out.write("                //$.fn.dataTable.ext.errMode = 'throw';\n");
      out.write("               \n");
      out.write("            });\n");
      out.write("        \n");
      out.write("        </script>      \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("\n");
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
      out.write("                                    <a class=\"nav-link\" href=\"ModuloAdministracion.jsp\">Inicio<span class=\"sr-only\">(current)</span></a>\n");
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
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"table-responsive\">\n");
      out.write("                        <table id=\"tablaEstudiantes\" class=\"table table-bordered table-striped table-hover\" style=\"width:100%\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Identificación</th>\n");
      out.write("                                    <th>Nombres</th>\n");
      out.write("                                    <th>Correo</th>\n");
      out.write("                                    <th>Teléfono</th>\n");
      out.write("                                    <th>Tipo</th>\n");
      out.write("                                    <th>Campus</th>\n");
      out.write("                                    <th>Facultad</th>\n");
      out.write("                                    <th>Programa</th>\n");
      out.write("                                    <th>Semestre</th>\n");
      out.write("                                    <th>Modalidad</th>\n");
      out.write("                                    <th>Modalidad</th>                                    \n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody id=\"employee_data\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                                \n");
      out.write("                        </table>\n");
      out.write("                    </div>                    \n");
      out.write("                </div>  \n");
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

package org.apache.jsp.Administrador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CrearCampus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Crear Campus</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/misestilos.css\" type=\"text/css\">\n");
      out.write("        <script src=\"../js/misScripts.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"../index.jsp\" tabindex=\"-1\" aria-disabled=\"true\">Salir</a>\n");
      out.write("                                </li>\n");
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
      out.write("    <div class=\"card-body\" id=\"body_administrador\">\n");
      out.write("        <div class=\"card text-center\">\n");
      out.write("            <h1>Crear campus universitarios o sedes</h1>\n");
      out.write("        </div>       \n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row justify-content-md-center\">\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <form action=\"../GenerarCampus\" method=\"post\" id=\"formularioCrearCampus\" class=\"needs-validation\" novalidate>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"validationCustom01\">Nombre del campus universitario</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"nombreCrearCampus\" name=\"nombre\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"validationCustom01\">Direccion del Campus</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"direccionCrearCampus\" name=\"direccion\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"validationCustom04\">Tipo de campus</label>\n");
      out.write("                            <select class=\"custom-select\" id=\"tipoCrearCampus\" name=\"tipo\" required>\n");
      out.write("                                <option selected disabled value=\"\">Seleccione</option>\n");
      out.write("                                <option>Sede</option> \n");
      out.write("                                <option>Seccional</option>\n");
      out.write("                            </select>                                                \n");
      out.write("                        </div>            \n");
      out.write("                        <button class=\"btn btn-primary\" type=\"button\" id=\"btnformularioCrearCampus\">Guardar</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>       \n");
      out.write("        \n");
      out.write("    </div>\n");
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
      out.write("    <script src=\"../js/jquery-3.5.0.slim.min.js\"></script>\n");
      out.write("    <script src=\"../js/popper.min.js\"></script>\n");
      out.write("    <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
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

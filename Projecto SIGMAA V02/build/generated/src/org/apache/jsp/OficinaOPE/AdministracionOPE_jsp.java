package org.apache.jsp.OficinaOPE;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdministracionOPE_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    String usuario = (String)objetoSession.getAttribute("UsuarioAutenticado");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    }  

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Módulo de OFE</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        \n");
      out.write("        \n");
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
      out.write("                                <li class=\"nav-item dropdown\">\n");
      out.write("                                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                        Crear\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"../OficinaOPE/CrearUsuarios.jsp\">Tutores</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"../OficinaOPE/CrearEstudiantes.jsp\">Estudiantes</a>                                        \n");
      out.write("                                        <a class=\"dropdown-item\" href=\"../OficinaOPE/CrearTutorias.jsp\">Tutorias</a>                                        \n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item dropdown\">\n");
      out.write("                                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                        Actualizar\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ModificarUsuarios.jsp\">Tutores</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ModificarEstudiantes.jsp\">Estudiantes</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"#\">Tutorias</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"../index.jsp\" tabindex=\"-1\" aria-disabled=\"true\">Salir</a>\n");
      out.write("                                </li>                                \n");
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
      out.write("            <div class=\"card-body\">                \n");
      out.write("                <div class=\"card text-center\">\n");
      out.write("                    <h1>Consulta para Orientadores</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"container\">                    \n");
      out.write("                    <div class=\"row justify-content-md-center\">\n");
      out.write("                      <div class=\"col-lg-3\">\n");
      out.write("                            <a class=\"nav-link\" href=\"ConsultaUsuarios.jsp\">\n");
      out.write("                                <img src=\"../Imagenes/Tutores.png\" class=\"rounded mx-auto d-block\" alt=\"...\" width=\"100px\" height=\"100px\">\n");
      out.write("                            </a>   \n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-lg-3\">\n");
      out.write("                            <a class=\"nav-link\" href=\"ConsultaEstudiantes.jsp\">\n");
      out.write("                                <img src=\"../Imagenes/Estudiantes.png\" class=\"rounded mx-auto d-block\" alt=\"...\" width=\"100px\" height=\"100px\">\n");
      out.write("                            </a>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-lg-3\">\n");
      out.write("                            <a class=\"nav-link\" href=\"ConsultaTutorias.jsp\">\n");
      out.write("                                <img src=\"../Imagenes/Tutorias.png\" class=\"rounded mx-auto d-block\" alt=\"...\" width=\"100px\" height=\"100px\">\n");
      out.write("                            </a>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>           \n");
      out.write("                \n");
      out.write("            </div>\n");
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

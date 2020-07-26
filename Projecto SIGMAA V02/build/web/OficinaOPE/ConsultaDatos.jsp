<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Modelo.GestionesListas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objetoSession = request.getSession(false);
    String usuario = (String)objetoSession.getAttribute("UsuarioAutenticado");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    };
    
    GestionesListas gl = new GestionesListas();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPE - Consulta de Datos</title>
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script>
             
        
    </head>
    
<%--Inicio del encabezado de la página --%>  
    <div class="card-header">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <div class="text-center">
                        <img src="../Imagenes/LogoUno.png" class="img-fluid float-left" alt="Responsive image" width="100% \9">
                    </div>
                </div>
                <div class="col-sm-7">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="AdministracionOPE.jsp">Inicio<span class="sr-only">(current)</span></a>
                                </li> 
                            </ul>                            
                        </div>
                    </nav>
                </div>
                <div class="col-sm-3">
                    <h6>Inicio de sesión como:</h6>
                    <% out.print(usuario); %>
                </div>
            </div>                    
        </div> 
    </div>
<%--Fin del encabezado de la página --%>  

<%-- Cuerpo de la página --%>
            <div class="card-body">
                <div class="card text-center">
                    <h1>Resumen de Datos</h1>
                </div> 
                <div class="container">
                    <div class="table-responsive content-center row d-flex justify-content-center">
                        <table id="tablaTutorias" class="table table-bordered table-striped table-hover" style="width:50%">
                            
                            <thead class="text-center">
                                <tr>
                                    <th>Dato</th>
                                    <th>Cantidad</th>                                                                                
                                </tr>
                            </thead>
                            <tbody >
                                <tr>
                                    <th>Monitores de Académicos</th>
                                    <th class="text-center"><%= gl.cantMonitorAcademico() %></th>    
                                </tr>
                                <tr>
                                    <th>Monitores de aula</th>
                                    <th class="text-center"><%= gl.cantMonitorAula() %></th>
                                </tr>    
                                <tr>
                                    <th>Tutorias registradas</th>
                                    <th class="text-center"><%= gl.cantTutorias() %></th>
                                </tr>    
                                <tr>
                                    <th>Tutorias Resueltas</th>
                                    <th class="text-center"><%= gl.cantTutoriasRealizadas() %></th>
                                </tr>    
                                <tr>
                                    <th>Tutorias pendientes por resolver</th>
                                    <th class="text-center"><%= gl.cantTutoriasPendientes() %></th>
                                </tr>
                                <tr>
                                    <th>Estudiantes Registrados</th>
                                    <th class="text-center"><%= gl.cantEstudiantesRegistrados() %></th>
                                </tr>
                            </tbody>                                
                        </table>
                    </div>                    
                </div>  
                
            </div>             
<%-- Fin del cuerpo de la página --%>  
            
<%-- Píe de la página --%>            
        <div class="card text-center">    
            <div class="card-footer text-muted">
                <h3>Sistema de Información y Gestión de Monitoria Académica Andina - SIGMAA</h3>
            </div>
        </div>
<%-- Fin del píe de la página --%>  

    
    
</html>

<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Modelo.GestionesTutorias"%>
<%@page import="Controlador.MuestraInforme"%>
<%@page import="Controlador.MuestraEstudiantes"%>
<%@page import="Modelo.GestionesListas"%>
<%@page import="Clases.Factor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@page import="Controlador.MuestraFacultades"%>
<%@page import="Controlador.MuestraCampus"%>
<%@page import="Clases.FacultadCampus"%>
<%@page import="Clases.Campus"%>
<%@page import="Modelo.GestionesFacultades"%>
<%@page import="Modelo.GestionesCampus"%>
<%@page import="Modelo.GestionesProgramas"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objetoSession = request.getSession(false);
    String usuario = (String)objetoSession.getAttribute("UsuarioAutenticado");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    }  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPE - Informes</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../css/misestilos.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.0.slim.min.js"></script>
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
        function seleccion(){
            var cod = document.getElementById("casos").value;
            alert(cod);
            window.location.replace("CrearInforme.jsp?id="+cod);
        };   
            
    </script>    
 
    </head>
    <body>

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
                                <li class="nav-item">
                                    <a class="nav-link" href="../index.jsp" tabindex="-1" aria-disabled="true">Salir</a>
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
    <div class="card-body" id="body_administrador">
        <div class="card text-center">
            <h1>Informe por casos</h1>
        </div> 
        <form action="../prueba" method="post" id="formularioTutorias" name="formularioTutorias" novalidate>        
                <%  MuestraInforme mi = new MuestraInforme(); %> 
                <%= mi.informe() %>
            
                <div class="d-flex align-items-end flex-column bd-highlight mb-3">                            
                    <button class="btn btn-primary" type="submit" id="btnformularioCrear" name="btnformularioCrear" value="2">Guardar</button>
                </div>
        </form>     
             
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

    
    </body>
</html>

<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Controlador.MuestraListas"%>
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
    String usuario = (String)objetoSession.getAttribute("UsuarioLogeado");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    }  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuarios</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../css/misestilos.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.0.slim.min.js"></script>
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
    <script>
            window.addEventListener('load', function (){
    
            document.getElementById('btnformularioCrearOPE').addEventListener('click', function (){
            var id = document.getElementById('identificacion').value;  
            var nombre = document.getElementById('nombresApellidos').value;
            var mail = document.getElementById('mail').value;
            var telefono=  document.getElementById('telefono').value;
                        
            var confirmacion = false;
         
            if(id.length > 0 && nombre.length > 0 && mail.length > 0 && telefono.length > 0 ){
             confirmacion = true;
            }
         
            if(confirmacion){
            alert('El usuario fue creado con exito.');
            
            document.getElementById('formularioUsuarios').submit();             
                }else{
                    alert('Por favor diligencie los campos relacionados con el tipo de usuario');
                    }
            }
            );
          }
        );
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
            <h1>Crear Usuarios</h1>
        </div>       
        <div class="container">            
            <form action="../crearusuarios?btnformularioCrear=1" method="post" id="formularioUsuarios" name="formularioUsuarios" novalidate>
                <div class="row text-center">
                    <div class="col-2">
                        <div class="form-group">
                            <label for="validationCustom01">Identificación</label><br>                                                          
                            <input type="text" class="form-control" id="identificacion" name="identificacion" required >
                        </div>
                    </div>
                    <div class="col-5">
                        <div class="form-group">
                            <label for="validationCustom01">Nombres y Apellidos</label>
                            <input type="text" class="form-control" id="nombresApellidos" name="nombresApellidos" required>
                        </div>                                
                    </div>
                    <div class="col-5">
                        <div class="form-group">
                            <label for="validationCustom04">Correo electrónico</label>
                            <input type="email" class="form-control" id="mail" name="mail" required placeholder="email@areandina.edu.co">
                        </div>
                    </div>                        
                </div>
                <div class="row text-center">
                    <div class="col-2">
                        <div class="form-group">
                            <label for="validationCustom04">Número de contacto</label>
                            <input type="tel" size="10" class="form-control" id="telefono" name="telefono" required placeholder="Ej: 3201111111">
                        </div>    
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom04">Tipo de usuario</label>
                            <select class="custom-select" id="tipo" name="tipo" required>
                                <option selected disabled>Seleccione...</option>
                                <%  MuestraListas mf = new MuestraListas(); %>
                                <%= mf.getListaTipoUsuario() %>
                            </select>
                        </div> 
                    </div> 
                    <div class="col-2">
                        <div class="form-group">
                            <label for="validationCustom04">Sede</label>
                            <select class="custom-select" id="idcampus" name="idcampus" >
                                <option selected disabled value="">Seleccione la sede o campus</option>
                                <% MuestraCampus mc = new MuestraCampus(); %>
                                <%= mc.getNombreCampus() %>
                            </select>                                                
                        </div>
                    </div>                        
                </div>            
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

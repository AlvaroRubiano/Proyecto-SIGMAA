<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Controlador.MuestraCampus"%>
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
        <title>Crear Facultad</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../css/misestilos.css" type="text/css">
        <script>
            window.addEventListener('load', function (){
    
            document.getElementById('btnformularioCrear').addEventListener('click', function (){
            var nombrefacultad =  document.getElementById('nombreCrearFacultad').value;
            var idcampus = document.getElementById('idcampus').value;
                        
            var confirmacion = false;
         
            if(nombrefacultad.length > 0 && idcampus.length > 0 ){
             confirmacion = true;
            }
         
            if(confirmacion){
            alert('La facultad fué creada con exito.');
            document.getElementById('formularioCrear').submit();             
                }else{
                            alert('Por favor diligencie todos los campos');
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
                                    <a class="nav-link" href="ModuloAdministracion.jsp">Inicio<span class="sr-only">(current)</span></a>
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
            <h1>Crear Facultades</h1>
        </div>       
        
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-sm-4">
                    <form action="../GenerarFacultad" method="post" id="formularioCrear" class="needs-validation" novalidate>
                      
                        <div class="form-group">
                            <label for="validationCustom01">Nombre de la Facultad</label>
                            <input type="text" class="form-control" id="nombreCrearFacultad" name="nombreFacultad" required>
                        </div>
                        
                        <div class="form-group">
                            <select class="custom-select" id="idcampus" name="tipo" required>
                                <option selected disabled value="">Identifique la sede a la que pertenece</option>
                                <% MuestraCampus mc = new MuestraCampus(); %>
                                <%= mc.getNombreCampus() %>
                            </select>                                                
                        </div>      
                            
                        <button class="btn btn-primary" type="button" id="btnformularioCrear">Guardar</button>
                    </form>
                </div>
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

    <script src="../js/jquery-3.5.0.slim.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    </body>
</html>

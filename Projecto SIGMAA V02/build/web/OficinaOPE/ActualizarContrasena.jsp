<%-- 
    Document   : Actualizar Contraseña
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Controlador.MuestraInforme"%>
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
        <title>Monitor - Actualizar Contraseña</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script> 
        <script>
            window.addEventListener('load', function (){    
            document.getElementById('actualizar').addEventListener('click', function (){
            var id =  document.getElementById('id').value;
            var uno = document.getElementById('password').value;                        
            var dos = document.getElementById('nuevoPassword').value;                        
            var tres = document.getElementById('confirmarPassword').value;                        
            var confirmacion = false;            
            if(dos===tres){
                if(id.length > 0 && uno.length > 0 && dos.length > 0 && tres.length > 0 && dos===tres ){
                    confirmacion = true;
                } 
                if(confirmacion){
                    alert('Contraseña actualizada con exito.');
                    document.getElementById('formularioActualizar').submit();             
                }else{alert('Por favor diligencie todos los campos');}
            }else{
                alert('Verifica la nueva contraseña');
            }            
            });
            });
    
            window.addEventListener('load', function () {
                document.getElementById("email").reset();
                document.getElementById("password").reset();
                document.getElementById("nuevoPassword").reset();
                document.getElementById("confirmarPassword").reset();
                
            });
        </script>
        
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
                                    <a class="nav-link" href="Tutores.jsp">Inicio<span class="sr-only">(current)</span></a>
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
<form action="../actualizarcontrasena?actualizar=administrativo" method="POST" name="formularioActualizar" id="formularioActualizar"> 
    <div class="card-body">
        <div class="card text-center">
            <h1>Actualizar Contraseña</h1>            
        </div>                
        <div class="container">                    
             <div class="row justify-content-md-center">
                <div class="col-sm-4">                    
                    <div class="form-group">
                        <input placeholder="Identificación" type="text" class="form-control" aria-describedby="emailHelp" id="id" name="id">
                    </div>
                    <div class="form-group">
                        <input placeholder="Contraseña actual" type="password" class="form-control" id="password" name="password">
                    </div>
                    <div class="form-group">
                        <input placeholder="Nueva Contraseña" type="password" class="form-control" id="nuevoPassword" name="nuevoPassword">
                    </div>
                    <div class="form-group">
                        <input placeholder="Confirmar Contraseña" type="password" class="form-control" id="confirmarPassword" name="confirmarPassword">
                    </div>
                    <button type="submit" id="actualizar" name="actualizar" class="btn btn-primary" onclick="limpiarFormulario()">Actualizar</button>
                </div>
            </div>
        </div>  
    </div>  
</form>                         
<%-- Fin del cuerpo de la página --%>  
            
<%-- Píe de la página --%>            
        <div class="card-footer text-center">    
            <div class="card-footer text-muted">
                <h3>Sistema de Información y Gestión de Monitoria Académica Andina - SIGMAA</h3>
            </div>
        </div>
<%-- Fin del píe de la página --%>  

    
    
</html>

<%-- 
    Document   : index
    Created on : 24/04/2020, 11:17:02 AM
    Author     : Alvaro Rubiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="css/misestilos.css" type="text/css">
        
        <script>
            function limpiarFormulario() {
                document.getElementById("email").reset();
                document.getElementById("password").reset();
            }
        </script>
    </head>
    <body>
<%--Inicio del encabezado de la página --%>  
    <div class="card-header">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <div class="text-center">
                        <img src="Imagenes/LogoUno.png" class="img-fluid float-left" alt="Responsive image" width="100% /9%">
                    </div>
                </div>
                <div class="col-sm-7 text-center">
                    <h1>Ingreso de Usuarios del Sistema</h1>
                </div>
            </div>  
        </div>
    </div>
<%--Fin del encabezado de la página --%> 
<%--Inicio cuerpo de la página --%>
    <div class="card-body" id="inicioGeneral">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-sm-4">
                    <form action="ingresousuarios" method="post">
                        <div class="form-group">
                            <input placeholder="Email" type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
                        </div>
                        <div class="form-group">
                            <input placeholder="Contraseña" type="password" class="form-control" id="password" name="password">
                        </div>
                        <button type="submit" class="btn btn-primary" onclick="limpiarFormulario()">Ingresar</button>
                    </form> 
                </div>
            </div>           
        </div>
    </div>
<%-- Fin del cuerpo de la página --%>

<%-- Inicio píe de la página --%>          
        <div class="card text-center">
            <div class="card-footer text-muted">
                <h3>Sistema de Información y Gestión de Monitoria Académica Andina - SIGMAA</h3>
            </div>
        </div>
<%-- Fin del píe de la página --%>         
    <script src="js/jquery-3.5.0.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>    
    </body>
</html>

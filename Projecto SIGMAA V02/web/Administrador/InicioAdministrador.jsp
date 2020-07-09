<%-- 
    Document   : InicioAdministrador
    Created on : 10/04/2020, 05:30:53 PM
    Author     : Alvaro Rubiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de administrador</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../css/misestilos.css" type="text/css">
    </head>
    <body>
<%--Inicio del encabezado de la página --%>          
    <div class="card-header" id="encabezado">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <div class="text-center">
                        <img src="../Imagenes/LogoUno.png" class="img-fluid float-left" alt="Responsive image" width="150% \9">
                    </div>
                </div>
                <div class="col-sm-10">
                    <h1>Módulo de autenticación en el sistema</h1>
                </div>
            </div>                    
        </div> 
    </div>
<%--Fin del encabezado de la página --%>  

<%--Inicio cuerpo de la página --%>
    <div class="card-body" id="administrador">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-sm-4">
                    <form action="../Administrador" method="post">
                        <div class="form-group">
                            <input placeholder="Usuario" type="email" class="form-control" id="Email" aria-describedby="emailHelp" name="Email">
                        </div>
                        <div class="form-group">
                            <input placeholder="Contraseña" type="password" class="form-control" id="InputPassword" name="InputPassword">
                        </div>
                        <button type="submit" class="btn btn-primary">Ingresar</button>
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
        
    <script src="../js/jquery-3.5.0.slim.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    </body>
</html>

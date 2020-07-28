<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


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
        <title>OPE - Actualizar las Tutorias</title>
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script>
        
        
        <script>            
            $(document).ready(function() {
                var tabla = $('#tablaTutorias').DataTable({
                        ajax:{
                            method: 'POST',
                            url: '../consultaevidencias',
                            dataSrc: 'datos'
                            },
                            columns: [
                                {data: "caso"},
                                {data: "estudiante"},
                                {data: "factor"},
                                {data: "tutor"},
                                {data: "observacionesOO"},
                                {data: "observacionesM"},
                                {data: "tipo"},
                                {data: "evidencia"}                                
                            ]                            
                });              
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
                    <h1>Revisión de Monitorias</h1>
                </div> 
                <div class="container">
                    <div class="table-responsive">
                        <table id="tablaTutorias" class="table table-bordered table-striped table-hover" style="width:100%">
                            <thead class="text-center">
                                <tr>
                                    <th>Caso</th>
                                    <th>Estudiante</th>
                                    <th>Factor</th>
                                    <th>Tutor</th>
                                    <th>Obs. Oficina Orientación</th>
                                    <th>Obs. Monitor</th>
                                    <th>Tipo de evidencia</th>
                                    <th>Evidencia</th>
                                </tr>
                            </thead>
                            <tbody id="employee_data" class="text-center">
                            </tbody>                                
                        </table>
                    </div>                    
                </div>  
                <div class="card text-center">
                <h1>Área de modificaciones</h1>
                </div>
                <div class="container">
                <form action="../cerrarcasos" method="post" id="formularioModificarEstudiantes" class="needs-validation" novalidate>
                    <div class="row text-center">
                        <div class="col-2">
                            <div class="form-group text-center">
                            <label for="validationCustom01">Caso de desea cerrar</label><br>                                                          
                            <input type="text" class="form-control" id="caso" name="caso" required >
                            </div>
                        </div> 
                        <div class="col-2">
                            <div class="form-group text-center">
                            <label for="validationCustom04">Acción</label><br>                            
                            <button type="submit" name="btnCerrarOPE" id="btnCerrarOPE" class="btn btn-outline-primary" data-toggle="tooltip" title="Cerrar caso"><i class="fa fa-check" aria-hidden="true"></i></button>
                            </div> 
                        </div>
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

    
    
</html>

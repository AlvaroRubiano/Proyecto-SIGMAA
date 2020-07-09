<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        <title>Consulta de Campus o sedes</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
=======
=======
>>>>>>> Stashed changes
        <title>Consulta de Campus</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script>
        
        
        <script>
            
            $(document).ready(function() {
                var tabla = $('#tablaSedes').DataTable({
                        ajax:{
                            method: 'POST',
                            url: '../consultaSede',
                            dataSrc: 'datos'
                            },
                            columns: [
                                {data: "identificador"},
                                {data: "nombre"},
                                {data: "tipo"}, 
                                {data: "direccion"} 
                            ]                        
                });
              
                //$.fn.dataTable.ext.errMode = 'throw';
               
            });
        
        </script>      
>>>>>>> Stashed changes
        
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
                <div class="container">
<<<<<<< Updated upstream
                    <div class="row">
                        <div class="col-sm">Nombre del Campus</div>
                        <div class="col-sm">Tipo de campus</div>
                        <div class="col-sm">Dirección</div>
                    </div>
                </div> 
            </div> 
                <%
                    Controlador.MuestraCampus cc = new MuestraCampus();
                %>
                <%= cc.getVistaCampus()%>                
            
=======
                    <div class="table-responsive">
                        <table id="tablaSedes" class="table table-bordered table-striped table-hover" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Identificador</th>
                                    <th>Sede</th>
                                    <th>Tipo</th>
                                    <th>Dirección</th>
                                                                        
                                </tr>
                            </thead>
                            <tbody id="employee_data">



                            </tbody>
                                
                        </table>
                    </div>                    
                </div>  
                
            </div>             
>>>>>>> Stashed changes
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

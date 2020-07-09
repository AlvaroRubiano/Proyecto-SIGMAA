<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


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
        <title>Modificar Campus</title>
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
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
            
            $(document).on('click', '.eliminar', function(){
                var idCampus = $(this).attr('id');
                var row = $(this).parent().parent();
                var texto;
                var respuesta =  confirm("¿Estas seguro de eliminar el registro?");
                if (respuesta === true){
                    $.ajax({
                        url: '../eliminarCampus',
                        method: 'POST',
                        data: {"action":"eliminar", "idCampus":"idCampus"},
                        
                        success: function (data) {
                            row.remove();   
                        },
                        error: function(error){
                            alert('Error en Ajax');
                        }
                       
                    });
                }else{
                    
                }              
                
                
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
                <div class="card text-center">
                    <h1>Sedes disponibles</h1>
                </div>                
                <div class="container">
                    <div class="table-responsive">
                        <table id="tablaSedes" class="table table-bordered table-striped table-hover text-center" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Identificador</th>
                                    <th>Sede</th>
                                    <th>Tipo</th>
                                    <th>Dirección</th>                                                      
                                </tr>
                            </thead>
                            <tbody id="employee_data" class="text-center">
                            </tbody>                                
                        </table>
                    </div>                    
                </div>
                <br>        
            <div class="card text-center">
                    <h1>Área de modificaciones</h1>
            </div>        
            <div class="container">
                <form action="../modificarCampus" method="post" id="formularioModificarCampus" class="needs-validation" novalidate>
                <div class="row justify-content-md-center">                    
                    <div class="col-sm-1">
                        <div class="form-group">
                            <div class="form-group text-center">
                                <label for="validationCustom01">Id</label>
                                <input type="text" class="form-control" id="identificadorCampus" name="identificadorCampus" required>
                            </div>                                                                       
                        </div> 
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">                       
                            <div class="form-group text-center">
                                <label for="validationCustom01">Nombre del campus</label>
                                <input type="text" class="form-control" id="nombreCampus" name="nombreCampus" required>
                            </div>                                                                        
                        </div> 
                    </div>
                    <div class="col-sm-2">
                        <div class="form-group text-center">                                                
                            <label for="validationCustom04">Tipo</label>
                            <select class="custom-select" id="tipoCampus" name="tipoCampus" required>
                                <option selected disabled value="">Seleccione</option>
                                <option>Sede</option> 
                                <option>Seccional</option>
                            </select>                                                
                        </div> 
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">                        
                            <div class="form-group text-center">
                                <label for="validationCustom01">Direccion del Campus</label>
                                <input type="text" class="form-control" id="direccionCampus" name="direccionCampus" required>
                            </div>                                         
                        </div> 
                    </div>                    
                    <div class="col-sm-2">
                        <div class="form-group text-center">
                            <label for="validationCustom04">Acción</label><br>
                            <button value="1" type="submit" name="btnModificarCampus" id="btnModificarCampus" class="btn btn-outline-primary" data-toggle="tooltip" title="Actualizar el registro"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            <button value="2" type="submit" name="btnEliminarCampus" id="btnEliminarCampus" class="btn btn-outline-primary" data-toggle="tooltip" title="Eliminar el registro"><i class="fa fa-trash" aria-hidden="true"></i></button>
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

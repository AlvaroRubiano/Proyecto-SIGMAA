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
        <title>Modificar Programas</title>
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script>
        
        
        <script>            
            $(document).ready(function() {
                var tabla = $('#tablaFacultades').DataTable({
                        ajax:{
                            method: 'POST',
                            url: '../consultarProgramas',
                            dataSrc: 'datos'
                            },
                        columns: [
                            {data: "identificador"},
                            {data: "nombre"},
                            {data: "modalidad"},
                            {data: "campus"},
                            {data: "facultad"}                                 
                        ]                        
                }); 
            });
        
        </script>
    <script type="text/javascript">
        
        $(document).ready(function(){
            $('select[name=idcampus]').on('change', function(){
                $.ajax({
                    type: 'GET',
                    url: '../seleccionaruncampus',
                    data: 'codigocampus='+$('select[name=idcampus]').val(),
                    statusCod:{
                        404: function(){
                            alert('Pagina no enocntrada');
                        },
                        500: function(){
                            alert('Error de servidor');
                        }
                    },
                    success: function(datos){
                        $('select[name=idfacultad] option').remove();
                        var pegados = datos.split(":");
                        
                        if(datos = ''){
                           $('select[name=idfacultad]').append('<option>La sede no tiene facultades</option>');
                        }else{
                            for(var i = 0; i < pegados.length-1; i++){
                                var codigosFacultades = pegados[i].split("-")[0];
                                var nombresFacultades = pegados[i].split("-")[1];
                                $('select[name=idfacultad]').append("<option value="+codigosFacultades+">"+nombresFacultades+"</option>");
                            } 
                        }
                        
                    }
                });
                
            })
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
                    <h1>Programas</h1>
                </div> 
                <div class="container">
                    <div class="table-responsive">
                        <table id="tablaFacultades" class="table table-bordered table-striped table-hover" style="width:100%">
                            <thead class="text-center">
                                <tr>
                                    <th>Identificador</th>
                                    <th>Programa</th>
                                    <th>Modalidad</th>                                                                        
                                    <th>Campus</th>                                                                        
                                    <th>Facultad</th>                                                                        
                                </tr>
                            </thead>
                            <tbody id="employee_data">
                            </tbody>                                
                        </table>
                    </div>                    
                </div>  
                
            </div> 
        <br>        
        <div class="card text-center">
            <h1>Área de modificaciones</h1>
        </div>
        <div class="container">
            <form action="../modificarProgramas" method="post" id="formularioModificarPrograma" class="needs-validation" novalidate>
                <div class="row justify-content-md-center">                    
                    <div class="col-sm-1">
                        <div class="form-group">
                            <div class="form-group text-center">
                                <label for="validationCustom01">Id</label>
                                <input type="text" class="form-control" id="identificadorPrograma" name="identificadorPrograma" required>
                            </div>                                                                       
                        </div> 
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">                       
                            <div class="form-group text-center">
                                <label for="validationCustom01">Programa</label>
                                <input type="text" class="form-control" id="nombrePrograma" name="nombrePrograma" required>
                            </div>                                                                        
                        </div> 
                    </div>
                    <div class="col-sm-2">
                        <div class="form-group text-center">                                                
                            <label for="validationCustom04">Modalidad</label>
                            <select class="custom-select" id="modalidad" name="modalidad" required>
                                <option selected disabled value="">Seleccione</option>
                                <option value="Presencial">Presencial</option>
                                <option value="Virtual">Virtual</option>
                                <option value="Distancia">Distancia</option>                                
                            </select>                                                
                        </div> 
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group text-center">
                            <label for="validationCustom04">Campus</label>
                            <select class="custom-select" id="idcampus" name="idcampus" >
                                <option selected disabled value="">Seleccione...</option>
                                <% MuestraCampus mc = new MuestraCampus(); %>
                                <%= mc.getNombreCampus() %>
                            </select>
                        </div>     
                    </div>    
                    <div class="col-sm-3">
                        <div class="form-group text-center">
                            <label for="validationCustom04">Facultad</label>
                            <select class="custom-select" id="idfacultad" name="idfacultad" >
                                <option selected disabled value="">Seleccione la facultad</option>  
                            </select>  
                        </div>     
                    </div>
                    <div class="col-sm-2">
                        <div class="form-group text-center">
                            <label for="validationCustom04">Acción</label><br>
                            <button value="1" type="submit" name="btnModificarPrograma" id="btnModificarPrograma" class="btn btn-outline-primary" data-toggle="tooltip" title="Actualizar el registro"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            <button value="2" type="submit" name="btnEliminarPrograma" id="btnEliminarPrograma" class="btn btn-outline-primary" data-toggle="tooltip" title="Eliminar el registro"><i class="fa fa-trash" aria-hidden="true"></i></button>
                        </div> 
                    </div>                   
                </div>
            </form>
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

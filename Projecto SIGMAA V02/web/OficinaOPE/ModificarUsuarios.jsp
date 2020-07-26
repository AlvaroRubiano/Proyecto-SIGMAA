<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Controlador.MuestraListas"%>
<%@page import="Controlador.MuestraCampus"%>
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
        <title>Modificar Usuarios</title>
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script>
        
        <script>
            
            $(document).ready(function() {
                var tabla = $('#tablaUsuarios').DataTable({
                        ajax:{
                            method: 'POST',
                            url: '../consultarusuarios',
                            dataSrc: 'datos'
                            },
                            columns: [
                                {data: "codigo"},
                                {data: "nombre"},
                                {data: "correo"},
                                {data: "telefono"},
                                {data: "tipo"},
                                {data: "campus"},
                                {data: "facultad"},
                                {data: "programa"},
                                {data: "semestre"},
                                {data: "modalidad"}                                
                            ]
                });              
            });
        
        </script>    
    
        <script type="text/javascript">
        
        $(document).ready(function(){
            $('select[name=idcampus]').on('change', function(){
                $.ajax({
                    type: 'GET',
                    url: '../seleccionarunafacultad',
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
                        
                        if(datos == ""){
                           $('select[name=idfacultad]').append('<option>La sede no tiene facultades</option>');
                        }else{
                            var vacio ="Seleccione";
                            for(var i = 0; i < pegados.length-1; i++){
                                var codigo = pegados[i].split("-")[0];
                                var nombre = pegados[i].split("-")[1];
                                if(i>0){
                                $('select[name=idfacultad]').append("<option value="+codigo+">"+nombre+"</option>");
                                }else{
                                $('select[name=idfacultad]').append("<option selected>"+vacio+"</option><option value="+codigo+">"+nombre+"</option>");    
                                }
                            } 
                        }
                        
                    }
                });
                
            })
        });
               
    </script>
        <script type="text/javascript">
        
        $(document).ready(function(){
            $('select[name=idfacultad]').on('change', function(){
                $.ajax({
                    type: 'GET',
                    url: '../seleccionarunprograma',
                    data: 'codigofacultad='+$('select[name=idfacultad]').val(),
                    statusCod:{
                        404: function(){
                            alert('Pagina no enocntrada');
                        },
                        500: function(){
                            alert('Error de servidor');
                        }
                    },
                    success: function(datos){
                        $('select[name=idprograma] option').remove();
                        var pegados = datos.split(":");
                        
                        if(datos == ""){
                           $('select[name=idprograma]').append('<option>La sede no tiene facultades</option>');
                        }else{
                            var vacio = "Seleccione";
                            for(var i = 0; i < pegados.length-1; i++){
                                var codigo = pegados[i].split("-")[0];
                                var nombre = pegados[i].split("-")[1];
                                var modalidad = pegados[i].split("-")[2];
                                if(i>0){
                                $('select[name=idprograma]').append("<option value="+codigo+">"+nombre+" - "+modalidad+"</option>");    
                                }else{
                                $('select[name=idprograma]').append("<option selected>"+vacio+"</option><option value="+codigo+">"+nombre+" - "+modalidad+"</option>");    
                                }                                
                            } 
                        }                        
                    }
                });                
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
                    <h1>Usuarios</h1>
                </div> 
                <div class="container">
                    <div class="table-responsive">
                        <table id="tablaUsuarios" class="table table-bordered table-striped table-hover" style="width:100%">
                            <thead class="text-center">
                                <tr>
                                    <th>Identificación</th>
                                    <th>Nombres</th>
                                    <th>Correo</th>
                                    <th>Teléfono</th>
                                    <th>Tipo</th>
                                    <th>Campus</th>
                                    <th>Facultad</th>
                                    <th>Programa</th>
                                    <th>Semestre</th>
                                    <th>Modalidad</th>                                    
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
                <form action="../modificarmonitores" method="post" id="formularioModificarUsuarios" class="needs-validation" novalidate>
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
                            <input type="email" class="form-control" id="mail" name="mail" required placeholder="email@estudiantes.areandina.edu.co">
                        </div>
                    </div>                        
                </div>               
                    <div class="row text-center">
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom04">Número de contacto</label>
                            <input type="tel" size="10" class="form-control" id="telefono" name="telefono" required placeholder="Ej: 3201111111">
                        </div>    
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom04">Tipo</label>
                            <select class="custom-select" id="tipo" name="tipo" required>
                                <option selected disabled>Seleccione...</option>
                                <%  MuestraListas mf = new MuestraListas(); %>
                                <%= mf.getListaTipoMonitor() %>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom04">Modalidad</label>
                            <select class="custom-select" id="nombreModalidad" name="nombreModalidad" required>
                                <option selected disabled>Seleccione...</option>
                                <option value="Presencial">Presencial</option>
                                <option value="Virtual">Virtual</option>
                                <option value="Distancia">Distancia</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom04">Semestre</label>
                            <select class="custom-select" id="semestre" name="semestre" required>
                                <option selected disabled>Seleccione...</option>                                
                                <%= mf.getListaSemestres() %>
                            </select>
                        </div>
                    </div>
                </div> 
                    <div class="row justify-content-md-center">                     
                        <div class="col-4">
                            <div class="form-group">
                                <select class="custom-select" id="idcampus" name="idcampus" >
                                    <option selected disabled value="">Seleccione la sede o campus</option>
                                    <% MuestraCampus mc = new MuestraCampus();%>
                                    <%= mc.getNombreCampus()%>
                                </select>                                                
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <select class="custom-select" id="idfacultad" name="idfacultad" >
                                    <option selected disabled value="">Seleccione la facultad</option>  
                                </select>                                                
                            </div>
                        </div> 
                        <div class="col-4">
                            <div class="form-group">
                                <select class="custom-select" id="idprograma" name="idprograma" >
                                    <option selected disabled value="">Seleccione el programa</option>  
                                </select>                                                
                            </div>
                        </div>                      
                        <div class="col-sm-2">
                            <div class="form-group text-center">
                                <label for="validationCustom04">Acción</label><br>
                                <button value="1" type="submit" name="btnModificarUsuario" id="btnModificarUsuario" class="btn btn-outline-primary" data-toggle="tooltip" title="Actualizar el registro"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                                <button value="2" type="submit" name="btnEliminarUsuario" id="btnEliminarUsuario" class="btn btn-outline-primary" data-toggle="tooltip" title="Eliminar el registro"><i class="fa fa-trash" aria-hidden="true"></i></button>
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

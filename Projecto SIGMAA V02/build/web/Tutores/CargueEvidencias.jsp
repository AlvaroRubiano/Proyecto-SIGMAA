<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Controlador.MuestraInforme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objetoSession = request.getSession(false);
    String usuario = (String)objetoSession.getAttribute("Usuario");
    if(usuario.equals(" ")){
        response.sendRedirect("index.jsp");
    }  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monitor - Cargue de evidencias</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="../js/datatables.min.js"></script>
        
    <script type="text/javascript">
        
        $(document).ready(function(){
            $('select[name=caso]').on('change', function(){
                $.ajax({
                    type: 'GET',
                    url: '../seleccionaunamateria',
                    data: 'codigocaso='+$('select[name=caso]').val(),
                    statusCod:{
                        404: function(){
                            alert('Pagina no enocntrada');
                        },
                        500: function(){
                            alert('Error de servidor');
                        }
                    },
                    success: function(datos){
                        $('select[name=asignatura] option').remove();
                        var pegados = datos.split(":");
                        
                        if(datos == ''){
                           $('select[name=asignatura]').append('<option>No hay materias registradas</option>');
                        }else{
                            var vacio = "Seleccione";
                            for(var i = 0; i < pegados.length-1; i++){
                                var codigo = pegados[i].split("-")[0];
                                var nombre = pegados[i].split("-")[1];
                                if(i>0){
                                $('select[name=asignatura]').append("<option value="+codigo+">"+nombre+"</option>");    
                                }else{
                                $('select[name=asignatura]').append("<option selected>"+vacio+"</option><option value="+codigo+">"+nombre+"</option>");    
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
<form action="../modificartutorias?accion=actualizar" method="POST" enctype="multipart/form-data" > 
    <div class="card-body">
        <div class="card text-center">
            <h1>Cargue de evidencias</h1>            
        </div>                
        <div class="container">                    
                        <div class="form-group row">
                            <div class="col-4">                            
                                <label for="validationCustom01">Caso</label><br>
                                    <select class="custom-select" id="caso" name="caso">
                                        <option disabled selected>Seleccione...</option>
                                            <% MuestraInforme mi = new MuestraInforme(); %>
                                            <%= mi.getListaCasos() %>
                                    </select> 
                            </div>
                            <div class="col-2">
                                <div class="form-group">
                                    <label for="validationCustom01">Fecha de la tutoria</label><br>
                                    <input type="date" class="form-control" id="fecha" name="fecha" required > 
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-group">
                                    <label for="validationCustom01">Asignatura</label><br>
                                    <select class="custom-select" id="asignatura" name="asignatura">
                                        <option disabled selected>Seleccione...</option>                                        
                                    </select>                                    
                                </div> 
                            </div>         
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <div class="form-group">
                                    <label for="validationCustom01">Observaciones</label><br>                                                          
                                    <textarea class="form-control" id="observaciones" name="observaciones" required></textarea>
                                </div>
                            </div>
                        </div>            
                        <div class="justify-content-around">
                            <h6>Siga las siguientes recomendaciones</h6>
                        <p>En caso de decir que, si algunas de estas opciones lo que tiene que hacer es anexar en este 
                            documento la evidencia, en los casos de correo electrónicos, atención por whappsat es preferible 
                            que anexe las capturas de pantallas, si es atentado en una sesión en línea anexe el enlace en donde 
                            quede grabada la sesión en línea.</p>    
                        </div>            
                        <div class="form-group row">                            
                            <div class="col-4">                            
                                <select class="custom-select" id="tipo" name="tipo">
                                    <option disabled selected>Seleccione...</option>
                                    <option value="foto">Fotografia</option>    
                                    <option value="captura">Captura de pantalla</option>    
                                    <option value="whatsapp">Whatsapp</option>    
                                    <option value="correo">Correo electrónico</option>
                                    <option value="sesion">Sesión en linea</option>
                                </select>
                            </div>            
                            <div class="col-4">                            
                                <input type="file" name="rutaArchivo" id="rutaArchivo">
                            </div> 
                        </div>
                                    
        <div class="d-flex align-items-end flex-column bd-highlight mb-3">                            
            <button class="btn btn-primary" type="submit" id="accion" name="accion" >Guardar</button>
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

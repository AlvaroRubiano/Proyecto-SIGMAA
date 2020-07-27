<%-- 
    Document   : Administracion
    Created on : 10/04/2020, 05:47:27 PM
    Author     : Alvaro Rubiano
--%>


<%@page import="Controlador.MuestraListas"%>
<%@page import="Controlador.MuestraEstudiantes"%>
<%@page import="Modelo.GestionesListas"%>
<%@page import="Clases.Factor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@page import="Controlador.MuestraFacultades"%>
<%@page import="Controlador.MuestraCampus"%>
<%@page import="Clases.FacultadCampus"%>
<%@page import="Clases.Campus"%>
<%@page import="Modelo.GestionesFacultades"%>
<%@page import="Modelo.GestionesCampus"%>
<%@page import="Modelo.GestionesProgramas"%>


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
        <title>OPE - Crear Tutorias</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../css/misestilos.css" type="text/css">
        <script type="text/javascript" src="../js/jquery-3.5.0.slim.min.js"></script>
        <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    
    <script type="text/javascript">        
        $(document).ready(function(){
            $('select[name=tipomonitor]').on('change', function(){
                $.ajax({
                    type: 'GET',
                    url: '../seleccionarmonitor',
                    data: 'codigomonitor='+$('select[name=tipomonitor]').val(),
                    statusCod:{
                        404: function(){
                            alert('Pagina no enocntrada');
                        },
                        500: function(){
                            alert('Error de servidor');
                        }
                    },
                    success: function(datos){
                        $('select[name=monitor] option').remove();
                        var pegados = datos.split(":");
                        
                        if(datos === ""){
                                $('select[name=monitor]').append('<option>No hay registros en esta categoria</option>');
                        }else{
                            var vacio = "Seleccione";
                            for(var i = 0; i < pegados.length-1; i++){
                                var codigoTutor = pegados[i].split("-")[0];
                                var nombreTutor = pegados[i].split("-")[1];
                                if(i>0){
                                $('select[name=monitor]').append("<option value="+codigoTutor+">"+nombreTutor+"</option>");    
                                }else{
                                $('select[name=monitor]').append("<option Selected>"+vacio+"</option><option value="+codigoTutor+">"+nombreTutor+"</option>");    
                                }
                                
                            } 
                        }                        
                    }
                });                
            });
        });               
    </script>
    <script type="text/javascript">        
        $(document).ready(function(){
            $('select[name=estudiante]').on('change', function(){
                $.ajax({
                    type: 'GET',
                    url: '../seleccionarprograma',
                    data: 'codigoestudiante='+$('select[name=estudiante]').val(),
                    statusCod:{
                        404: function(){
                            alert('Pagina no enocntrada');
                        },
                        500: function(){
                            alert('Error de servidor');
                        }
                    },
                    success: function(datos){
                        $('select[name=programa] option').remove();
                        var pegados = datos.split(":");
                        
                        if(datos === ""){
                                $('select[name=programa]').append('<option>El estudiante no esta asociado a un programa</option>');
                        }else{
                            var vacio = "Seleccione";
                            for(var i = 0; i < pegados.length-1; i++){
                                var codigo = pegados[i].split("-")[0];
                                var nombre = pegados[i].split("-")[1];
                                if(i>0){
                                $('select[name=programa]').append("<option value="+codigo+">"+nombre+"</option>");    
                                }else{
                                $('select[name=programa]').append("<option selected>"+vacio+"</option><option value="+codigo+">"+nombre+"</option>");    
                                }                                
                            } 
                        }                        
                    }
                });                
            });
        });               
    </script> 
    <script>
            window.addEventListener('load', function (){
    
            document.getElementById('btnformularioCrear').addEventListener('click', function (){
            var fecha = document.getElementById('fecha').value;  
            var identificador = document.getElementById('identificacionEstudiante').value;
            var semestre = document.getElementById('semestre').value;
            var factor =  document.getElementById('factor').value;
            var tipoMonitor =  document.getElementById('tipomonitor').value;
            var monitor =  document.getElementById('monitor').value;
                        
            var confirmacion = false;
         
            if(fecha.length > 0 && identificador.length > 0 && semestre.length > 0 && factor.length > 0 && tipoMonitor.length >0 && monitor.length > 0 ){
             confirmacion = true;
            }
         
            if(confirmacion){
            alert('La tutoria fue creada con exito.');            
            document.getElementById('formularioTutorias').submit(); 
            
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
                                    <a class="nav-link" href="AdministracionOPE.jsp">Inicio<span class="sr-only">(current)</span></a>
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
            <h1>Crear Tutorias</h1>
        </div>       
        <div class="container">            
            <form action="../creartutorias" method="post" id="formularioTutorias" name="formularioTutorias" novalidate>
                <div class="row text-center">
                    <div class="col-2">
                        <div class="form-group">
                            <label for="validationCustom01">Fecha</label><br>                                                          
                            <input type="date" class="form-control" id="fecha" name="fecha" required >
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="form-group">
                            <label for="validationCustom01">Estudiante</label><br>                                                          
                            <select class="custom-select" id="estudiante" name="estudiante" >
                                <option disabled selected>Seleccione...</option>
                                <%  MuestraEstudiantes me = new MuestraEstudiantes(); %> 
                                <%= me.getListaEstudiantes() %>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom01">Programa</label><br>                                                          
                            <select class="custom-select" id="programa" name="programa" >
                                <option disabled selected>Seleccione...</option>
                                <%  MuestraListas mf = new MuestraListas(); %>
                                <%= mf.getListaProgramas() %>
                            </select> 
                        </div>
                    </div>        
                    <div class="col-2">
                        <div class="form-group">
                            <label for="validationCustom01">Semestre</label><br>                                                          
                            <select class="custom-select" id="semestre" name="semestre" >
                                <option disabled selected>Seleccione...</option>                                
                                <%= mf.getListaSemestres() %>
                            </select> 
                        </div>
                    </div> 
                </div>                
                <div class="row">
                    <div class="col-2">
                        <div class="form-group">
                            <label for="validationCustom01">Factor</label><br>
                            <select class="custom-select" id="factor" name="factor" >
                                <option disabled selected>Seleccione...</option>                                
                                <%= mf.getListaFactores() %>
                            </select> 
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="validationCustom01">Tipo de monitor</label><br>
                            <select class="custom-select" id="tipomonitor" name="tipomonitor" >
                                <option disabled selected>Seleccione...</option>                                
                                <%= mf.getListaTipoMonitor() %>
                            </select> 
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="validationCustom01">Tutor</label><br>                                                          
                            <select class="custom-select" id="monitor" name="monitor">
                                <option disabled selected>Seleccione...</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-11">
                        <div class="form-group">
                            <label for="validationCustom01">Observaciones</label><br>                                                          
                            <textarea class="form-control" id="observaciones" name="observaciones" required></textarea>
                        </div>
                    </div>
                    </div>
                </div> 
                <div class="d-flex align-items-end flex-column bd-highlight mb-3">                            
                    <button class="btn btn-primary" type="submit" id="btnformularioCrear" name="btnformularioCrear" value="2">Guardar</button>
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

    
    </body>
</html>

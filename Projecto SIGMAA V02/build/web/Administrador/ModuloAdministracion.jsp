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
        <title>Módulo de Administración</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../css/misestilos.css" type="text/css">
        
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
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Crear
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="CrearCampus.jsp">Campus</a>
                                        <a class="dropdown-item" href="CrearFacultad.jsp">Facultad</a>
                                        <a class="dropdown-item" href="CrearProgramas.jsp">Programa</a>
                                        <a class="dropdown-item" href="#">Clases</a>
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Modificar
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
<<<<<<< Updated upstream
                                        <a class="dropdown-item" href="#">Campus</a>
                                        <a class="dropdown-item" href="#">Facultad</a>
                                        <a class="dropdown-item" href="#">Programa</a>
                                        <a class="dropdown-item" href="#">Clases</a>
=======
                                        <a class="dropdown-item" href="ModificarCampus.jsp">Sedes</a>
                                        <a class="dropdown-item" href="ModificarFacultades.jsp">Facultades</a>
                                        <a class="dropdown-item" href="ModificarProgramas.jsp">Programas</a>
                                        <a class="dropdown-item" href="ModificarMaterias.jsp">Materias</a>
>>>>>>> Stashed changes
                                    </div>
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
<<<<<<< Updated upstream
                
                <div class="container">
                    <div class="row justify-content-md-center">
                      <div class="col-lg-2">
=======
                <div class="card text-center">
                    <h1>Zona de consultas</h1>
                </div>  
                                
                <div class="container">
                    <div class="row justify-content-md-center">
                        <div class="col-lg-3">
>>>>>>> Stashed changes
                            <a class="nav-link" href="ConsultaCampus.jsp">
                                <img src="../Imagenes/Campus.svg" class="rounded mx-auto d-block" alt="..." width="100px" height="100px">
                            </a>   
<<<<<<< Updated upstream
                      </div>
                      <div class="col-lg-2">
=======
                        </div>
                        <div class="col-lg-3">
>>>>>>> Stashed changes
                            <a class="nav-link" href="ConsultaFacultades.jsp">
                                <img src="../Imagenes/Facultades.svg" class="rounded mx-auto d-block" alt="..." width="100px" height="100px">
                            </a>
<<<<<<< Updated upstream
                      </div>
                      <div class="col-lg-2">
=======
                        </div>
                        <div class="col-lg-3">
                            <a class="nav-link" href="ConsultaProgramas.jsp">
                                <img src="../Imagenes/Programas.png" class="rounded mx-auto d-block" alt="..." width="100px" height="100px">
                            </a>
                        </div>
                        <div class="col-lg-3">
>>>>>>> Stashed changes
                            <a class="nav-link" href="ConsultaMaterias.jsp">
                                <img src="../Imagenes/Materias.svg" class="rounded mx-auto d-block" alt="..." width="100px" height="100px">
                            </a>
                        </div> 
                    </div>
<<<<<<< Updated upstream
                    <div class="row justify-content-md-center">
                      <div class="col-lg-2">
=======
                    <div class="row justify-content-md-center">                         
                        <div class="col-lg-3">
>>>>>>> Stashed changes
                            <a class="nav-link" href="ConsultaTutores.jsp">
                                <img src="../Imagenes/Tutores.svg" class="rounded mx-auto d-block" alt="..." width="100px" height="100px">
                            </a>   
<<<<<<< Updated upstream
                      </div>
                      <div class="col-lg-2">
=======
                        </div>
                        <div class="col-lg-3">
>>>>>>> Stashed changes
                            <a class="nav-link" href="ConsultaEstudiantes.jsp">
                                <img src="../Imagenes/Estudiantes.svg" class="rounded mx-auto d-block" alt="..." width="100px" height="100px">
                            </a>
<<<<<<< Updated upstream
                      </div>
                      <div class="col-lg-2">
                            Empty
                      </div>
=======
                        </div>                      
>>>>>>> Stashed changes
                    </div>
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

    <script src="../js/jquery-3.5.0.slim.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    </body>
</html>

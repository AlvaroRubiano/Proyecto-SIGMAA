-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-07-2020 a las 02:01:38
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_sigmaa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `Id_administrador` bigint(15) NOT NULL,
  `Nombres` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '827ccb0eea8a706c4c34a16891f84e7b',
  `Clave` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`Id_administrador`, `Nombres`, `Email`, `Clave`) VALUES
(86066225, 'Alvaro Augusto Rubiano Guarnizo', 'arubiano20@estudiantes.areandina.edu.co', '827ccb0eea8a706c4c34a16891f84e7b');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campus`
--

CREATE TABLE `campus` (
  `Id_campus` int(11) NOT NULL,
  `Name_campus` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Tipo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `campus`
--

INSERT INTO `campus` (`Id_campus`, `Name_campus`, `Tipo`, `Direccion`) VALUES
(1, 'Bogotá', 'Sede', 'Carrera 14A No.70 A-34'),
(2, 'Valledupar', 'Sede', 'Transv 22 Bis #4-105'),
(3, 'Pereira', 'Sede', 'Calle 24 No. 8-55, Risaralda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `Id_estudiante` int(11) NOT NULL,
  `Name_users` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Mail_users` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Phone_users` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Estado_usuario` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Id_campus` int(11) NOT NULL,
  `Id_faculty` int(11) DEFAULT NULL,
  `Id_program` int(11) NOT NULL,
  `Semestre` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Modalidad` varchar(45) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`Id_estudiante`, `Name_users`, `Mail_users`, `Phone_users`, `Estado_usuario`, `Id_campus`, `Id_faculty`, `Id_program`, `Semestre`, `Modalidad`) VALUES
(457899, 'Jose Prudencio Padilla', 'jose.prudencio@gmail.com', '3203712166', 'activo', 1, 3, 1, '2', 'Presencial'),
(4343434, 'Mariana Rubiano Marrugo', 'mariana@gmail.com', '3125232577', 'activo', 3, 9, 3, '4', 'Presencial'),
(45549420, 'Andres Felipe Rubiano Marrugo', 'andresrubiano@gmail.com', '3125232577', 'activo', 2, 8, 2, '2', 'Virtual'),
(86066225, 'Alvaro Augusto Rubiano Guarnizo', 'rubiano124@gmail.com', '3203712166', 'activo', 1, 3, 1, '9', 'Presencial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factor_asociado`
--

CREATE TABLE `factor_asociado` (
  `Id_factor` int(11) NOT NULL,
  `Name_factor` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Observaciones` text CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `factor_asociado`
--

INSERT INTO `factor_asociado` (`Id_factor`, `Name_factor`, `Observaciones`) VALUES
(1, 'Laboral', NULL),
(2, 'Académico', NULL),
(3, 'Institucional', NULL),
(4, 'Otros', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `faculta`
--

CREATE TABLE `faculta` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `IdCampus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `faculta`
--

INSERT INTO `faculta` (`Id`, `Name`, `IdCampus`) VALUES
(1, 'Ciencias Administrativas, EconÃ³micas y Financieras', 1),
(2, 'Ciencias de la Salud y el Deporte', 1),
(3, 'DiseÃ±o, ComunicaciÃ³n y Bellas Artes', 1),
(4, 'Derecho', 1),
(5, 'EducaciÃ³n', 1),
(6, 'Ciencias Sociales y Humanas', 1),
(7, 'IngenierÃ­as y Ciencias BÃ¡sicas', 1),
(8, 'EducaciÃ³n', 2),
(9, 'Derecho', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `Id_clase` int(11) NOT NULL,
  `Nombre_clase` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Id_programa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`Id_clase`, `Nombre_clase`, `Id_programa`) VALUES
(10, 'Derecho Civil General y Personas', 3),
(11, 'Arte, Cultura y Sociedad', 1),
(12, 'Biologia del Desarrollo Humano', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE `programa` (
  `Id_program` int(11) NOT NULL,
  `Name_program` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Modalidad` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Id_faculty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`Id_program`, `Name_program`, `Modalidad`, `Id_faculty`) VALUES
(1, 'Diseño Grafico', 'Presencial', 3),
(2, 'Licenciatura en Ciencias Sociales', 'Virtual', 8),
(3, 'Derecho', 'Presencial', 9),
(18, 'Derecho', 'Presencial', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE `resultado` (
  `Id_resultado` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `asignatura` int(10) DEFAULT NULL,
  `observaciones` text COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ruta` varchar(100) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `resultado`
--

INSERT INTO `resultado` (`Id_resultado`, `fecha`, `asignatura`, `observaciones`, `nombre`, `ruta`) VALUES
(3, '2020-07-23', 11, 'Se estableciÃ³ comunicaciÃ³n con el estudiante y se realizÃ³ la monitoria. ', 'sesion', 'http://localhost:8080/Projecto_SIGMAA_V02/evidencias/Recibo 1er semestre 2019.pdf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestre`
--

CREATE TABLE `semestre` (
  `Id_semestre` int(2) NOT NULL,
  `nombre` varchar(10) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `semestre`
--

INSERT INTO `semestre` (`Id_semestre`, `nombre`) VALUES
(1, 'Primero'),
(2, 'Segundo'),
(3, 'Tercero'),
(4, 'Cuarto'),
(5, 'Quinto'),
(6, 'Sexto'),
(7, 'Septimo'),
(8, 'Octavo'),
(9, 'Noveno'),
(10, 'Decimo'),
(11, 'No Aplica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipotutor`
--

CREATE TABLE `tipotutor` (
  `Id_tipo` int(1) NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipotutor`
--

INSERT INTO `tipotutor` (`Id_tipo`, `nombre`) VALUES
(1, 'Monitor de aula'),
(2, 'Monitor académico'),
(3, 'Administrativo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutorias`
--

CREATE TABLE `tutorias` (
  `Id_tutorias` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `Id_estudiante` int(11) NOT NULL,
  `Id_programa` int(11) NOT NULL,
  `semestre` int(11) NOT NULL,
  `Id_factor` int(11) NOT NULL,
  `Id_tutor` int(11) NOT NULL,
  `obervaciones` text COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` text COLLATE utf8_spanish_ci DEFAULT 'Abierto'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tutorias`
--

INSERT INTO `tutorias` (`Id_tutorias`, `fecha`, `Id_estudiante`, `Id_programa`, `semestre`, `Id_factor`, `Id_tutor`, `obervaciones`, `estado`) VALUES
(3, '2020-07-23', 86066225, 1, 2, 2, 4343434, 'Se debe revisar que pasa con el estudiante.', 'Cerrado'),
(4, '2020-07-25', 457899, 1, 1, 2, 4343434, 'Revisar las notas en las materias. ', 'Abierto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id_usuario` int(11) NOT NULL,
  `Name_users` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Mail_users` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Pass_users` varchar(100) COLLATE utf8_spanish_ci NOT NULL DEFAULT '12345',
  `Phone_users` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Type_users` int(2) NOT NULL,
  `Id_campus` int(11) NOT NULL,
  `Id_faculty` int(11) NOT NULL,
  `Id_program` int(11) NOT NULL,
  `Semestre` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Modalidad` varchar(45) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id_usuario`, `Name_users`, `Mail_users`, `Pass_users`, `Phone_users`, `Type_users`, `Id_campus`, `Id_faculty`, `Id_program`, `Semestre`, `Modalidad`) VALUES
(123456, 'Jose Emilio Gutierrez Padilla', 'jose@gmail.com', '12345', '3203712166', 1, 1, 3, 1, '10', 'Presencial'),
(4343434, 'Mariana Rubiano Marrugo', 'mariana@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '3125232577', 2, 2, 8, 2, '1', 'Presencial'),
(21212121, 'Andres Felipe Rubiano Marrugo', 'andresrubiano@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '3203712166', 1, 3, 9, 3, '1', 'Presencial'),
(86066225, 'Alvaro Augusto Rubiano Guarnizo', 'rubiano124@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '3203712166', 3, 1, 3, 1, '11', 'No Aplica');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`Id_administrador`);

--
-- Indices de la tabla `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`Id_campus`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`Id_estudiante`);

--
-- Indices de la tabla `factor_asociado`
--
ALTER TABLE `factor_asociado`
  ADD PRIMARY KEY (`Id_factor`);

--
-- Indices de la tabla `faculta`
--
ALTER TABLE `faculta`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`Id_clase`);

--
-- Indices de la tabla `programa`
--
ALTER TABLE `programa`
  ADD PRIMARY KEY (`Id_program`);

--
-- Indices de la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD PRIMARY KEY (`Id_resultado`);

--
-- Indices de la tabla `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`Id_semestre`);

--
-- Indices de la tabla `tipotutor`
--
ALTER TABLE `tipotutor`
  ADD PRIMARY KEY (`Id_tipo`);

--
-- Indices de la tabla `tutorias`
--
ALTER TABLE `tutorias`
  ADD PRIMARY KEY (`Id_tutorias`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id_usuario`),
  ADD UNIQUE KEY `Mail_users` (`Mail_users`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `campus`
--
ALTER TABLE `campus`
  MODIFY `Id_campus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `faculta`
--
ALTER TABLE `faculta`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `Id_clase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `programa`
--
ALTER TABLE `programa`
  MODIFY `Id_program` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tipotutor`
--
ALTER TABLE `tipotutor`
  MODIFY `Id_tipo` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tutorias`
--
ALTER TABLE `tutorias`
  MODIFY `Id_tutorias` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

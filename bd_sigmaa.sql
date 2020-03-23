-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-03-2020 a las 22:29:55
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
-- Estructura de tabla para la tabla `campus`
--

CREATE TABLE `campus` (
  `Id_campus` int(11) NOT NULL,
  `Name_campus` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `class`
--

CREATE TABLE `class` (
  `Id_class` int(11) NOT NULL,
  `Name_class` varchar(50) NOT NULL,
  `Id_program` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `Id_estudiante` int(11) NOT NULL,
  `Name_users` varchar(100) NOT NULL,
  `Mail_users` varchar(100) NOT NULL,
  `Phone_users` varchar(10) NOT NULL,
  `Type_users` varchar(50) NOT NULL,
  `Id_campus` int(11) NOT NULL,
  `Id_faculty` int(11) NOT NULL,
  `Id_program` int(11) NOT NULL,
  `Semestre` varchar(45) NOT NULL,
  `Modalidad` varchar(45) NOT NULL,
  `Id_clase` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factor_asociado`
--

CREATE TABLE `factor_asociado` (
  `Id_factor` int(11) NOT NULL,
  `Name_factor` varchar(45) NOT NULL,
  `Observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facultad`
--

CREATE TABLE `facultad` (
  `Id_faculty` int(11) NOT NULL,
  `Name_faculty` varchar(45) NOT NULL,
  `Id_campus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `Id_material` int(11) NOT NULL,
  `Name_material` varchar(100) NOT NULL,
  `Id_tutorias` int(11) NOT NULL,
  `Id_tutor` int(11) NOT NULL,
  `Id_class` int(11) NOT NULL,
  `coment` text NOT NULL,
  `file` blob NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE `programa` (
  `Id_program` int(11) NOT NULL,
  `Name_program` varchar(45) NOT NULL,
  `Id_faculty` int(11) NOT NULL,
  `Id-class` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE `resultado` (
  `Id_resultado` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Id_users` int(11) NOT NULL,
  `Id_tutor` int(11) NOT NULL,
  `Id_estudiante` int(11) NOT NULL,
  `Id_tutoria` int(11) NOT NULL,
  `EstadoAtencion` varchar(45) NOT NULL,
  `Evidencia` text DEFAULT NULL,
  `EstadoRemision` varchar(45) NOT NULL,
  `Remision` text DEFAULT NULL,
  `Observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutorias`
--

CREATE TABLE `tutorias` (
  `Id_tutorias` int(11) NOT NULL,
  `Name_tutoria` varchar(50) NOT NULL,
  `Id_users` int(11) NOT NULL,
  `Id_class` int(11) NOT NULL,
  `Id_factor` int(11) NOT NULL,
  `Id_tutor` int(11) NOT NULL,
  `Id_estudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `Id_users` int(11) NOT NULL,
  `Name_users` varchar(100) NOT NULL,
  `Mail_users` varchar(100) NOT NULL,
  `Pass-users` varchar(100) NOT NULL,
  `Phone_users` varchar(10) NOT NULL,
  `Tpe_users` varchar(45) NOT NULL,
  `Id_campus` int(11) NOT NULL,
  `Id_faculty` int(11) NOT NULL,
  `Id_program` int(11) NOT NULL,
  `semestre` varchar(45) DEFAULT NULL,
  `Modalidad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`Id_campus`);

--
-- Indices de la tabla `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`Id_class`),
  ADD KEY `IdPrograma_idx` (`Id_program`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`Id_estudiante`),
  ADD KEY `IdCampus_idx` (`Id_campus`),
  ADD KEY `IdFacultad_idx` (`Id_faculty`),
  ADD KEY `IdPrograma_idx` (`Id_program`),
  ADD KEY `IdClases_idx` (`Id_clase`);

--
-- Indices de la tabla `factor_asociado`
--
ALTER TABLE `factor_asociado`
  ADD PRIMARY KEY (`Id_factor`);

--
-- Indices de la tabla `facultad`
--
ALTER TABLE `facultad`
  ADD PRIMARY KEY (`Id_faculty`),
  ADD KEY `IdCampus_idx` (`Id_campus`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`Id_material`),
  ADD KEY `IdUsers_idx` (`Id_tutor`),
  ADD KEY `IdTutorias_idx` (`Id_tutorias`),
  ADD KEY `IdClass_idx` (`Id_class`);

--
-- Indices de la tabla `programa`
--
ALTER TABLE `programa`
  ADD PRIMARY KEY (`Id_program`),
  ADD KEY `Idfaculty_idx` (`Id_faculty`),
  ADD KEY `Idclass_idx` (`Id-class`);

--
-- Indices de la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD PRIMARY KEY (`Id_resultado`),
  ADD KEY `IdUser_idx` (`Id_users`),
  ADD KEY `IdTutor_idx` (`Id_tutor`),
  ADD KEY `IdEstudiante_idx` (`Id_estudiante`),
  ADD KEY `IdTutoria_idx` (`Id_tutoria`);

--
-- Indices de la tabla `tutorias`
--
ALTER TABLE `tutorias`
  ADD PRIMARY KEY (`Id_tutorias`),
  ADD KEY `IdUsers_idx` (`Id_users`),
  ADD KEY `IdClass_idx` (`Id_class`),
  ADD KEY `IdFactor_idx` (`Id_factor`),
  ADD KEY `IdUser2_idx` (`Id_tutor`),
  ADD KEY `IdEstudiante_idx` (`Id_estudiante`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id_users`),
  ADD KEY `IdCampus_idx` (`Id_campus`),
  ADD KEY `IdFaculty_idx` (`Id_faculty`),
  ADD KEY `IdProgram_idx` (`Id_program`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `campus`
--
ALTER TABLE `campus`
  MODIFY `Id_campus` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `class`
--
ALTER TABLE `class`
  MODIFY `Id_class` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `facultad`
--
ALTER TABLE `facultad`
  MODIFY `Id_faculty` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `Id_material` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `programa`
--
ALTER TABLE `programa`
  MODIFY `Id_program` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tutorias`
--
ALTER TABLE `tutorias`
  MODIFY `Id_tutorias` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `ProgramasClases` FOREIGN KEY (`Id_program`) REFERENCES `programa` (`Id_program`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `CampusEstudiantes` FOREIGN KEY (`Id_campus`) REFERENCES `campus` (`Id_campus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ClasesEstudiantes` FOREIGN KEY (`Id_clase`) REFERENCES `class` (`Id_class`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FacultadesEstudiantes` FOREIGN KEY (`Id_faculty`) REFERENCES `facultad` (`Id_faculty`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProgramasEstudiantes` FOREIGN KEY (`Id_program`) REFERENCES `programa` (`Id_program`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `facultad`
--
ALTER TABLE `facultad`
  ADD CONSTRAINT `CampusFacultad` FOREIGN KEY (`Id_campus`) REFERENCES `campus` (`Id_campus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `ClasesMaterial` FOREIGN KEY (`Id_class`) REFERENCES `class` (`Id_class`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `TutoriasMaterial` FOREIGN KEY (`Id_tutorias`) REFERENCES `tutorias` (`Id_tutorias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `UsersMaterial` FOREIGN KEY (`Id_tutor`) REFERENCES `users` (`Id_users`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `programa`
--
ALTER TABLE `programa`
  ADD CONSTRAINT `ClasesPrograma` FOREIGN KEY (`Id-class`) REFERENCES `class` (`Id_class`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FacultadPrograma` FOREIGN KEY (`Id_faculty`) REFERENCES `facultad` (`Id_faculty`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD CONSTRAINT `EstudianteResultado` FOREIGN KEY (`Id_estudiante`) REFERENCES `estudiantes` (`Id_estudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `TutorResultado` FOREIGN KEY (`Id_tutor`) REFERENCES `users` (`Id_users`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `TutoriaResultado` FOREIGN KEY (`Id_tutoria`) REFERENCES `tutorias` (`Id_tutorias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `UserResultado` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tutorias`
--
ALTER TABLE `tutorias`
  ADD CONSTRAINT `ClasesTutorias` FOREIGN KEY (`Id_class`) REFERENCES `class` (`Id_class`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `EstudianteTutorias` FOREIGN KEY (`Id_estudiante`) REFERENCES `estudiantes` (`Id_estudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FactorTurorias` FOREIGN KEY (`Id_factor`) REFERENCES `factor_asociado` (`Id_factor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `TutorTutorias` FOREIGN KEY (`Id_tutor`) REFERENCES `users` (`Id_users`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `UsersTutorias` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `CampusUsers` FOREIGN KEY (`Id_campus`) REFERENCES `campus` (`Id_campus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FacultadUsers` FOREIGN KEY (`Id_faculty`) REFERENCES `facultad` (`Id_faculty`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProgramaUsers` FOREIGN KEY (`Id_program`) REFERENCES `programa` (`Id_program`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

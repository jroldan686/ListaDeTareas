-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-06-2018 a las 10:38:08
-- Versión del servidor: 5.7.22-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `notengotiempo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `importancia` tinyint(2) UNSIGNED DEFAULT '5',
  `finalizacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `enlace` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT 'https://jesusroldan.sytes.net/',
  `imagen` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id`, `nombre`, `descripcion`, `importancia`, `finalizacion`, `enlace`, `imagen`, `updated_at`, `created_at`) VALUES
(32, 'Entrega Tareas', 'Entregar trabajo de Acceso a Datos', 10, '2018-06-14 00:00:00', 'https://portadaalta.mobi/cursos/login/index.php', NULL, '2018-06-14 10:17:07', '2018-06-14 10:17:07'),
(33, 'Exposicion Tareas', 'Exponer el trabajo de Acceso a Datos', 10, '2018-06-14 00:00:00', 'https://portadaalta.mobi/cursos/login/index.php', NULL, '2018-06-14 10:19:55', '2018-06-14 10:19:55'),
(34, 'Pagar DigitalOcean', 'Pagar el servidor de Digital Ocean', 7, '2018-07-02 00:00:00', 'https://jesusroldan.sytes.net', NULL, '2018-06-14 10:22:05', '2018-06-14 10:22:05');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

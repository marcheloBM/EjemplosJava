-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-07-2017 a las 21:59:18
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca1`
--
CREATE DATABASE `biblioteca1` ;

USE `biblioteca1`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_us` int(11) NOT NULL,
  `nombre_us` varchar(50) NOT NULL,
  `ape_us` varchar(50) NOT NULL,
  `cel_us` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `tipo_us` varchar(50) NOT NULL,
  `recuperacion` varchar(50) NOT NULL,
  `foto_us` longblob
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_us`, `nombre_us`, `ape_us`, `cel_us`, `usuario`, `pass`, `tipo_us`, `recuperacion`, `foto_us`) VALUES
(1, '', '', '', 'RojeruSan', 'noseroger', 'ADMINISTRADOR MASTER', 'C06DA67B-148E-4A7E-9F41-2888D586428D', NULL),
(2, 'USUARIOS', 'USUARIOS', '', 'User1', 'nose1234', 'NORMAL', '893426E1-6A86-4C14-9B16-812B1E47D643', NULL),
(3, 'USUARIOS', 'USUARIOS', '', 'User2', '12345678', 'ADMINISTRADOR', '1E57E06C-22BE-4B6E-8788-C2A11BB864AD', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

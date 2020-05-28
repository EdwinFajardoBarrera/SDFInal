-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 28-05-2020 a las 22:43:25
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bolsadevalores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `companies`
--

CREATE TABLE `companies` (
  `companyRFC` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `numOfActions` int(11) NOT NULL,
  `valueOfAction` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `companies`
--

INSERT INTO `companies` (`companyRFC`, `numOfActions`, `valueOfAction`) VALUES
('AA10000000', 100, 200),
('AA20000000', 100, 200),
('AA30000000', 100, 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transactions`
--

CREATE TABLE `transactions` (
  `userRFC` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `companyRFC` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `date` timestamp NOT NULL,
  `operatedActions` int(11) NOT NULL,
  `operatedActionsPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `transactions`
--

INSERT INTO `transactions` (`userRFC`, `companyRFC`, `date`, `operatedActions`, `operatedActionsPrice`) VALUES
('AA12001082', 'AA10000000', '2020-05-28 22:06:19', 30, 50),
('AA12001082', 'AA10000000', '2020-05-13 22:06:19', -15, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `userRFC` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `companyRFC` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `numOfActions` int(11) NOT NULL,
  `lastBuyPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`userRFC`, `companyRFC`, `numOfActions`, `lastBuyPrice`) VALUES
('AA12001082', 'AA10000000', 0, 0),
('AA12001083', 'AA10000000', 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`companyRFC`);

--
-- Indices de la tabla `transactions`
--
ALTER TABLE `transactions`
  ADD KEY `userRFC` (`userRFC`),
  ADD KEY `companyRFC` (`companyRFC`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `userRFC` (`userRFC`),
  ADD KEY `companyRFC` (`companyRFC`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`userRFC`) REFERENCES `users` (`userRFC`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`companyRFC`) REFERENCES `companies` (`companyRFC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

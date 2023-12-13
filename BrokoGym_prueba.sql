-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.28-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para brokogym_prueba
CREATE DATABASE IF NOT EXISTS `brokogym_prueba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `brokogym_prueba`;

-- Volcando estructura para tabla brokogym_prueba.administrador
CREATE TABLE IF NOT EXISTS `administrador` (
  `id_administrador` bigint(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sueldo` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_administrador`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_administrador`) REFERENCES `usuario` (`cedula_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.administrador: ~0 rows (aproximadamente)
INSERT INTO `administrador` (`id_administrador`, `password`, `sueldo`) VALUES
	(1, '12345', 3900000);

-- Volcando estructura para tabla brokogym_prueba.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` bigint(11) NOT NULL,
  `grupo_sanguineo` varchar(3) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`cedula_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.cliente: ~0 rows (aproximadamente)
INSERT INTO `cliente` (`id_cliente`, `grupo_sanguineo`) VALUES
	(5, 'A+');

-- Volcando estructura para tabla brokogym_prueba.entrenador
CREATE TABLE IF NOT EXISTS `entrenador` (
  `id_entrenador` bigint(11) NOT NULL,
  `turno` enum('Mañana','Tarde','Noche') NOT NULL,
  `sueldo` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_entrenador`),
  CONSTRAINT `entrenador_ibfk_1` FOREIGN KEY (`id_entrenador`) REFERENCES `usuario` (`cedula_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.entrenador: ~0 rows (aproximadamente)
INSERT INTO `entrenador` (`id_entrenador`, `turno`, `sueldo`) VALUES
	(4, 'Mañana', 1300000);

-- Volcando estructura para tabla brokogym_prueba.membresia_cliente
CREATE TABLE IF NOT EXISTS `membresia_cliente` (
  `id_membresia` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `tipo_membresia` enum('Bronce','Plata','Oro') NOT NULL,
  `id_cliente` bigint(11) NOT NULL,
  `estado` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.membresia_cliente: ~0 rows (aproximadamente)
INSERT INTO `membresia_cliente` (`id_membresia`, `fecha_inicio`, `fecha_fin`, `tipo_membresia`, `id_cliente`, `estado`) VALUES
	(0, '2023-12-12', '2024-01-12', 'Bronce', 6, 'Activo'),
	(0, '2023-12-12', '2024-01-12', 'Bronce', 7, 'Activo');

-- Volcando estructura para tabla brokogym_prueba.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.producto: ~0 rows (aproximadamente)
INSERT INTO `producto` (`id_producto`, `nombre`, `cantidad`, `precio`) VALUES
	(1, 'Speed', 80, 1800);

-- Volcando estructura para tabla brokogym_prueba.recepcionista
CREATE TABLE IF NOT EXISTS `recepcionista` (
  `id_recepcionista` bigint(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `turno` enum('Mañana','Tarde','Noche') NOT NULL,
  `sueldo` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_recepcionista`),
  CONSTRAINT `recepcionista_ibfk_1` FOREIGN KEY (`id_recepcionista`) REFERENCES `usuario` (`cedula_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.recepcionista: ~0 rows (aproximadamente)
INSERT INTO `recepcionista` (`id_recepcionista`, `password`, `turno`, `sueldo`) VALUES
	(3, '12345', 'Mañana', 1690000);

-- Volcando estructura para tabla brokogym_prueba.supervisor
CREATE TABLE IF NOT EXISTS `supervisor` (
  `id_supervisor` bigint(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `turno` enum('Mañana','Tarde','Noche') NOT NULL,
  `sueldo` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_supervisor`),
  CONSTRAINT `supervisor_ibfk_1` FOREIGN KEY (`id_supervisor`) REFERENCES `usuario` (`cedula_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.supervisor: ~0 rows (aproximadamente)
INSERT INTO `supervisor` (`id_supervisor`, `password`, `turno`, `sueldo`) VALUES
	(2, '12345', 'Tarde', 2600000);

-- Volcando estructura para tabla brokogym_prueba.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `cedula_usuario` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dia_nac` int(11) NOT NULL,
  `mes_nac` int(11) NOT NULL,
  `year_nac` int(11) NOT NULL,
  `email` varchar(70) NOT NULL,
  `tipo_usuario` enum('Administrador','Supervisor','Recepcionista','Entrenador','Cliente') NOT NULL,
  `estado` enum('Activo','Inactivo') NOT NULL,
  PRIMARY KEY (`cedula_usuario`),
  KEY `tipo_usuario` (`tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla brokogym_prueba.usuario: ~5 rows (aproximadamente)
INSERT INTO `usuario` (`cedula_usuario`, `nombre`, `apellido`, `dia_nac`, `mes_nac`, `year_nac`, `email`, `tipo_usuario`, `estado`) VALUES
	(1, 'Miguel', 'Escobar', 17, 11, 2004, 'migue171104@hotmail.com', 'Administrador', 'Activo'),
	(2, 'Juan jose', 'Bedoya', 28, 6, 2005, 'Juancho@gmail.com', 'Supervisor', 'Activo'),
	(3, 'Maria', 'Gomez', 28, 8, 1991, 'Maleja@gmail.com', 'Recepcionista', 'Activo'),
	(4, 'Jhon', 'Rodriguez', 12, 12, 2002, 'JhonRodriguez@Gmail.com', 'Entrenador', 'Activo'),
	(5, 'Miguel', 'Marin', 5, 12, 2000, 'maem1704@gmail.com', 'Cliente', 'Activo');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

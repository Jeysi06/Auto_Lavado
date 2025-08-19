-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: autolavado
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbb_usuarios`
--

DROP TABLE IF EXISTS `tbb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbb_usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(90) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `idRol` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_rol_idx` (`idRol`),
  CONSTRAINT `idRol` FOREIGN KEY (`idRol`) REFERENCES `tbc_rols` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbb_usuarios`
--

LOCK TABLES `tbb_usuarios` WRITE;
/*!40000 ALTER TABLE `tbb_usuarios` DISABLE KEYS */;
INSERT INTO `tbb_usuarios` VALUES (2,' angel','dasd ',' asd',' sad',' 4353545',' sadsad',' jessi',' 1234','2000-12-12',3),(12,' luis','dasd ',' asd',' sad',' 4353545',' sadsad',' jessi',' 1234','2000-12-12',2),(13,' jessi','dasd ',' asd',' sad',' 4353545',' sadsad',' jessi',' 1234','2000-12-12',1),(14,' luis','dasd ',' asd',' sad',' 4353545',' sadsad',' jessi',' 1234','2000-12-12',1),(15,' luis','dasd ',' asd',' sad',' 4353545',' sadsad',' jessi',' 1234','2000-12-12',1),(16,' luis','dasd ',' asd',' sad',' 4353545',' sadsad',' jessi',' 1234','2000-12-12',1);
/*!40000 ALTER TABLE `tbb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbb_vehiculos`
--

DROP TABLE IF EXISTS `tbb_vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbb_vehiculos` (
  `idVehiculo` int NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `anio` year NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  KEY `fk_clientes_idx` (`id_cliente`),
  CONSTRAINT `fk_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `tbc_clientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbb_vehiculos`
--

LOCK TABLES `tbb_vehiculos` WRITE;
/*!40000 ALTER TABLE `tbb_vehiculos` DISABLE KEYS */;
INSERT INTO `tbb_vehiculos` VALUES (1,'3333','asdasad','asdsa','asddas',2000,'Carro',1),(6,'2222','asdasad','asdsa','asddas',2000,'Carro',1);
/*!40000 ALTER TABLE `tbb_vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbc_clientes`
--

DROP TABLE IF EXISTS `tbc_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbc_clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(90) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbc_clientes`
--

LOCK TABLES `tbc_clientes` WRITE;
/*!40000 ALTER TABLE `tbc_clientes` DISABLE KEYS */;
INSERT INTO `tbc_clientes` VALUES (1,'luis','hdz','hdz','texcoco','35621727312','luis@gmail.com','1234'),(2,'jessi ',' cruz',' baroan','xico','378643694',' jessi@gmail.com',' 1234'),(9,'angelito',' cruz',' baroan','xico','378643694',' jessi@gmail.com',' 1234');
/*!40000 ALTER TABLE `tbc_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbc_rols`
--

DROP TABLE IF EXISTS `tbc_rols`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbc_rols` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbc_rols`
--

LOCK TABLES `tbc_rols` WRITE;
/*!40000 ALTER TABLE `tbc_rols` DISABLE KEYS */;
INSERT INTO `tbc_rols` VALUES (1,'cliente'),(2,' empleado'),(3,'lavador');
/*!40000 ALTER TABLE `tbc_rols` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbc_servicios`
--

DROP TABLE IF EXISTS `tbc_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbc_servicios` (
  `idServicio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(90) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `estatus` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbc_servicios`
--

LOCK TABLES `tbc_servicios` WRITE;
/*!40000 ALTER TABLE `tbc_servicios` DISABLE KEYS */;
INSERT INTO `tbc_servicios` VALUES (1,'se lava','lavadora',120.00,1),(2,' encerado',' se encera',250.00,1),(8,'lavador','se lavas',120.00,1);
/*!40000 ALTER TABLE `tbc_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbd_venta_servicio`
--

DROP TABLE IF EXISTS `tbd_venta_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbd_venta_servicio` (
  `id_ventaServicio` int NOT NULL AUTO_INCREMENT,
  `idUsuarioC` int NOT NULL,
  `idUsuarioL` int NOT NULL,
  `idServicio` int NOT NULL,
  `idVehiculo` int NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `estatus` varchar(45) NOT NULL,
  `pagado` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_ventaServicio`),
  KEY `fk_UsuariosC_idx` (`idUsuarioC`),
  KEY `fk_UsuariosL_idx` (`idUsuarioL`),
  KEY `fk_Servicios_idx` (`idServicio`),
  KEY `fk_Vehiculo_idx` (`idVehiculo`),
  CONSTRAINT `fk_Servicios` FOREIGN KEY (`idServicio`) REFERENCES `tbc_servicios` (`idServicio`),
  CONSTRAINT `fk_UsuariosC` FOREIGN KEY (`idUsuarioC`) REFERENCES `tbb_usuarios` (`idUsuario`),
  CONSTRAINT `fk_UsuariosL` FOREIGN KEY (`idUsuarioL`) REFERENCES `tbb_usuarios` (`idUsuario`),
  CONSTRAINT `fk_Vehiculo` FOREIGN KEY (`idVehiculo`) REFERENCES `tbb_vehiculos` (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbd_venta_servicio`
--

LOCK TABLES `tbd_venta_servicio` WRITE;
/*!40000 ALTER TABLE `tbd_venta_servicio` DISABLE KEYS */;
INSERT INTO `tbd_venta_servicio` VALUES (5,2,2,1,1,'2000-12-12','12:11:11','finish',1);
/*!40000 ALTER TABLE `tbd_venta_servicio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-03 21:49:09

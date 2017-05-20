CREATE DATABASE  IF NOT EXISTS `sudoku_unir` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sudoku_unir`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sudoku_unir
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `maquina`
--

DROP TABLE IF EXISTS `maquina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maquina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_maquina` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `maquina_uk` (`codigo_maquina`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquina`
--

LOCK TABLES `maquina` WRITE;
/*!40000 ALTER TABLE `maquina` DISABLE KEYS */;
INSERT INTO `maquina` VALUES (1,'jUdm6i3OQlLqgqOizma1tvjGdIcSujiI');
/*!40000 ALTER TABLE `maquina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maquina_id` int(11) NOT NULL,
  `partida` varchar(4096) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_partida_maquina_idx` (`maquina_id`),
  CONSTRAINT `fk_partida_maquina` FOREIGN KEY (`maquina_id`) REFERENCES `maquina` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
INSERT INTO `partida` VALUES (2,1,'[[{\"v\":\"7\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"1\",\"p\":true}],[{\"v\":\"2\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"1\",\"p\":true},{\"v\":\"5\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"4\",\"p\":false}],[{\"v\":\"4\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"9\",\"p\":true},{\"v\":\"8\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"3\",\"p\":false}],[{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"8\",\"p\":false}],[{\"v\":\"5\",\"p\":true},{\"v\":\"4\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"9\",\"p\":true},{\"v\":\"8\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"6\",\"p\":false}],[{\"v\":\"6\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"4\",\"p\":true},{\"v\":\"5\",\"p\":false}],[{\"v\":\"9\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"7\",\"p\":false}],[{\"v\":\"3\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"5\",\"p\":true},{\"v\":\"8\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":false}],[{\"v\":\"8\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"6\",\"p\":true},{\"v\":\"9\",\"p\":false}]]','2017-05-21 00:13:27'),(3,1,'[[{\"v\":\"3\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"9\",\"p\":true},{\"v\":\"8\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"4\",\"p\":true},{\"v\":\"7\",\"p\":false}],[{\"v\":\"6\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"2\",\"p\":false}],[{\"v\":\"2\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"9\",\"p\":true},{\"v\":\"6\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"3\",\"p\":true},{\"v\":\"5\",\"p\":false},{\"v\":\"1\",\"p\":false}],[{\"v\":\"8\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"\",\"p\":false}],[{\"v\":\"5\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"7\",\"p\":true},{\"v\":\"6\",\"p\":false},{\"v\":\"2\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"4\",\"p\":true}],[{\"v\":\"4\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"8\",\"p\":true},{\"v\":\"2\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"9\",\"p\":false}],[{\"v\":\"1\",\"p\":false},{\"v\":\"2\",\"p\":true},{\"v\":\"4\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"\",\"p\":false},{\"v\":\"5\",\"p\":true}],[{\"v\":\"7\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"5\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"9\",\"p\":false},{\"v\":\"1\",\"p\":false},{\"v\":\"\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"6\",\"p\":false}],[{\"v\":\"9\",\"p\":false},{\"v\":\"8\",\"p\":false},{\"v\":\"6\",\"p\":false},{\"v\":\"2\",\"p\":true},{\"v\":\"5\",\"p\":false},{\"v\":\"3\",\"p\":false},{\"v\":\"4\",\"p\":false},{\"v\":\"7\",\"p\":false},{\"v\":\"\",\"p\":false}]]','2017-05-21 00:36:40');
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-20 17:52:39

CREATE DATABASE  IF NOT EXISTS `realtor_social` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `realtor_social`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: realtor_social
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `c_requirements`
--

DROP TABLE IF EXISTS `c_requirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_requirements` (
  `CR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `number_of_persons` int(11) DEFAULT NULL,
  `number_of_bedrooms` int(11) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `C_ID` int(20) NOT NULL,
  `number_of_baths` int(10) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `range_low` varchar(30) DEFAULT NULL,
  `range_high` varchar(30) DEFAULT NULL,
  `house_description` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`CR_ID`),
  KEY `C_ID_idx` (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_requirements`
--

LOCK TABLES `c_requirements` WRITE;
/*!40000 ALTER TABLE `c_requirements` DISABLE KEYS */;
INSERT INTO `c_requirements` VALUES (1,5,3,'San Jose','CA','95114','house',0,NULL,NULL,NULL,NULL,NULL),(2,NULL,2,'','','95112','house',6,1,NULL,'100000','400000',NULL),(3,NULL,2,'San Francisco','CA','95112','house',7,2,NULL,'100000','400000',NULL),(4,NULL,1,'San Francisco','CA','95112','apartment',8,2,NULL,'100000','400000','clean and safe'),(5,NULL,2,'San Francisco','CA','95112','apartment',9,1,NULL,'400000','1000000000000','safe and sound for smarth');
/*!40000 ALTER TABLE `c_requirements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-27 16:49:54

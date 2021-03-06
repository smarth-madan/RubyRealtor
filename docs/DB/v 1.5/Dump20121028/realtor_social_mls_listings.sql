CREATE DATABASE  IF NOT EXISTS `realtor_social` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `realtor_social`;
-- MySQL dump 10.13  Distrib 5.5.24, for osx10.5 (i386)
--
-- Host: localhost    Database: realtor_social
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `mls_listings`
--

DROP TABLE IF EXISTS `mls_listings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mls_listings` (
  `MLS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `bed_bath` varchar(45) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `parking` varchar(10) DEFAULT NULL,
  `garage` varchar(10) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `tags` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`MLS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mls_listings`
--

LOCK TABLES `mls_listings` WRITE;
/*!40000 ALTER TABLE `mls_listings` DISABLE KEYS */;
INSERT INTO `mls_listings` VALUES (1,'5, W. Santa clara street','Sunnyvale','CA','95114','3/2','1200 sq-ft','550000','house','yes','yes','property1.gif',NULL),(2,'148, E. William street','San Jose','CA','95112','2/2','1225 sq-ft','240000','Apartment','yes','no','property2.gif',NULL),(3,'201 E. San Carlos Street','Palo Alto','CA','95113','4/2','1500 sq-ft','566000','house','yes','yes','property4.gif',NULL);
/*!40000 ALTER TABLE `mls_listings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-28 14:57:43

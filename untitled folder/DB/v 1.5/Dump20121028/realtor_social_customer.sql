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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(45) NOT NULL,
  `lName` varchar(45) NOT NULL,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `marital_status` varchar(20) DEFAULT NULL,
  `email_ID` varchar(75) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `R_ID` int(11) DEFAULT NULL,
  `salary_min_val` varchar(20) DEFAULT NULL,
  `salary_max_val` varchar(20) DEFAULT NULL,
  `customer_priority` int(2) DEFAULT '2' COMMENT 'Priority 1 = High Priority 2 = Default Priority 3=Low',
  PRIMARY KEY (`C_ID`),
  KEY `C_ID` (`C_ID`),
  KEY `R_ID` (`R_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Rob','Stein','123 W. San Carlos st','San Jose','CA','95110','single','rob.stein@gmail.com','221-236-2809',1,NULL,NULL,2),(3,'Shaunak','Khedkar','148, e. wILLIam street, APt#21','San Jose','San Jose','95112','SINGLE','shaunakkhedkar@gmail.com','7206486010',1,'2000','100000',1),(4,'Shaunak','Khedkar','148, e. wILLIam street, APt#21','San Jose','San Jose','95112','SINGLE,any','shaunakkhedkar@gmail.com','7206486010',1,'2000','100000',1),(5,'Shaunak','Khedkar','148, e. wILLIam street, APt#21','San Jose','CA - California','95112','SINGLE,any','shaunakkhedkar@gmail.com','7206486010',1,'2000','100000',1),(6,'Shaunak','Khedkar','148, e. wILLIam street, APt#21','San Jose','CA - California','95112','SINGLE,any','shaunakkhedkar@gmail.com','7206486010',1,'2000','100000',1),(7,'Shaunak','Khedkar','148, e. wILLIam street, APt#21','San Jose','CA - California','95112','SINGLE','shaunakkhedkar@gmail.com','7206486010',1,'2000','100000',1),(8,'Shaunak','Khedkar','148, e. wILLIam street, APt#21','San Jose','CA - California','95112','SINGLE','shaunakkhedkar@gmail.com','7206486010',1,'2000','100000',1),(9,'Smarth ','Madan','123, San fearnando','San Jose','CA - California','95112','SINGLE','madanb@gmail.com','7206486010',1,'2000','100000',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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

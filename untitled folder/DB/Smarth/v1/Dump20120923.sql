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
  `state` varchar(10) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `range_amount` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_requirements`
--

LOCK TABLES `c_requirements` WRITE;
/*!40000 ALTER TABLE `c_requirements` DISABLE KEYS */;
INSERT INTO `c_requirements` VALUES (1,5,3,'San Jose','CA','95114','400000-500000','house');
/*!40000 ALTER TABLE `c_requirements` ENABLE KEYS */;
UNLOCK TABLES;

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
  `state` varchar(10) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `marital_status` varchar(20) DEFAULT NULL,
  `email_ID` varchar(75) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `R_ID` int(11) DEFAULT NULL,
  `CR_ID` int(11) DEFAULT NULL,
  `salary_min_val` int(20) DEFAULT NULL,
  `salary_max_val` int(20) DEFAULT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `C_ID` (`C_ID`),
  KEY `R_ID` (`R_ID`),
  KEY `CR_ID` (`CR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Rob','Stein','123 W. San Carlos st','San Jose','CA','95110','single','rob.stein@gmail.com','221-236-2809',1,1,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`MLS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mls_listings`
--

LOCK TABLES `mls_listings` WRITE;
/*!40000 ALTER TABLE `mls_listings` DISABLE KEYS */;
INSERT INTO `mls_listings` VALUES (1,'5, W. Santa clara street','Sunnyvale','CA','95114','3/2','1200 sq-ft','550000','house','yes','yes');
/*!40000 ALTER TABLE `mls_listings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_social`
--

DROP TABLE IF EXISTS `r_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_social` (
  `R_Social_ID` int(11) NOT NULL,
  `Account_type` varchar(5) NOT NULL,
  `username` varchar(75) DEFAULT NULL,
  `password` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`R_Social_ID`,`Account_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_social`
--

LOCK TABLES `r_social` WRITE;
/*!40000 ALTER TABLE `r_social` DISABLE KEYS */;
INSERT INTO `r_social` VALUES (1,'FB','bob.woolmer@gmail.com','password'),(2,'TW','bob.woolmer@gmail.com','password');
/*!40000 ALTER TABLE `r_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realtor`
--

DROP TABLE IF EXISTS `realtor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realtor` (
  `R_ID` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `email_ID` varchar(75) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `R_Social_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`R_ID`),
  KEY `R_ID` (`R_ID`),
  KEY `R_Social_ID` (`R_Social_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realtor`
--

LOCK TABLES `realtor` WRITE;
/*!40000 ALTER TABLE `realtor` DISABLE KEYS */;
INSERT INTO `realtor` VALUES (1,'Bob','Woolmer','172 W. Wincester st','San Jose','CA','95114','bob.woolmer@gmail.com','721-536-2009',0);
/*!40000 ALTER TABLE `realtor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-23 20:54:32

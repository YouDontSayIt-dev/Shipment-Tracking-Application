CREATE DATABASE  IF NOT EXISTS `shipmenttracking` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shipmenttracking`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shipmenttracking
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `serial_number` int NOT NULL AUTO_INCREMENT,
  `description_text` varchar(200) DEFAULT NULL,
  `piece_count` int DEFAULT NULL,
  `shipment_ID` int DEFAULT NULL,
  `container_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`serial_number`),
  KEY `Container_ID_idx` (`container_number`),
  KEY `Shipment_ID_idx` (`shipment_ID`),
  CONSTRAINT `Container_ID` FOREIGN KEY (`container_number`) REFERENCES `container_number` (`Container_ID`),
  CONSTRAINT `Shipment_ID` FOREIGN KEY (`shipment_ID`) REFERENCES `shipment_details` (`shipment_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2248280 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (2248279,'COUCH',2,10039257,'MAIY6697460');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consignee_contact_table`
--

DROP TABLE IF EXISTS `consignee_contact_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consignee_contact_table` (
  `consignee_comm_number` varchar(50) NOT NULL,
  `consignee_comm_qualifier` char(5) DEFAULT NULL,
  `consignee_ID` int DEFAULT NULL,
  PRIMARY KEY (`consignee_comm_number`),
  KEY `consignee_ID_idx` (`consignee_ID`),
  CONSTRAINT `consignee_ID` FOREIGN KEY (`consignee_ID`) REFERENCES `consignee_table` (`consignee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consignee_contact_table`
--

LOCK TABLES `consignee_contact_table` WRITE;
/*!40000 ALTER TABLE `consignee_contact_table` DISABLE KEYS */;
INSERT INTO `consignee_contact_table` VALUES ('mjmuyco13@gmail.com','EMAIL',35542014),('mjpmuyco@gmail.com','EMAIL',35542014);
/*!40000 ALTER TABLE `consignee_contact_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consignee_table`
--

DROP TABLE IF EXISTS `consignee_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consignee_table` (
  `consignee_ID` int NOT NULL,
  `consignee_name` varchar(50) DEFAULT NULL,
  `consignee_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`consignee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consignee_table`
--

LOCK TABLES `consignee_table` WRITE;
/*!40000 ALTER TABLE `consignee_table` DISABLE KEYS */;
INSERT INTO `consignee_table` VALUES (35542014,'Jeffrei','Hubei, China');
/*!40000 ALTER TABLE `consignee_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `container_number`
--

DROP TABLE IF EXISTS `container_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `container_number` (
  `Container_ID` varchar(15) NOT NULL,
  `Vessel_Name` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`Container_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `container_number`
--

LOCK TABLES `container_number` WRITE;
/*!40000 ALTER TABLE `container_number` DISABLE KEYS */;
INSERT INTO `container_number` VALUES ('MAIY6697460','MAERSK BEYOND');
/*!40000 ALTER TABLE `container_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_details`
--

DROP TABLE IF EXISTS `shipment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_details` (
  `shipment_ID` int NOT NULL,
  `trade_update_date` date DEFAULT NULL,
  `run_date` date DEFAULT NULL,
  `estimated_arrival_date` date DEFAULT NULL,
  `foreign_port_lading` char(40) DEFAULT NULL,
  `place_of_receipt` char(30) DEFAULT NULL,
  `port_of_destination` char(40) DEFAULT NULL,
  `actual_arrival_date` date DEFAULT NULL,
  `consignee_ID` int DEFAULT NULL,
  `shipper_ID` int DEFAULT NULL,
  PRIMARY KEY (`shipment_ID`),
  KEY `consignee_Num_idx` (`consignee_ID`),
  KEY `shipper_Num_idx` (`shipper_ID`),
  CONSTRAINT `consignee_Num` FOREIGN KEY (`consignee_ID`) REFERENCES `consignee_table` (`consignee_ID`),
  CONSTRAINT `shipper_Num` FOREIGN KEY (`shipper_ID`) REFERENCES `shipper_table` (`shipper_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_details`
--

LOCK TABLES `shipment_details` WRITE;
/*!40000 ALTER TABLE `shipment_details` DISABLE KEYS */;
INSERT INTO `shipment_details` VALUES (10039257,'2022-07-20','2022-07-28','2022-07-23','Shanghai,China','Mandaluyong, Metro Manila','Manila, Philippines','2022-06-02',35542014,35542013);
/*!40000 ALTER TABLE `shipment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper_contact_table`
--

DROP TABLE IF EXISTS `shipper_contact_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper_contact_table` (
  `shipper_comm_number` varchar(50) NOT NULL,
  `shipper_comm_qualifier` char(5) DEFAULT NULL,
  `shipper_ID` int DEFAULT NULL,
  PRIMARY KEY (`shipper_comm_number`),
  KEY `shipper_ID_idx` (`shipper_ID`),
  CONSTRAINT `shipper_ID` FOREIGN KEY (`shipper_ID`) REFERENCES `shipper_table` (`shipper_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper_contact_table`
--

LOCK TABLES `shipper_contact_table` WRITE;
/*!40000 ALTER TABLE `shipper_contact_table` DISABLE KEYS */;
INSERT INTO `shipper_contact_table` VALUES ('hehe','TEL',35542013);
/*!40000 ALTER TABLE `shipper_contact_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper_table`
--

DROP TABLE IF EXISTS `shipper_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper_table` (
  `shipper_ID` int NOT NULL,
  `shipper_name` varchar(50) DEFAULT NULL,
  `shipper_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`shipper_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper_table`
--

LOCK TABLES `shipper_table` WRITE;
/*!40000 ALTER TABLE `shipper_table` DISABLE KEYS */;
INSERT INTO `shipper_table` VALUES (35542013,'Shiela','Manila');
/*!40000 ALTER TABLE `shipper_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_ID` int NOT NULL,
  `staff_name` varchar(50) DEFAULT NULL,
  `staff_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`staff_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-14 17:16:42

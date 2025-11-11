CREATE DATABASE  IF NOT EXISTS `malldb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `malldb`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: malldb
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `full_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` enum('ADMIN','TENANT') COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','123456','Administrator','ADMIN'),(2,'tenant1','12345','Dat','TENANT'),(12,'tenant23','123456','DaoDat','TENANT'),(14,'tenant36','123456','Dat vo tri','TENANT'),(18,'tenant12','123456','Đạt','TENANT');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint NOT NULL,
  `shop_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `shop_name` varchar(250) NOT NULL,
  `type` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `income` decimal(12,2) NOT NULL DEFAULT '0.00',
  `status` enum('active','expired','terminated') NOT NULL DEFAULT 'active',
  PRIMARY KEY (`contract_id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,1,1,'Dat','0987654321','daodat23@gmail.com','GShop','Quần Áo','2025-10-10','2026-10-10',3600000.00,'active'),(13,23,4,'DaoDat','0234567891','dd@gmail.com','DDShop','Thực phẩm','2025-01-01','2026-01-01',600000.00,'active'),(15,36,7,'Dat vo tri','0123654789','datvt@gmail.com','VoTri Shop','Meme','2025-11-01','2026-03-03',900000.00,'active'),(22,12,3,'Đạt','0123456789','daovudat@gmail.com','Cửa hàng rau củ','Rau củ','2025-11-12','2026-11-11',3000000.00,'active');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(14,2) DEFAULT NULL,
  `image_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `shop_id` int NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`name`,`shop_id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('Áo choàng băng giá',2000.00,'C:\\Users\\Admin\\Pictures\\Saved Pictures\\tải xuống.jpg',1,''),('Giáp thống khổ',1940.00,'C:\\Users\\Admin\\Pictures\\Saved Pictures\\channels4_profile.jpg',1,'300 giáp, 1200 máu tối đa. Nội tại: Phàn lại 15% sát thương vật lý gánh chịu thành sát thuong phép lên mục tiêu'),('Giày du mục',700.00,'C:\\Users\\Admin\\Pictures\\Saved Pictures\\timthumb.jpg',1,'Tăng 60% tốc chạy và 20% tốc đánh. Nội tại: Đánh thường hồi 20 máu'),('meo vo tri',8000.00,'C:\\Users\\Admin\\Pictures\\Saved Pictures\\z6308942558062_88fbcdf71f8f1bfce5882b491a207ea0.jpg',7,'mot con meo');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `shop_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `area` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rental_status` enum('Đang thuê','Trống') COLLATE utf8mb4_unicode_ci DEFAULT 'Trống',
  `tenant_id` int DEFAULT NULL,
  `contract_id` int DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `tenant_id` (`tenant_id`),
  KEY `contract_id` (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'GShop','Quần Áo','Khu X','Đang thuê',1,1),(2,NULL,NULL,'Khu A1','Trống',NULL,NULL),(3,'Cửa hàng rau củ','Rau củ','Khu A2','Đang thuê',12,22),(4,'DDShop','Thực phẩm','Khu B1','Đang thuê',23,13),(5,NULL,NULL,'Khu B2','Trống',NULL,NULL),(6,NULL,NULL,'Khu C1','Trống',NULL,NULL),(7,'VoTri Shop','Meme','Khu C2','Đang thuê',36,15);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant` (
  `tenant_id` int NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contract_id` int DEFAULT NULL,
  `shop_id` int DEFAULT NULL,
  `username` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tenant_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `shop_id` (`shop_id`),
  KEY `tenant_ibfk_1` (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'Dat','0987654321','daodat2305@gmail.com',1,1,'tenant1','123456'),(12,'Đạt','0123456789','daovudat@gmail.com',22,3,'tenant12','123456'),(23,'DaoDat','0234567891','dd@gmail.com',13,4,'tenant23','123456'),(36,'Dat vo tri','0123654789','datvt@gmail.com',15,7,'tenant36','123456');
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-11 22:38:40

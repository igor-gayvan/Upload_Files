--
-- Current Database: `filesbucket`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `filesbucket` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `filesbucket`;

-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 192.168.1.37    Database: filesbucket
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `upload_files`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload_files` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `file_name` varchar(200) NOT NULL,
  `file_path` varchar(4000) NOT NULL,
  `file_UUID` varchar(36) NOT NULL,
  `file_md5` varchar(32) DEFAULT NULL,
  `date_rec` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload_files`
--

LOCK TABLES `upload_files` WRITE;
/*!40000 ALTER TABLE `upload_files` DISABLE KEYS */;
INSERT INTO `upload_files` VALUES (1,'2','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','1',NULL,'2016-10-08 01:00:33');
INSERT INTO `upload_files` VALUES (2,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','1',NULL,'2016-10-08 01:08:33');
INSERT INTO `upload_files` VALUES (3,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','fc93c072-7f98-444b-94d6-9588564f6397',NULL,'2016-10-08 01:15:39');
INSERT INTO `upload_files` VALUES (4,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','a63b92fd-ef00-4bd4-954c-5dff67a0726d',NULL,'2016-10-08 01:17:11');
INSERT INTO `upload_files` VALUES (5,'Dump20161008.sql','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','d048179c-c5f1-4150-8373-7503344385af',NULL,'2016-10-08 01:24:49');
INSERT INTO `upload_files` VALUES (6,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','5db932fe-9987-4167-888e-de5da78bb70d',NULL,'2016-10-08 01:26:50');
INSERT INTO `upload_files` VALUES (7,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','5b2e58f4-aa81-464e-bf5e-e6107b579211',NULL,'2016-10-08 01:28:56');
INSERT INTO `upload_files` VALUES (8,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','217889b2-41e4-4de3-95fd-96c21fe99803',NULL,'2016-10-08 01:30:05');
INSERT INTO `upload_files` VALUES (9,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','fd59353c-187b-49eb-8d25-5c1f6594dcc8',NULL,'2016-10-08 01:32:13');
INSERT INTO `upload_files` VALUES (10,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','1ef7571f-3641-4442-887d-f4dd7aa8b6ee',NULL,'2016-10-08 01:37:51');
INSERT INTO `upload_files` VALUES (11,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','f8be6cee-71e2-4836-ac99-39820c134e94',NULL,'2016-10-08 01:41:01');
INSERT INTO `upload_files` VALUES (12,'MAC.txt','D:\\Codefire_projects\\Upload_Files\\target\\Upload_Files-1.0-SNAPSHOT\\\\uploadFiles','75239be0-5d8c-4c5f-ba52-21990fccb179','6302f9354b006446dab4b67f79a1c986','2016-10-08 02:03:31');
/*!40000 ALTER TABLE `upload_files` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-09  0:55:15

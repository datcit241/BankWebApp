-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: banking
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` varchar(90) NOT NULL,
  `user_id` varchar(90) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `type` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('fd018f98-ed03-45a4-b27e-9ebd593318dc','1',100029000,'Current'),('713459da-29f5-4938-a3fa-b598c86f4a0f','1',0,'Saving');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_users`
--

DROP TABLE IF EXISTS `new_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_users` (
  `id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_users`
--

LOCK TABLES `new_users` WRITE;
/*!40000 ALTER TABLE `new_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saving_accounts`
--

DROP TABLE IF EXISTS `saving_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saving_accounts` (
  `account_id` varchar(90) NOT NULL,
  `saved_from` date DEFAULT NULL,
  `saving_plan_id` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saving_accounts`
--

LOCK TABLES `saving_accounts` WRITE;
/*!40000 ALTER TABLE `saving_accounts` DISABLE KEYS */;
INSERT INTO `saving_accounts` VALUES ('713459da-29f5-4938-a3fa-b598c86f4a0f','2022-08-18','-1');
/*!40000 ALTER TABLE `saving_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `id` varchar(90) NOT NULL,
  `account_id` varchar(90) DEFAULT NULL,
  `to_account_id` varchar(90) DEFAULT NULL,
  `type` varchar(90) DEFAULT NULL,
  `time_stamp` timestamp NULL DEFAULT NULL,
  `prev_amount` double DEFAULT NULL,
  `final_amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('457755dd-bef7-4746-a806-5d7f45d8000c','fd018f98-ed03-45a4-b27e-9ebd593318dc','null','Deposit','2022-08-18 14:31:17',10000,20000),('85a0317d-691a-4bb1-8811-4e423b6613bf','fd018f98-ed03-45a4-b27e-9ebd593318dc','null','Deposit','2022-08-18 14:36:02',20000,100020000),('02cc44cb-9f81-44af-afd7-8877a0eb44f0','fd018f98-ed03-45a4-b27e-9ebd593318dc','null','Deposit','2022-08-18 14:42:09',100020000,100030000),('5529be33-164b-4aac-99bc-2c7a70f6f331','fd018f98-ed03-45a4-b27e-9ebd593318dc','null','Deposit','2022-08-18 14:42:33',100030000,100041000),('d82e9e6c-fdbf-4a89-aff0-07e0158f36d0','fd018f98-ed03-45a4-b27e-9ebd593318dc','null','Withdraw','2022-08-18 14:46:13',100041000,100029000);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` varchar(90) NOT NULL,
  `username` varchar(90) DEFAULT NULL,
  `password` varchar(90) DEFAULT NULL,
  `name` varchar(250) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone_number` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('1','dat','123','Dat','ABC','113');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18 21:49:50

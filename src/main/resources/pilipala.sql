-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pilibala
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `user_fan`
--

DROP TABLE IF EXISTS `user_fan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_fan` (
  `ID` int NOT NULL COMMENT '用户ID',
  `fans_id` int NOT NULL COMMENT '粉丝ID',
  PRIMARY KEY (`ID`),
  KEY `user_fan___user` (`fans_id`),
  CONSTRAINT `user_fan___user` FOREIGN KEY (`fans_id`) REFERENCES `user_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_fan_main_user___User` FOREIGN KEY (`ID`) REFERENCES `user_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户粉丝列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_fan`
--

LOCK TABLES `user_fan` WRITE;
/*!40000 ALTER TABLE `user_fan` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_fan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_favor`
--

DROP TABLE IF EXISTS `user_favor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_favor` (
  `ID` int NOT NULL COMMENT '用户ID',
  `video_id` int NOT NULL COMMENT '视频ID',
  PRIMARY KEY (`ID`),
  CONSTRAINT `userFavor___User` FOREIGN KEY (`ID`) REFERENCES `user_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_favor`
--

LOCK TABLES `user_favor` WRITE;
/*!40000 ALTER TABLE `user_favor` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_favor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_subscribe`
--

DROP TABLE IF EXISTS `user_subscribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_subscribe` (
  `ID` int NOT NULL COMMENT '用户ID',
  `subscribe_user_id` int NOT NULL COMMENT '被关注的ID',
  PRIMARY KEY (`ID`),
  KEY `user_subscribe___User` (`subscribe_user_id`),
  CONSTRAINT `user_subscribe___User` FOREIGN KEY (`subscribe_user_id`) REFERENCES `user_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_subscribe_main_user___User` FOREIGN KEY (`ID`) REFERENCES `user_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户关注列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_subscribe`
--

LOCK TABLES `user_subscribe` WRITE;
/*!40000 ALTER TABLE `user_subscribe` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_table` (
  `id` int NOT NULL COMMENT '用户ID',
  `name` varchar(100) NOT NULL COMMENT '用户名',
  `avert` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `coinCounter` int NOT NULL COMMENT '硬币数量',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userTable_pk_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'admin','no',100,'123456..a');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `video_id` int NOT NULL COMMENT '视频ID',
  `video_title` varchar(100) NOT NULL COMMENT '视频标题',
  `author_id` int DEFAULT NULL COMMENT '作者ID',
  `seen` int NOT NULL COMMENT '播放量',
  `date` datetime DEFAULT (now()) COMMENT '创作时间',
  `video_URL` varchar(100) DEFAULT NULL COMMENT '视频地址',
  PRIMARY KEY (`video_id`),
  UNIQUE KEY `video_pk` (`video_id`),
  KEY `video___auther` (`author_id`),
  CONSTRAINT `video___auther` FOREIGN KEY (`author_id`) REFERENCES `user_table` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='视频信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_comment`
--

DROP TABLE IF EXISTS `video_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video_comment` (
  `ID` int NOT NULL COMMENT '评论编号',
  `user_id` int DEFAULT NULL COMMENT '发言用户',
  `video_id` int DEFAULT NULL COMMENT '视频ID',
  `comment` text NOT NULL COMMENT '用户评论',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `video_comment_pk_2` (`ID`),
  KEY `video_comment___video` (`video_id`),
  KEY `video_comment_userID__user` (`user_id`),
  CONSTRAINT `video_comment___video` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `video_comment_userID__user` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='视频评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_comment`
--

LOCK TABLES `video_comment` WRITE;
/*!40000 ALTER TABLE `video_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `video_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-05 20:38:14

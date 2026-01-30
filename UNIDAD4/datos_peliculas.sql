-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: peliculas_marcadiz
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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(500) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  `fec_nac` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actor_has_pelicula`
--

DROP TABLE IF EXISTS `actor_has_pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor_has_pelicula` (
  `actor_id` int NOT NULL,
  `pelicula_id` int NOT NULL,
  `personaje` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`actor_id`,`pelicula_id`),
  KEY `fk_actor_has_pelicula_pelicula1_idx` (`pelicula_id`),
  KEY `fk_actor_has_pelicula_actor_idx` (`actor_id`),
  CONSTRAINT `fk_actor_has_pelicula_actor` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`),
  CONSTRAINT `fk_actor_has_pelicula_pelicula1` FOREIGN KEY (`pelicula_id`) REFERENCES `pelicula` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_has_pelicula`
--

LOCK TABLES `actor_has_pelicula` WRITE;
/*!40000 ALTER TABLE `actor_has_pelicula` DISABLE KEYS */;
/*!40000 ALTER TABLE `actor_has_pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cine`
--

DROP TABLE IF EXISTS `cine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(1000) DEFAULT NULL,
  `localidades` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cine`
--

LOCK TABLES `cine` WRITE;
/*!40000 ALTER TABLE `cine` DISABLE KEYS */;
/*!40000 ALTER TABLE `cine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `clasificacion` int DEFAULT NULL,
  `sinopsis` varchar(505) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'forest gump',134,1,'Muy guena'),(2,'avatar',145,2,'Peleas de la muerte'),(3,'el golpe',100,2,'The best'),(4,'Matrix',120,1,'Super BSO'),(5,'Farrah Petty',218,2,'Palma de Mallorca'),(6,'Adena Barnes',52,2,'Elx'),(7,'Bo Washington',398,1,'Pontevedra'),(8,'Carter Berry',228,2,'Melilla'),(9,'Shad Ray',326,1,'San Cristóbal de la Laguna'),(10,'Martin Noble',401,1,'Teruel'),(11,'Kim Stevenson',254,2,'Melilla'),(12,'Russell Moon',242,1,'Ceuta'),(13,'Fritz Bean',316,1,'Ciudad Real'),(14,'Quemby Sloan',224,1,'Girona'),(15,'Porter Ford',339,2,'Pamplona'),(16,'Pamela Ramsey',411,2,'Santander'),(17,'Zenaida Hernandez',229,2,'Jaén'),(18,'Perry Jackson',314,2,'Badajoz'),(19,'Lionel Bentley',238,2,'Cáceres'),(20,'Stuart Wiley',352,1,'Pamplona'),(21,'Sara Knight',194,2,'Murcia'),(22,'Roary Sharpe',371,2,'Zaragoza'),(23,'Ignacia Kaufman',396,1,'Palma de Mallorca'),(24,'Sasha Alvarez',334,2,'Ceuta'),(25,'Tate Payne',244,1,'Madrid'),(26,'Gillian Beach',175,1,'Gijón'),(27,'Ariana Byers',207,2,'Cartagena'),(28,'Yael Foley',337,2,'Las Palmas'),(29,'Nichole Evans',431,1,'Santander'),(30,'Wade Wells',235,1,'Torrevieja'),(31,'Justine Charles',255,1,'Huesca'),(32,'Bert May',171,2,'Cartagena'),(33,'Alfonso Gamble',220,1,'Pamplona'),(34,'Maris Marks',212,2,'Murcia'),(35,'Keefe Simmons',48,1,'Pamplona'),(36,'Shana Howard',160,1,'A Coruña'),(37,'Cora Castro',124,2,'Pontevedra'),(38,'Whitney Cole',152,1,'Logroño'),(39,'Zoe Fleming',438,1,'Vigo'),(40,'Candice Parsons',182,1,'Santander'),(41,'Jaquelyn Moses',84,2,'Cartagena'),(42,'Magee Fulton',195,2,'Ceuta'),(43,'Urielle Page',108,1,'Logroño'),(44,'Paloma Rowland',165,1,'Cartagena'),(45,'Nasim Kelley',214,1,'Melilla'),(46,'Eve Vincent',228,1,'Gijón'),(47,'Kennedy Mcdowell',326,1,'Oviedo'),(48,'Gail Palmer',132,1,'Melilla'),(49,'Katell O\'Neill',72,2,'Badajoz'),(50,'Noble Rush',51,1,'Elx'),(51,'Raja Horton',425,1,'Palma de Mallorca'),(52,'Tarik Sharp',387,2,'Cartagena'),(53,'Darius Santos',396,2,'Gijón'),(54,'Malachi Barrett',352,2,'San Cristóbal de la Laguna'),(55,'Marny Vaughn',192,1,'Pamplona'),(56,'Tyrone Chang',413,1,'L\'Hospitalet de Llobregat'),(57,'Jessamine Hopkins',175,1,'Huelva'),(58,'Yvette Nichols',112,1,'Badajoz'),(59,'Carl Briggs',319,1,'Donosti'),(60,'Graham Greer',61,1,'Ciudad Real'),(61,'Deanna Williamson',255,1,'Guadalajara'),(62,'Elizabeth Forbes',308,2,'Ceuta'),(63,'Jordan Vega',292,1,'Gijón'),(64,'Raymond Vaughan',418,1,'Palma de Mallorca'),(65,'Tanner Mccarty',111,2,'Burgos'),(66,'Bo Valentine',447,2,'San Cristóbal de la Laguna'),(67,'Hashim Beach',291,2,'Pamplona'),(68,'Rogan Keller',348,2,'Guadalajara'),(69,'Nola Baldwin',437,1,'Oviedo'),(70,'Burton Carney',338,1,'Logroño'),(71,'Dylan Smith',192,1,'Torrevieja'),(72,'Roary Mccray',127,1,'Donosti'),(73,'Sybil Fry',341,1,'Dos Hermanas'),(74,'Malik Marshall',139,1,'Pamplona'),(75,'Alvin Mckenzie',173,2,'Pamplona'),(76,'Steel Mccarty',54,1,'Gijón'),(77,'Dustin Cain',179,2,'Bilbo'),(78,'Vladimir Beasley',327,1,'Donosti'),(79,'Keith Dickson',146,2,'Cáceres'),(80,'Brady Harrison',325,1,'Melilla'),(81,'Kareem Raymond',285,2,'Santander'),(82,'Larissa Keller',169,1,'Barcelona'),(83,'Kane Chen',449,2,'Santa Cruz de Tenerife'),(84,'Germaine Craig',253,1,'Huelva'),(85,'Addison Galloway',329,2,'Alacant'),(86,'Melvin George',30,2,'Gasteiz'),(87,'Colt Mccray',196,1,'Donosti'),(88,'Baker Gallegos',148,2,'Huesca'),(89,'Lilah Quinn',339,1,'Pamplona'),(90,'Melyssa Jones',412,2,'Pamplona'),(91,'Tyrone Franks',350,2,'Algeciras'),(92,'Joseph Osborn',272,2,'Santander'),(93,'Hadley Gutierrez',234,1,'Zaragoza'),(94,'Jared Hatfield',40,2,'Zaragoza'),(95,'Dominic Merritt',41,2,'Cádiz'),(96,'Jana Farmer',92,2,'Pamplona'),(97,'Benjamin Herrera',364,1,'Donosti'),(98,'Julian Mcconnell',271,2,'San Cristóbal de la Laguna'),(99,'Ima Velazquez',178,2,'Teruel'),(100,'Neve Dickson',75,1,'Badajoz'),(101,'Herman Daugherty',159,1,'Palma de Mallorca'),(102,'Shelly Nguyen',161,1,'Melilla'),(103,'Doris Christensen',152,1,'Cáceres'),(104,'Jermaine Barker',376,1,'Santander'),(105,'Shannon Pittman',312,1,'Zaragoza'),(106,'Yolanda Weaver',105,2,'Telde'),(107,'Tanek Mills',172,1,'Alcalá de Henares'),(108,'Laith Sellers',210,2,'Sabadell'),(109,'Geoffrey Crosby',45,2,'Huesca'),(110,'Tiger Bowman',35,1,'Torrevieja'),(111,'Ezekiel Simmons',281,1,'Guadalajara'),(112,'Jenna Lancaster',102,2,'Albacete'),(113,'Elijah Hardin',224,1,'Donosti'),(114,'Amethyst White',123,2,'Guadalajara'),(115,'Minerva Duke',150,1,'Alacant'),(116,'Phillip Cortez',345,1,'Palma de Mallorca'),(117,'Bevis Dillard',269,2,'Valéncia'),(118,'Vivien Stokes',62,1,'Guadalajara'),(119,'Noble Farmer',448,1,'Murcia'),(120,'Zachary Baldwin',143,2,'Ceuta'),(121,'Arthur Hamilton',61,1,'Pamplona'),(122,'Callum Stevens',95,1,'Oviedo'),(123,'Paloma Powell',175,1,'Ceuta'),(124,'Cedric Fernandez',364,2,'Ourense'),(125,'Jonas Marshall',435,1,'Oviedo'),(126,'Malik Gutierrez',245,1,'Cáceres'),(127,'Autumn Barton',152,1,'Torrevieja'),(128,'Stella Hernandez',159,1,'Pontevedra'),(129,'Yael Barrera',363,1,'Alcobendas'),(130,'Darius Orr',237,2,'Zaragoza'),(131,'Kareem Reed',100,1,'Badajoz'),(132,'Joshua Cook',95,1,'Gijón'),(133,'Desirae Mills',141,1,'Toledo'),(134,'Kiayada Dyer',341,1,'Logroño'),(135,'Lois Langley',343,2,'Oviedo'),(136,'Sybill Mcguire',229,1,'Pamplona'),(137,'Justin Robbins',379,2,'Oviedo'),(138,'Carter Combs',437,2,'Gasteiz'),(139,'Chester Downs',364,2,'Santa Cruz de Tenerife'),(140,'Nayda Sherman',242,2,'Palma de Mallorca'),(141,'Rhiannon Black',101,2,'Zaragoza'),(142,'Felix Bridges',427,2,'Almería'),(143,'Naomi Rice',250,1,'Cartagena'),(144,'Melinda Williamson',381,1,'Lugo'),(145,'Vincent Patterson',382,2,'Bilbo'),(146,'Gage Key',107,1,'Oviedo'),(147,'Colt Buckley',238,2,'Cuenca'),(148,'Lionel Patton',370,1,'Toledo'),(149,'Hayes Clark',203,1,'Vigo'),(150,'Angelica Hoffman',40,1,'Zamora'),(151,'Chase Solis',80,2,'Córdoba'),(152,'Daryl Lopez',169,1,'Santa Cruz de Tenerife'),(153,'Hedy Gomez',53,2,'Pamplona'),(154,'Fay Burgess',243,1,'Castelló'),(155,'Rigel Osborn',393,1,'Málaga'),(156,'Eagan Graham',346,1,'Palma de Mallorca'),(157,'Cyrus Chavez',294,1,'Palma de Mallorca'),(158,'Keith Castillo',266,2,'Pamplona'),(159,'Cailin Ingram',178,2,'Palma de Mallorca'),(160,'Colton Keith',321,1,'Torrevieja'),(161,'Melvin Vaughan',195,1,'Logroño'),(162,'Kaye Sandoval',428,1,'Ávila'),(163,'Bruno Gilbert',274,1,'San Cristóbal de la Laguna'),(164,'Nina Mullen',231,1,'Santander'),(165,'Latifah Greene',316,2,'Burgos'),(166,'Igor Wong',104,2,'Dos Hermanas'),(167,'Zephr Williams',359,1,'Pamplona'),(168,'Reed Stokes',102,2,'Teruel'),(169,'Fletcher Lynch',339,1,'Cáceres'),(170,'India Harrell',314,1,'Baracaldo'),(171,'Jameson Guerra',68,2,'Lugo'),(172,'Hyacinth Craig',138,1,'Marbella'),(173,'Raja Tran',317,2,'Sevilla'),(174,'Amelia Battle',432,2,'Ceuta'),(175,'Jasper Drake',427,1,'Marbella'),(176,'Orla Chambers',213,1,'Palma de Mallorca'),(177,'Orla Sloan',136,2,'Madrid'),(178,'Christine Lara',44,1,'León'),(179,'Mona Dennis',316,1,'Vigo'),(180,'Xandra Fields',87,1,'Alcalá de Henares'),(181,'Denton Wyatt',338,1,'Palma de Mallorca'),(182,'Chaney Brooks',342,2,'Salamanca'),(183,'Lionel Crawford',250,1,'Castelló'),(184,'Margaret Potter',341,1,'Melilla'),(185,'Rhona Lindsay',109,2,'Gijón'),(186,'Barry Petersen',305,2,'Alcalá de Henares'),(187,'Xavier Mercer',44,1,'Elx'),(188,'Jordan Holden',149,2,'Alacant'),(189,'Jacqueline Sharpe',425,2,'Huesca'),(190,'Vivien Herman',356,1,'Sabadell'),(191,'Malachi Bridges',315,2,'Albacete'),(192,'Reese Roman',363,2,'Oviedo'),(193,'Laurel Lowery',270,2,'Madrid'),(194,'Leo Bond',145,1,'Málaga'),(195,'Flynn Barrera',330,2,'Oviedo'),(196,'Charles Noel',320,2,'Murcia'),(197,'Ryan Moreno',403,2,'Baracaldo'),(198,'Palmer Mcdaniel',268,1,'Oviedo'),(199,'Derek Cobb',199,1,'Pamplona'),(200,'Winter Greene',158,1,'Reus'),(201,'Russell Bright',79,2,'Murcia'),(202,'Chastity Lester',253,1,'Gijón'),(203,'Hunter Lopez',220,2,'Alcorcón'),(204,'Cassady Britt',354,2,'Elx');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_has_cine`
--

DROP TABLE IF EXISTS `pelicula_has_cine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_has_cine` (
  `pelicula_id` int NOT NULL,
  `cine_id` int NOT NULL,
  PRIMARY KEY (`pelicula_id`,`cine_id`),
  KEY `fk_pelicula_has_cine_cine1_idx` (`cine_id`),
  KEY `fk_pelicula_has_cine_pelicula1_idx` (`pelicula_id`),
  CONSTRAINT `fk_pelicula_has_cine_cine1` FOREIGN KEY (`cine_id`) REFERENCES `cine` (`id`),
  CONSTRAINT `fk_pelicula_has_cine_pelicula1` FOREIGN KEY (`pelicula_id`) REFERENCES `pelicula` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_has_cine`
--

LOCK TABLES `pelicula_has_cine` WRITE;
/*!40000 ALTER TABLE `pelicula_has_cine` DISABLE KEYS */;
/*!40000 ALTER TABLE `pelicula_has_cine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `localidades` int DEFAULT NULL,
  `tipo_sala` int DEFAULT NULL,
  `cine_id` int NOT NULL,
  PRIMARY KEY (`id`,`cine_id`),
  KEY `fk_sala_cine1_idx` (`cine_id`),
  CONSTRAINT `fk_sala_cine1` FOREIGN KEY (`cine_id`) REFERENCES `cine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-27 10:50:32

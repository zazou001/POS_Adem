-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (armv7l)
--
-- Host: localhost    Database: adem
-- ------------------------------------------------------
-- Server version	5.5.44-0+deb7u1

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
-- Table structure for table `caisse`
--

DROP TABLE IF EXISTS `caisse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caisse` (
  `idcaisse` int(11) NOT NULL AUTO_INCREMENT,
  `1cent` int(11) NOT NULL,
  `2cent` int(11) NOT NULL,
  `5cent` int(11) NOT NULL,
  `10cent` int(11) NOT NULL,
  `20cent` int(11) NOT NULL,
  `50cent` int(11) NOT NULL,
  `1euro` int(11) NOT NULL,
  `2euro` int(11) NOT NULL,
  `5euro` int(11) NOT NULL,
  `10euro` int(11) NOT NULL,
  `20euro` int(11) NOT NULL,
  `50euro` int(11) NOT NULL,
  `100euro` int(11) NOT NULL,
  `200euro` int(11) NOT NULL,
  `500euro` int(11) NOT NULL,
  `datecaisse` date NOT NULL,
  PRIMARY KEY (`idcaisse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caisse`
--

LOCK TABLES `caisse` WRITE;
/*!40000 ALTER TABLE `caisse` DISABLE KEYS */;
/*!40000 ALTER TABLE `caisse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiants2014`
--

DROP TABLE IF EXISTS `etudiants2014`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etudiants2014` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `dateDeNaissance` text NOT NULL,
  `eMail` text NOT NULL,
  `annee` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiants2014`
--

LOCK TABLES `etudiants2014` WRITE;
/*!40000 ALTER TABLE `etudiants2014` DISABLE KEYS */;
/*!40000 ALTER TABLE `etudiants2014` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formule`
--

DROP TABLE IF EXISTS `formule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formule` (
  `idvente` int(11) NOT NULL,
  `idSandwich` int(11) NOT NULL,
  `idSnack` int(11) DEFAULT NULL,
  `idBoisson` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formule`
--

LOCK TABLES `formule` WRITE;
/*!40000 ALTER TABLE `formule` DISABLE KEYS */;
/*!40000 ALTER TABLE `formule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sandwich`
--

DROP TABLE IF EXISTS `sandwich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sandwich` (
  `idSandwich` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`idSandwich`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sandwich`
--

LOCK TABLES `sandwich` WRITE;
/*!40000 ALTER TABLE `sandwich` DISABLE KEYS */;
/*!40000 ALTER TABLE `sandwich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snack`
--

DROP TABLE IF EXISTS `snack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snack` (
  `idtype` int(2) NOT NULL,
  `idSnack` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `img` varchar(50) NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`idSnack`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snack`
--

LOCK TABLES `snack` WRITE;
/*!40000 ALTER TABLE `snack` DISABLE KEYS */;
INSERT INTO `snack` VALUES (1,101,'Bueno','no.jpg',0.6),(1,102,'Delice','no.jpg',0.5),(1,103,'Twix','no.jpg',0.5),(1,104,'Nougatti','no.jpg',0.5),(1,105,'Kit kat','no.jpg',0.5),(1,106,'kit kat ball','no.jpg',0.5),(1,107,'Snickers','no.jpg',0.5),(1,108,'Oreo','no.jpg',0.5),(1,109,'M&m\'s','no.jpg',0.5),(1,110,'Country','no.jpg',0.3),(1,111,'Prince','no.jpg',0.3),(1,112,'Chips','no.jpg',0.3),(1,113,'Maxi','no.jpg',0.3),(2,201,'Coca','no.jpg',0.5),(2,202,'Coca zero','no.jpg',0.5),(2,203,'Ice tea','no.jpg',0.5),(2,204,'7Up','no.jpg',0.5),(2,205,'Fanta','no.jpg',0.5),(2,206,'Schweppes','no.jpg',0.5),(2,207,'Orangina','no.jpg',0.5),(2,208,'Oasis','no.jpg',0.5),(2,209,'Limonade','no.jpg',0.5),(2,210,'Eau','no.jpg',0.3),(3,301,'Photocopie Ami','no.jpg',0.03),(3,302,'Photocopie Non Ami','no.jpg',0.05),(3,303,'Polos','no.jpg',10),(3,304,'Pin\'s','no.jpg',2),(3,305,'Tee-shirt PI','no.jpg',3.14);
/*!40000 ALTER TABLE `snack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stocks` (
  `idSnack` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `datestock` date DEFAULT NULL,
  PRIMARY KEY (`idSnack`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks`
--

LOCK TABLES `stocks` WRITE;
/*!40000 ALTER TABLE `stocks` DISABLE KEYS */;
/*!40000 ALTER TABLE `stocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateurs` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `groupe` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `passwd` varchar(255) NOT NULL DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateurs`
--

LOCK TABLES `utilisateurs` WRITE;
/*!40000 ALTER TABLE `utilisateurs` DISABLE KEYS */;
INSERT INTO `utilisateurs` VALUES (1,'utilisateur','adem','a0489b2e90939bba87131f3591fca4fe'),(2,'utilisateur;stock;tresorier','tresor','b92c12c6bbf7c437f5b58eae164d80a1'),(3,'utilisateur;stock','stock','99c1ea929284c97a8aa3f9d40a0abaf9');
/*!40000 ALTER TABLE `utilisateurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vente`
--

DROP TABLE IF EXISTS `vente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vente` (
  `idvente` int(11) NOT NULL,
  `datevente` date NOT NULL,
  PRIMARY KEY (`idvente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vente`
--

LOCK TABLES `vente` WRITE;
/*!40000 ALTER TABLE `vente` DISABLE KEYS */;
/*!40000 ALTER TABLE `vente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'adem'
--

--
-- Dumping routines for database 'adem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-26  7:09:06

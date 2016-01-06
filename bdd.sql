/* Table caisse */
DROP TABLE IF EXISTS `caisse`;
CREATE TABLE `caisse` (
  `idcaisse` int( NOT NULL AUTO_INCREMENT,
  `total` float NOT NULL,
  `datecaisse` date NOT NULL,
  PRIMARY KEY (`idcaisse`)
);

/* 	Table etudiants2015
	Contient la liste des etudiants.	*/
DROP TABLE IF EXISTS `etudiants2015`;
CREATE TABLE `etudiants2015` (
  `idEtu` int unsigned NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `dateDeNaissance` text NOT NULL,
  `eMail` text NOT NULL,
  `annee` text NOT NULL,
  PRIMARY KEY (`idEtu`)
);

/*	Table utilisateurs
	Contient la liste des utilisateurs ainsi que le mots de passe	
	Groupes :
	1 : User
	2 : Trez / Stock
	3 : Root / Prez		*/
DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE `utilisateurs` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `groupe` int NOT NULL DEFAULT '1',
  `user` varchar(255) NOT NULL DEFAULT '',
  `passwd` varchar(255) NOT NULL DEFAULT '',
  UNIQUE (`user`),
  PRIMARY KEY (`idUser`)
);

/* 	Table produit
	Contient la liste des produits en vente */
CREATE TABLE `produit` (
  `idProduit` int NOT NULL,
  `prix` float NOT NULL,
  `nom` varchar(255) NOT NULL DEFAULT'',
  PRIMARY KEY (`idProduit`)
);

/* 	Table vente 
	Contient la liste des vente*/;
DROP TABLE IF EXISTS `vente`;
CREATE TABLE `vente` (
  `idVente` int NOT NULL AUTO_INCREMENT,
  `datevente` date NOT NULL,
  PRIMARY KEY (`idVente`),
  
  FOREIGN KEY (idUser) REFERENCES utilisateurs(idUser)
  FOREIGN KEY (idProduit) REFERENCES produit(idProduit)
);

/* 	Table stock
	Contient la quantite de stock de chacun des produits */
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `quantite` int NOT NULL,
  FOREIGN KEY (idProduit) REFERENCES produit(idProduit)
);

/*	Table sandwichs
	Contient la liste des noms de sandwichs */
DROP TABLE IF EXISTS `sandwichs`;
CREATE TABLE `sandwichs` (
  `idSand` int NOT NULL,
  `nom` varchar(255) NOT NULL,
  
  PRIMARY KEY (`idSand`)
);


INSERT INTO `utilisateurs` VALUES
				(1,3,'root','63a9f0ea7bb98050796b649e85481845'),
				(2,2,'trez','4760acd914e9e26ffe45445bede3db74'),
				(3,1,'adem','8b372a2d003dc7c6e3ca4c4420c88ea9'),
				(4,3,'prez','6721346ab707897993e8f040b8dc2b9c');


#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

drop table utilisateurs;
drop table vente;
drop table stock;
drop table caisseTresorier;
drop table etudiants;
drop table sandwichs;
drop table produit;

#------------------------------------------------------------
# Table: utilisateurs
#------------------------------------------------------------

CREATE TABLE utilisateurs(
        idUser   Int NOT NULL ,
        username Varchar (255) NOT NULL ,
        password Varchar (255) NOT NULL ,
        groupe   Int NOT NULL ,
        PRIMARY KEY (idUser ) ,
        UNIQUE (username )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: produit
#------------------------------------------------------------

CREATE TABLE produit(
        idProduit Int NOT NULL ,
        nom       Varchar (255) NOT NULL ,
        prix      Float NOT NULL ,
        idType      Int NOT NULL ,
        image     Blob ,
        PRIMARY KEY (idProduit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: etudiants
#------------------------------------------------------------

CREATE TABLE etudiants(
        idEtu     int (11) Auto_increment  NOT NULL ,
        nom       Varchar (255) ,
        prenom    Varchar (255) ,
        naissance Varchar (255) ,
        annee     Varchar (255) ,
        email     Varchar (255) NOT NULL ,
        PRIMARY KEY (idEtu )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: sandwichs
#------------------------------------------------------------

CREATE TABLE sandwichs(
        idSandwichs Int NOT NULL ,
        nom         Varchar (255) NOT NULL ,
        PRIMARY KEY (idSandwichs )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: stock
#------------------------------------------------------------

CREATE TABLE stock(
        quantite  Int NOT NULL ,
        idProduit Int NOT NULL ,
        PRIMARY KEY (idProduit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: caisseTresorier
#------------------------------------------------------------

CREATE TABLE caisseTresorier(
        idCaisse   Int NOT NULL ,
        value      Float NOT NULL ,
        dateCaisse Datetime NOT NULL ,
        PRIMARY KEY (idCaisse )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: vente
#------------------------------------------------------------

CREATE TABLE vente(
        idVente   Int NOT NULL ,
        dateVente Datetime ,
        idUser    Int NOT NULL ,
        idProduit Int NOT NULL ,
        PRIMARY KEY (idUser ,idProduit )
)ENGINE=InnoDB;

ALTER TABLE stock ADD CONSTRAINT FK_stock_idProduit FOREIGN KEY (idProduit) REFERENCES produit(idProduit);
ALTER TABLE vente ADD CONSTRAINT FK_vente_idUser FOREIGN KEY (idUser) REFERENCES utilisateurs(idUser);
ALTER TABLE vente ADD CONSTRAINT FK_vente_idProduit FOREIGN KEY (idProduit) REFERENCES produit(idProduit);


INSERT INTO utilisateurs (idUser, username, password, groupe) VALUES (0, "root", MD5("root"), 2);
INSERT INTO utilisateurs (idUser, username, password, groupe) VALUES (1, "prez", MD5("cyril"), 2);
INSERT INTO utilisateurs (idUser, username, password, groupe) VALUES (2, "trez", MD5("baptiste"), 2);
INSERT INTO utilisateurs (idUser, username, password, groupe) VALUES (3, "vicetrez", MD5("jimmy"), 1);
INSERT INTO utilisateurs (idUser, username, password, groupe) VALUES (4, "adem", MD5("adem"), 0);

INSERT INTO produit (idProduit, nom, prix, type) VALUES (0, "coca cola", 0.5, 1);
INSERT INTO produit (idProduit, nom, prix, type) VALUES (1, "coca cola light", 0.5, 1);
INSERT INTO produit (idProduit, nom, prix, type) VALUES (2, "coca cola zero", 0.5, 1);
INSERT INTO produit (idProduit, nom, prix, type) VALUES (3, "kinder counrty", 0.3, 2);
INSERT INTO produit (idProduit, nom, prix, type) VALUES (4, "photocopie / impression", 0.05, 3);

INSERT INTO stock (quantite, idProduit) VALUES (42, 0);

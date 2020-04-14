CREATE DATABASE crudapi;

use crudapi;
create table tbl_Role
(
RolaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
NazivRole VARCHAR(20),
KreiranaU DATE,
AZURIRANAU DATE
);
create table tbl_Korisnik
(
KorisnikID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
Ime VARCHAR(20),
Prezime VARCHAR(20),
Godine INT,
BrojKartice VARCHAR(8)
);
create table tbl_KorisnickeRole
(
KorisnickaRolaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
foreign key(KorisnikID) REFERENCES tbl_Korisnik(KorisnikID),
foreign key(RolaID) REFERENCES tbl_Role(RolaID)
);

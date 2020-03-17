CREATE SCHEMA IF NOT EXISTS `BANK_S_DB` DEFAULT CHARACTER SET utf8;
USE `BANK_S_DB`;
CREATE TABLE Person
(
IDPerson INT NOT NULL AUTO_INCREMENT,
FirstName VARCHAR(25) NOT NULL,
LastName VARCHAR(25) NOT NULL,
Age INT NOT NULL CHECK(Age>17),
Country VARCHAR(20) NOT NULL,
Email VARCHAR(30) NOT NULL,
PRIMARY KEY (IDPerson)
)ENGINE = InnoDB AUTO_INCREMENT=100 ;

CREATE TABLE Bank
(
IDBank INT AUTO_INCREMENT,
BankName VARCHAR(25) NOT NULL,
Country VARCHAR(25) NOT NULL,
City VARCHAR(25) NOT NULL,
Street VARCHAR(25) NOT NULL,
StreetNumber INT  NOT NULL,
PRIMARY KEY (IDBank,BankName),
UNIQUE(BankName)
)ENGINE = InnoDB AUTO_INCREMENT=12222;

CREATE TABLE ClientAccount (
    Login INT NOT NULL AUTO_INCREMENT,
    Parole VARCHAR(25) NOT NULL,
    IDClient INT NOT NULL,
    PRIMARY KEY (Login),
    CONSTRAINT  FOREIGN KEY (IDClient)
        REFERENCES Person(IDPerson),
    CONSTRAINT  FOREIGN KEY (IDClient)
        REFERENCES Bank(IDBank),
	UNIQUE(IDClient)
)  ENGINE=INNODB AUTO_INCREMENT=9000;


CREATE TABLE Operation
(
IDOperation INT NOT NULL AUTO_INCREMENT,
BankName VARCHAR(25) NOT NULL,
IDClient INT NOT NULL,
Amount INT NOT NULL,
Percent DOUBLE NOT NULL,
Currency VARCHAR(10) NOT NULL,
Date_Issue DATE NOT NULL,
Date_Return DATE NOT NULL,
TypeOperation VARCHAR(15) NOT NULL,
PRIMARY KEY (IDOperation),
CONSTRAINT fk_operation_clientaccount FOREIGN KEY (IDClient)
     REFERENCES ClientAccount(IDClient),
CONSTRAINT  fk_operation_bank FOREIGN KEY (BankName)
    REFERENCES  Bank (BankName)
)ENGINE = InnoDB AUTO_INCREMENT=33331;

INSERT INTO Bank VALUES 
(12222,'Private Bank','Ukraine','Kyiv','Hreshchatuc', 10),
(12223,'OTP Bank','Ukraine','Lviv','Zelena', 21),
(12224,'Future Bank','Ukraine','Ternopil','Bahata', 34);


DELIMITER //
CREATE PROCEDURE InsertPerson
(
IN FirstNamePersonIn varchar(25),
IN LastNameIn varchar(45)
)
BEGIN
	DECLARE msg varchar(40);

  -- checks for present
  IF NOT EXISTS( SELECT * FROM Person WHERE FirstName=FirstNamePersonIn AND LastName=LastNameIn)
  THEN SET msg = 'This Person is absent';

    ELSEIF EXISTS( SELECT * FROM Person WHERE FirstName=FirstNamePersonIn AND LastName=LastNameIn)
  THEN SET msg = 'This Person already exists';

	END IF;

	SELECT msg AS msg;

END //

CREATE PROCEDURE InsertBank
(
IN BankNameIn varchar(25)
)
BEGIN
	DECLARE msg varchar(40);
	IF EXISTS( SELECT * FROM Bank WHERE BankName=BankNameIn)
	THEN SET msg = 'This bank already exists';
    ELSEIF NOT EXISTS(SELECT * FROM Bank WHERE BankName=BankNameIn)
    THEN SET msg = 'This bank is absent';
	END IF;
	SELECT msg AS msg;
END //

CREATE PROCEDURE TakeLoan
(
IN IDClientIN INT,
IN BankNameIN VARCHAR(15),
IN TypeIN VARCHAR(15)
)
BEGIN
	DECLARE msg varchar(60);
  -- checks if there are this combination already
	IF EXISTS( SELECT * FROM Operation l
		WHERE l.TypeOperation=TypeIN AND l.BankName =BankNameIN AND l.IDClient = (SELECT IDPerson FROM Person WHERE IDPerson=IDClientIN) OR l.IDClient=(SELECT IDBank FROM Bank WHERE IDBank=IDClientIN))
       THEN SET msg = 'This Client already has LOAN in this Bank';
	ELSEIF NOT EXISTS( SELECT * FROM Operation l
		WHERE  l.TypeOperation=TypeIN AND l.BankName =BankNameIN AND l.IDClient = (SELECT IDPerson FROM Person WHERE IDPerson=IDClientIN) OR l.IDClient=(SELECT IDBank FROM Bank WHERE IDBank=IDClientIN))
	THEN SET msg = 'This Client can take LOAN in this Bank';
    END IF;
	SELECT msg AS msg;
END //
DELIMITER ;
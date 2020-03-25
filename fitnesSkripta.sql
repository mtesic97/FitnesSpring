-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fitnes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fitnes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnes` DEFAULT CHARACTER SET latin1 ;
USE `fitnes` ;

-- -----------------------------------------------------
-- Table `fitnes`.`clan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnes`.`clan` (
  `idclan` INT(11) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idclan`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fitnes`.`trener`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnes`.`trener` (
  `idtrener` INT(11) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtrener`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fitnes`.`komentar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnes`.`komentar` (
  `idkomentar` INT(11) NOT NULL AUTO_INCREMENT,
  `tekst` VARCHAR(45) NOT NULL,
  `idClan` INT(11) NOT NULL,
  `idTrener` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idkomentar`),
  INDEX `idClan_idx` (`idClan` ASC) VISIBLE,
  INDEX `idTrener_idx` (`idTrener` ASC) VISIBLE,
  CONSTRAINT `idClan`
    FOREIGN KEY (`idClan`)
    REFERENCES `fitnes`.`clan` (`idclan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTrener`
    FOREIGN KEY (`idTrener`)
    REFERENCES `fitnes`.`trener` (`idtrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fitnes`.`radnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnes`.`radnik` (
  `idradnik` INT(11) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idradnik`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fitnes`.`trening`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnes`.`trening` (
  `idtrening` INT(11) NOT NULL AUTO_INCREMENT,
  `idClana` INT(11) NOT NULL,
  `idTrenera` INT(11) NOT NULL,
  `datumTreninga` VARCHAR(45) NOT NULL,
  `vremeTreninga` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtrening`),
  INDEX `idClana_idx` (`idClana` ASC) ,
  INDEX `idTrenera_idx` (`idTrenera` ASC) ,
  CONSTRAINT `idClana`
    FOREIGN KEY (`idClana`)
    REFERENCES `fitnes`.`clan` (`idclan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTrenera`
    FOREIGN KEY (`idTrenera`)
    REFERENCES `fitnes`.`trener` (`idtrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

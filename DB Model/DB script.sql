-- MySQL Script generated by MySQL Workbench
-- 07/01/17 20:55:52
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema expense_tracker
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema expense_tracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `expense_tracker` DEFAULT CHARACTER SET utf8 ;
USE `expense_tracker` ;

-- -----------------------------------------------------
-- Table `expense_tracker`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense_tracker`.`Category` ;

CREATE TABLE IF NOT EXISTS `expense_tracker`.`Category` (
  `idCategory` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(45) NOT NULL,
  `CategoryDescription` VARCHAR(45) NULL,
  PRIMARY KEY (`idCategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expense_tracker`.`Store`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense_tracker`.`Store` ;

CREATE TABLE IF NOT EXISTS `expense_tracker`.`Store` (
  `idStore` INT NOT NULL AUTO_INCREMENT,
  `storeName` VARCHAR(45) NOT NULL,
  `storeLocation` VARCHAR(45) NULL,
  PRIMARY KEY (`idStore`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expense_tracker`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense_tracker`.`User` ;

CREATE TABLE IF NOT EXISTS `expense_tracker`.`User` (
  `idUser` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expense_tracker`.`Expense`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense_tracker`.`Expense` ;

CREATE TABLE IF NOT EXISTS `expense_tracker`.`Expense` (
  `idExpense` INT NOT NULL AUTO_INCREMENT,
  `expenseDate` DATETIME(4) NOT NULL,
  `ammount` DECIMAL(4) NOT NULL,
  `expenseDescription` VARCHAR(45) NULL,
  `Category_idCategory` INT NOT NULL,
  `Store_idStore` INT NOT NULL,
  `User_idUser` INT NOT NULL,
  PRIMARY KEY (`idExpense`),
  INDEX `fk_Expense_Category_idx` (`Category_idCategory` ASC),
  INDEX `fk_Expense_Store1_idx` (`Store_idStore` ASC),
  INDEX `fk_Expense_User1_idx` (`User_idUser` ASC),
  CONSTRAINT `fk_Expense_Category`
    FOREIGN KEY (`Category_idCategory`)
    REFERENCES `expense_tracker`.`Category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Expense_Store1`
    FOREIGN KEY (`Store_idStore`)
    REFERENCES `expense_tracker`.`Store` (`idStore`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Expense_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `expense_tracker`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

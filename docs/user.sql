-- MySQL Script generated by MySQL Workbench
-- 03/15/17 13:23:20
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lte_failure_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `lte_failure_system`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lte_failure_system`.`users` ;

CREATE TABLE IF NOT EXISTS `lte_failure_system`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,  
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_role` ENUM('administrator', 'support_engineer', 'network_engineer', 'customer_service') NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`user_name` ASC) 
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

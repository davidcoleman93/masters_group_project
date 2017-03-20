
--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `lte_failure_system`.`users` ;

CREATE TABLE `lte_failure_system`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `lte_failure_system`.`role_type` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
--
-- Table structure for table `role_type`
--	
	
DROP TABLE IF EXISTS `lte_failure_system`.`role_type` ;

  CREATE TABLE `lte_failure_system`.`role_type` (
  `role_id` INT NOT NULL,
  `role_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`));
  
  
  

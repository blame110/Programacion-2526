-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema peliculas_marcadiz
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `peliculas_marcadiz` ;

-- -----------------------------------------------------
-- Schema peliculas_marcadiz
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `peliculas_marcadiz` DEFAULT CHARACTER SET utf8 ;
USE `peliculas_marcadiz` ;

-- -----------------------------------------------------
-- Table `peliculas_marcadiz`.`pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculas_marcadiz`.`pelicula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NULL,
  `duracion` INT NULL,
  `clasificacion` INT NULL,
  `sinopsis` VARCHAR(505) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peliculas_marcadiz`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculas_marcadiz`.`actor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(500) NULL,
  `nacionalidad` VARCHAR(45) NULL,
  `fec_nac` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peliculas_marcadiz`.`actor_has_pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculas_marcadiz`.`actor_has_pelicula` (
  `actor_id` INT NOT NULL,
  `pelicula_id` INT NOT NULL,
  `personaje` VARCHAR(45) NULL,
  PRIMARY KEY (`actor_id`, `pelicula_id`),
  CONSTRAINT `fk_actor_has_pelicula_actor`
    FOREIGN KEY (`actor_id`)
    REFERENCES `peliculas_marcadiz`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actor_has_pelicula_pelicula1`
    FOREIGN KEY (`pelicula_id`)
    REFERENCES `peliculas_marcadiz`.`pelicula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peliculas_marcadiz`.`cine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculas_marcadiz`.`cine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(1000) NULL,
  `localidades` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peliculas_marcadiz`.`pelicula_has_cine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculas_marcadiz`.`pelicula_has_cine` (
  `pelicula_id` INT NOT NULL,
  `cine_id` INT NOT NULL,
  PRIMARY KEY (`pelicula_id`, `cine_id`),
  CONSTRAINT `fk_pelicula_has_cine_pelicula1`
    FOREIGN KEY (`pelicula_id`)
    REFERENCES `peliculas_marcadiz`.`pelicula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pelicula_has_cine_cine1`
    FOREIGN KEY (`cine_id`)
    REFERENCES `peliculas_marcadiz`.`cine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `peliculas_marcadiz`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculas_marcadiz`.`sala` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `localidades` INT NULL,
  `tipo_sala` INT NULL,
  `cine_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cine_id`),
  CONSTRAINT `fk_sala_cine1`
    FOREIGN KEY (`cine_id`)
    REFERENCES `peliculas_marcadiz`.`cine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

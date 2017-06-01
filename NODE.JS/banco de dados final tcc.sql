-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema projetotcc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projetotcc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projetotcc` DEFAULT CHARACTER SET utf8 ;
USE `projetotcc` ;

-- -----------------------------------------------------
-- Table `projetotcc`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetotcc`.`curso` (
  `idcurso` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `turno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetotcc`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetotcc`.`aluno` (
  `idaluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(40) NOT NULL,
  `idcurso` INT NOT NULL,
  PRIMARY KEY (`idaluno`),
  INDEX `fk_aluno_curso1_idx` (`idcurso` ASC),
  CONSTRAINT `fk_aluno_curso1`
    FOREIGN KEY (`idcurso`)
    REFERENCES `projetotcc`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetotcc`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetotcc`.`professor` (
  `idprofessor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`idprofessor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetotcc`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetotcc`.`disciplina` (
  `iddisciplina` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `idcurso` INT NOT NULL,
  PRIMARY KEY (`iddisciplina`),
  INDEX `fk_disciplina_curso1_idx` (`idcurso` ASC),
  CONSTRAINT `fk_disciplina_curso1`
    FOREIGN KEY (`idcurso`)
    REFERENCES `projetotcc`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetotcc`.`aluno_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetotcc`.`aluno_disciplina` (
  `iddisciplina` INT NOT NULL,
  `idaluno` INT NOT NULL,
  `nota1` DOUBLE NULL,
  `nota2` DOUBLE NULL,
  PRIMARY KEY (`iddisciplina`, `idaluno`),
  INDEX `fk_disciplina_has_aluno_aluno1_idx` (`idaluno` ASC),
  INDEX `fk_disciplina_has_aluno_disciplina1_idx` (`iddisciplina` ASC),
  CONSTRAINT `fk_disciplina_has_aluno_disciplina1`
    FOREIGN KEY (`iddisciplina`)
    REFERENCES `projetotcc`.`disciplina` (`iddisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_aluno_aluno1`
    FOREIGN KEY (`idaluno`)
    REFERENCES `projetotcc`.`aluno` (`idaluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetotcc`.`professor_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetotcc`.`professor_disciplina` (
  `iddisciplina` INT NOT NULL,
  `idprofessor` INT NOT NULL,
  PRIMARY KEY (`iddisciplina`, `idprofessor`),
  INDEX `fk_disciplina_has_professor_professor1_idx` (`idprofessor` ASC),
  INDEX `fk_disciplina_has_professor_disciplina1_idx` (`iddisciplina` ASC),
  CONSTRAINT `fk_disciplina_has_professor_disciplina1`
    FOREIGN KEY (`iddisciplina`)
    REFERENCES `projetotcc`.`disciplina` (`iddisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_professor_professor1`
    FOREIGN KEY (`idprofessor`)
    REFERENCES `projetotcc`.`professor` (`idprofessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

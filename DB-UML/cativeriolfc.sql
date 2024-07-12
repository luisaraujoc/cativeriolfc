-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11/07/2024 às 04:03
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cativeriolfc`
--
CREATE DATABASE IF NOT EXISTS `cativeriolfc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `cativeriolfc`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `current_player`
--

DROP TABLE IF EXISTS `current_player`;
CREATE TABLE IF NOT EXISTS `current_player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gameday_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gameday_person` (`gameday_id`),
  KEY `fk_person_gameday` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Estrutura para tabela `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` bigint(20) NOT NULL,
  `gameDay` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `game`
--

INSERT INTO `game` (`id`, `gameDay`) VALUES
(1, '2024-07-01'),
(2, '2024-07-02'),
(3, '2024-07-03');

-- --------------------------------------------------------

--
-- Estrutura para tabela `gameday`
--

DROP TABLE IF EXISTS `gameday`;
CREATE TABLE IF NOT EXISTS `gameday` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Estrutura para tabela `gameday_team`
--

DROP TABLE IF EXISTS `gameday_team`;
CREATE TABLE IF NOT EXISTS `gameday_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gameDay_id` bigint(20) DEFAULT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team_gameday` (`team_id`),
  KEY `fk_gameday_team` (`gameDay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Estrutura para tabela `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `host_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Guest_Host` (`host_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `guest`
--

INSERT INTO `guest` (`id`, `name`, `host_id`) VALUES
(1, 'Guest One', 1),
(2, 'Guest Two', 2),
(3, 'Guest Three', 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cpf` char(11) NOT NULL,
  `tel` char(14) DEFAULT NULL,
  `kindPerson` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `person`
--

INSERT INTO `person` (`id`, `name`, `cpf`, `tel`, `kindPerson`) VALUES
(1, 'John Doe', '12345678901', '555-1234', 'USER'),
(2, 'Jane Smith', '23456789012', '555-5678', 'ADMIN'),
(3, 'Alice Johnson', '34567890123', '555-8765', 'USER');

-- --------------------------------------------------------

--
-- Estrutura para tabela `scout`
--

DROP TABLE IF EXISTS `scout`;
CREATE TABLE IF NOT EXISTS `scout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Team_id` bigint(20) NOT NULL,
  `Game_id` bigint(20) NOT NULL,
  `Person_id` bigint(20) NOT NULL,
  `gol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Scout_Team1_idx` (`Team_id`),
  KEY `fk_Scout_Game1_idx` (`Game_id`),
  KEY `fk_Scout_Person1_idx` (`Person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `scout`
--

INSERT INTO `scout` (`id`, `Team_id`, `Game_id`, `Person_id`, `gol`) VALUES
(1, 1, 1, 1, 2),
(2, 1, 2, 2, 1),
(3, 2, 3, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `team`
--

DROP TABLE IF EXISTS `team`;
CREATE TABLE IF NOT EXISTS `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `team`
--

INSERT INTO `team` (`id`, name) VALUES
(1, 'Team A'),
(2, 'Team B');

-- --------------------------------------------------------

--
-- Estrutura para tabela `team_person`
--

DROP TABLE IF EXISTS `team_person`;
CREATE TABLE IF NOT EXISTS `team_person` (
  `id` bigint(20) NOT NULL,
  `time_id` bigint(20) NOT NULL,
  `current_player_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_time_id` (`time_id`),
  KEY `fk_currentPlayer_Team` (`current_player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `team_person`
--

INSERT INTO `team_person` (`id`, `time_id`, `current_player_id`) VALUES
(1, 1, NULL),
(2, 1, NULL),
(3, 2, NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` char(255) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `person_id` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `user`
--

INSERT INTO `user` (`id`, `userName`, `password`, `status`, `person_id`) VALUES
(1, 'johndoe', 'password12', 1, 1),
(2, 'janesmith', 'password45', 1, 2),
(3, 'alicejohnson', 'password78', 0, 3);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `current_player`
--
ALTER TABLE `current_player`
  ADD CONSTRAINT `fk_gameday_person` FOREIGN KEY (`gameday_id`) REFERENCES `gameday` (`id`),
  ADD CONSTRAINT `fk_person_gameday` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Restrições para tabelas `gameday_team`
--
ALTER TABLE `gameday_team`
  ADD CONSTRAINT `fk_gameday_team` FOREIGN KEY (`gameDay_id`) REFERENCES `gameday` (`id`),
  ADD CONSTRAINT `fk_team_gameday` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`);

--
-- Restrições para tabelas `guest`
--
ALTER TABLE `guest`
  ADD CONSTRAINT `fk_Guest_Host` FOREIGN KEY (`host_id`) REFERENCES `person` (`id`);

--
-- Restrições para tabelas `scout`
--
ALTER TABLE `scout`
  ADD CONSTRAINT `fk_Scout_Game` FOREIGN KEY (`Game_id`) REFERENCES `game` (`id`),
  ADD CONSTRAINT `fk_Scout_Person` FOREIGN KEY (`Person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `fk_Scout_Team` FOREIGN KEY (`Team_id`) REFERENCES `team` (`id`);

--
-- Restrições para tabelas `team_person`
--
ALTER TABLE `team_person`
  ADD CONSTRAINT `fk_TeamPerson_Team` FOREIGN KEY (`time_id`) REFERENCES `team` (`id`),
  ADD CONSTRAINT `fk_currentPlayer_Team` FOREIGN KEY (`current_player_id`) REFERENCES `current_player` (`id`);

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_Person_User` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

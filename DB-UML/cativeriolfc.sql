-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09/07/2024 às 00:29
-- Versão do servidor: 8.0.37
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cativeriolfc2`
--
CREATE DATABASE IF NOT EXISTS `cativeriolfc2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `cativeriolfc2`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` bigint NOT NULL,
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
-- Estrutura para tabela `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `host_id` bigint NOT NULL,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `cpf` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `tel` char(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `kindPerson` ENUM('ADMIN', 'USER') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
  `id` int NOT NULL AUTO_INCREMENT,
  `Team_id` bigint NOT NULL,
  `Game_id` bigint NOT NULL,
  `Person_id` bigint NOT NULL,
  `gol` int DEFAULT NULL,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `team`
--

INSERT INTO `team` (`id`, `nome`) VALUES
(1, 'Team A'),
(2, 'Team B');

-- --------------------------------------------------------

--
-- Estrutura para tabela `team_person`
--

DROP TABLE IF EXISTS `team_person`;
CREATE TABLE IF NOT EXISTS `team_person` (
  `id` bigint NOT NULL,
  `time_id` bigint NOT NULL,
  `person_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_time_id` (`time_id`),
  KEY `fk_person_id` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `team_person`
--

INSERT INTO `team_person` (`id`, `time_id`, `person_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `password` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `person_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `person_id` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Despejando dados para a tabela `user`
--

INSERT INTO `user` (`id`, `userName`, `password`, `status`, `person_id`) VALUES
(1, 'johndoe', 'password123', 1, 1),
(2, 'janesmith', 'password456', 1, 2),
(3, 'alicejohnson', 'password789', 0, 3);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `guest`
--
ALTER TABLE `guest`
  ADD CONSTRAINT `fk_Guest_Host` FOREIGN KEY (`host_id`) REFERENCES `person` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Restrições para tabelas `scout`
--
ALTER TABLE `scout`
  ADD CONSTRAINT `fk_Scout_Game` FOREIGN KEY (`Game_id`) REFERENCES `game` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_Scout_Person` FOREIGN KEY (`Person_id`) REFERENCES `person` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_Scout_Team` FOREIGN KEY (`Team_id`) REFERENCES `team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Restrições para tabelas `team_person`
--
ALTER TABLE `team_person`
  ADD CONSTRAINT `fk_TeamPerson_Person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_TeamPerson_Team` FOREIGN KEY (`time_id`) REFERENCES `team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_Person_User` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

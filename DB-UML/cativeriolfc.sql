-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08/07/2024 às 15:27
-- Versão do servidor: 8.0.37
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "-03:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cativeriolfc`
--

CREATE DATABASE IF NOT EXISTS `cativeriolfc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cativeriolfc`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `timeHome_id` bigint NOT NULL,
                                      `timeVisitor_id` bigint NOT NULL,
                                      `golA` int DEFAULT NULL,
                                      `golB` int DEFAULT NULL,
                                      PRIMARY KEY (`id`),
    KEY `fk_timeHome_id` (`timeHome_id`),
    KEY `fk_timeVisitor_id` (`timeVisitor_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
                                       `id` bigint NOT NULL AUTO_INCREMENT,
                                       `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `host_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`),
    UNIQUE KEY `host_id` (`host_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `cpf` char(11) COLLATE utf8mb4_general_ci NOT NULL,
    `tel` char(14) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `kindPerson` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time`
--

DROP TABLE IF EXISTS `time`;
CREATE TABLE IF NOT EXISTS `time` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `nome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time_person`
--

DROP TABLE IF EXISTS `time_person`;
CREATE TABLE IF NOT EXISTS `time_person` (
                                             `id` bigint NOT NULL,
                                             `time_id` bigint NOT NULL,
                                             `person_id` bigint NOT NULL,
                                             PRIMARY KEY (`id`),
    KEY `fk_time_id` (`time_id`),
    KEY `fk_person_id` (`person_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `userName` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `password` char(30) COLLATE utf8mb4_general_ci NOT NULL,
    `status` tinyint(1) DEFAULT NULL,
    `person_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `userName` (`userName`),
    UNIQUE KEY `person_id` (`person_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `game`
--
ALTER TABLE `game`
    ADD CONSTRAINT `fk_timeHome_id` FOREIGN KEY (`timeHome_id`) REFERENCES `time` (`id`),
  ADD CONSTRAINT `fk_timeVisitor_id` FOREIGN KEY (`timeVisitor_id`) REFERENCES `time` (`id`);

--
-- Restrições para tabelas `guest`
--
ALTER TABLE `guest`
    ADD CONSTRAINT `fk_host_id` FOREIGN KEY (`host_id`) REFERENCES `person` (`id`);

--
-- Restrições para tabelas `time_person`
--
ALTER TABLE `time_person`
    ADD CONSTRAINT `fk_time_id` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`),
  ADD CONSTRAINT `fk_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
    ADD CONSTRAINT `fk_personUser_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08/07/2024 às 15:27
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
-- Banco de dados: `cativeriolfc`
--

CREATE DATABASE IF NOT EXISTS `cativeriolfc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cativeriolfc`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `timeHome_id` bigint NOT NULL,
                                      `timeVisitor_id` bigint NOT NULL,
                                      `golA` int DEFAULT NULL,
                                      `golB` int DEFAULT NULL,
                                      PRIMARY KEY (`id`),
    KEY `fk_timeHome_id` (`timeHome_id`),
    KEY `fk_timeVisitor_id` (`timeVisitor_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
                                       `id` bigint NOT NULL AUTO_INCREMENT,
                                       `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `host_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`),
    UNIQUE KEY `host_id` (`host_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `cpf` char(11) COLLATE utf8mb4_general_ci NOT NULL,
    `tel` char(14) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `kindPerson` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time`
--

DROP TABLE IF EXISTS `time`;
CREATE TABLE IF NOT EXISTS `time` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `nome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time_person`
--

DROP TABLE IF EXISTS `time_person`;
CREATE TABLE IF NOT EXISTS `time_person` (
                                             `id` bigint NOT NULL,
                                             `time_id` bigint NOT NULL,
                                             `person_id` bigint NOT NULL,
                                             PRIMARY KEY (`id`),
    KEY `fk_time_id` (`time_id`),
    KEY `fk_person_id` (`person_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `userName` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `password` char(30) COLLATE utf8mb4_general_ci NOT NULL,
    `status` tinyint(1) DEFAULT NULL,
    `person_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `userName` (`userName`),
    UNIQUE KEY `person_id` (`person_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `game`
--
ALTER TABLE `game`
    ADD CONSTRAINT `fk_timeHome_id` FOREIGN KEY (`timeHome_id`) REFERENCES `time` (`id`),
  ADD CONSTRAINT `fk_timeVisitor_id` FOREIGN KEY (`timeVisitor_id`) REFERENCES `time` (`id`);

--
-- Restrições para tabelas `guest`
--
ALTER TABLE `guest`
    ADD CONSTRAINT `fk_host_id` FOREIGN KEY (`host_id`) REFERENCES `person` (`id`);

--
-- Restrições para tabelas `time_person`
--
ALTER TABLE `time_person`
    ADD CONSTRAINT `fk_time_id` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`),
  ADD CONSTRAINT `fk_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
    ADD CONSTRAINT `fk_personUser_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

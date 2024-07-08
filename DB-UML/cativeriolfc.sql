-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08/07/2024 às 04:35
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

-- --------------------------------------------------------

--
-- Estrutura para tabela `game`
--

CREATE TABLE `game` (
  `id` bigint(20) NOT NULL,
  `timeHome_id` bigint(20) NOT NULL,
  `timeVisitor_id` bigint(20) NOT NULL,
  `golA` int(11) DEFAULT NULL,
  `golB` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `guest`
--

CREATE TABLE `guest` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `host_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cpf` char(11) NOT NULL,
  `tel` char(14) DEFAULT NULL,
  `kindPerson` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time`
--

CREATE TABLE `time` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time_person`
--

CREATE TABLE `time_person` (
  `id` bigint(20) NOT NULL,
  `time_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `password` char(30) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `person_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_timeHome_id` (`timeHome_id`),
  ADD KEY `fk_timeVisitor_id` (`timeVisitor_id`);

--
-- Índices de tabela `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `host_id` (`host_id`);

--
-- Índices de tabela `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `time_person`
--
ALTER TABLE `time_person`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_time_id` (`time_id`);

--
-- Índices de tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`),
  ADD UNIQUE KEY `person_id` (`person_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `game`
--
ALTER TABLE `game`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `guest`
--
ALTER TABLE `guest`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `person`
--
ALTER TABLE `person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `time`
--
ALTER TABLE `time`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `fk_time_id` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`);

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

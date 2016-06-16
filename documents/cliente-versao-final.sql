-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- Servidor: mysql04-farm57.uni5.net
-- Tempo de Geração: Jun 16, 2016 as 12:23 PM
-- Versão do Servidor: 5.6.24
-- Versão do PHP: 5.3.28

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `testeplanos05`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) DEFAULT NULL,
  `sobrenome` varchar(150) DEFAULT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `cpf` varchar(18) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `id_conta` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_to_conta_id_idx` (`id_conta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `sobrenome`, `rg`, `cpf`, `endereco`, `id_conta`) VALUES
(1, 'Bruno Henrique', 'Woisa', '11.111.111-1', '080.272.809-07', 'Rua das Andorinhas, 1500', NULL),
(2, 'Guilherme', 'Budnieswski', '063.538.649-65', '012.840.354-00', 'Rua das Flores, 2503', 5),
(3, 'Fabiano Sarzi', 'Sartori', '12.945.644-00', '321.963.147-00', 'Rua Javari, 350', NULL),
(4, 'Vera Lúcia Lerias da', 'Silva', '022.325.AS5-06', '753.951.852-25', 'Rua Lindóia, 94', NULL),
(5, 'Victor', 'Fernandez', '072.854.9AQ-07', '616.750.161-00', 'Rua União da Vitória, 98', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE IF NOT EXISTS `conta` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_tipo` int(10) unsigned NOT NULL,
  `saldo` double DEFAULT NULL,
  `limite` double DEFAULT NULL,
  `montante_minimo` double DEFAULT NULL,
  `deposito_minimo` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_conta_to_conta_tipo_id_idx` (`id_tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id`, `id_tipo`, `saldo`, `limite`, `montante_minimo`, `deposito_minimo`) VALUES
(1, 1, 100, 3000, 0, 0),
(2, 2, 3.5, 0, 100, 100),
(3, 2, 100, 0, 100, 100),
(4, 2, 100, 0, 100, 100),
(5, 2, 100, 0, 100, 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta_tipo`
--

CREATE TABLE IF NOT EXISTS `conta_tipo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `conta_tipo`
--

INSERT INTO `conta_tipo` (`id`, `nome`) VALUES
(1, 'Conta Corrente'),
(2, 'Conta Investimento');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_to_conta_id` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `conta`
--
ALTER TABLE `conta`
  ADD CONSTRAINT `fk_conta_to_conta_tipo_id` FOREIGN KEY (`id_tipo`) REFERENCES `conta_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

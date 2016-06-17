-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- Servidor: mysql04-farm57.uni5.net
-- Tempo de Geração: Jun 17, 2016 as 12:34 PM
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=348 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `sobrenome`, `rg`, `cpf`, `endereco`, `id_conta`) VALUES
(188, 'Félix', 'Madureira', '18.363.127-4', '803.177.671-78', 'Rua Jornalista Henrique Cordeiro', NULL),
(189, 'Zuleica', 'Duarte', '40.796.968-9', '280.534.194-53', 'Rua Professora Julieta Caldas Ferraz', NULL),
(190, 'Belchior', 'Caneira', '24.303.754-5', '996.558.051-07', 'Rua Sergio Saleh Riman', NULL),
(191, 'Ágata', 'Gago', '01.398.979-8', '517.177.643-12', 'Rua Senador Euzebio', 20),
(192, 'Jacinta', 'Franca', '96.836.990-7', '933.955.024-22', 'Alameda Santo Angelo', NULL),
(193, 'Adão', 'Vargas', '93.676.855-9', '896.547.644-58', 'Amaro Damasio 210 Bl 14 Ap 003', NULL),
(194, 'Lucas', 'Rego', '39.198.501-8', '796.118.561-56', 'Rua Walter Kaufmann', 0),
(195, 'Pedro', 'Macieira', '64.726.908-1', '305.312.987-60', 'Rua Sotero José Do Bonfim', 0),
(196, 'Brites', 'Quirino', '75.663.368-9', '092.864.785-42', 'Rua Paulino Ayres De Aguirre', NULL),
(197, 'Roquita', 'Valgueiro', '78.791.735-8', '077.667.403-03', 'Quadra Qn 5 Conjunto 11', NULL),
(198, 'Lucília', 'Pêcego', '55.296.617-1', '221.614.959-41', 'Rua Francisco De Almeida', NULL),
(199, 'Honorina', 'Ferro', '93.039.727-7', '692.657.926-12', 'Rua Ceciliano Tavares', NULL),
(200, 'Solano', 'Alcoforado', '74.795.392-8', '342.576.998-76', 'Rua Doutor José Elias', NULL),
(201, 'Rodolfo', 'Malafaia', '34.591.433-7', '029.601.522-98', 'Esmerindo Leite Ribeiro', NULL),
(202, 'Adosindo', 'Vilaça', '84.784.583-3', '513.536.832-90', 'Rua Euclides Da Cunha', NULL),
(203, 'Epaminondas', 'Fernandes', '19.835.897-9', '144.865.980-91', 'Rua Orlando Rodrigues', NULL),
(204, 'Caím', 'Gabeira', '00.287.460-5', '603.391.831-28', 'Rua Victorino Bento Lorena Da Silva', NULL),
(205, 'Udo', 'Loureiro', '66.649.627-0', '813.886.442-74', 'Rua Gaspar Ricardo', NULL),
(206, 'Leandro', 'Bessa', '86.203.737-7', '933.246.618-11', 'Rua Abraham Bloemaert', NULL),
(207, 'Renato', 'Antas', '00.920.619-3', '427.012.453-97', 'Rua Professora Julieta Caldas Ferraz', NULL),
(208, 'Adélia', 'Rolim', '59.651.265-4', '473.947.367-41', 'Avenida Bento Amaral Monteiro', NULL),
(209, 'Aarão', 'Álvaro', '69.995.113-6', '362.458.668-80', 'Rua Vereador José Joaquim Garcia', NULL),
(210, 'Constantino', 'Esteves', '55.030.529-0', '472.772.169-46', 'Rua Baltazar Da Silveira', NULL),
(211, 'Luís', 'Nazário', '94.093.610-8', '414.147.111-90', 'Travessa Da Generosidade', NULL),
(212, 'Palmiro', 'Frade', '91.795.364-7', '507.132.025-80', 'Rua. Francisco Sanches', NULL),
(213, 'Calisto', 'Pederneiras', '44.461.409-8', '147.680.086-31', 'Borges De Medeiros', NULL),
(214, 'Emanuel', 'Urias', '68.894.179-9', '690.744.357-00', 'Quadra 05 Casa 25 Condomínio Primar', NULL),
(215, 'Lucílio', 'Leiria', '46.231.914-4', '572.027.522-39', 'Avenida Marechal Fiuza De Castro', NULL),
(216, 'Frutuoso', 'Araújo', '27.932.706-5', '070.060.244-55', 'Rua Pedro Boaventura', NULL),
(217, 'Rodolfo', 'Duarte', '00.421.584-0', '560.136.573-35', 'Rua Fritz Plaumann', NULL),
(218, 'Eduarda', 'Bessa', '28.871.035-9', '446.150.576-60', 'Rua Beneamino Giampani', NULL),
(219, 'Constantino', 'Temes', '72.428.339-6', '579.494.853-10', 'Rua Cabo João Fagundes Machado', NULL),
(220, 'Pedro', 'Zarco', '42.464.627-8', '324.721.101-20', 'Rua Bernardino Angelo', 0),
(221, 'Minervina', 'Simão', '66.900.209-8', '867.102.523-37', 'Travessa Filgueiras', NULL),
(222, 'Estefânia', 'Minho', '43.761.938-6', '488.355.858-48', 'Quadra Qr 308 Conjunto G', NULL),
(223, 'Barnabé', 'Inês', '48.092.110-4', '016.377.254-18', 'Quadra Shces Quadra 703 Bloco J', NULL),
(224, 'Milena', 'Maia', '98.245.074-7', '026.743.927-03', 'Rua Rosa Oneda Soligo ', NULL),
(225, 'Alfredo', 'Sequeira', '09.561.198-1', '565.962.702-11', 'Avenida Alberto Byington', NULL),
(226, 'Ermelinda', 'Quaresma', '42.888.485-3', '939.276.307-72', 'Rua Leila Daniel De Castro', NULL),
(227, 'Cândido', 'Farinha', '58.898.980-1', '180.095.657-68', 'Avenida Santa Isabel', NULL),
(228, 'Mamede', 'Silvestre', '51.416.150-1', '410.290.886-24', 'Rua Banco Dos Ingleses', NULL),
(229, 'Gueda', 'Hilário', '73.044.605-2', '094.725.450-17', 'Rua Guilherme Bruschz', NULL),
(230, 'Dalila', 'Espargosa', '42.774.710-3', '777.660.849-10', 'Rua Senador Vergueiro', NULL),
(231, 'Guadalupe', 'Bencatel', '87.331.790-8', '263.121.554-04', 'Rua Antonio Angelo', NULL),
(232, 'Vivaldo', 'Marcondes', '85.429.338-3', '538.930.406-33', 'Rua Elias Farah Badra', NULL),
(233, 'Francisca', 'Bairros', '88.283.183-9', '574.620.124-30', 'Ralzira Ferreira Campos', NULL),
(234, 'Emanuel', 'Sacadura', '65.916.656-6', '979.170.694-86', 'Rua Onze De Novembro', NULL),
(235, 'Boaventura', 'Simões', '70.438.362-3', '516.274.451-45', 'Alameda José Faciola', NULL),
(236, 'Catarina', 'Regueira', '93.848.903-1', '630.284.771-06', 'Avenida General Rondon', NULL),
(237, 'Sandro', 'Rebouças', '45.651.288-6', '168.724.473-11', 'Quadra Qi 31 Bl15 Ap', NULL),
(238, 'Quintiliano', 'Doutel', '67.737.284-0', '292.906.104-92', 'Rua Manuel Cardoso', NULL),
(239, 'Caetano', 'Rios', '98.678.355-2', '072.418.042-79', 'Rua Rubem De Souza', NULL),
(240, 'Magda', 'Paula', '50.775.097-7', '183.479.973-22', 'Rua Justino Martins', NULL),
(241, 'Bibiana', 'Manso', '19.873.866-0', '055.780.871-59', 'Rua Jose Da Costa Mesquita', NULL),
(242, 'Dorindo', 'Lages', '79.829.666-3', '436.859.682-03', 'Conjunto Ipasep Ii Rua We-4', NULL),
(243, 'Deolinda', 'Serpa', '00.178.808-6', '968.626.535-04', 'Rua Dona Margarida De Campos', NULL),
(244, 'Feliciana', 'Beltrão', '81.398.122-6', '629.103.827-70', 'Rua Jc 18 A Qd 11 Lt 10', NULL),
(245, 'Gui', 'Madruga', '71.493.448-1', '712.281.911-66', 'Estrada Da Pedra Branca', NULL),
(246, 'Sílvia', 'Gama', '27.711.004-4', '892.847.014-57', 'Rua Rodolpho Senff', NULL),
(247, 'Vanessa', 'Murtinho', '46.101.573-9', '525.217.452-00', 'Avenida 15 De Novembro 1220', NULL),
(248, 'Aarão', 'Gama', '60.122.297-8', '153.470.649-60', 'Rua João Navarro Botelho', NULL),
(249, 'Antonieta', 'Fortunato', '89.183.640-8', '779.013.762-01', 'Rua José Manoel Voluz', NULL),
(250, 'Henriqueta', 'Luz', '43.029.608-9', '311.723.891-36', 'Rua Antonio Martins', NULL),
(251, 'Tânia', 'Bragança', '23.870.636-1', '314.871.634-52', 'Rua Doutor Luiz Migliano', NULL),
(252, 'Elsa', 'Soverosa', '37.038.714-4', '246.216.439-16', 'Marcionilio Ribeiro Costa', NULL),
(253, 'César', 'Viana', '78.796.963-0', '196.893.558-48', 'Conjunto Cabula Vi', NULL),
(254, 'Rosalinda', 'Luz', '87.647.354-3', '530.882.773-75', 'Rua Doutor José Rufino Bezerra', NULL),
(255, 'Melissa', 'Borba', '26.851.507-3', '312.263.698-04', 'Rua Farme De Amoedo', NULL),
(256, 'Diana', 'Leão', '66.812.301-4', '835.159.841-00', 'Rua Sete De Setembro', NULL),
(257, 'Hermenegildo', 'Salazar', '09.979.625-1', '207.563.792-02', 'Rua Professor Adalberto Nascimento', NULL),
(258, 'Mem', 'Alencar', '69.090.116-0', '496.350.415-43', 'Rua Antonio Lopes Filho', NULL),
(259, 'Adolfo', 'Antas', '45.937.760-8', '505.336.729-96', 'Rua Das Sacramentinas', NULL),
(260, 'Hipólito', 'Carmona', '81.458.253-1', '212.196.133-04', 'Rua Albertino Teixeira Dias', NULL),
(261, 'Gabriela', 'Domingos', '91.336.548-8', '987.508.863-39', 'Rua Governador Valadares', NULL),
(262, 'Lucas', 'Ramalho', '38.371.554-4', '099.370.713-05', 'Rua Carlos Giometti', 0),
(263, 'Soraia', 'Tomé', '04.488.357-7', '499.751.547-78', 'Rua Antônio Gomes Morgado', NULL),
(264, 'Patrício', 'Guerreiro', '27.828.553-3', '500.881.531-85', 'Rua Deputado Nelson Martins', NULL),
(265, 'Corina', 'Santiago', '40.285.537-3', '205.326.711-98', 'Rua José Airton De Castro', NULL),
(266, 'Zuriel', 'Canto', '86.397.625-3', '295.817.282-10', 'Rua Braulio Muniz ', NULL),
(267, 'Lorena', 'Lins', '33.611.648-2', '232.006.073-19', 'Rua Helena Aparecida Secol', NULL),
(268, 'Garibaldo', 'Pires', '78.830.634-9', '739.418.380-75', 'Rodovia Sp 68 Km 253', NULL),
(269, 'Ester', 'Lemes', '67.488.861-6', '993.964.702-60', 'Rodovia Amaral Peixoto', NULL),
(270, 'Ulrico', 'Moreno', '27.426.570-9', '627.533.715-04', 'Rua Vereador Antonio Pinto Coelho ', NULL),
(271, 'Quirina', 'Lousã', '61.706.605-9', '026.025.194-13', 'Rua Nelson Gama De Oliveira', NULL),
(272, 'Dinis', 'Belchiorinho', '47.726.217-5', '481.574.391-67', 'Rua Guilherme Moura', NULL),
(273, 'Ruca', 'Nobre', '99.687.753-1', '670.088.056-40', 'Rua Pedrinho Filho', NULL),
(274, 'Ana', 'Cachoeira', '46.148.417-5', '246.612.039-92', 'Avenida Governador Argemiro De Figueiredo', NULL),
(275, 'Evaristo', 'Simões', '24.348.305-1', '920.852.287-39', 'Quadra Qnn 7 Conjunto K', NULL),
(276, 'Dora', 'Jácome', '69.278.255-7', '666.090.533-24', 'Avenida Beira Lago', NULL),
(277, 'Pandora', 'Vilanova', '83.582.264-5', '886.769.706-45', 'Avenida Nelson Cardoso', NULL),
(278, 'Miguelina', 'Rebotim', '70.244.549-8', '303.172.211-67', 'Avenida Alberto Lamego', NULL),
(279, 'Liliana', 'Homem', '54.714.404-1', '662.171.844-60', 'Rua Paulino Guimarães', NULL),
(280, 'Salomão', 'Arouca', '12.643.849-1', '655.224.338-33', 'Rua Carlos Izino Pereira', NULL),
(281, 'Juliano', 'Valverde', '44.794.457-1', '617.974.852-70', 'Rua Francisco Sgambatt', NULL),
(282, 'Reginaldo', 'Sesimbra', '09.247.549-8', '033.829.755-30', 'Avenida Doutor Adhemar De Barros', NULL),
(283, 'Bibiana', 'Rosário', '93.226.822-9', '160.436.826-80', 'Rua Fernandez Palero', NULL),
(284, 'Celestino', 'Teodoro', '69.460.555-5', '339.556.707-91', 'Loteamento Dona Rosa', NULL),
(285, 'Clementina', 'Lages', '75.941.589-6', '564.865.519-33', 'Avenida Doutor Salvador Rocco', NULL),
(286, 'Serafina', 'Uchoa', '94.511.735-8', '466.590.877-02', 'Rua Sebastiana Lustosa De Freitas', NULL),
(287, 'Eusébio', 'Vale', '00.531.671-7', '362.007.850-58', 'Rua Doutor Antônio Ferreira Inocêncio', NULL),
(288, 'Lucinda', 'Vergueiro', '59.260.283-2', '711.504.188-18', 'Avenida Antônio De Costa', NULL),
(289, 'Ricardo', 'Pedro', '12.223.730-8', '465.215.922-62', 'Rua Carolina Roque', 0),
(290, 'Júlio', 'Lustosa', '97.330.160-6', '380.442.415-58', 'Rua Gomes De Oliveira', NULL),
(291, 'Aniano', 'Damásio', '14.365.634-8', '691.169.026-96', 'Rua Henrique Schaumann', NULL),
(292, 'Íris', 'Telinhos', '52.830.377-4', '616.639.801-87', 'Travessa Orival Marinho', NULL),
(293, 'Armindo', 'Barros', '37.230.322-5', '525.733.026-10', 'Rua Marechal Antônio Sousa', NULL),
(294, 'Catarino', 'Vilela', '49.628.881-0', '121.267.835-45', 'Rua Alceu De Toledo Pontes', NULL),
(295, 'Ulrico', 'Melgaço', '42.113.744-4', '497.785.582-56', 'Rua José Dalla Riva', NULL),
(296, 'Josefa', 'Lage', '47.164.044-9', '414.880.888-70', 'Rua General Carneiro', NULL),
(297, 'Adelina', 'Quadros', '78.382.942-2', '154.643.295-79', 'Rua Das Sacramentinas', NULL),
(298, 'Josias', 'Coronel', '64.272.630-9', '873.144.130-02', 'Travessa João Bonn', NULL),
(299, 'Mem', 'Marreiro', '54.305.735-9', '645.298.307-56', 'Av. Diogo Braga Filho', NULL),
(300, 'Rosa', 'Cisneiros', '26.601.142-9', '169.045.548-94', 'Av. Presidente Vargas ', NULL),
(301, 'Maximiliano', 'Frota', '46.974.123-1', '893.360.528-29', 'Rua Salvador Do Vale', NULL),
(302, 'Gláuber', 'Jácome', '32.418.795-5', '185.808.827-53', 'Rua Jarbas De Carvalho', NULL),
(303, 'Isadora', 'Sobreira', '95.881.044-9', '419.410.343-22', 'Rua Benedicto Milton De Souza Mendes', NULL),
(304, 'Milena', 'Quintão', '06.281.829-5', '453.110.009-37', 'Rua Carolina Machado', NULL),
(305, 'Lucas', 'Gouveia', '59.209.366-9', '602.981.376-58', 'Rua Ernesto Cerreti', 0),
(306, 'Josefa', 'Diegues', '29.337.786-5', '404.427.409-64', 'Rua Ilma Henriques', NULL),
(307, 'Milena', 'Costa', '91.151.218-6', '161.354.513-40', 'Estrada De Sepetiba', NULL),
(308, 'Greice', 'Farias', '56.496.018-4', '364.433.679-28', 'Rua Marechal Taumaturgo De Azevedo', NULL),
(309, 'Ximeno', 'Belém', '44.211.501-0', '128.708.577-64', 'Rua Papa João Xxiii', NULL),
(310, 'Normando', 'Sobral', '63.845.368-7', '982.835.472-16', 'Rua Ascendino Diniz', NULL),
(311, 'Adelaide', 'Vilar', '77.690.617-2', '065.283.020-06', 'Rua Elson Nunes De Souza', NULL),
(312, 'Leopoldo', 'Leitão', '04.003.993-1', '205.310.809-60', 'Rua Maria Clara De Jesus', NULL),
(313, 'Judas', 'Uchoa', '19.519.022-1', '274.012.263-24', 'Rua Joaquim Floriano', NULL),
(314, 'Cristiano', 'Lucena', '96.780.770-8', '007.735.046-48', 'Avenida Edmundo Amaral   ', NULL),
(315, 'Tobias', 'Cotrim', '97.525.160-2', '780.161.409-71', 'Estrada Eduardo Pereira Dias Junior', NULL),
(316, 'Anabela', 'Bicalho', '35.624.885-4', '929.935.920-25', 'Alameda Dos Jurupis', NULL),
(317, 'Gaudêncio', 'Peres', '25.348.529-9', '264.030.426-70', 'Rua Professor Paulo Freire', NULL),
(318, 'Adosindo', 'Inês', '94.645.119-0', '921.221.327-87', 'Rua Emílio Scuissiato', NULL),
(319, 'Jónatas', 'Carqueijeiro', '59.424.549-6', '853.881.966-66', 'Avenida Cristiano Machado', NULL),
(320, 'Valdeci', 'Gonçalves', '04.649.058-1', '172.602.131-91', 'Avenida Lucy Mesquita De Araújo', NULL),
(321, 'Higino', 'Faro', '47.676.433-4', '718.441.849-27', 'Avenida Do Estado Q15 L03 ', NULL),
(322, 'Vanderlei', 'Regodeiro', '00.477.221-3', '366.571.222-09', 'Rua Antônio De Barros', NULL),
(323, 'Ernesto', 'Lemes', '51.711.098-5', '998.585.290-74', 'Rua José Aparácio', NULL),
(324, 'Horácio', 'Gameiro', '67.203.555-1', '116.590.842-53', 'Rua Josepha Monagatti Ferri', NULL),
(325, 'Leopoldo', 'Grilo', '58.464.222-1', '689.591.795-07', 'Rua Doutor Guapiacu', NULL),
(326, 'Nádia', 'Mourato', '26.797.254-9', '684.673.905-06', 'Rua Vasco Teixeira Bueno', NULL),
(327, 'Calisto', 'Ilha', '91.887.236-7', '975.368.995-05', 'Rua Gomes De Carvalho', NULL),
(328, 'Lorena', 'Freire', '35.015.098-0', '322.897.215-14', 'Avenida Doutor Bernardino De Campos', NULL),
(329, 'Epaminondas', 'Nazário', '68.916.898-8', '260.816.768-38', 'Rua Estudante Arilson Antônio Brisolla', NULL),
(330, 'Nelson', 'Malafaia', '07.355.469-6', '101.583.791-36', 'Avenida José De Moraes Cabral', NULL),
(331, 'Eunice', 'Canto', '37.562.808-2', '641.880.435-04', 'Rua General Miguel Costa', NULL),
(332, 'Ângelo', 'Arruda', '49.713.114-7', '313.203.337-53', 'Quadra 806 Sul Alameda 20 Lote 11', NULL),
(333, 'Cesário', 'Campelo', '66.600.833-9', '300.840.678-53', 'Avenida Campos Sales', NULL),
(334, 'Gilda', 'Trindade', '73.145.729-6', '715.234.919-30', 'Rua João Biancalana', NULL),
(335, 'Gilda', 'Barros', '33.331.181-4', '832.530.978-46', 'Rua Manoel De Aguiar', NULL),
(336, 'Amílcar', 'Carreiro', '54.289.932-6', '440.850.676-13', 'Avenida Gilberto Amado', NULL),
(337, 'Frutuoso', 'Lisboa', '52.980.741-7', '241.049.719-52', 'Rua Herval Sampaio Pereira', NULL),
(338, 'Garibaldo', 'Gouveia', '51.151.150-1', '453.235.122-70', 'Rua Conselheiro Mafra', NULL),
(339, 'Cora', 'Valim', '28.726.745-4', '213.440.376-40', 'Quadra Qnp 12 Conjunto D', NULL),
(340, 'Rudi', 'Águeda', '47.823.593-5', '060.792.643-07', 'Av. Jeremias Pereira', NULL),
(341, 'Hermígio', 'Castelo', '52.818.016-7', '433.341.599-30', 'Rua Joaquim Guarani', NULL),
(342, 'Tomás', 'Portugal', '82.114.664-3', '419.490.291-23', 'Condominio Campu Verdes ', NULL),
(343, 'Garibaldo', 'Viana', '40.408.395-2', '010.887.841-43', 'Rua Antônio La Giudice', NULL),
(344, 'Pedro', 'Hernandes', '69.071.918-0', '060.694.513-09', 'Rua São João N 060', 0),
(345, 'Lénia', 'Feijó', '56.411.297-9', '336.674.835-46', 'Alameda Piracicaba', NULL),
(346, 'Leonor', 'Marinho', '06.442.442-9', '807.222.114-06', 'Rua Isaura Parente', NULL),
(347, 'Udo', 'Chousa', '36.912.971-4', '601.730.276-01', 'Rua Pref Luiz Ulisses Quaglia', NULL);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id`, `id_tipo`, `saldo`, `limite`, `montante_minimo`, `deposito_minimo`) VALUES
(15, 2, 1000, 0, 100, 100),
(17, 2, 299, 0, 20, 300),
(18, 2, 450, 0, 50, 100),
(19, 2, 1800, 0, 300, 100),
(20, 2, 150, 0, 100, 50);

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

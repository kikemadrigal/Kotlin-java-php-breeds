use dbs5548750;


-- -----------------------------------------------------
--                Creación
-- .....................................................

-- 1.Crea la tabla users ya que si id es foráneo en todas las tablas


-- Tipos de datos en Mysql
-- Numericos: bit, boolean, smallint,int, float, double, real
-- Cadena: char, varchar, tinytext,text, longtext
-- fecha: date, datetime, timestamp time, year 
-- json: json
-- --------------------------------------------------------


 

-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `users`
--

-- --------------------------------------------------------

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` smallint(4) UNSIGNED NOT NULL DEFAULT '0',
  `email` varchar(100),
  `realName` varchar(100),
  `surname` varchar(100),
  `web` varchar(100),
  `validate` smallint(2),
  `counter` int(100),
  `date` varchar(500),
  `view` int(11),
  `token` varchar(100),
  `observations` longtext,
  UNIQUE KEY `ID` (`id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci; 


--
-- BHorrando la tabla `usuarios`
-- Para poder borrar la tabla users primero tendrás que borrar las tablas game, gameUsers y multimedia que tienen el id como clave foranea
-- Drop table users;
  
--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `users` (`id`, `name`, `password`, `role`, `email`, `realName`, `surname`, `web`, `validate`, `counter`, `date`, `view`, `token`, `observations`) VALUES
(1, 'kike', '1c558dfd6f4148767d40386fa7b59c18e3b8627e', 1, 'kikemadrigal@hotmail.com', 'Enrique', 'Madrigal', 'tipolisto.es', '1', 0, '', 1, '', ''),
(2, 'ada', '1c558dfd6f4148767d40386fa7b59c18e3b8627e', 3, 'userada@test.es', '', '', '', '1', 0, '', 1, '', ''),
(3, 'lucas', '8b08a87c980d75add89798754899184c196b1a50', 3, 'userlucas@test2.es', '', '', '', '1', 0, '', 1, '', ''),
(4, 'maria', '3885b8a5e5c5087b42086a494b7cc26210721602', 3, 'usermariao@test3.es', '', '', '', '1', 0, '11/01/2018', 1, '', ''),
(5, 'juan', '58746b54a4c7e856562f17e9bc6d2a07861da891', 3, 'userjuan@test4.es', ' ', ' ', ' ', '1', 0, '29/04/2022', 1, '', '');

-- delete from users;



-- --------------------------------------------------------


--
-- 			Estructura de tabla para la tabla `breed_cat`
--

-- --------------------------------------------------------

create table `breed_cat` (
	`id` int(10)  NOT NULL AUTO_INCREMENT,
  `id_name` text(200),
	`name` text(200),
  `name_es` text(200),
	`cfa_url` varchar (255),
	`vetstreet_url` varchar (255),
	`vcahospitals_url` varchar (255),
	`temperament` varchar (255),
	`temperament_es` varchar (255),
	`origin` text,
	`origin_es` text,
  `morphology` text,
	`morphology_es` text,
	`country_codes` varchar(255),
	`country_code` varchar(255),
	`description` longtext,
  `description_es` longtext,
	`life_span` varchar(255),
-- interior
	`indoor` int(11),
-- regazo
	`lap` int (3),
-- nombres alternativos
	`alt_names` varchar(255),
  `adaptability` int(3),
  `affection_level` int(3),
  `child_friendly` int(3),
  `cat_friendly` int(3),
  `dog_friendly` int(3),
  `energy_level` int(3),
-- aseo
  `grooming` int(3),
-- problemas de salud
  `health_issues` int(3),
  `intelligence` int(3),
-- nivel de muda
  `shedding_level` int(3),
-- necesidades sociales
  `social_needs` int(3),
  `stranger_friendly` int(3),
-- vocalización
  `vocalisation` int(3),
  `experimental` int(3),
-- sin pelo
  `hairless` int(3),
  `natural` int(3),
  `rare` int(3),
  `rex` int(3),
-- cola suprimida
  `suppressed_tail` int(3),
-- piernas cortas
  `short_legs` int(3),
  `wikipedia_url` varchar(255),
-- hipoalergénica
  `hypoallergenic` int(3),
-- peso
   weight varchar(255),
-- Las razas pueden tener varias imágenes
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
-- el id nos sirve para encontrar imágenes
  `reference_image_id`varchar(255),
  `path_image`varchar(255),
  `creator_id` int(11),
	UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;



-- --------------------------------------------------------


--
-- 			Estructura de tabla para la tabla `breed_dog`
--

-- --------------------------------------------------------

CREATE TABLE `breed_dog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `breed_id` varchar(255),
  `name` varchar(255),
  `name_es` varchar(255),
  `description` text,
  `description_es` text,
  `wiki_url` varchar(255),
-- Criado para
  `bred_for` text,
  `bred_for_es` text,
-- grupo de raza
  `breed_group` varchar(255),
  `breed_group_es` varchar(255),
  `life_span`  varchar(255),
  `temperament` text,
  `temperament_es` text,
  `origin` text,
  `origin_es` text,
  `morphology` text,
	`morphology_es` text,
  `weight` varchar(255),
  `height` varchar(255),
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
-- tiene una imagen propia
  `reference_image_id` varchar(255),
  `path_image`varchar(255),
  `creator_id` int(11),
  UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;



-- --------------------------------------------------------


--
-- 			Estructura de tabla para la tabla `specie_fish`
--

-- --------------------------------------------------------

CREATE TABLE `specie_fish` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `name_es` varchar(255),
  `description` text,
  `url_wiki` varchar(255),
  `url_image` varchar(255),
  `morphology` text,
  `habitat` text,
  `feeding` text,

  `phylum` varchar(255),
  `class` varchar(255),
  `orden` varchar(255),
  `family` varchar(255),
  `genus` varchar(255),

  `path_image`varchar(255),
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `creator_id` int(11),
  UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;




-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `cat`
--

-- --------------------------------------------------------
CREATE TABLE `cat` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `name_es` varchar(255),
  `breed_id` varchar(255),
  `family` varchar(255),
  `description` text,
  `description_es` text,
  `year_of_birth` varchar(255),
  `sex` tinyint,
  `address` varchar(255),
  `vaccines` int(10) DEFAULT 0,
  `path_image`varchar(255),
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `creator_id` int(11),
  UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `dog`
--

-- --------------------------------------------------------
CREATE TABLE `dog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `name_es` varchar(255),
  `breed_id` varchar(255),
  `family` varchar(255),
  `description` text,
  `description_es` text,
  `year_of_birth` varchar(255),
  `sex` tinyint,
  `address` varchar(255),
  `vaccines` int(10) DEFAULT 0,
  `path_image` varchar(255),
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `creator_id` int(11),
  UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `fish`
--

-- --------------------------------------------------------
CREATE TABLE `fish` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `name_es` varchar(255),
  `specie_id` varchar(255),
  `path_image` varchar(255),
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `creator_id` int(11),
  UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `multimedia`
--

-- --------------------------------------------------------

CREATE TABLE `multimedia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50),
  `path` varchar(100),
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `creator_id` int(11),
  UNIQUE KEY `ID` (`id`),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
INSERT INTO `multimedia` (`id`, `name`, `path`, `date`, `creator_id`) VALUES ('0', 'Sin image', NULL, current_timestamp(), '1');






-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `theme`
--
-- el theme es el tema informática, MSX, 8 bits, etc 
-- --------------------------------------------------------
create table `themes`(
	`id` int(10)  NOT NULL AUTO_INCREMENT,
	`title` varchar(100),
	`date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	`creator_id` int (11),
	UNIQUE KEY `ID` (`id`),
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;





-- --------------------------------------------------------

--
-- 			Estructura de tabla para la tabla `group`
--

-- --------------------------------------------------------
create table `groups`(
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`title` varchar(100),
	`date` timestamp,
  `depends_on` int(10) DEFAULT 0,
	`creator_id` int (11),
	UNIQUE KEY `ID` (`id`),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`creator_id`) REFERENCES users(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;






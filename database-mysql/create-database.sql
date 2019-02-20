CREATE SCHEMA `crud-people-mysql` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `crud-people-mysql`.`people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_birth` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sw73blrfiqs1etfk8qecdieyx` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

CREATE TABLE `crud-people-mysql`.`dependent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_birth` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `dependent_type` int(11) NOT NULL,
  `people_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh5ljw3h6yusy3bmjbss5n5o86` (`people_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

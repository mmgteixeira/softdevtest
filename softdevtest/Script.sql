DROP SCHEMA IF EXISTS `db-sensor-temp-uni`;

CREATE SCHEMA `db-sensor-temp-uni`;

use `db-sensor-temp-uni`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `sensor`;

CREATE TABLE `sensor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `NAME_UNIQUE` (`name`)
  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `temperature`;

CREATE TABLE `temperature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `temp` DOUBLE(3,1) DEFAULT NULL,
  `date_entered` varchar(128) NOT NULL,
  `sensor_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_SENSOR_ID_idx` (`sensor_id`),

  CONSTRAINT `FK_SENSOR` 
  FOREIGN KEY (`sensor_id`) 
  REFERENCES `sensor` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;

--
-- Data for table `employee`
--

INSERT INTO `sensor` VALUES 
	(1,'Sensor1'),
	(2,'Sensor2'),
	(3,'Sensor3'),
	(4,'Sensor4'),
	(5,'Sensor5');
    
INSERT INTO `temperature` VALUES 
	(1,'25.5','2019-11-30 15:00','2'),
	(2,'26.4','2019-11-30 15:00','1'),
	(3,'28.5','2019-11-30 15:00','4'),
	(4,'20.4','2019-11-30 15:00','2'),
	(5,'29.7','2019-11-30 15:00','3');

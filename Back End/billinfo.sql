create database if not exists hospital_management_system;

use hospital_management_system;

drop table if exists billinfo;

CREATE TABLE `billinfo` (
	`bill_id` int(10) NOT NULL AUTO_INCREMENT,
  	`p_id` int(10) NOT NULL,
	`d_id` int(10) NOT NULL,
	`bill_date` date NOT NULL,
  	`total_amount` DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (`bill_id`)
	/*
	FOREIGN KEY (`p_id`) REFERENCES  `patients` (`id`),
	FOREIGN KEY (`d_id`) REFERENCES  `doctors` (`id`)
	*/
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `billinfo` (`bill_id`,`p_id`,`d_id`,`bill_date`,`total_amount`) VALUES (601,105,205,'2020-11-10','1350.00');
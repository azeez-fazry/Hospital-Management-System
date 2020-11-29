create database if not exists hospital_management_system;

use hospital_management_system;

drop table if exists appointment;

CREATE TABLE `appointment` (
	`app_id` int(10) NOT NULL AUTO_INCREMENT,
  	`p_id` int(10) NOT NULL,
	`blood_pressure` varchar(32) NOT NULL,
	`blood_sugar` varchar(32) NOT NULL,
 	`weight` varchar(32) NOT NULL,
  	`temperature` varchar(32) NOT NULL,
	`d_id` int(10) NOT NULL,
 	`app_date` date NOT NULL,
	PRIMARY KEY (`app_id`),
	FOREIGN KEY (`p_id`) REFERENCES  `patients` (`id`),
	FOREIGN KEY (`d_id`) REFERENCES  `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `appointment` (`app_id`,`p_id`,`blood_pressure`,`blood_sugar`,`weight`,`temperature`,`d_id`,`app_date`) VALUES (501,101, '120/185', '80/120', '85 Kg', '101 degree',201,'2020-09-15');
INSERT INTO `appointment` (`app_id`,`p_id`,`blood_pressure`,`blood_sugar`,`weight`,`temperature`,`d_id`,`app_date`) VALUES (502,102, '90/120', '92/190', '86 kg', '99 deg',202,'2020-09-15');
INSERT INTO `appointment` (`app_id`,`p_id`,`blood_pressure`,`blood_sugar`,`weight`,`temperature`,`d_id`,`app_date`) VALUES (503,103, '125/200', '86/120', '56 kg', '98 deg',203,'2020-09-15');

INSERT INTO `appointment` (`app_id`,`p_id`,`blood_pressure`,`blood_sugar`,`weight`,`temperature`,`d_id`,`app_date`) VALUES (504,104, '96/120', '98/120', '57 kg', '102 deg',204,'2020-09-20');
INSERT INTO `appointment` (`app_id`,`p_id`,`blood_pressure`,`blood_sugar`,`weight`,`temperature`,`d_id`,`app_date`) VALUES (505,105, '90/120', '120', '56', '98 F',205,'2020-09-20');
INSERT INTO `appointment` (`app_id`,`p_id`,`blood_pressure`,`blood_sugar`,`weight`,`temperature`,`d_id`,`app_date`) VALUES (506,106, '80/120', '120', '85', '98.6',206,'2020-09-20');

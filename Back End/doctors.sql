create database if not exists hospital_management_system;

use hospital_management_system;

drop table if exists doctors;

CREATE TABLE `doctors` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(64) NOT NULL,
  `lname` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `phone` varchar(10) NOT NULL UNIQUE,
  `qualification` varchar(64) NOT NULL,
  `department` varchar(64) NOT NULL,
  `fee` DECIMAL(10,2) NOT NULL,
  `date` date NOT NULL,
  `age` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (201,'John','Smith','mg road','9933300924','MBBS','OPD','600.00','2020-09-15','27');
INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (202,'Ravi','Sharma','Jayanagar','9242889791','MBBS','OPD','600.00','2020-09-15','35');
INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (203,'Alice','Zelaya','Whitefield','7031086846','MBBS','OPD','600.00','2020-09-20','27');

INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (204,'Preethi','Prasad','Banashankari','9844037640','MBBS','OPD','600.00','2020-09-15','27');
INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (205,'Kumar','Narayan','vv puram','9511747841','MBBS','OPD','600.00','2020-09-20','22');
INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (206,'Chetana','Ashok','Jayanagar','998056423','MBBS','OPD','600.00','2020-09-20','35');

INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (207,'Harsha','Gowda','Banashankari','8861268940','MBBS','OPD','600.00','2020-09-20','27');
INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (208,'Priya','Singh','Jayanagar','8879610560','MBBS','OPD','600.00','2020-09-20','22');
INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (209,'Neha','Jayanth','Banashankari','8924299881','MBBS','OPD','600.00','2020-09-20','35');

INSERT INTO `doctors` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`fee`,`date`,`age`) VALUES (210,'Ahmad','Jabbar','Whitefield','9760578022','MBBS','OPD','600.00','2020-09-20','27');

create database if not exists hospital_management_system;

use hospital_management_system;

drop table if exists patients;

CREATE TABLE `patients` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(64) NOT NULL,
  `lname` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `phone` varchar(10) NOT NULL UNIQUE,
  `date` date NOT NULL,
  `disease` varchar(64) NOT NULL,
  `age` int(2) NOT NULL,
  `sex` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (101,'John','Smith','mg road','9933300924','2020-09-15','fever','22','M');
INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (102,'Ravi','Sharma','Jayanagar','9242889791','2020-09-15','cough','35','M');
INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (103,'Alice','Zelaya','Whitefield','7031086846','2020-09-20','fever','27','F');

INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (104,'Preethi','Prasad','Banashankari','9844037640','2020-09-15','cold','27','F');
INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (105,'Kumar','Narayan','vv puram','9511747841','2020-09-20','cold','22','M');
INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (106,'Chetana','Ashok','Jayanagar','998056423','2020-09-20','fever','35','F');

INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (107,'Harsha','Gowda','Banashankari','8861268940','2020-09-20','cough','27','M');
INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (108,'Priya','Singh','Jayanagar','8879610560','2020-09-20','cold','22','F');
INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (109,'Neha','Jayanth','Banashankari','8924299881','2020-09-20','cough','35','F');

INSERT INTO `patients` (`id`,`fname`,`lname`,`address`,`phone`,`date`,`disease`,`age`,`sex`) VALUES (110,'Ahmad','Jabbar','Whitefield','9760578022','2020-09-20','fever','27','M');

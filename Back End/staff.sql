create database if not exists hospital_management_system;

use hospital_management_system;

drop table if exists staff;

CREATE TABLE `staff` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(64) NOT NULL,
  `lname` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `phone` varchar(10) NOT NULL UNIQUE,
  `qualification` varchar(64) DEFAULT NULL,
  `department` varchar(64) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (401,'John','Smith','mg road','9933300924','B.Sc.','OPD','2020-09-15');
INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (402,'Ravi','Sharma','Jayanagar','9242889791','B.Sc.','OPD','2020-09-15');
INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (403,'Preethi','Prasad','Banashankari','9844037640','B.Sc.','OPD','2020-09-15');

INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (404,'Kumar','Narayan','vv puram','9511747841','B.Sc.','OPD','2020-09-20');
INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (405,'Chetana','Ashok','Jayanagar','998056423','B.Sc.','OPD','2020-09-20');
INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (406,'Harsha','Gowda','Banashankari','8861268940','B.Sc.','OPD','2020-09-20');

INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (407,'Priya','Singh','Jayanagar','8879610560','B.Sc.','OPD','2020-09-20');
INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (408,'Neha','Jayanth','Banashankari','8924299881','B.Sc.','OPD','2020-09-20');
INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (409,'Ahmad','Jabbar','Whitefield','9760578022','B.Sc.','OPD','2020-09-20');

INSERT INTO `staff` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`) VALUES (410,'Alice','Zelaya','Whitefield','7031086846','B.Sc.','OPD','2020-09-20');

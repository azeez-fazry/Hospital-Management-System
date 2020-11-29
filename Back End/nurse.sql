create database if not exists hospital_management_system;

use hospital_management_system;

drop table if exists nurse;

CREATE TABLE `nurse` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(64) NOT NULL,
  `lname` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `phone` varchar(10) NOT NULL UNIQUE,
  `qualification` varchar(64) NOT NULL,
  `department` varchar(64) NOT NULL,
  `date` date NOT NULL,
  `ward` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (301,'John','Smith','mg road','9933300924','B.Sc.','OPD','2020-09-15','10');
INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (302,'Ravi','Sharma','Jayanagar','9242889791','B.Sc.','OPD','2020-09-15','11');
INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (303,'Preethi','Prasad','Banashankari','9844037640','B.Sc.','OPD','2020-09-15','12');

INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (304,'Kumar','Narayan','vv puram','9511747841','B.Sc.','OPD','2020-09-20','18');
INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (305,'Chetana','Ashok','Jayanagar','998056423','B.Sc.','OPD','2020-09-20','15');
INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (306,'Harsha','Gowda','Banashankari','8861268940','B.Sc.','OPD','2020-09-20','13');

INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (307,'Priya','Singh','Jayanagar','8879610560','B.Sc.','OPD','2020-09-20','20');
INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (308,'Neha','Jayanth','Banashankari','8924299881','B.Sc.','OPD','2020-09-20','16');
INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (309,'Ahmad','Jabbar','Whitefield','9760578022','B.Sc.','OPD','2020-09-20','11');

INSERT INTO `nurse` (`id`,`fname`,`lname`,`address`,`phone`,`qualification`,`department`,`date`,`ward`) VALUES (310,'Alice','Zelaya','Whitefield','7031086846','B.Sc.','OPD','2020-09-20','14');

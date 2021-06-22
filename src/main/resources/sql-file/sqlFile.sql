DROP SCHEMA IF EXISTS `employee_payroll`;

CREATE SCHEMA `employee_payroll`;

SET FOREIGN_KEY_CHECKS = 0;

use `employee_payroll`;


drop table if exists `employee`;
create table`employee`
(
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` varchar(64) Default NULL,
`last_name` varchar(64) Default NULL,
`phone` varchar(64) Default NULL,
`email` varchar(64) Default NULL,
`employee_number` int(16) Default NULL,
`salary` int(16) Default NULL,
`post` varchar(64) Default NULL,
`status` varchar(64) Default NULL,
`address_id` int(16) Default NULL,

PRIMARY KEY (`id`),


 KEY `FK_ADDRESS_id` (`address_id`),
 CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION


) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




drop table if exists `user`;
create table `user`
(
`id` int(16) NOT NULL AUTO_INCREMENT,
`username` varchar(64) Default NULL,
`password` varchar(64) DEfault NULL,
`role` varchar(64) Default NULL,
`enabled` varchar(64) Default NULL,




primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;





drop table if exists `address`;
create table `address`
(
`id` int(16) NOT NULL AUTO_INCREMENT,
`house_number` varchar(64) Default NULL,
`street` varchar(64) DEfault NULL,
`city` varchar(64) Default NULL,
`district` varchar(64) Default NULL,
`state` varchar(64) Default NULL,
`pin_code` varchar(64) Default NULL,


primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




drop table if exists `course`;
create table `course`
(
`id` int(16) NOT NULL AUTO_INCREMENT,
`course_name` varchar(64) Default NULL,
`employee_id` int(16) Default NULL,

  KEY `FK_EMPLOYEE_id` (`employee_id`),

  CONSTRAINT `FK_EMPLOYEE`
  FOREIGN KEY (`employee_id`)
  REFERENCES `employee` (`id`)

  ON DELETE NO ACTION ON UPDATE NO ACTION,



primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;





drop table if exists `skill`;
create table `skill`
(
`id` int(16) NOT NULL AUTO_INCREMENT,
`skill_name` varchar(64) Default NULL,

primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;








DROP TABLE IF EXISTS `employee_skill`;

CREATE TABLE `employee_skill` (
  `skill_id` int(16) NOT NULL,
  `employee_id` int(16) NOT NULL,

  PRIMARY KEY (`skill_id`,`employee_id`),

  KEY `FK_EMPLOYEE_Id` (`employee_id`),

  CONSTRAINT `FK_SKILL` FOREIGN KEY (`skill_id`)
  REFERENCES `skill` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_EMPLOYEE_SKILL` FOREIGN KEY (`employee_id`)
  REFERENCES `employee` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




SET FOREIGN_KEY_CHECKS = 1;

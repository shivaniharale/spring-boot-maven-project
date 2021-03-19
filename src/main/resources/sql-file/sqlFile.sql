create database if not exists `employee-payroll`;
drop table if exists `Employee`;
create table`Employee`
(
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` varchar(50) Default NULL,
`last_name` varchar(50) Default NULL,
`phone` varchar(50) Default NULL,
`email` varchar(50) Default NULL,
`details_id` int(11) Default null,

KEY `FK_DETAIL_id` (`details_id`),
CONSTRAINT `FK_DETAIL` FOREIGN KEY (`details_id`) REFERENCES `Details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,


primary key (`id`)
);

drop table if exists `Details`;
create table `Details`
(
`id` int(11) NOT NULL AUTO_INCREMENT,
`employee_number` int(11) Default NULL,
`salary` int(20) DEfault NULL,
`status` varchar(50) Default NULL,

primary key (`id`)
);
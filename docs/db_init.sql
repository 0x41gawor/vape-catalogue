CREATE DATABASE IF NOT EXISTS `vape_catalogue_db`;
USE `vape_catalogue_db`;

DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `item`;


CREATE TABLE `category` (
`id` int NOT NULL auto_increment,
`name` varchar(45) NOT NULL unique,

primary key (`id`)
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `item` (
`id` int NOT NULL auto_increment,
`name` varchar(45)  NOT NULL,
`price` double  NOT NULL,
`imagePath` varchar(45)  NOT NULL,
`notes` varchar(200),
`category_id` int  NOT NULL,

primary key (`id`),

KEY `FK_category_idx` (`category_id`),
CONSTRAINT `FK_category_in_item`
FOREIGN KEY (`category_id`)
REFERENCES `category` (`id`)

on delete no action on update no action
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

select * from `category`;
select * from `item`;
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vimal
 * Created: 24 Nov, 2019
 */

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile_number` varchar(10) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  `id_number` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ;




CREATE TABLE `video` (
  `video_id` int(11) NOT NULL  AUTO_INCREMENT,
  `video_name` varchar(65) NOT NULL ,
  `author_name` varchar(65) NOT NULL,
  `quantity` integer NOT NULL,
  `published_year` integer DEFAULT NULL,
  `language` char(20) NOT NULL,
  `type` varchar(45) NOT NULL,
  `price` decimal(16) DEFAULT NULL,
  PRIMARY KEY (`video_id`));
  
  CREATE TABLE `video_transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT ,
  `video_id` int(11) NOT NULL ,
  `video_sub_id` varchar(9) NOT NULL,
  `user_id` integer NOT NULL,
  `rent_date` date DEFAULT NULL,
  `return_status` boolean NOT NULL,
  PRIMARY KEY (`transaction_id`));
  
  CREATE TABLE `video_account` (
  `video_account_id` int(11) NOT NULL ,
  `transaction_id` int(11) NOT NULL ,
  `amount_received` decimal(9) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`video_account_id`));
  
  CREATE TABLE `video_language` (
  `language_id` int(11) NOT NULL ,
  `name`  varchar(20) not null,
  PRIMARY KEY (`language_id`));
 
  CREATE TABLE `kyc` (
  `kyc_id` varchar(9) NOT NULL ,
  `kyc_type` varchar(11) NOT NULL ,
  PRIMARY KEY (`kyc_id`));


ALTER TABLE `video_rental`.`customer` 
ADD UNIQUE INDEX `mobile_number_UNIQUE` (`mobile_number` ASC) VISIBLE;

ALTER TABLE `video_rental`.`video_transaction` 
CHANGE COLUMN `rent_date` `rent_date` DATE NOT NULL ;

ALTER TABLE video MODIFY COLUMN video_name VARCHAR(255) CHARACTER  SET UTF8 COLLATE UTF8_GENERAL_CI;

ALTER TABLE `video_rental`.`video_transaction` 
CHANGE COLUMN `video_sub_id` `video_sub_id` VARCHAR(9) NULL ;


  



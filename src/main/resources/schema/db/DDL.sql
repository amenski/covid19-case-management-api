CREATE DATABASE COVID19_REST;
USE COVID19_REST;

-- USER TABLE
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `account_non_expired` int(1) NOT NULL,
  `account_non_locked` int(1) NOT NULL,
  `enabled` int(1) NOT NULL,
  `last_access` timestamp DEFAULT current_timestamp,
  
  PRIMARY KEY(`id`)
) ENGINE=InnoDb DEFAULT CHARSET=utf8;

-- ROLE
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `enabled` int(1) not null default 1,
  
  PRIMARY KEY(`ID`)
) ENGINE=InnoDb DEFAULT CHARSET=utf8;

-- JOIN
CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY(`role_id`, `user_id`)
) ENGINE=InnoDb DEFAULT CHARSET=utf8;

alter table user_roles add CONSTRAINT fk_user_role_user FOREIGN KEY user_roles(user_id) REFERENCES user(id);
alter table user_roles add CONSTRAINT fk_user_roles_role FOREIGN KEY user_roles(role_id) REFERENCES role(id);

-- health facility info
CREATE TABLE `HEALTH_FACILITY` (
	`ID` 				INT(11) NOT NULL AUTO_INCREMENT,
	`OSM_ID`  			DOUBLE  NULL,
	`NAME`    			VARCHAR(200) NOT NULL,
	`ADDRFULL` 			VARCHAR(250) NOT NULL,
	`AMENITY` 			VARCHAR(50)  NULL,
	`X_CORD`  			DOUBLE  NOT NULL,
	`Y_CORD`  			DOUBLE NOT NULL,
	
	PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;;

-- PERSON UNDER INVESTIGATION(PUI) INFO
CREATE TABLE `pui_info` (
  `id` 							int(11) NOT NULL AUTO_INCREMENT,
  `case_code` 				    varchar(36) UNIQUE NOT NULL,
  `first_name` 				    varchar(50) NOT NULL,
  `last_name` 				    varchar(50) NOT NULL,
  `dob` 					    date DEFAULT NULL,
  `gender`                      enum('M','F') DEFAULT NULL,
  `phone`                       varchar(45) DEFAULT NULL,
  `occupation`                  varchar(50) DEFAULT NULL,
  
  `passport_number`		        varchar(50) NOT NULL  DEFAULT '',
  `incident_contact_phone_1`	varchar(50),
  `incident_contact_phone_2`	varchar(50),
  `country_of_residence`		varchar(50) NOT NULL  DEFAULT '',
  `country_of_origin`		 	varchar(50) NOT NULL  DEFAULT '',
  `nationality`		 			varchar(50) NOT NULL  DEFAULT '',
  `region`		 				varchar(50) NOT NULL  DEFAULT '',
  `subcity_or_zone`		 		varchar(50) NOT NULL  DEFAULT '',
  `woreda`		 				varchar(50) NOT NULL  DEFAULT '',
  `kebele`		 				varchar(50) NOT NULL  DEFAULT '',
  `house_no`		 				varchar(50) NOT NULL  DEFAULT '',
  `phone_no`		 				varchar(50) NOT NULL  DEFAULT '',
  `latitude`		 			varchar(50) DEFAULT '',
  `longitude`		 			varchar(50) DEFAULT '',
  
  `presumptive_result`			int(11) NOT NULL  DEFAULT '1', -- pending, positive, negative => default pending
  `confirmed_result`			int(11) NOT NULL  DEFAULT '1',
   
  `identified_by`				int(11) NOT NULL  DEFAULT '20', -- clinical_eval, contact_tracing, surveilance => default clinical_eval
  `contact_parent_case_code`   varchar(36),
  `recent_travel_to`           varchar(250),
  
  `status`						int(11) NOT NULL DEFAULT '1061',
  
  `reporting_date`  			timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` 				varchar(250) NOT NULL, -- health official table id
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- HEALTH OFFICIAL INFO
CREATE TABLE `health_official` (
  `id` 							int(11) NOT NULL AUTO_INCREMENT,
  `first_name` 				    varchar(50) NOT NULL DEFAULT '',
  `last_name` 				    varchar(50) NOT NULL DEFAULT '',
  `email`						varchar(50) NOT NULL DEFAULT '',
  `dob` 					    date DEFAULT NULL,
  `gender`                      enum('M','F') DEFAULT NULL,
  `phone`                       varchar(45) ,
  `occupation`                  varchar(50) NOT NULL,
  `organization`				varchar(50) NOT NULL,
 
  `created_date`  			timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- QUESTIONIER
CREATE TABLE `questionier` (
  `id` 							int(11) NOT NULL AUTO_INCREMENT,
  `question` 				    varchar(4000) NOT NULL,
  `options` 					varchar(250) NOT NULL DEFAULT "{\"yes\":\"YES\", \"no\":\"No\", \"unk\":\"Unknown\"}",
  `category`					int(11) NOT NULL,
  `parent_id`					int(11), -- if it depends on an other question
  `description` 				varchar(4000)  NOT NULL  DEFAULT '',
  `modified_by`					varchar(250) NOT NULL,
  `created_date`  				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- PUI-FOLLOW-UP
CREATE TABLE `pui_follow_up` (
  `id` 							int(11) NOT NULL AUTO_INCREMENT,
  `pui_case_code` 				varchar(36) NOT NULL,
  `questionier_id` 				int(11) NOT NULL,
  `option_selected`				varchar(50) NOT NULL,
  `description` 				varchar(4000),
  `modified_by`					varchar(250) NOT NULL,
  `created_date`  				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- CONSTANTS
CREATE TABLE `constant_enum` (
  `enum_id` 						int(11) NOT NULL AUTO_INCREMENT,
  `enum_code` 						int(11) NOT NULL,
  `enum_name` 				    	varchar(50) NOT NULL DEFAULT '',
  `enum_type` 				    	varchar(50) NOT NULL DEFAULT '',
  `enum_label` 				    	varchar(50) NOT NULL DEFAULT '',
  `enum_desc` 				    	varchar(250) NOT NULL DEFAULT '',
  `disabled`						int(1) NOT NULL DEFAULT '0',
  
  PRIMARY KEY (`enum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


ALTER TABLE PUI_FOLLOW_UP ADD CONSTRAINT FK_FOLLOW_UP_QUESTIONIER FOREIGN KEY pui_follow_up(questionier_id) REFERENCES questionier(id);
ALTER TABLE PUI_FOLLOW_UP ADD CONSTRAINT FK_FOLLOW_UP_PUI_INFO FOREIGN KEY pui_follow_up(pui_case_code) REFERENCES pui_info(case_code);

ALTER TABLE constant_enum DROP COLUMN ENUM_ID;
ALTER TABLE CONSTANT_ENUM ADD PRIMARY KEY(ENUM_CODE);

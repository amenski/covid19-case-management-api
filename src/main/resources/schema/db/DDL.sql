CREATE DATABASE COVID19_REST;
USE COVID19_REST;

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
  `incident_contact_phone_1`	varchar(50) NOT NULL  DEFAULT '',
  `incident_contact_phone_2`	varchar(50) NOT NULL  DEFAULT '',
  `country_of_residence`		varchar(50) NOT NULL  DEFAULT '',
  `country_of_origin`		 	varchar(50) NOT NULL  DEFAULT '',
  `nationality`		 			varchar(50) NOT NULL  DEFAULT '',
  `region`		 				varchar(50) NOT NULL  DEFAULT '',
  `subcityOrZone`		 		varchar(50) NOT NULL  DEFAULT '',
  `woreda`		 				varchar(50) NOT NULL  DEFAULT '',
  `kebele`		 				varchar(50) NOT NULL  DEFAULT '',
  `houseNo`		 				varchar(50) NOT NULL  DEFAULT '',
  `phoneNo`		 				varchar(50) NOT NULL  DEFAULT '',
  `latitude`		 			varchar(50) NOT NULL  DEFAULT '',
  `longitude`		 			varchar(50) NOT NULL  DEFAULT '',
  
  `presumptive_result`			varchar(50) NOT NULL  DEFAULT 'pending', -- pending, positive, negative
  `confirmed_result`			varchar(50) NOT NULL  DEFAULT 'pending',
   
  `identified_by`				varchar(50) NOT NULL  DEFAULT '', -- clinical_eval, contact_tracing, surveilance)
  `contact_parent_case_code`   varchar(36),
  `travel_history_id`          int(11),
  
  `reporting_date`  			timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` 				int(11), -- health official table id
  
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
  `options` 					varchar(250) NOT NULL DEFAULT '{\'Yes\', \'No\', \'Unknown\'}',
  `categories`					varchar(250) NOT NULL  DEFAULT '{\'user_info\', \'symptom\', \'existing_condition\'}',
  `parent_id`					int(11), -- if it depends on an other question
  `description` 				varchar(4000)  NOT NULL  DEFAULT '',
  `modified_by`					int(11) NOT NULL,
  `created_date`  				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- PUI-FOLLOW-UP
CREATE TABLE `pui_follow_up` (
  `id` 							int(11) NOT NULL AUTO_INCREMENT,
  `pui_id` 				    	int(11) NOT NULL,
  `questionier_id` 				int(11) NOT NULL,
  `option_selected`				varchar(50) NOT NULL,
  `description` 				varchar(4000),
  `modified_by`					int(11) NOT NULL,
  `created_date`  				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` 				timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
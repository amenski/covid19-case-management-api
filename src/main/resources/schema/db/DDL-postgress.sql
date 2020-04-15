set client_encoding to 'UTF8';

/*
Table structure for table 'public.constant_enum'
*/

DROP TABLE IF EXISTS "public"."constant_enum" CASCADE;
CREATE TABLE "public"."constant_enum" (
"enum_code" INTEGER NOT NULL, 
"enum_name" VARCHAR(50)  DEFAULT '' NOT NULL, 
"enum_type" VARCHAR(50)  DEFAULT '' NOT NULL,
"enum_label" VARCHAR(50)  DEFAULT '' NOT NULL, 
"enum_desc" VARCHAR(250)  DEFAULT '' NOT NULL, 
"disabled" INTEGER DEFAULT 0 NOT NULL
);
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."constant_enum" ADD CONSTRAINT "PRIMARY" PRIMARY KEY ("enum_code");

/*
Dumping data for table 'public.constant_enum'
*/


/*
Table structure for table 'public.health_facility' => we can use SERIAL type not to use nextval
*/

CREATE SEQUENCE "public"."health_facility_id_seq";
DROP TABLE IF EXISTS "public"."health_facility" CASCADE;
CREATE TABLE "public"."health_facility" (
"ID" INTEGER NOT NULL DEFAULT NEXTVAL('health_facility_id_seq'), 
"OSM_ID" DOUBLE PRECISION,
"NAME" VARCHAR(200)  DEFAULT '' NOT NULL, 
"ADDRFULL" VARCHAR(250)  DEFAULT '' NOT NULL,
"AMENITY" VARCHAR(50) ,
"X_CORD" DOUBLE PRECISION NOT NULL, 
"Y_CORD" DOUBLE PRECISION NOT NULL,
"MODIFIED_BY" VARCHAR(250)  DEFAULT '' NOT NULL, 
"MODIFIED_DATE" TIMESTAMP NOT NULL
);
ALTER TABLE "public"."health_facility" ADD CONSTRAINT "PK_health_facility_ID" PRIMARY KEY ("ID");

/*
Dumping data for table 'public.health_facility'
*/


/*
Table structure for table 'public.health_official'
*/
CREATE SEQUENCE "public"."health_official_id_seq";
DROP TABLE IF EXISTS "public"."health_official" CASCADE;
CREATE TABLE "public"."health_official" (
"id" INTEGER NOT NULL DEFAULT NEXTVAL('health_official_id_seq'), 
"first_name" VARCHAR(50)  DEFAULT '' NOT NULL, 
"last_name" VARCHAR(50)  DEFAULT '' NOT NULL, 
"email" VARCHAR(50)  DEFAULT '' NOT NULL, 
"dob" DATE, 
"gender" VARCHAR(3) , 
"phone" VARCHAR(45) , 
"occupation" VARCHAR(50)  DEFAULT '' NOT NULL, 
"organization" VARCHAR(50)  DEFAULT '' NOT NULL, 
"created_date" TIMESTAMP NOT NULL, 
"modified_date" TIMESTAMP NOT NULL
);
ALTER TABLE "public"."health_official" ADD CONSTRAINT "PK_health_official_ID" PRIMARY KEY ("id");

/*
Dumping data for table 'public.health_official'
*/


/*
Table structure for table 'public.pui_follow_up'
*/
CREATE SEQUENCE "public"."pui_follow_up_id_seq";
DROP TABLE IF EXISTS "public"."pui_follow_up" CASCADE;
CREATE TABLE "public"."pui_follow_up" (
"id" INTEGER NOT NULL DEFAULT NEXTVAL('pui_follow_up_id_seq'), 
"created_date" TIMESTAMP, 
"description" VARCHAR(255) , 
"modified_by" VARCHAR(250) , 
"modified_date" TIMESTAMP, 
"option_selected" VARCHAR(255) , 
"pui_case_code" VARCHAR(255) , 
"questionier_id" INTEGER
);
ALTER TABLE "public"."pui_follow_up" ADD CONSTRAINT "PK_pui_follow_up_ID" PRIMARY KEY ("id");
CREATE INDEX "FK2oldyg9oi2obhptfub3tehw9e00000" ON "public"."pui_follow_up" ("pui_case_code");
CREATE INDEX "FKndggiw6xsvbd4ctr9n00ha98i00000" ON "public"."pui_follow_up" ("questionier_id");

/*
Dumping data for table 'public.pui_follow_up'
*/


/*
Table structure for table 'public.pui_info'
*/

CREATE SEQUENCE "public"."pui_info_id_seq";
DROP TABLE IF EXISTS "public"."pui_info" CASCADE;
CREATE TABLE "public"."pui_info" (
"id" INTEGER NOT NULL DEFAULT NEXTVAL('pui_info_id_seq'), 
"case_code" VARCHAR(255) , 
"contact_parent_case_code" VARCHAR(255) , 
"country_of_origin" VARCHAR(255) , 
"country_of_residence" VARCHAR(255) , 
"dob" DATE, 
"first_name" VARCHAR(255) , 
"last_name" VARCHAR(255) ,
"gender" VARCHAR(255) , 
"house_no" VARCHAR(255) , 
"incident_contact_phone_1" VARCHAR(255) , 
"incident_contact_phone_2" VARCHAR(255) , 
"kebele" VARCHAR(255) ,  
"latitude" VARCHAR(255) , 
"longitude" VARCHAR(255) , 
"modified_by" VARCHAR(250) , 
"modified_date" TIMESTAMP, 
"nationality" VARCHAR(255) , 
"occupation" VARCHAR(255) , 
"passport_number" VARCHAR(255) , 
"phone_no" VARCHAR(255) , 
"recent_travel_to" VARCHAR(255) , 
"region" VARCHAR(255) , 
"reporting_date" TIMESTAMP, 
"subcity_or_zone" VARCHAR(255) , 
"woreda" VARCHAR(255) ,
"confirmed_result" INTEGER, 
"identified_by" INTEGER, 
"presumptive_result" INTEGER, 
"status" INTEGER, 
"admitted_to_facility" INTEGER);
ALTER TABLE "public"."pui_info" ADD CONSTRAINT "PK_pui_info_ID" PRIMARY KEY ("id");
CREATE UNIQUE INDEX "UK_1bjsftk8ltvdljyafalsfghtm00000" ON "public"."pui_info" ("case_code");

/*
Dumping data for table 'public.pui_info'
*/


/*
Table structure for table 'public.questionier'
*/

CREATE SEQUENCE "public"."questionier_id_seq";
DROP TABLE IF EXISTS "public"."questionier" CASCADE;
CREATE TABLE "public"."questionier" (
"id" INTEGER NOT NULL DEFAULT NEXTVAL('questionier_id_seq'), 
"category" INTEGER, 
"created_date" TIMESTAMP, 
"description" VARCHAR(255) , 
"modified_by" VARCHAR(250) , 
"modified_date" TIMESTAMP, 
"options" VARCHAR(255) , 
"parent_id" INTEGER, 
"question" VARCHAR(255)
);
ALTER TABLE "public"."questionier" ADD CONSTRAINT "PR_questionier_ID" PRIMARY KEY ("id");

/*
Dumping data for table 'public.questionier'
*/


/*
Table structure for table 'public.role'
*/

CREATE SEQUENCE "public"."role_id_seq";
DROP TABLE IF EXISTS "public"."role" CASCADE;
CREATE TABLE "public"."role" (
"id" INTEGER NOT NULL DEFAULT NEXTVAL('role_id_seq'), 
"name" VARCHAR(255)  DEFAULT '' NOT NULL, 
"enabled" INTEGER DEFAULT 1 NOT NULL
);
ALTER TABLE "public"."role" ADD CONSTRAINT "PR_role_ID" PRIMARY KEY ("id");

/*
Dumping data for table 'public.role'
*/


/*
Table structure for table 'public.eth_user'
*/

CREATE SEQUENCE "public"."eth_user_id_seq";
DROP TABLE IF EXISTS "public"."eth_user" CASCADE;
CREATE TABLE "public"."eth_user" (
"id" INTEGER NOT NULL DEFAULT NEXTVAL('eth_user_id_seq'), 
"username" VARCHAR(255)  DEFAULT '' NOT NULL, 
"password" VARCHAR(255)  DEFAULT '' NOT NULL, 
"first_name" VARCHAR(255)  DEFAULT '' NOT NULL, 
"last_name" VARCHAR(255) , 
"account_non_expired" INTEGER NOT NULL, 
"account_non_locked" INTEGER NOT NULL, 
"enabled" INTEGER NOT NULL, 
"last_access" TIMESTAMP NOT NULL
);
ALTER TABLE "public"."eth_user" ADD CONSTRAINT "PR_eth_user_ID" PRIMARY KEY ("id");
ALTER TABLE "public"."eth_user" ADD CONSTRAINT "PR_eth_user_name_unique" UNIQUE (username);

/*
Dumping data for table 'public.eth_user'
*/


/*
Table structure for table 'public.user_roles'
*/

DROP TABLE IF EXISTS "public"."user_roles" CASCADE;
CREATE TABLE "public"."user_roles" (
"user_id" INTEGER NOT NULL,
"role_id" INTEGER NOT NULL
);
ALTER TABLE "public"."user_roles" ADD CONSTRAINT "PR_role_id_user_id_ID" PRIMARY KEY ("role_id", "user_id");

/*
Dumping data for table 'public.user_roles'
*/

/*
 * CASE STATUS REPORTING TABLE
 */
CREATE SEQUENCE CASE_STAT_SEQ;
CREATE TABLE CASE_STAT (
ID INTEGER NOT NULL DEFAULT NEXTVAL('CASE_STAT_SEQ'),
NEW_CASES INTEGER NOT NULL,
NEW_DEATHS INTEGER NOT NULL,
TOTAL_DEATHS INTEGER NOT NULL,
TOTAL_RECOVERED INTEGER NOT NULL,
ACTIVE_CASES INTEGER NOT NULL,
SERIOUS_CRITICAL_CASES INTEGER NOT NULL,
TOTAL_CASES INTEGER NOT NULL,
REPORT_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE CASE_STAT ADD CONSTRAINT PK_CASE_STAT_ID PRIMARY KEY (ID);


-- 10/04/20
ALTER TABLE CASE_STAT ADD COLUMN NEW_TESTS INTEGER NOT NULL DEFAULT 0;
ALTER TABLE CASE_STAT ADD COLUMN TOTAL_TESTS INTEGER NOT NULL DEFAULT 0;

CREATE SEQUENCE rumor_id_seq;
CREATE TABLE  rumor_reports (
	id INTEGER NOT NULL DEFAULT NEXTVAL('rumor_id_seq'),
	suspect_name  VARCHAR(250) NOT NULL,
	gender  VARCHAR(1),
	address  VARCHAR(250),
	fever BOOLEAN NOT NULL DEFAULT FALSE,
	cough BOOLEAN NOT NULL DEFAULT FALSE,
	headache BOOLEAN NOT NULL DEFAULT FALSE,
	symptoms_duration INTEGER,
	reporting_person_name VARCHAR(250) NOT NULL,
	relation_with_suspect VARCHAR(250) NULL,
	phone_number1 VARCHAR(250) NOT NULL,
	phone_number2 VARCHAR(250) NULL,
	status  INTEGER NOT NULL DEFAULT 1080,
	modified_by VARCHAR(250), 
	modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	report_date TIMESTAMP
);
ALTER TABLE rumor_reports ADD CONSTRAINT rumor_reports_pk PRIMARY KEY (id);
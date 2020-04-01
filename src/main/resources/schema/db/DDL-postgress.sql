/*
File name: C:\Users\prg\Desktop\projects\covid19-Rest-api\src\main\resources\schema\db\DDL-postgress.sql
Creation date: 04/01/2020
Created by MySQL to PostgreSQL 4.5 [Demo]
--------------------------------------------------
More conversion tools at http://www.convert-in.com
*/
set client_encoding to 'UTF8';

/*
Table structure for table 'public.constant_enum'
*/

DROP TABLE IF EXISTS "public"."constant_enum" CASCADE;
CREATE TABLE "public"."constant_enum" ("enum_code" INTEGER NOT NULL, "enum_name" VARCHAR(50)  DEFAULT '' NOT NULL, "enum_type" VARCHAR(50)  DEFAULT '' NOT NULL, "enum_label" VARCHAR(50)  DEFAULT '' NOT NULL, "enum_desc" VARCHAR(250)  DEFAULT '' NOT NULL, "disabled" INTEGER DEFAULT 0 NOT NULL);
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."constant_enum" ADD CONSTRAINT "PRIMARY" PRIMARY KEY ("enum_code");

/*
Dumping data for table 'public.constant_enum'
*/


/*
Table structure for table 'public.health_facility'
*/

DROP TABLE IF EXISTS "public"."health_facility" CASCADE;
CREATE TABLE "public"."health_facility" ("ID" SERIAL NOT NULL, "OSM_ID" DOUBLE PRECISION, "NAME" VARCHAR(200)  DEFAULT '' NOT NULL, "ADDRFULL" VARCHAR(250)  DEFAULT '' NOT NULL, "AMENITY" VARCHAR(50) , "X_CORD" DOUBLE PRECISION NOT NULL, "Y_CORD" DOUBLE PRECISION NOT NULL, "MODIFIED_BY" VARCHAR(250)  DEFAULT '' NOT NULL, "MODIFIED_DATE" TIMESTAMP NOT NULL);
ALTER SEQUENCE "public"."health_facility_id_seq" RESTART WITH 1 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00000";
ALTER TABLE "public"."health_facility" ADD CONSTRAINT "PRIMARY00000" PRIMARY KEY ("ID");

/*
Dumping data for table 'public.health_facility'
*/


/*
Table structure for table 'public.health_official'
*/

DROP TABLE IF EXISTS "public"."health_official" CASCADE;
CREATE TABLE "public"."health_official" ("id" SERIAL NOT NULL, "first_name" VARCHAR(50)  DEFAULT '' NOT NULL, "last_name" VARCHAR(50)  DEFAULT '' NOT NULL, "email" VARCHAR(50)  DEFAULT '' NOT NULL, "dob" DATE, "gender" VARCHAR(3) , "phone" VARCHAR(45) , "occupation" VARCHAR(50)  DEFAULT '' NOT NULL, "organization" VARCHAR(50)  DEFAULT '' NOT NULL, "created_date" TIMESTAMP NOT NULL, "modified_date" TIMESTAMP NOT NULL);
ALTER SEQUENCE "public"."health_official_id_seq" RESTART WITH 1 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00001";
ALTER TABLE "public"."health_official" ADD CONSTRAINT "PRIMARY00001" PRIMARY KEY ("id");

/*
Dumping data for table 'public.health_official'
*/


/*
Table structure for table 'public.pui_follow_up'
*/

DROP TABLE IF EXISTS "public"."pui_follow_up" CASCADE;
CREATE TABLE "public"."pui_follow_up" ("id" SERIAL NOT NULL, "created_date" TIMESTAMP, "description" VARCHAR(255) , "modified_by" VARCHAR(250) , "modified_date" TIMESTAMP, "option_selected" VARCHAR(255) , "pui_case_code" VARCHAR(255) , "questionier_id" INTEGER);
ALTER SEQUENCE "public"."pui_follow_up_id_seq" RESTART WITH 1 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00002";
ALTER TABLE "public"."pui_follow_up" ADD CONSTRAINT "PRIMARY00002" PRIMARY KEY ("id");
DROP INDEX IF EXISTS "FK2oldyg9oi2obhptfub3tehw9e";
CREATE INDEX "FK2oldyg9oi2obhptfub3tehw9e00000" ON "public"."pui_follow_up" ("pui_case_code");
DROP INDEX IF EXISTS "FKndggiw6xsvbd4ctr9n00ha98i";
CREATE INDEX "FKndggiw6xsvbd4ctr9n00ha98i00000" ON "public"."pui_follow_up" ("questionier_id");

/*
Dumping data for table 'public.pui_follow_up'
*/


/*
Table structure for table 'public.pui_info'
*/

DROP TABLE IF EXISTS "public"."pui_info" CASCADE;
CREATE TABLE "public"."pui_info" ("id" SERIAL NOT NULL, "case_code" VARCHAR(255) , "contact_parent_case_code" VARCHAR(255) , "country_of_origin" VARCHAR(255) , "country_of_residence" VARCHAR(255) , "dob" DATE, "first_name" VARCHAR(255) , "gender" VARCHAR(255) , "house_no" VARCHAR(255) , "incident_contact_phone_1" VARCHAR(255) , "incident_contact_phone_2" VARCHAR(255) , "kebele" VARCHAR(255) , "last_name" VARCHAR(255) , "latitude" VARCHAR(255) , "longitude" VARCHAR(255) , "modified_by" VARCHAR(250) , "modified_date" TIMESTAMP, "nationality" VARCHAR(255) , "occupation" VARCHAR(255) , "passport_number" VARCHAR(255) , "phone" VARCHAR(255) , "phone_no" VARCHAR(255) , "recent_travel_to" VARCHAR(255) , "region" VARCHAR(255) , "reporting_date" TIMESTAMP, "subcity_or_zone" VARCHAR(255) , "woreda" VARCHAR(255) , "confirmed_result" INTEGER, "identified_by" INTEGER, "presumptive_result" INTEGER, "status" INTEGER, "admitted_to_facility" INTEGER);
ALTER SEQUENCE "public"."pui_info_id_seq" RESTART WITH 1 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00003";
ALTER TABLE "public"."pui_info" ADD CONSTRAINT "PRIMARY00003" PRIMARY KEY ("id");
DROP INDEX IF EXISTS "UK_1bjsftk8ltvdljyafalsfghtm";
CREATE UNIQUE INDEX "UK_1bjsftk8ltvdljyafalsfghtm00000" ON "public"."pui_info" ("case_code");
DROP INDEX IF EXISTS "FKtdtucn82o40uvsseooutf7kvh";
CREATE INDEX "FKtdtucn82o40uvsseooutf7kvh00000" ON "public"."pui_info" ("confirmed_result");
DROP INDEX IF EXISTS "FKh6nc668vxh3ny0vg6k7eo8os3";
CREATE INDEX "FKh6nc668vxh3ny0vg6k7eo8os300000" ON "public"."pui_info" ("identified_by");
DROP INDEX IF EXISTS "FKqwxq76hx3fjftw7lqselx5p5o";
CREATE INDEX "FKqwxq76hx3fjftw7lqselx5p5o00000" ON "public"."pui_info" ("presumptive_result");
DROP INDEX IF EXISTS "FKelfx5ja1tsqbpj1sjnxsd0wcx";
CREATE INDEX "FKelfx5ja1tsqbpj1sjnxsd0wcx00000" ON "public"."pui_info" ("status");

/*
Dumping data for table 'public.pui_info'
*/


/*
Table structure for table 'public.questionier'
*/

DROP TABLE IF EXISTS "public"."questionier" CASCADE;
CREATE TABLE "public"."questionier" ("id" SERIAL NOT NULL, "category" INTEGER, "created_date" TIMESTAMP, "description" VARCHAR(255) , "modified_by" VARCHAR(250) , "modified_date" TIMESTAMP, "options" VARCHAR(255) , "parent_id" INTEGER, "question" VARCHAR(255) );
ALTER SEQUENCE "public"."questionier_id_seq" RESTART WITH 1 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00004";
ALTER TABLE "public"."questionier" ADD CONSTRAINT "PRIMARY00004" PRIMARY KEY ("id");

/*
Dumping data for table 'public.questionier'
*/


/*
Table structure for table 'public.role'
*/

DROP TABLE IF EXISTS "public"."role" CASCADE;
CREATE TABLE "public"."role" ("id" INTEGER NOT NULL, "name" VARCHAR(255)  DEFAULT '' NOT NULL, "enabled" INTEGER DEFAULT 1 NOT NULL);
DROP INDEX IF EXISTS "PRIMARY00005";
ALTER TABLE "public"."role" ADD CONSTRAINT "PRIMARY00005" PRIMARY KEY ("id");

/*
Dumping data for table 'public.role'
*/


/*
Table structure for table 'public.eth_user'
*/

DROP TABLE IF EXISTS "public"."eth_user" CASCADE;
CREATE TABLE "public"."eth_user" ("id" INTEGER NOT NULL, "username" VARCHAR(255)  DEFAULT '' NOT NULL, "password" VARCHAR(255)  DEFAULT '' NOT NULL, "first_name" VARCHAR(255)  DEFAULT '' NOT NULL, "last_name" VARCHAR(255) , "account_non_expired" INTEGER NOT NULL, "account_non_locked" INTEGER NOT NULL, "enabled" INTEGER NOT NULL, "last_access" TIMESTAMP NOT NULL);
DROP INDEX IF EXISTS "PRIMARY00006";
ALTER TABLE "public"."eth_user" ADD CONSTRAINT "PRIMARY00006" PRIMARY KEY ("id");

/*
Dumping data for table 'public.eth_user'
*/


/*
Table structure for table 'public.user_roles'
*/

DROP TABLE IF EXISTS "public"."user_roles" CASCADE;
CREATE TABLE "public"."user_roles" ("user_id" INTEGER NOT NULL, "role_id" INTEGER NOT NULL);
DROP INDEX IF EXISTS "PRIMARY00007";
ALTER TABLE "public"."user_roles" ADD CONSTRAINT "PRIMARY00007" PRIMARY KEY ("role_id", "user_id");
DROP INDEX IF EXISTS "fk_user_role_user";
CREATE INDEX "fk_user_role_user00000" ON "public"."user_roles" ("user_id");

/*
Dumping data for table 'public.user_roles'
*/


-- CONSTANTS
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('TEST_PENDING','1001', 'TEST_RESULT', 'Pending', 'Pending test', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('TEST_NEGATIVE', '1002','TEST_RESULT', 'Negative', 'Negative', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('TEST_POSITIVE', '1003','TEST_RESULT', 'Positive', 'Positive', false);


INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('CLINICAL_EVALUATION','1020','IDENTIFIED_BY', 'Clinical evaluation', 'Identified by clinical evaluation', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('CONTACT_TRACING','1021','IDENTIFIED_BY', 'Contact tracing', 'Identified by contact tracing', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('COMMUNITY_SURVEILLANCE','1022','IDENTIFIED_BY', 'Community surveillance', 'Identified by community surveillance', false);


INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('PUI_INFO','1040','QUESTIONNIER_CATEGORY', 'PUI Information', 'Information about Person under investigation', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('SYMPTOMS','1041','QUESTIONNIER_CATEGORY', 'Symptoms', 'Symptoms', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('EXISTING_CONDITION','1042','QUESTIONNIER_CATEGORY', 'Existing condition', 'Existing condition', false);


INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('STABLE','1060','STATUS', 'PUI Status stable.', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('CRITICAL','1061','STATUS', 'PUI Status critical.', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('DECEASED','1062','STATUS', 'PUI Status deceased.', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('RECOVERED','1063','STATUS', 'PUI Status recovered.', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('NA','1064','STATUS', 'Not available', '', false);
--INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('IN_ISOLATION','1065','STATUS', 'PUI in Isolation.', '', false);


INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('PENDING','1080','RUMOR_STATUS', 'Rumor Status pending approval.', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('WAITING_RESULT','1081','RUMOR_STATUS', 'Rumor status waiting for clinical evaluation', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('REGISTERED_AS_CASE','1082','RUMOR_STATUS', 'Rumor status tested positive.', '', false);
INSERT INTO CONSTANT_ENUM(ENUM_NAME, ENUM_CODE, ENUM_TYPE, ENUM_LABEL, ENUM_DESC, DISABLED) VALUES('IN_ISOLATION','1083','RUMOR_STATUS', 'Rumor Status tested negative.', '', false);

-- USER ROLES
INSERT INTO "public"."role"("id", "enabled", "name") VALUES('1', true, 'ADMIN');
INSERT INTO "public"."role"("id", "enabled", "name") VALUES('2', true, 'HEALTH_OFFICER');


-- result, patient status and rumor possible workflow transitions
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1001, 1002, false, 'Test result Pending to Negative.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1001, 1003, false, 'Test result Pending to Positive.');

INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1060, 1061, false, 'PUI status Stable to Critical.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1060, 1062, false, 'PUI status Stable to Deceased.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1060, 1063, false, 'PUI status Stable to Recovered.');

INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1061, 1060, false, 'PUI status Critical to Stable.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1061, 1062, false, 'PUI status Critical to Deceased.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1061, 1063, false, 'PUI status Critical to Recovered.');

INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1064, 1060, false, 'PUI status NA to Stable.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1064, 1061, false, 'PUI status NA to Critical.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1064, 1062, false, 'PUI status NA to Deceased.');
INSERT INTO workflow (start_state, end_state, disabled, description) VALUES (1064, 1063, false, 'PUI status NA to Recovered.');

-- sample user, password=[pass]
INSERT INTO public.eth_user (id,username,"password",first_name,last_name,account_non_expired,account_non_locked,enabled, last_access )
	VALUES (1,'user1','$2a$12$AiKXxSsVUgsZ1jc7k7D8jOMbFIJsxV718bdK8B7U1AyeGF0smnEC2','Bambo','Kase',true, true, true, current_date);


INSERT INTO user_roles (user_id,role_id) VALUES (1,1); -- admin
INSERT INTO user_roles (user_id,role_id) VALUES (1,2); -- health-officer

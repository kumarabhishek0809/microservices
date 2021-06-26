--For Oracle DB.
--this file is loaded by spring boot 
DROP USER OAUTH;

CREATE TABLESPACE tbs_OAUTH DATAFILE 'tbs_oauth.dat' SIZE 10M AUTOEXTEND ON;

CREATE USER oauth IDENTIFIED BY oauth DEFAULT TABLESPACE tbs_OAUTH QUOTA unlimited on tbs_OAUTH;

GRANT create session TO oauth;
GRANT create table TO oauth;
GRANT create sequence TO oauth;

drop table oauth_client_details;

create table oauth_client_details (
  client_id varchar2(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret varchar2(256),
  scope varchar2(256),
  authorized_grant_types varchar2(256),
  web_server_redirect_uri varchar2(256),
  authorities varchar2(256),
  access_token_validity number(20),
  refresh_token_validity number(20),
  additional_information varchar2(500),
  autoapprove char(1) DEFAULT '1'
);

drop table oauth_client_token cascade constraints;

create table oauth_client_token (
  token_id varchar2(256),
  token NUMBER,
  authentication_id varchar2(256) PRIMARY KEY,
  user_name varchar2(256),
  client_id varchar2(256)
);

drop table oauth_access_token cascade constraints;

create table oauth_access_token (
  token_id varchar2(256),
  token NUMBER,
  authentication_id varchar2(256) PRIMARY KEY,
  user_name varchar2(256),
  client_id varchar2(256),
  authentication NUMBER,
  refresh_token varchar2(256)
);

drop table oauth_refresh_token cascade constraints;

create table oauth_refresh_token (
  token_id varchar2(256),
  token NUMBER,
  authentication NUMBER
);

drop table oauth_code cascade constraints;

create table oauth_code (
  code varchar2(256), authentication NUMBER
);

drop table oauth_approvals cascade constraints;

create table oauth_approvals (
	userId varchar2(256),
	clientId varchar2(256),
	scope varchar2(256),
	status varchar2(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);


drop table client_details cascade constraints;

-- customized oauth_client_details table
create table client_details (
  appId varchar2(256) PRIMARY KEY,
  resourceIds varchar2(256),
  appSecret varchar2(256),
  scope varchar2(256),
  grantTypes varchar2(256),
  redirectUrl varchar2(256),
  authorities varchar2(256),
  access_token_validity number(20),
  refresh_token_validity number(20),
  additionalInformation varchar2(500),
  autoApproveScopes varchar2(256)
);



INSERT INTO OAUTH.OAUTH_CLIENT_DETAILS(CLIENT_ID,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,
AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE)
VALUES ('webapp','websecret','trust,read,write','password,authorization_code,refresh_token',null,null,36000,36000,
                    null,1);

INSERT INTO OAUTH.OAUTH_CLIENT_DETAILS(CLIENT_ID,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,
AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE)
VALUES ('resource1','secret','trust,read,write','password,authorization_code,refresh_token',null,null,36000,36000,
                    null,1);
                    
                    
                    
                    

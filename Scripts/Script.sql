CREATE DATABASE luuzun_board;
USE luuzun_board;

CREATE TABLE member(
	member_id VARCHAR(50) NOT NULL PRIMARY KEY,
	member_name VARCHAR(50) NOT NULL,
	member_password VARCHAR(10) NOT NULL,
	member_reg_date DATETIME NOT NULL
);

CREATE TABLE article(
   article_no 	INT(11) 		NOT NULL auto_increment,
   writer_id 	VARCHAR(50) 	NOT NULL,
   wirter_name 	VARCHAR(50) 	NOT NULL,
   title 		VARCHAR(255) 	NOT NULL,
   reg_date		DATETIME 		NOT NULL,
   mod_date		DATETIME 		NOT NULL,
   read_cnt 	INT (11) 		DEFAULT 0,
   PRIMARY KEY (article_no)
);

CREATE TABLE article_content(
   article_no 	INT(11) NOT NULL,
   content 		TEXT,
   PRIMARY KEY (article_no)
);


CREATE DATABASE project_erp;
USE project_erp;
CREATE TABLE project_info (
	project_no 			INT				NOT NULL PRIMARY KEY auto_increment,
	project_name		VARCHAR(100)	NOT NULL,
	project_content		TEXT			NOT NULL,
	project_begin_date	DATE			NOT NULL,
	project_end_date	DATE			NOT NULL,
	project_progress	VARCHAR(20) 	NOT NULL
);

USE board;
SELECT * FROM MEMBER;
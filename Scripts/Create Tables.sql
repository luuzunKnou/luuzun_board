-- 
DROP DATABASE luuzun_board;

CREATE DATABASE luuzun_board;
USE luuzun_board;


CREATE TABLE member (
	member_id       VARCHAR(50) NOT NULL, 
	member_name     VARCHAR(50) NOT NULL, 
	member_password VARCHAR(20) NOT NULL, 
	member_reg_date DATE        NOT NULL,
	PRIMARY KEY (member_id)
);

CREATE TABLE article (
	article_no       INTEGER(11) NOT NULL AUTO_INCREMENT, 
	writer_id        VARCHAR(50) NOT NULL, 
	title            VARCHAR(50) NOT NULL, 
	article_reg_date DATE        NOT NULL, 
	article_mod_date DATE        NOT NULL, 
	read_cnt         INTEGER     DEFAULT 0,
	PRIMARY KEY (article_no),
	FOREIGN KEY (writer_id) 
		REFERENCES member (member_id)
		ON UPDATE CASCADE
);

CREATE TABLE article_content (
	article_no INTEGER(11)  NOT NULL, 
	content    TEXT         NULL, 
	file_path  VARCHAR(200) NULL, 
	FOREIGN KEY (article_no) 
		REFERENCES article (article_no)
		ON DELETE CASCADE,
	PRIMARY KEY (article_no)
);

CREATE TABLE article_comment (
	comment_no INTEGER(11)  NOT NULL,
	article_no INTEGER(11)  NOT NULL, 
	content    TEXT         NULL,
	parent_no  INTEGER(11)   
	FOREIGN KEY (article_no) 
		REFERENCES article (article_no)
		ON DELETE CASCADE,
	FOREIGN KEY (parent_no) 
		REFERENCES article_comment (comment_no),
	PRIMARY KEY (article_no)
);

INSERT INTO member
(member_id, member_name, member_password, member_reg_date)
VALUES('luuzun', '이원준', '1234', CURDATE());

INSERT INTO member
(member_id, member_name, member_password, member_reg_date)
VALUES('dididas', '이승우', '1234', CURDATE());

INSERT INTO member
(member_id, member_name, member_password, member_reg_date)
VALUES('ASOR', '신진욱', '1234', CURDATE());

SELECT * FROM MEMBER;

SELECT * FROM article;



SELECT * FROM article JOIN MEMBER ON article.writer_id = MEMBER.member_id;
SELECT * FROM article_content 
	JOIN article ON article_content.article_no = article.article_no
	JOIN MEMBER ON article.writer_id = MEMBER.member_id;

SELECT * FROM article_content;
INSERT INTO article	(writer_id, title, article_reg_date, article_mod_date)
			VALUES("ASOR", "ASOR", CURDATE(), CURDATE());
			
select distinct last_insert_id() from article;

INSERT INTO article_content
		(article_no, content, file_path)
		VALUES(1, "String", "")
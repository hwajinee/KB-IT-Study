-- 뷰 : 읽기 전용으로 쓴다.

-- 특정 쿼리문을 자주 사용할 떄, 매번 타이핑하는 것은 비효율적임. (주로 조인 쿼리문)
-- 따라서, 이를 뷰로 생성하여 생성한 뷰 이름으로 가져와서 사용한다.
-- 예) 쇼핑몰 구매 내역 -> 반품한 상품 내역

-- 실습_심화1) 테이블

CREATE DATABASE tabledb3;
USE tabledb3;
DROP TABLE IF EXISTS userTBL;
CREATE TABLE userTBL(
	userID 		CHAR(8) NOT NULL PRIMARY KEY,
    name 		VARCHAR(10) NOT NULL,
    birthyear 	INT NOT NULL
);

DROP TABLE IF EXISTS buyTBL;
CREATE TABLE buyTBL(
	num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    userID 		CHAR(8) NOT NULL,
    prodName	CHAR(6) NOT NULL,
    FOREIGN KEY (userID) REFERENCES userTBL(userID)
);

DROP TABLE IF EXISTS buyTBL;
DROP TABLE IF EXISTS userTBL;

CREATE TABLE userTBL(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    email CHAR(30) NULL UNIQUE
);

DROP TABLE IF EXISTS userTBL;
CREATE TABLE userTBL(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10),
    birthyear INT CHECK(birthyear >= 1900 AND birthyear <= 2023),
    mobile CHAR(3) NOT NULL
);

DROP TABLE IF EXISTS userTBL;
CREATE TABLE userTBL(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL DEFAULT -1,
    addr CHAR(3) NOT NULL DEFAULT '서울',
    mobile1 CHAR(3) NULL,
	mobile2 CHAR(8) NULL,
    height SMALLINT NULL DEFAULT 170,
    mDate DATE NULL
);

INSERT INTO userTBL values('CHJ', '최화진', 1999, '경기도', '010', '12341234', '161', '2025-05-19');
INSERT INTO userTBL(userID, name, mobile1, mobile2, mDate) values('PJW', '박지원','010', '23452345', '2025-04-13');
INSERT INTO userTBL(userID, name, birthyear, mobile1, mobile2, mDate) values('HBW', '황병웅', '2000', '010', '24682468', '2025-03-21');

ALTER TABLE userTBL
DROP COLUMN mobile1;

ALTER TABLE userTBL
CHANGE COLUMN name uName VARCHAR(10) NOT NULL;

ALTER TABLE userTBL
DROP PRIMARY KEY;

SELECT * FROM userTBL;

-- 실습_심화2) 뷰

USE employees;

-- 1. EMPLOYEES_INFO 뷰 생성
CREATE VIEW EMPLOYEES_INFO
AS
SELECT e.*, t.title, t.from_date AS t_from, t.to_date AS t_to, s.salary, s.from_date AS s_from, s.to_date AS s_to
FROM employees e
	INNER JOIN titles t
	ON e.emp_no = t.emp_no
	INNER JOIN salaries s
    ON s.emp_no = e.emp_no;
    
SELECT * FROM EMPLOYEES_INFO;

-- 2. EMPLOYEES_INFO 뷰에서 현재 재직중인 사람의 정보만 출력
SELECT * FROM EMPLOYEES_INFO
WHERE t_to > CURDATE() AND s_to > CURDATE();

-- 3. EMP_DEPT_INFO 뷰 생성 
SELECT * FROM dept_emp;
SELECT * FROM departments; -- dept_name

CREATE VIEW EMP_DEPT_INFO
AS
SELECT emp_no, de.dept_no, dept_name, from_date, to_date
FROM dept_emp de
	INNER JOIN departments d
    ON de.dept_no = d.dept_no;
    
SELECT * FROM EMP_DEPT_INFO;

-- 4. EMP_DEPT_INFO 에서 현재 재직자의 부서 정보만 출력
SELECT * FROM EMP_DEPT_INFO
WHERE to_date > CURDATE();




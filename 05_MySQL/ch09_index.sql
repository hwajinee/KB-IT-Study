USE sqldb;

-- 1. 기본키 -> 클러스터형 인덱스 자동 생성
CREATE TABLE tbl1 (
	a INT PRIMARY KEY,
    b INT,
	c INT
);
SHOW INDEX FROM tbl1;

CREATE TABLE tbl2 (
	a INT PRIMARY KEY,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
SHOW INDEX FROM tbl2;

CREATE TABLE tbl3(
	a INT UNIQUE,
	b INT UNIQUE,
	c INT UNIQUE,
	d INT
);
SHOW INDEX FROM tbl3;

CREATE TABLE tbl4(
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
SHOW INDEX FROM tbl4;

-- 5. UNIQUE + NOT NULL과 PK가 둘 다 있다면, PK가 클러스터형 인덱스
CREATE TABLE tbl5(
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT PRIMARY KEY
);
SHOW INDEX FROM tbl5;

CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr CHAR(2) NOT NULL
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울');

SHOW INDEX FROM usertbl;
SELECT * FROM  usertbl; -- 기본키인 userID로 정렬되어 있음.

ALTER TABLE usertbl DROP PRIMARY KEY;
ALTER TABLE usertbl ADD CONSTRAINT pk_name PRIMARY KEY(name);

SHOW INDEX FROM usertbl;
SELECT * FROM  usertbl; -- 변경한 기본키인 name으로 정렬되어 있음.

USE sqldb;
SELECT * FROM usertbl;

SHOW INDEX FROM usertbl;
SHOW TABLE STATUS LIKE 'usertbl'; -- 인덱스 크기 확인

CREATE INDEX idx_usertbl_addr ON usertbl(addr); -- 인덱스 생성
SHOW INDEX FROM usertbl;

SHOW TABLE STATUS LIKE 'usertbl'; -- index-length가 0이 나옴.
ANALYZE TABLE usertbl; -- 생성한 인덱스를 실제 적용시킴.
SHOW TABLE STATUS LIKE 'usertbl'; -- 적용된 index_length 가 나옴.

CREATE UNIQUE INDEX idx_usertbl_birthYear ON usertbl(birthYear); -- 에러 발생 ) 중복값이 있어서 UNIQUE 인덱스 생성 불가
-- UNIQUE INDEX : 중복값 있을 경우 에러 발생
CREATE UNIQUE INDEX idx_usertbl_name ON usertbl(name); -- 중복값이 없는 name에 대해서는 UNIQUE 인덱스 생성 가능
SHOW INDEX FROM usertbl;

-- name 보조 인덱스 삭제
DROP INDEX idx_usertbl_name ON usertbl;

-- name, birthYear 조합으로 unique index 생성
CREATE UNIQUE INDEX idx_usertbl_name_birthYear
ON usertbl(name, birthYear);

SHOW INDEX FROM usertbl;

-- 인덱스 삭제
DROP INDEX idx_usertbl_name_birthYear ON usertbl;
DROP INDEX idx_usertbl_addr ON usertbl;
SHOW INDEX FROM usertbl;

-- <사용자 관리>
-- 실습 데이터 베이스 및 사용자를 생성하고, 해당 데이터베이스에 대해 모든 권한을 부여하세요.
CREATE DATABASE scoula_db;

DROP USER IF EXISTS 'scoula'@'%';
CREATE USER 'scoula'@'%' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON scoula_db.* TO 'scoula'@'%';
GRANT ALL PRIVILEGES ON sqldb.* TO 'scoula'@'%';
FLUSH PRIVILEGES; -- 실제 권한 적용











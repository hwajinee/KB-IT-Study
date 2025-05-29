DROP DATABASE IF EXISTS tabledb;
CREATE DATABASE tabledb;
USE tabledb;

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
	-- 컬럼명     타입   제약조건
	userID 		CHAR(8) NOT NULL PRIMARY KEY,
    name 		VARCHAR(10) NOT NULL,
    birthYear 	INT NOT NULL,
    addr		CHAR(2) NOT NULL,
    mobile1		CHAR(3) NULL,
    mobile2		CHAR(8) NULL,
    height		SMALLINT NULL,
    mDate		DATE NULL
);

DROP TABLE IF EXISTS buytbl;

CREATE TABLE buytbl(
	-- 컬럼 레벨 정의
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 번호로 기본키 만들 때, AUTO_INCREMENT NOT NULL PRIMARY KEY !!!
	userID CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL,
    groupName CHAR(4) NULL,
    price INT NOT NULL,
    amount SMALLINT NOT NULL,
    -- 테이블 레벨 정의
    FOREIGN KEY(userID) REFERENCES usertbl(userID) -- FOREIGN KEY(컬럼명) REFERENCES 참조테이블(참조컬럼)
);

-- INSERT INTO 테이블명 VALUES( 컬럼 ... )
INSERT INTO usertbl VALUES();
INSERT INTO usertbl VALUES(), (), ();

INSERT INTO usertbl VALUES('JYP', '조용필', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

-- 첫번째 컬럼인 num은 AUTO_INCREMENT이므로, NULL로 저장. (직접 지정하는 것도 가능)
INSERT INTO buytbl VALUES
(NULL, 'KBS', '운동화', NULL, 30, 2),
(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);
    
SELECT * FROM usertbl;
SELECT * FROM buytbl;

-- 실습(뷰 생성)
CREATE VIEW view1
AS
SELECT u.userid, u.name, b.prodName, u.addr, CONCAT(mobile1, mobile2) AS '연락처'
FROM usertbl u
	INNER JOIN buytbl b
		ON u.userid = b.userid;

SELECT * FROM view1;
SELECT * FROM view1 WHERE userid='KBS';


-- < 제약 조건 >
-- 1. 기본키 제약 조건 ) 중복이나 NULL을 허용하지 않음.
-- 	  기본 키로 생성한 것은 자동으로 클러스터형 인덱스 생성 ->  즉, 기본키로 테이블이 정렬된다는 뜻. * 검색 속도 빠름
	  
--	  두 개 이상의 컬럼을 합친 복합키를 기본키로 정의하는 테이블의 경우, 테이블 레벵에서 기본키를 정의해야 한다.
--	  CONSTRAINT 제약조건명
--		         PRIMARY KEY (컬럼1, 컬럼2)
--    (기본키가 하나일 때도 테이블레벨에서 정의할 수 있지만, 주로 컬럼레벨에서 정의함.)

-- 2. 외래키 제약 조건
-- 	  데이터의 무결성 보장
-- 	  * 외래키 설정 시, 사용할 참조 컬럼은 PK 또는 UQ 여야 함. 즉, 중복이 없는 값이여야 한다.
--    ON DELETE CASCADE/ON UPDATE CASCADE 옵션 - 기준 데이터 변경 시, 외래키 테이블 적용 여부 설정
--	  - ) 회원이 탈퇴할 경우, 회원의 구매이력을 삭제하면 매출내역에도 변화가 생김. -> 회원 delete 테이블을 따로 만들어서 해결하기도 함.
--    테이블 생성한 뒤, ALTER TABLE로 외래키를 설정할 수 있음. 

-- 3. UNIQUE 제약 조건
--    중복 X , NULL값은 허용
--    Unique로 정렬됨.
-- 		Q. 테이블은 기본키로 정렬되는 거 아닌가?
-- 		 테이블 자체는 PK로 정렬된 <- 클러스터형 인덱스
-- 		 UNIQUE 컬럼은 따로 분리하여 정렬한 테이블을 생성. 

-- 4. CHECK 제약 조건
-- 5. DEFAULT 정의
--	  값을 정의하지 않았을 때, 자동으로 입력될 default값을 지정할 수 있음. 
-- 6. 

-- 테이블 삭제 (DELETE)
--  IF EXISTS 같이 써줄 것.
--  외래키 테이블 먼저 삭제 후, 기준 테이블 삭제할 것. 

-- 테이블 수정 (ALTER)
--	CHANGE COLUMN : 기존 데이터가 있을 경우 변경이 가능한지 고려해야 함.


-- 실습 ) 기본키 제약조건
CREATE DATABASE tabledb2;
USE tabledb2;

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    CONSTRAINT primary_key PRIMARY KEY (userID)
);

DROP TABLE IF EXISTS prodTbl;
CREATE TABLE prodtbl(
	prodCode CHAR(3) NOT NULL,
    prodID CHAR(4) NOT NULL,
    prodDate DATETIME NOT NULL,
    proCur CHAR(10) NULL,
    CONSTRAINT primary_key PRIMARY KEY (prodCode, prodID)
);






USE sqldb;

SELECT * FROM usertbl;
SELECT * FROM buytbl;

SELECT u.userID, u.name, GROUP_CONCAT(b.prodName SEPARATOR ',') AS '상품목록'
FROM usertbl u
LEFT OUTER JOIN buytbl b
	ON u.userID = b.userID
GROUP BY u.userID;

SELECT u.userID, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2) AS '연락처'
FROM usertbl u
LEFT OUTER JOIN buytbl b
ON u.userID = b.userID
ORDER BY userID;

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력하세요
SELECT name, CONCAT(mobile1, mobile2) AS '전화번호'
FROM usertbl
WHERE name NOT IN 
	(SELECT name FROM usertbl WHERE mobile1 IS NULL);

SELECT name, CONCAT(mobile1, mobile2) AS '전화번호'
FROM usertbl
WHERE name IN 
	(SELECT name FROM usertbl WHERE mobile1 IS NULL);





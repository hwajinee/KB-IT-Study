SHOW DATABASES;

USE employees;

SHOW TABLES;

DESC employees;

SELECT * FROM titles;

SELECT first_name FROM employees;

SELECT first_name, last_name, gender FROM employees;

SELECT * FROM employees;

SELECT first_name AS '이름', gender AS '성별', hire_date AS '회사 입사일'
FROM employees;

USE sqldb;

SELECT * FROM usertbl WHERE name='김경호';

SELECT * FROM usertbl WHERE birthYear >= 1970 AND height >= 182;

SELECT * FROM usertbl WHERE height >= 180 AND height <= 183;

SELECT * FROM usertbl WHERE addr='경남' OR addr='전남' OR addr='경북';

SELECT * FROM usertbl WHERE name LIKE '김%';

SELECT name, height
FROM usertbl
WHERE height > (SELECT height FROM usertbl WHERE name = '김경호');

SELECT *
FROM usertbl
ORDER BY mDate;

SELECT *
FROM usertbl
ORDER BY mDate DESC;

SELECT *
FROM usertbl
ORDER BY height DESC, name DESC;

SELECT DISTINCT addr
FROM usertbl
ORDER BY addr;

USE world;

SELECT population
FROM city
WHERE CountryCode='KOR'
ORDER BY population DESC;

SELECT CountryCode, population
FROM city
ORDER BY CountryCode, population DESC;

SELECT COUNT(CountryCode)
FROM city
WHERE CountryCode = 'KOR';

SELECT Name
FROM city
WHERE CountryCode = 'KOR' OR  CountryCode = 'CHN' OR  CountryCode = 'JPN';

SELECT Name
FROM city
WHERE CountryCode = 'KOR' AND Population >= 1000000;

SELECT Name, Population
FROM city
WHERE CountryCode = 'KOR'
ORDER BY Population DESC LIMIT 10;

SELECT Name, Population
FROM city
WHERE CountryCode = 'KOR' AND Population >= 1000000 AND Population <= 5000000;

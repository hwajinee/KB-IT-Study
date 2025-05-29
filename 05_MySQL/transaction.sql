USE sqldb;

SELECT * FROM buytbl;

START TRANSACTION;
DELETE FROM buytbl WHERE num = 1;
DELETE FROM buytbl WHERE num = 2;

SELECT * FROM buytbl;

ROLLBACK;

SELECT * FROM buytbl;
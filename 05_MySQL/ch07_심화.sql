USE sqldb;

SELECT * FROM stdtbl; -- stdName, addr
SELECT * FROM clubtbl; -- clubName, roomNo
SELECT * FROM stdclubtbl; -- num, stdName, clubName

-- 학생을 기준으로 학생 이름/지역/가입한 동아리/동아리방을 출력하세요.
SELECT S.stdName, S.addr, C.clubName, C.roomNo
FROM stdtbl S
	INNER JOIN stdclubtbl SC
		ON S.stdName=SC.stdName
	INNER JOIN clubtbl C
		ON SC.clubName=C.clubName;

-- 동아리를 기준으로 가입한 학생의 목록을 출력하세요.alter
SELECT C.clubName, C.roomNo, S.stdName, S.addr
FROM clubtbl C
	INNER JOIN stdclubtbl SC
		ON C.clubName=SC.clubName
	INNER JOIN stdtbl S
		ON SC.stdName=	S.stdName
ORDER BY C.clubName;
   
-- emptbl에서 '우대리'의 상관 연락처 정보를 확인하세요. (출력할 정보: 부하직원, 직속상관, 직속상관연락처)
SELECT * FROM emptbl;

SELECT A.emp AS 부하직원, B.emp AS '직속상관', B.empTel AS '직속상관연락처'
FROM emptbl A
INNER JOIN emptbl B
ON A.manager=B.emp
WHERE A.emp='우대리';

USE employees;

SELECT * FROM employees;

SELECT e.emp_no, e.first_name, e.last_name, GROUP_CONCAT(t.title) AS titles
FROM employees e
	INNER JOIN titles t
		ON e.emp_no=t.emp_no
GROUP BY e.emp_no;

SELECT e.*, t.title, s.salary
FROM employees e
	INNER JOIN titles t
		ON e.emp_no=t.emp_no
	INNER JOIN salaries s
		ON e.emp_no=s.emp_no;

SELECT e.emp_no, e.first_name, e.last_name, d.dept_name AS department
FROM employees e
	INNER JOIN dept_emp de
		ON e.emp_no=de.emp_no
	INNER JOIN departments d
		ON de.dept_no=d.dept_no
ORDER BY emp_no;

-- 부서번호, 부서명, 인원수
SELECT d.dept_no, d.dept_name, count(*)
FROM departments d
	INNER JOIN dept_emp de
		ON d.dept_no=de.dept_no
GROUP BY d.dept_no
ORDER BY d.dept_no;

-- 직원 번호가 10209인 직원의 부서 이동 히스토리를 출력하세요.
-- 출력항목: employees(emp_no, first_name, last_name), departments(dept_name), dept_emp(from_date, to_date)
SELECT e.emp_no, e.first_name, e.last_name, d.dept_name, de.from_date, de.to_date
FROM employees e
	INNER JOIN dept_emp de
		ON e.emp_no=de.emp_no
	INNER JOIN departments d
		ON de.dept_no=d.dept_no
WHERE e.emp_no=10209;









-- 04_집합.sql
SELECT * FROM employees WHERE first_name LIKE '%a%'; -- 66명
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 30명

-- INTERSECT : 교집합
SELECT * FROM employees WHERE first_name LIKE '%a%'
INTERSECT
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 20명

-- UNION : 합집합
SELECT * FROM employees WHERE first_name LIKE '%a%'
UNION
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 76명

-- UNION ALL : 합집합 (중복 행 제거 안함)
SELECT * FROM employees WHERE first_name LIKE '%a%'
UNION ALL
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 96명

-- MINUS : 차집합
SELECT * FROM employees WHERE first_name LIKE '%a%'
MINUS
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 46명

SELECT * FROM employees WHERE last_name LIKE '%o%'
MINUS
SELECT * FROM employees WHERE first_name LIKE '%a%'; -- 10명

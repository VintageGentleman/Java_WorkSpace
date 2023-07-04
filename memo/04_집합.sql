-- 04_����.sql
SELECT * FROM employees WHERE first_name LIKE '%a%'; -- 66��
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 30��

-- INTERSECT : ������
SELECT * FROM employees WHERE first_name LIKE '%a%'
INTERSECT
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 20��

-- UNION : ������
SELECT * FROM employees WHERE first_name LIKE '%a%'
UNION
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 76��

-- UNION ALL : ������ (�ߺ� �� ���� ����)
SELECT * FROM employees WHERE first_name LIKE '%a%'
UNION ALL
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 96��

-- MINUS : ������
SELECT * FROM employees WHERE first_name LIKE '%a%'
MINUS
SELECT * FROM employees WHERE last_name LIKE '%o%'; -- 46��

SELECT * FROM employees WHERE last_name LIKE '%o%'
MINUS
SELECT * FROM employees WHERE first_name LIKE '%a%'; -- 10��

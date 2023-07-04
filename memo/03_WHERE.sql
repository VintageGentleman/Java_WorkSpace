-- 03_WHERE.sql

/*
    # SELECT 컬럼명 FROM 테이블명 WHERE 조건절;
    
    - SELECT문 뒤에 WHERE절을 추가하여 해당 조건을 만족하는 행만 조회할 수 있다    
    - 조건에 사용되는 데이터는 대소문자에 영향을 받는다
    - 오라클의 비교 연산자와 논리 연산자를 사용해 조건절을 만들 수 있다
    
    # 비교 연산자
    
    =            : 같으면 true, (==은 안된다)
    !=, <>, ^=   : 다르면 true
    <, >, <=, >= : 비교
    
    # 논리 연산자
    
    AND, OR, NOT
*/

SELECT * FROM employees WHERE job_id = 'FI_ACCOUNT';
SELECT * FROM employees WHERE job_id = 'fi-account'; -- 안됨

-- 숫자 타입 비교
SELECT * FROM employees WHERE salary >= 10000;
SELECT * FROM employees WHERE salary <= 5000;

-- 문자 타입 비교
SELECT * FROM employees WHERE first_name < 'C';
SELECT * FROM employees WHERE first_name >= 'T';
SELECT * FROM employees WHERE job_id = 'SH_CLERK';
SELECT * FROM employees WHERE job_id != 'SH_CLERK';
SELECT * FROM employees WHERE job_id <> 'SH_CLERK';
SELECT * FROM employees WHERE job_id ^= 'SH_CLERK';

-- 날짜 타입 비교
SELECT * FROM employees WHERE hire_date >= '2007/09/09';

-- AND, OR, NOT
SELECT * FROM employees
WHERE hire_date >= '2007/09/09' AND job_id = 'SH_CLERK';

SELECT * FROM employees
WHERE job_id = 'SH_CLERK' OR job_id = 'IT_PROG';

-- 연습1: 월급이 2000에서 3000사이인 사원들의 이름,월급,직책을 조회해보세요
SELECT first_name AS 이름, salary AS 월급, job_id AS 직책 FROM employees
WHERE salary >= 2000 AND salary <= 3000;

-- 연습2: 30, 60, 100번 부서에 속한 사원들의 이름, 전화번호, 부서번호를 조회해보세요.
SELECT first_name AS 이름, phone_number  AS 전화번호, department_id AS 부서번호 FROM employees
WHERE department_id = 30 OR department_id = 60 OR department_id = 100; 

-- # 컬럼명 BETWEEN A AND B : 해당 컬럼 값이 A와 B사이인 경우 true
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 3000;
SELECT * FROM employees WHERE hire_date BETWEEN '05/01/01' AND '05/12/31';

-- # 컬럼명 IN (A,B,C...) : ()안의 내용에 해당 값이 있으면 true
SELECT * FROM employees WHERE department_id IN (30, 60, 100);
SELECT * FROM employees WHERE job_id IN ('SH_CLERK', 'FI_ACCOUNT');

-- ()안의 나열하는 장소에는 다른 쿼리문이 들어갈 수 있다
SELECT * FROM employees WHERE department_id
IN (SELECT DISTINCT department_id FROM employees WHERE job_id IN ('SH_CLERK', 'FI_ACCOUNT'));

-- null은 크기 비교가 불가능하기 때문에 일반 비교 연산자를 통해 연산할 수 없다
SELECT * FROM employees WHERE commission_pct = null;

-- 해당 컬럼의 행이 null인 경우를 조회하고 싶다면 IS NULL을 사용해야 한다
SELECT first_name, salary, NVL(commission_pct, 0) AS commission FROM employees 
WHERE commission_pct IS NULL;

-- 반대로, NULL이 아닌 경우를 조회하고 싶을 때는
-- IS NOT NULL 또는 NOT 컬럼 IS NULL을 사용한다
SELECT first_name, commission_pct FROM employees
WHERE commission_pct IS NOT NULL;

SELECT first_name, commission_pct FROM employees
WHERE NOT commission_pct IS NULL;

-- # 사원번호가 홀수인 사원들만 조회해보기
--   데이터베이스에서 %는 연산자가 아니므로
--   나머지를 구하고 싶다면 MOD() 함수를 사용해야 한다
SELECT * FROM employees WHERE MOD(employee_id, 2) = 1;
SELECT * FROM employees WHERE MOD(employee_id, 2) = 0;

/*
    # 조건으로 LIKE 사용하기
    
    - 데이터의 일부분이 일치하는 내용을 조회할 수 있다
    - % : 길이 제한 없이 문자가 있어도 되고 없어도 되는 자리
    - _ : 어떤 문자든 한 글자가 반드시 존재해야하는 자리
*/

SELECT first_name FROM employees WHERE first_name LIKE 'A%'; -- A로 시작
SELECT first_name FROM employees WHERE first_name LIKE '_a%'; -- 2번째 글자가 a
SELECT first_name FROM employees WHERE first_name LIKE '__a%'; -- 3번째 글자가 a
SELECT first_name FROM employees WHERE first_name LIKE '%a'; -- a로 끝남
SELECT first_name FROM employees WHERE first_name LIKE '%a_'; -- 뒤에서 2번째 글자가 a

SELECT hire_date FROM employees WHERE hire_date LIKE '07/%'; -- 07년도 입사자
SELECT hire_date FROM employees WHERE hire_date LIKE '_2/%'; -- 2로 끝나는 년도 입사자
SELECT hire_date FROM employees WHERE hire_date LIKE '%/_2/%'; -- 2월, 12월 입사자

-- 연습1: first_name의 뒤에서 세 번째 글자가 a인 모든 사람들의 풀네임을 조회
SELECT first_name || ' ' || last_name AS 풀네임 FROM employees
WHERE first_name LIKE '%a__';

-- 연습2: first_name에 e가 두 개 이상 포함된 사원들의 풀네임을 조회
SELECT first_name || ' ' || last_name AS 풀네임 FROM employees
WHERE first_name LIKE '%e%e%';

SELECT first_name || ' ' || last_name AS 풀네임 FROM employees
WHERE LOWER(first_name) LIKE '%e%e%'; -- 첫 대문자 E 포함되는 로직
-- UPPER(value) : 모두 대문자로 변환하는 함수
-- LOWER(value) : 모두 소문자로 변환하는 함수

-- 연습3: first_name이 다섯 글자이면서 r로 끝나는 사원들의 풀네임을 조회
SELECT first_name || ' ' || last_name AS 풀네임 FROM employees
WHERE first_name LIKE '____r';

-- 연습4: 8월에 입사한 사원들의 이름과 고용일을 조회
SELECT first_name AS 이름, hire_date AS 고용일 FROM employees
WHERE hire_date LIKE '%/08/%';

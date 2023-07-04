-- 02_SELECT.sql

/*
    # SELECT 컬럼명 FROM 테이블명;
    
    - 원하는 테이블의 원하는 컬럼을 조회할 수 있는 쿼리문
    - 여러 컬럼을 조회할 때는 ,를 사용해 구분한다
    - 컬럼명 자리에 *를 쓰는 것은 모든 컬럼을 의미한다
    - 컬럼명과 테이블명은 대소문자를 구분하지 않는다
    - 쿼리문과 명령어도 대소문자를 구분하지 않는다
    - 하지만, 데이터는 대소문자를 구분한다
*/

-- ctrl + F7 자동형식 맞춤
select FIRST_NAME from EMPLOYEES; 
SELECT FiRsT_NaMe FROM EmPlOyEeS;
SELECT first_name FROM employees;
SELECT first_name,salary FROM employees;
SELECT * FROM employees;

-- # HR 계정에 미리 만들어져있는 연습용 테이블들
SELECT * FROM tab;
SELECT * FROM countries; -- 나라 정보 테이블
SELECT * FROM employees; -- 사원 정보 테이블
SELECT * FROM departments; -- 부서 정보 테이블
SELECT * FROM jobs; -- 직급 정보 테이블
SELECT * FROM regions; -- 대륙 정보 테이블
SELECT * FROM locations; -- 지역 정보 테이블
SELECT * FROM job_history; -- 근무 내역 테이블 (부서 이동 or 퇴사)

-- 연습1 : 모든 부서의 부서번호와 부서명을 조회해보세요
SELECT department_id, department_name FROM departments;
-- 연습2 : 모든 사원의 사원번호/이름/월급/고용일/부서번호를 조회해보세요
SELECT employee_id, first_name, last_name, salary, hire_date, department_id FROM employees;

/*
    # DESC 테이블명
    
    - 해당 테이블의 컬럼 정보를 볼 수 있다
    - 컬럼명, NULL 가능 여부, 컬럼타입을 볼 수 있다
    
    # NUMBER (n), NUMBER (n, m)
    
    - 숫자 데이터를 저장할 수 있는 컬럼 타입
    - 숫자가 하나만 적혀있으면 정수의 길이를 나타낸다
    - 숫자가 두 개 적혀있으면 숫자 전체의 길이와 소수점 자리수를 나타낸다
    
    NUMBER(8) : 정수 8자리까지 저장가능한 숫자 컬럼
    NUMBER(8,2) : 정수 부분은 6자리, 소수 부분은 2자리까지 저장가능한 숫자 컬럼
    NUMBER(2,2) : 정수 부분은 0자리, 소수 부분은 2자리까지 저장가능한 숫자 컬럼
    
    # VARCHAR2(n)
    
    - 문자를 저장할 수 있는 타입
    - 저장되는 데이터의 크기에 맞춰 알맞은 공간만 사용하도록 설계되어 있다
    - 저장 공간을 효율적으로 사용할 수 있다
    
    # CHAR(n)
    
    - 문자를 저장할 수 있지만 크기가 저절로 조절 되지 않는 컬럼 타입
    - 데이터 크기에 맞추지 않고 항상 일정한 공간을 차지한다
    - 해당 컬럼의 성격에 따라 저장 공간 낭비가 심해질 수 있다
    - 국가 코드(ex: KR)처럼 길이가 고정되어있는 행만 지닌 컬럼은 
      CHAR 타입이 더 좋을 수 있다
      
    # DATE
    
    - 날짜 및 시간 데이터를 저장할 수 있는 컬럼 타입
*/

DESC employees;
DESC departments;
DESC countries;

-- # AS를 사용해 컬럼 이름을 원하는 이름으로 설정하여 조회할 수 있다
SELECT first_name AS 이름, last_name AS 성, salary AS 월급 FROM employees;

-- # 컬럼 값에 산술 연산자를 활용할 수 있다
SELECT
    salary AS "한 달치",
    salary * 2 AS "두 달치",
    salary * 3 AS "세 달치",
    first_name
FROM employees;

-- # 컬럼끼리도 계산할 수 있다
-- # NVL(column, value)
--   : 해당 컬럼 값이 null value인 경우 대신 사용할 값을 지정하는 함수
SELECT
    salary,
    commission_pct,
    salary * NVL(commission_pct, 0) AS bonus,
    salary + NVL(salary * commission_pct,0) AS total_salary,
    first_name
FROM
    employees;

-- # 두 컬럼을 이어붙여서 출력할 수 있다 (이어붙이기)
SELECT first_name || ' ' || last_name AS full_name FROM employees;

-- 연습1: 모든 사원들의 '사원번호, 풀네임, 직책, 연봉(SALARY는 월급)'을 조회해보세요
SELECT
    employee_id AS 사원번호,
    first_name || ' ' || last_name AS 풀네임,
    job_id AS 직책,
    salary * 12 AS 연봉
FROM                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
    employees;

-- # SELECT DISTINCT : 각 데이터를 한 번씩만 출력한다 (중복 제거)
SELECT DISTINCT job_id FROM employees; -- 존재하는 직책을 한 번씩만 출력
SELECT job_id FROM employees; -- 모든 사원의 직책을 모두 출력

SELECT DISTINCT department_id FROM employees; -- 존재하는 부서 번호 보기




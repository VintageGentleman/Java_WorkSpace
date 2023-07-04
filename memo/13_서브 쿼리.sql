-- 13_서브 쿼리.sql

/*
    # 서브 쿼리
    
    - 쿼리문 내부에 포함된 또 다른 쿼리문
    - 서브 쿼리를 포함하고 있는 쿼리를 메인 쿼리라고 부른다
    - 서브 쿼리의 실행 결과에 따라 단일 행 서브 쿼리와 다중 행 서브 쿼리로 분류한다
    - 단일 행 대상 연산자와 다중 행 대상 연산자가 다르다
    - 서브 쿼리는 비교 또는 연산 값으로 활용되거나 
      조회해야하는 테이블 대용으로 활용될 수 있다
    
    # 단일 행 서브 쿼리
    
    - 서브 쿼리의 결과가 단 하나의 행인 경우
    - 단일 값끼리 비교하는 일반 연산자를 사용할 수 있다(=, >, <, ...)
    
    # 다중 행 서브 쿼리
    
    - 서브 쿼리의 결과가 2행 이상일 수도 있는 경우
    - 다중 행 연산자와 함께 사용해야 한다
      (IN, ANY, SOME, ALL, EXISTS, ...)
*/

/*
    # 단일 행 서브 쿼리
    
    - 테이블에서 하나의 행을 선택하는 가장 확실한 방법은 기본키를 사용하는 것이다
*/

-- 값 대신 서브쿼리 사용
SELECT * FROM employees 
WHERE salary >= (SELECT salary FROM employees WHERE employee_id = 102);

-- 테이블 대신 서브쿼리 사용
SELECT * FROM (SELECT job_id, job_title FROM jobs WHERE job_id = 'IT_PROG');

/*
    # 다중 행 서브 쿼리 연산자
    
    - IN     : 여러 값들 중 일치하는 것이 하나라도 있으면 true
    - ANY    : 여러 값들 중 하나라도 조건을 만족시키는 것이 있으면 true
    - SOME   : ANY랑 같음
    - ALL    : 모든 값들이 조건을 만족시켜야 true
    - EXISTS : 값이 하나라도 존재하면 true  
*/

-- # IN

-- ex : Steven이라는 사람이 속해있는 직책의 모든 직원들을 조회
SELECT * FROM employees WHERE job_id IN
(SELECT DISTINCT job_id FROM employees WHERE first_name = 'Steven');

-- # ANY, SOME

SELECT * FROM employees WHERE salary > ANY(8000, 10000, 5000, 8800);
SELECT * FROM employees WHERE salary > SOME(8000, 10000, 5000, 8800);
SELECT * FROM employees WHERE salary > 5000;

-- ex: IT 개발자들 중 가장 못 버는 사람보다 더 많이 버는 사람들을 모두 조회
SELECT * FROM employees WHERE
salary > ANY(SELECT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id != 'IT_PROG';

-- # ALL
-- ex: 모든 IT 개발자들보다 월급을 많이 받는 사원들을 조회
SELECT * FROM employees WHERE
salary > ALL(SELECT salary FROM employees WHERE job_id = 'IT_PROG');

-- # EXISTS

-- ex: 최대 급여를 받는 사원이 있는 부서를 조회
SELECT * FROM departments dept
WHERE EXISTS
(SELECT employee_id FROM employees emp INNER JOIN jobs USING (job_id)
WHERE salary = max_salary AND emp.department_id = dept.department_id);

-- 연습1: job_title에 Manager가 포함되는 사원들의 전화번호를 조회
SELECT 
    phone_number
FROM 
    employees
WHERE
    job_id IN(SELECT job_id FROM jobs WHERE LOWER(job_title) LIKE '%manager%');

-- # rownum : 행 번호 컬럼

-- ex: 월급 순으로 10명을 조회하고 싶은 경우
--     순서대로 5명을 먼저 뽑고 월급 순으로 정렬을 하는 문제 발생한다
SELECT rownum, first_name FROM employees
WHERE rownum <= 10 ORDER BY salary DESC;

-- 서브쿼리에서 정렬을 먼저 진행한 후 rownum을 붙여서 원하는 데이터를 조회할 수 있다
SELECT rownum, emp.*
FROM (SELECT * FROM employees ORDER BY salary DESC) emp
WHERE rownum <= 10;

-- rownum을 통해 월급 순위 20 ~ 30등을 조회하려고 했으나
-- 조회되지 않는다
-- => rownum 1번이 조건을 만족하지 못하면 해당 행이 삭제되면서
--    다음 행이 rownum 1이 되기 때문
SELECT rownum, emp.*
FROM (SELECT * FROM employees ORDER BY salary DESC) emp
WHERE rownum >= 20;

-- 정렬하고 rownum을 붙인 결과를 또다시 서브쿼리로 조회하여
-- 월급 순위 20등 ~ 30등을 조회할 수 있다
SELECT rownum, emp2.* FROM (SELECT rownum rn, emp.*
FROM (SELECT * FROM employees ORDER BY salary DESC) emp) emp2
WHERE rn BETWEEN 20 AND 30;



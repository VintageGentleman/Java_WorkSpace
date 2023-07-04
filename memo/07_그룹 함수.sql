-- 07_그룹 함수.sql

/*
    # 그룹 함수
    
    - 하나의 컬럼값을 그룹 기준으로 삼아 여러 행들을 하나로 합쳐 조회하는 것
    - 그룹의 기준이 되는 컬럼을 GROUP BY절을 통해 선택할 수 있다
    - 그룹 함수를 사용하면 일반 컬럼은 함께 출력할 수 없다
      그룹의 대상이 되는 컬럼과 그룹 함수의 결과만 출력 가능하다
*/

SELECT * FROM employees;

-- # SUM(column) : 해당 컬럼의 총합을 구해주는 그룹 함수
SELECT SUM(salary) FROM employees;

-- 부서 번호별 월급의 총합
SELECT department_id, SUM(salary) FROM employees GROUP BY department_id;

-- 직책별 월급의 총합
SELECT job_id, SUM(salary) FROM employees GROUP BY job_id;

-- 같은 이름을 가진 사람들의 총합
SELECT first_name, SUM(salary) FROM employees GROUP BY first_name;

-- # AVG(column) : 해당 컬럼의 평균값을 구하는 그룹 함수
SELECT 
    DECODE(job_id,
        'IT_PROG', '프로그래머',
        job_id
    ) AS job_id,
    SUM(salary),
    AVG(salary)
FROM
    employees
GROUP BY
     job_id;
     
-- # COUNT(column) : 해당 컬럼의 행의 개수를 구하는 그룹 함수 (null을 제외)
SELECT COUNT(*) FROM employees;
SELECT COUNT(commission_pct) FROM employees;
SELECT COUNT(department_id) FROM employees;
SELECT COUNT(job_id) FROM employees;
SELECT COUNT(manager_id) FROM employees;

-- # MAX(column) : 해당 컬럼의 최대값을 구하는 그룹 함수
-- # MIN(column) : 해당 컬럼의 최소값을 구하는 그룹 함수
SELECT department_id, MIN(hire_date), MAX(hire_date)
FROM employees GROUP BY department_id;

-- 연습1: 각 직책별 평균 연봉을 구해보세요 (월급 말고 연봉)

SELECT job_id, AVG(salary * 12) AS 평균연봉 FROM employees GROUP BY job_id;

-- 연습2: 각 직책별로 가장 최근에 사원이 입사한 날짜와
-- 가장 오래전 입사한 날짜를 조회해보세요.

SELECT
    job_id,
    MAX(hire_date) AS 최근입사날,
    MIN(hire_date) AS 가장오래전입사날
FROM
    employees
GROUP BY
    job_id;
 
/*
    # HAVING
    
    - 그룹 함수의 결과에 대해 조건을 적용하고 싶은 경우 사용한다
    - WHERE절은 그룹화 전의 행들로 조건을 만들 수 있고
      HAVING절은 그룹 함수 적용 후의 값들로 조건을 만들 수 있다
*/

-- ex : 직책별 평균 월급이 10000달러 이상인 직책에 속한 사원들의 수
SELECT job_id, COUNT(salary) FROM employees
GROUP BY job_id HAVING AVG(salary) >= 10000;

-- ex : 각 부서에 월급이 8000달러 이상인 사원들이 3명 이상인 부서만 출력
SELECT department_id, COUNT(*) FROM employees
WHERE salary >= 8000
GROUP BY department_id
HAVING COUNT(*) >= 3;



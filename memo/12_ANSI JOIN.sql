-- 12_ANSI JOIN.sql

/*
    # ANSI JOIN
    
    - ANSI에서 지정한 표준 JOIN 문법
    - 다른 관계형 데이터베이스에서도 사용할 수 있는 표준 문법    
    
    * ANSI(America National Standard Institute) : 미국 국제 표준 기구
*/

-- # CROSS JOIN
SELECT * FROM employees CROSS JOIN departments;

/*
    # INNER JOIN (조건을 충족하는 행만 등장하는 것)
    
    - 조인 조건에는 ON 절을 사용하고 원하는 조건에는 WHERE절을 사용
    - 조인하는 두 테이블이 조인하기 위해 사용하는 컬럼명이 같다면 USING을 사용할 수 있다
      (조인에 사용된 컬럼이 맨 앞으로 이동되고, 중복도 알아서 제거된다)
*/

SELECT * FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id WHERE salary <= 5000;

SELECT * FROM employees e INNER JOIN departments d USING (department_id);

-- 연습1: 모든 사원들의 사원번호/이름/부서명을 조회해보세요
SELECT
    employee_id     AS 사원번호,
    first_name      AS 이름,
    department_name AS 부서명
FROM
         employees 
    INNER JOIN departments USING ( department_id )
ORDER BY
    employee_id;
    
-- 연습2: job_id가 IT_PROG인 사원들의 사원번호/이름/부서번호/부서명을 조회해보세요
SELECT
    employee_id     AS 사원번호,
    first_name      AS 이름,
    department_id   AS 부서번호,
    department_name AS 부서명
FROM
         employees 
    INNER JOIN departments USING ( department_id )
WHERE
    job_id = 'IT_PROG';      
    
-- 연습3: 커미션을 받는 사원들의 사원번호/이름/직책명(job_title)을 조회해보세요
--       Hint. jobs table
SELECT
    employee_id AS 사원번호,
    first_name  AS 이름,
    job_title   AS 직책명
FROM
         employees
    INNER JOIN jobs USING ( job_id )
WHERE
    commission_pct IS NOT NULL
ORDER BY
    employee_id;
    
-- 연습4: Seattle에서 근무하는 사원들의 이름/부서명/급여/city를 조회해보세요
--       Hint. locations table
SELECT
    first_name      AS 이름,
    department_name AS 부서명,
    salary          AS 급여,
    city
FROM
         employees 
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations   USING ( location_id )
WHERE
    city = 'Seattle';

SELECT 
    emp.first_name || ' ' || emp.last_name AS 이름,
    mgr.first_name || ' ' || mgr.last_name As 매니저이름
FROM
        employees emp 
    INNER JOIN employees mgr ON emp.manager_id = mgr.employee_id;

/*
    # OUTER JOIN (조건을 충족하지 않는 행도 등장하는 것)
    
    1. LEFT OUTER JOIN : 오른쪽 테이블에 (+)를 추가하는 효과
    2. RIGHT OUTER JOIN : 왼쪽 테이블에 (+)를 추가하는 효과
    3. FULL OUTER JOIN : 양쪽 모두에 (+)를 추가하는 효과
*/

SELECT 
    first_name,
    department_name
FROM
    employees FULL OUTER JOIN departments USING (department_id)
ORDER BY
    first_name;

-- 연습1: 모든 사원들의 "이름/직책/매니저이름"을 조회하시오
SELECT
    emp.first_name AS 이름,
    job_title      AS 직책,
    mgr.first_name AS 매니저이름
FROM
        employees emp
    LEFT OUTER JOIN employees mgr ON emp.manager_id = mgr.employee_id
    INNER JOIN jobs j ON emp.job_id = j.job_id
ORDER BY
    mgr.first_name DESC;

-- 연습2: 모든 도시의 "도시이름/주소/소속부서존재여부"를 조회하시오
SELECT
    city           AS 도시이름,
    street_address AS 주소,
    CASE 
        WHEN department_id IS NULL THEN 'False'
        ELSE 'True'
    END            AS have_dept
FROM
        locations
    LEFT OUTER JOIN departments USING (location_id)
ORDER BY
    소속부서존재여부;

-- 연습3 : 모든 사원들의 "이름/월급/직책명/월급의최대치의몇퍼센트인지"를 조회하시오
SELECT
    first_name       AS 이름,
    salary           AS 월급,
    job_title        AS 직책명,
    TRUNC(
    (salary - min_salary) /
    (max_salary - min_salary)
    * 100, 2) || '%' AS eval
FROM
        employees 
    INNER JOIN jobs USING (job_id)
ORDER BY
    salary DESC;


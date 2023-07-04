-- 11_SELF JOIN.sql

/*
    # SELF JOIN
    
    - 하나의 테이블에서 자기 자신과 JOIN하여 원하는 데이터를 얻어내는 JOIN
    - 해당 테이블의 기본키를 같은 테이블의 다른 컬럼에서 외래키로 사용하는 경우
      ex: employees의 manager_id
*/

SELECT 
    emp.first_name AS 사원이름,
    emp.salary AS 부하월급,
    mgr.first_name AS 담당매니저이름,
    mgr.salary AS 상사월급
FROM employees emp, employees mgr
WHERE  emp.manager_id = mgr.employee_id;

-- 연습1: 매니저의 이름에 e가 들어가는 사원들의
--       "사원번호/이름/job_title/매니저이름"을 조회해보세요

SELECT
    emp.employee_id AS 사원번호,
    emp.first_name  AS 이름,
    job_title,
    mgr.first_name  AS 매니저이름
FROM
    employees emp,
    employees mgr,
    jobs      j
WHERE
        emp.manager_id = mgr.employee_id
    AND emp.job_id = j.job_id
    AND LOWER(mgr.first_name) LIKE '%e%'
ORDER BY
    mgr.first_name ASC;

SELECT * FROM employees;
SELECT * FROM jobs;    

-- 연습2: 담당하는 사원이 10명 이상인 매니저들과
--       해당 매니저가 담당하는 사원들의 정보를 조회해보세요   
-- 서브쿼리 형태
SELECT
    *
FROM
    employees emp,
    (SELECT * FROM employees WHERE employee_id IN
        (SELECT manager_id FROM employees GROUP BY manager_id HAVING COUNT(*) >= 10)
    ) mgr
WHERE
    emp.manager_id = mgr.employee_id
ORDER BY
    emp.employee_id;

-- UNION으로 표현
SELECT * FROM employees WHERE manager_id IN(SELECT manager_id FROM employees GROUP BY manager_id HAVING COUNT(*) >= 10)
UNION
SELECT * FROM employees WHERE employee_id IN(SELECT manager_id FROM employees GROUP BY manager_id HAVING COUNT(*) >= 10);


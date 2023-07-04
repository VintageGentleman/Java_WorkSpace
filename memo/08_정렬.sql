-- 08_정렬.sql

/*
    # ORDER BY 컬럼명 [ASC|DESC]
    
    - 조회시 원하는 컬럼 기준으로 정렬하여 출력할 수 있다
    - ASC : 오름차순(Ascending)
    - DESC : 내림차순(Descending)
    - ASC, DESC 입력 생략 시 ASC로 적용된다
*/

SELECT salary, first_name FROM employees
WHERE salary >= 10000 ORDER BY salary ASC;

-- 내림차순시 null이 먼저 등장한다 (정렬시 가장 큰 값으로 취급된다)
SELECT salary, commission_pct, first_name FROM employees
ORDER BY commission_pct DESC;

-- 오름차순시 null이 가장 나중에 등장한다
SELECT salary, commission_pct, first_name FROM employees
ORDER BY commission_pct ASC;

-- # 정렬 기준을 여러개 설정할 수 있다
-- ex: 직책 기준으로 오름차순, 직책이 같은 경우 월급 내림차순,
--     월급마저 같은경우 이름으로 오름차순
SELECT job_id, salary, first_name FROM employees
ORDER BY job_id ASC, salary DESC, first_name ASC; 

-- 연습1: 이름에 i가 포함되어 있는 사원들을 월급 많이 받는 순으로 조회
SELECT first_name, salary FROM employees WHERE LOWER(first_name) LIKE '%i%'
ORDER BY salary DESC;

-- 연습2: 모든 사원들을 성 기준으로 오름차순 정렬하고
--       성이 같은 경우 이름으로 오름차순 정렬하여 조회
SELECT first_name, last_name FROM employees 
ORDER BY last_name ASC, first_name ASC;

-- 연습3: 각 부서의 총 월급, 평균 월급, 사원 수를 조회하고
--       평균 월급 내림차순으로 정렬하여 조회
SELECT
    department_id AS 부서코드,
    SUM(salary) AS 총월급,
    TRUNC(AVG(salary), 2) AS 평균월급,
    COUNT(*) AS 사원수
FROM
    employees
GROUP BY
    department_id
ORDER BY
    AVG(salary) DESC;

/*
    # 소수점 아래 자르는 함수들
    
    - CEIL(value) : 올린다
    - FLOOR(value) : 내린다
    - ROUND(value, num) : 반올림한다 (자리수 설정 가능)
    - TRUNC(value, num) : 잘라버린다 (자리수 설정 가능)
*/

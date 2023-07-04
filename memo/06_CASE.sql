-- 06_CASE.sql

/*
    # CASE
    
    - DECODE()는 컬럼과 정확하게 일치하는 케이스만 매핑할 수 있었다
    - CASE 문법은 해당 컬럼에 원하는 조건을 적용할 수 있다
    
        CASE
            WHEN 조건절 THEN 출력할 것
            ...
            ELSE 기본값
        END        
*/

-- ex: 모든 종류의 CLERK을 3퍼센트 인상하고 싶은 경우

SELECT
    first_name,
    job_id,
    salary AS before_salary,
    CASE 
        WHEN job_id = 'IT_PROG' THEN salary * 1.1
        WHEN job_id LIKE '%_CLERK' THEN salary * 1.03
        ELSE salary        
    END AS after_salary
FROM
    employees;   
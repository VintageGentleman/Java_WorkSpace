-- 05_DECODE.sql

/*
    # DECODE
    
    - 자바의 switch-case와 유사하다
    - DECODE(column, case, value, ...)
*/

SELECT first_name, department_id FROM employees;
SELECT DISTINCT department_id FROM employees;
SELECT * FROM departments;

SELECT
    first_name,
    DECODE(department_id,
        90, '익스큐티브',        --case 90:
        100, '파이낸스',         --case 100:
        110, '어카운팅',         --case 110:
        80, '세일즈',            --case 80:
        '아직 디코드 하지 않음'    -- default
    ) AS "한글부서명"
FROM
    employees;

/*
    연습1: 직책에 따라 급여를 다음과 같이 다르게 인상하여 출력해보세요

    IT_PROG : 10%
    SH_CLERK : 2%
    ST_CLERK : 3%
    그 외 : 변동 없음
    
    'first_name/job_id/before_salary/after_salary'를 출력
*/

SELECT
    first_name,
    job_id,
    salary AS before_salary,
    DECODE(job_id,
        'IT_PROG', salary * 1.1,
        'SH_CLERK', salary * 1.02,
        'ST_CLERK', salary * 1.03,
        salary
    ) AS after_salary
FROM employees;   
    
    
-- 09_JOIN.sql

/*
    # 기본키 (Primary Key, PK)
    
    - 한 테이블에서 하나의 행을 유일하게 구분할 수 있는 컬럼
    - 각 테이블에서 기본키는 하나밖에 설정할 수 없다
    - 기본키로 설정된 컬럼에는 중복된 값이 없어야 한다 (UNIQUE)
    - 기본키로 설정된 컬럼에는 NULL 값이 없어야 한다 (NOT NULL)
    
    # 후보키 (Candidate Key)
    
    - 기본키가 될 자격을 갖추었지만 기본키로 선택되지 않은 컬럼
      (ex : employee_id, email, phone_number)
    
    # 외래키 (Foreign Key, FK)
    
    - 다른 테이블에서는 기본키(또는 후보키)이지만 해당 테이블에서는
      중복되는 값을 지닌 일반 컬럼인 경우
      ex : employees의 department_id는 외래키
           departments의 dapartment_id는 기본키
    - 외래키 컬럼에는 다른 테이블의 기본키 컬럼(참조하는 컬럼)에 없는 값은 넣으면 안된다
      (참조 무결성) (NULL은 상관없다 = 값을 넣지않은 것)
    - 어떤 테이블의 기본키(또는 후보키)가 해당 테이블의 외래키로 설정되었다면
      두 테이블간에는 1(departments):N(employees) 관계(일대다 관계)가 형성되었다고 볼 수 있다
      ex: 부서 하나에 사원 여러명이 소속할 수 있다
      
    # 개체 간 관계의 종류
    
    - 1:1 관계 : 같은 테이블 안에 컬럼으로 넣으면 된다
    - 1:N 관계 : 부서 - 사원, 글 - 댓글, 회원 - 글, 매니저 - 사원 ...
    - N:N 관계 : 피자(여러 종류의 피자) - 토핑(여러 종류의 토핑), 손님(여러 손님) - 메뉴(여러 종류), 라이더 - 음식점 ...
    
    # JOIN
    
    - 기본키와 외래키로 관계가 형성되어 있는 두 테이블의 정보를 종합하여 조회하는 것
    - CROSS JOIN
    - EQUI JOIN
    - NON-EQUI JOIN
    - SELF JOIN
    - OUTER JOIN
    - ...
*/

/*
    # CROSS JOIN
    
    - 조인에 사용되는 테이블들의 모든 행을 조합하여 
      나올 수 있는 모든 경우를 출력하는 JOIN
    - 모든 행을 조합했을 뿐인 쓸데 없는 정보
*/

SELECT * FROM employees;    -- 107 rows
SELECT * FROM departments;  -- 27 rows
SELECT * FROM employees, departments; -- 2889 rows (107 * 27) 

-- 두 테이블에 존재하는 모든 컬럼을 사용할 수 있다
-- 같은 이름의 컬럼이 존재하는 경우에는 반드시 어느 테이블 소속인지 명확하게 해야한다
SELECT
    employee_id,
    last_name,
    employees.department_id,
    departments.department_id,
    department_name
FROM employees, departments;

/*
    # EQUI_JOIN
    
    - 두 테이블에서 서로 동일한 값을 지닌 컬럼들(주로 기본키와 외래키)을 이용하여
      CROSS JOIN으로부터 의미있는 데이터를 걸러내는 JOIN
*/

SELECT
    employee_id,
    last_name,
    employees.department_id,
    departments.department_id,
    department_name
FROM
    employees, departments
WHERE
    employees.department_id = departments.department_id
ORDER BY
    employees.employee_id;
    
-- 연습1: 모든 사원들의 사원번호/이름/부서명을 조회해보세요
SELECT
    employee_id     AS 사원번호,
    first_name      AS 이름,
    department_name AS 부서명
FROM
    employees emp,
    departments dept
WHERE
    emp.department_id = dept.department_id
ORDER BY
    employee_id;

-- 연습2: job_id가 IT_PROG인 사원들의 사원번호/이름/부서번호/부서명을 조회해보세요
SELECT
    employee_id     AS 사원번호,
    first_name      AS 이름,
    e.department_id AS 부서번호,
    department_name AS 부서명
FROM
    employees   e,
    departments d
WHERE
        e.department_id = d.department_id
    AND job_id = 'IT_PROG';
    
-- 연습3: 커미션을 받는 사원들의 사원번호/이름/직책명(job_title)을 조회해보세요
--       Hint. jobs table
SELECT
    employee_id AS 사원번호,
    first_name  AS 이름,
    job_title   AS 직책명
FROM
    employees e,
    jobs j
WHERE
        e.job_id = j.job_id
    AND commission_pct IS NOT NULL;

-- 연습4: Seattle에서 근무하는 사원들의 이름/부서명/급여/city를 조회해보세요
--       Hint. locations table
SELECT
    first_name      AS 이름,
    department_name AS 부서명,
    salary          AS 급여,
    city
FROM
    employees e,
    departments d,
    locations l
WHERE
        e.department_id = d.department_id
    AND d.location_id = l.location_id
    AND city = 'Seattle'
ORDER BY
    employee_id;

/*
    (1) employees와 department처럼 1:N 관계로 설정할 수 있는
        실제 사례들을 생각해보세요
        
    (2) 1:N 관계로 설정한 각 개체를 테이블 형태로 설계해보세요
        (테이블명, 컬럼명, 각 컬럼 타입)
        
    (3) 어떤 컬럼이 기본키 역할을 하고 어떤 컬럼이 외래키 역할을 할지 설정해보세요
*/

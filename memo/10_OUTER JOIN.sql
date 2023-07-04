-- 10_OUTER JOIN.sql

/*
    # OUTER JOIN
    
    - JOIN 조건을 만족하지 못해 등장하지 못하는 행을 추가로 확인할 수 있는 JOIN
    - (+)를 붙인 쪽에 null을 추가해서 조건을 억지로 맞춰 등장하지 못했던 행을 조회한다
*/

-- 일반적인 조인의 경우 외래키 컬럼에 null이 있으면 조회되지 않는 행이 존재한다

-- departments쪽에 (+)를 붙이면 해당하는 부서가 없더라도 등장하게 된다
SELECT * FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
ORDER BY employee_id;

-- employees쪽에 (+)를 붙이면 employees쪽에 null을 붙여서
-- 등장하지 못했던 부서들이 등장한다
SELECT * FROM employees e, departments d
WHERE e.department_id(+) = d.department_id
ORDER BY employee_id;

-- 연습1: "부서번호/부서명/주소/도시"를 조회하되 소속된 부서가 없는 도시들도
--       함께 조회해보세요
SELECT
    department_id   AS 부서번호,
    department_name AS 부서명,
    street_address  AS 주소,
    city            AS 도시
FROM
    departments d,
    locations   l
WHERE
    d.location_id(+) = l.location_id
ORDER BY
    department_id DESC;

-- 연습2: 소속된 사원이 없는 부서만 조회해보세요
SELECT
    department_name AS 부서명
FROM
    employees   e,
    departments d
WHERE
        e.department_id (+) = d.department_id
    AND employee_id IS NULL;

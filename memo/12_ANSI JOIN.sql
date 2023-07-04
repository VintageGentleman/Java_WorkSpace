-- 12_ANSI JOIN.sql

/*
    # ANSI JOIN
    
    - ANSI���� ������ ǥ�� JOIN ����
    - �ٸ� ������ �����ͺ��̽������� ����� �� �ִ� ǥ�� ����    
    
    * ANSI(America National Standard Institute) : �̱� ���� ǥ�� �ⱸ
*/

-- # CROSS JOIN
SELECT * FROM employees CROSS JOIN departments;

/*
    # INNER JOIN (������ �����ϴ� �ุ �����ϴ� ��)
    
    - ���� ���ǿ��� ON ���� ����ϰ� ���ϴ� ���ǿ��� WHERE���� ���
    - �����ϴ� �� ���̺��� �����ϱ� ���� ����ϴ� �÷����� ���ٸ� USING�� ����� �� �ִ�
      (���ο� ���� �÷��� �� ������ �̵��ǰ�, �ߺ��� �˾Ƽ� ���ŵȴ�)
*/

SELECT * FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id WHERE salary <= 5000;

SELECT * FROM employees e INNER JOIN departments d USING (department_id);

-- ����1: ��� ������� �����ȣ/�̸�/�μ����� ��ȸ�غ�����
SELECT
    employee_id     AS �����ȣ,
    first_name      AS �̸�,
    department_name AS �μ���
FROM
         employees 
    INNER JOIN departments USING ( department_id )
ORDER BY
    employee_id;
    
-- ����2: job_id�� IT_PROG�� ������� �����ȣ/�̸�/�μ���ȣ/�μ����� ��ȸ�غ�����
SELECT
    employee_id     AS �����ȣ,
    first_name      AS �̸�,
    department_id   AS �μ���ȣ,
    department_name AS �μ���
FROM
         employees 
    INNER JOIN departments USING ( department_id )
WHERE
    job_id = 'IT_PROG';      
    
-- ����3: Ŀ�̼��� �޴� ������� �����ȣ/�̸�/��å��(job_title)�� ��ȸ�غ�����
--       Hint. jobs table
SELECT
    employee_id AS �����ȣ,
    first_name  AS �̸�,
    job_title   AS ��å��
FROM
         employees
    INNER JOIN jobs USING ( job_id )
WHERE
    commission_pct IS NOT NULL
ORDER BY
    employee_id;
    
-- ����4: Seattle���� �ٹ��ϴ� ������� �̸�/�μ���/�޿�/city�� ��ȸ�غ�����
--       Hint. locations table
SELECT
    first_name      AS �̸�,
    department_name AS �μ���,
    salary          AS �޿�,
    city
FROM
         employees 
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations   USING ( location_id )
WHERE
    city = 'Seattle';

SELECT 
    emp.first_name || ' ' || emp.last_name AS �̸�,
    mgr.first_name || ' ' || mgr.last_name As �Ŵ����̸�
FROM
        employees emp 
    INNER JOIN employees mgr ON emp.manager_id = mgr.employee_id;

/*
    # OUTER JOIN (������ �������� �ʴ� �൵ �����ϴ� ��)
    
    1. LEFT OUTER JOIN : ������ ���̺� (+)�� �߰��ϴ� ȿ��
    2. RIGHT OUTER JOIN : ���� ���̺� (+)�� �߰��ϴ� ȿ��
    3. FULL OUTER JOIN : ���� ��ο� (+)�� �߰��ϴ� ȿ��
*/

SELECT 
    first_name,
    department_name
FROM
    employees FULL OUTER JOIN departments USING (department_id)
ORDER BY
    first_name;

-- ����1: ��� ������� "�̸�/��å/�Ŵ����̸�"�� ��ȸ�Ͻÿ�
SELECT
    emp.first_name AS �̸�,
    job_title      AS ��å,
    mgr.first_name AS �Ŵ����̸�
FROM
        employees emp
    LEFT OUTER JOIN employees mgr ON emp.manager_id = mgr.employee_id
    INNER JOIN jobs j ON emp.job_id = j.job_id
ORDER BY
    mgr.first_name DESC;

-- ����2: ��� ������ "�����̸�/�ּ�/�ҼӺμ����翩��"�� ��ȸ�Ͻÿ�
SELECT
    city           AS �����̸�,
    street_address AS �ּ�,
    CASE 
        WHEN department_id IS NULL THEN 'False'
        ELSE 'True'
    END            AS have_dept
FROM
        locations
    LEFT OUTER JOIN departments USING (location_id)
ORDER BY
    �ҼӺμ����翩��;

-- ����3 : ��� ������� "�̸�/����/��å��/�������ִ�ġ�Ǹ��ۼ�Ʈ����"�� ��ȸ�Ͻÿ�
SELECT
    first_name       AS �̸�,
    salary           AS ����,
    job_title        AS ��å��,
    TRUNC(
    (salary - min_salary) /
    (max_salary - min_salary)
    * 100, 2) || '%' AS eval
FROM
        employees 
    INNER JOIN jobs USING (job_id)
ORDER BY
    salary DESC;


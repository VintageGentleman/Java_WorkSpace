-- 09_JOIN.sql

/*
    # �⺻Ű (Primary Key, PK)
    
    - �� ���̺��� �ϳ��� ���� �����ϰ� ������ �� �ִ� �÷�
    - �� ���̺��� �⺻Ű�� �ϳ��ۿ� ������ �� ����
    - �⺻Ű�� ������ �÷����� �ߺ��� ���� ����� �Ѵ� (UNIQUE)
    - �⺻Ű�� ������ �÷����� NULL ���� ����� �Ѵ� (NOT NULL)
    
    # �ĺ�Ű (Candidate Key)
    
    - �⺻Ű�� �� �ڰ��� ���߾����� �⺻Ű�� ���õ��� ���� �÷�
      (ex : employee_id, email, phone_number)
    
    # �ܷ�Ű (Foreign Key, FK)
    
    - �ٸ� ���̺����� �⺻Ű(�Ǵ� �ĺ�Ű)������ �ش� ���̺�����
      �ߺ��Ǵ� ���� ���� �Ϲ� �÷��� ���
      ex : employees�� department_id�� �ܷ�Ű
           departments�� dapartment_id�� �⺻Ű
    - �ܷ�Ű �÷����� �ٸ� ���̺��� �⺻Ű �÷�(�����ϴ� �÷�)�� ���� ���� ������ �ȵȴ�
      (���� ���Ἲ) (NULL�� ������� = ���� �������� ��)
    - � ���̺��� �⺻Ű(�Ǵ� �ĺ�Ű)�� �ش� ���̺��� �ܷ�Ű�� �����Ǿ��ٸ�
      �� ���̺����� 1(departments):N(employees) ����(�ϴ�� ����)�� �����Ǿ��ٰ� �� �� �ִ�
      ex: �μ� �ϳ��� ��� �������� �Ҽ��� �� �ִ�
      
    # ��ü �� ������ ����
    
    - 1:1 ���� : ���� ���̺� �ȿ� �÷����� ������ �ȴ�
    - 1:N ���� : �μ� - ���, �� - ���, ȸ�� - ��, �Ŵ��� - ��� ...
    - N:N ���� : ����(���� ������ ����) - ����(���� ������ ����), �մ�(���� �մ�) - �޴�(���� ����), ���̴� - ������ ...
    
    # JOIN
    
    - �⺻Ű�� �ܷ�Ű�� ���谡 �����Ǿ� �ִ� �� ���̺��� ������ �����Ͽ� ��ȸ�ϴ� ��
    - CROSS JOIN
    - EQUI JOIN
    - NON-EQUI JOIN
    - SELF JOIN
    - OUTER JOIN
    - ...
*/

/*
    # CROSS JOIN
    
    - ���ο� ���Ǵ� ���̺���� ��� ���� �����Ͽ� 
      ���� �� �ִ� ��� ��츦 ����ϴ� JOIN
    - ��� ���� �������� ���� ���� ���� ����
*/

SELECT * FROM employees;    -- 107 rows
SELECT * FROM departments;  -- 27 rows
SELECT * FROM employees, departments; -- 2889 rows (107 * 27) 

-- �� ���̺� �����ϴ� ��� �÷��� ����� �� �ִ�
-- ���� �̸��� �÷��� �����ϴ� ��쿡�� �ݵ�� ��� ���̺� �Ҽ����� ��Ȯ�ϰ� �ؾ��Ѵ�
SELECT
    employee_id,
    last_name,
    employees.department_id,
    departments.department_id,
    department_name
FROM employees, departments;

/*
    # EQUI_JOIN
    
    - �� ���̺��� ���� ������ ���� ���� �÷���(�ַ� �⺻Ű�� �ܷ�Ű)�� �̿��Ͽ�
      CROSS JOIN���κ��� �ǹ��ִ� �����͸� �ɷ����� JOIN
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
    
-- ����1: ��� ������� �����ȣ/�̸�/�μ����� ��ȸ�غ�����
SELECT
    employee_id     AS �����ȣ,
    first_name      AS �̸�,
    department_name AS �μ���
FROM
    employees emp,
    departments dept
WHERE
    emp.department_id = dept.department_id
ORDER BY
    employee_id;

-- ����2: job_id�� IT_PROG�� ������� �����ȣ/�̸�/�μ���ȣ/�μ����� ��ȸ�غ�����
SELECT
    employee_id     AS �����ȣ,
    first_name      AS �̸�,
    e.department_id AS �μ���ȣ,
    department_name AS �μ���
FROM
    employees   e,
    departments d
WHERE
        e.department_id = d.department_id
    AND job_id = 'IT_PROG';
    
-- ����3: Ŀ�̼��� �޴� ������� �����ȣ/�̸�/��å��(job_title)�� ��ȸ�غ�����
--       Hint. jobs table
SELECT
    employee_id AS �����ȣ,
    first_name  AS �̸�,
    job_title   AS ��å��
FROM
    employees e,
    jobs j
WHERE
        e.job_id = j.job_id
    AND commission_pct IS NOT NULL;

-- ����4: Seattle���� �ٹ��ϴ� ������� �̸�/�μ���/�޿�/city�� ��ȸ�غ�����
--       Hint. locations table
SELECT
    first_name      AS �̸�,
    department_name AS �μ���,
    salary          AS �޿�,
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
    (1) employees�� departmentó�� 1:N ����� ������ �� �ִ�
        ���� ��ʵ��� �����غ�����
        
    (2) 1:N ����� ������ �� ��ü�� ���̺� ���·� �����غ�����
        (���̺��, �÷���, �� �÷� Ÿ��)
        
    (3) � �÷��� �⺻Ű ������ �ϰ� � �÷��� �ܷ�Ű ������ ���� �����غ�����
*/

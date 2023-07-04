-- 11_SELF JOIN.sql

/*
    # SELF JOIN
    
    - �ϳ��� ���̺��� �ڱ� �ڽŰ� JOIN�Ͽ� ���ϴ� �����͸� ���� JOIN
    - �ش� ���̺��� �⺻Ű�� ���� ���̺��� �ٸ� �÷����� �ܷ�Ű�� ����ϴ� ���
      ex: employees�� manager_id
*/

SELECT 
    emp.first_name AS ����̸�,
    emp.salary AS ���Ͽ���,
    mgr.first_name AS ���Ŵ����̸�,
    mgr.salary AS ������
FROM employees emp, employees mgr
WHERE  emp.manager_id = mgr.employee_id;

-- ����1: �Ŵ����� �̸��� e�� ���� �������
--       "�����ȣ/�̸�/job_title/�Ŵ����̸�"�� ��ȸ�غ�����

SELECT
    emp.employee_id AS �����ȣ,
    emp.first_name  AS �̸�,
    job_title,
    mgr.first_name  AS �Ŵ����̸�
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

-- ����2: ����ϴ� ����� 10�� �̻��� �Ŵ������
--       �ش� �Ŵ����� ����ϴ� ������� ������ ��ȸ�غ�����   
-- �������� ����
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

-- UNION���� ǥ��
SELECT * FROM employees WHERE manager_id IN(SELECT manager_id FROM employees GROUP BY manager_id HAVING COUNT(*) >= 10)
UNION
SELECT * FROM employees WHERE employee_id IN(SELECT manager_id FROM employees GROUP BY manager_id HAVING COUNT(*) >= 10);


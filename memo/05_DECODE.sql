-- 05_DECODE.sql

/*
    # DECODE
    
    - �ڹ��� switch-case�� �����ϴ�
    - DECODE(column, case, value, ...)
*/

SELECT first_name, department_id FROM employees;
SELECT DISTINCT department_id FROM employees;
SELECT * FROM departments;

SELECT
    first_name,
    DECODE(department_id,
        90, '�ͽ�ťƼ��',        --case 90:
        100, '���̳���',         --case 100:
        110, '��ī����',         --case 110:
        80, '������',            --case 80:
        '���� ���ڵ� ���� ����'    -- default
    ) AS "�ѱۺμ���"
FROM
    employees;

/*
    ����1: ��å�� ���� �޿��� ������ ���� �ٸ��� �λ��Ͽ� ����غ�����

    IT_PROG : 10%
    SH_CLERK : 2%
    ST_CLERK : 3%
    �� �� : ���� ����
    
    'first_name/job_id/before_salary/after_salary'�� ���
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
    
    
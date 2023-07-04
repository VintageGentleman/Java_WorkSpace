-- 07_�׷� �Լ�.sql

/*
    # �׷� �Լ�
    
    - �ϳ��� �÷����� �׷� �������� ��� ���� ����� �ϳ��� ���� ��ȸ�ϴ� ��
    - �׷��� ������ �Ǵ� �÷��� GROUP BY���� ���� ������ �� �ִ�
    - �׷� �Լ��� ����ϸ� �Ϲ� �÷��� �Բ� ����� �� ����
      �׷��� ����� �Ǵ� �÷��� �׷� �Լ��� ����� ��� �����ϴ�
*/

SELECT * FROM employees;

-- # SUM(column) : �ش� �÷��� ������ �����ִ� �׷� �Լ�
SELECT SUM(salary) FROM employees;

-- �μ� ��ȣ�� ������ ����
SELECT department_id, SUM(salary) FROM employees GROUP BY department_id;

-- ��å�� ������ ����
SELECT job_id, SUM(salary) FROM employees GROUP BY job_id;

-- ���� �̸��� ���� ������� ����
SELECT first_name, SUM(salary) FROM employees GROUP BY first_name;

-- # AVG(column) : �ش� �÷��� ��հ��� ���ϴ� �׷� �Լ�
SELECT 
    DECODE(job_id,
        'IT_PROG', '���α׷���',
        job_id
    ) AS job_id,
    SUM(salary),
    AVG(salary)
FROM
    employees
GROUP BY
     job_id;
     
-- # COUNT(column) : �ش� �÷��� ���� ������ ���ϴ� �׷� �Լ� (null�� ����)
SELECT COUNT(*) FROM employees;
SELECT COUNT(commission_pct) FROM employees;
SELECT COUNT(department_id) FROM employees;
SELECT COUNT(job_id) FROM employees;
SELECT COUNT(manager_id) FROM employees;

-- # MAX(column) : �ش� �÷��� �ִ밪�� ���ϴ� �׷� �Լ�
-- # MIN(column) : �ش� �÷��� �ּҰ��� ���ϴ� �׷� �Լ�
SELECT department_id, MIN(hire_date), MAX(hire_date)
FROM employees GROUP BY department_id;

-- ����1: �� ��å�� ��� ������ ���غ����� (���� ���� ����)

SELECT job_id, AVG(salary * 12) AS ��տ��� FROM employees GROUP BY job_id;

-- ����2: �� ��å���� ���� �ֱٿ� ����� �Ի��� ��¥��
-- ���� ������ �Ի��� ��¥�� ��ȸ�غ�����.

SELECT
    job_id,
    MAX(hire_date) AS �ֱ��Ի糯,
    MIN(hire_date) AS ����������Ի糯
FROM
    employees
GROUP BY
    job_id;
 
/*
    # HAVING
    
    - �׷� �Լ��� ����� ���� ������ �����ϰ� ���� ��� ����Ѵ�
    - WHERE���� �׷�ȭ ���� ���� ������ ���� �� �ְ�
      HAVING���� �׷� �Լ� ���� ���� ����� ������ ���� �� �ִ�
*/

-- ex : ��å�� ��� ������ 10000�޷� �̻��� ��å�� ���� ������� ��
SELECT job_id, COUNT(salary) FROM employees
GROUP BY job_id HAVING AVG(salary) >= 10000;

-- ex : �� �μ��� ������ 8000�޷� �̻��� ������� 3�� �̻��� �μ��� ���
SELECT department_id, COUNT(*) FROM employees
WHERE salary >= 8000
GROUP BY department_id
HAVING COUNT(*) >= 3;



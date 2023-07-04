-- 08_����.sql

/*
    # ORDER BY �÷��� [ASC|DESC]
    
    - ��ȸ�� ���ϴ� �÷� �������� �����Ͽ� ����� �� �ִ�
    - ASC : ��������(Ascending)
    - DESC : ��������(Descending)
    - ASC, DESC �Է� ���� �� ASC�� ����ȴ�
*/

SELECT salary, first_name FROM employees
WHERE salary >= 10000 ORDER BY salary ASC;

-- ���������� null�� ���� �����Ѵ� (���Ľ� ���� ū ������ ��޵ȴ�)
SELECT salary, commission_pct, first_name FROM employees
ORDER BY commission_pct DESC;

-- ���������� null�� ���� ���߿� �����Ѵ�
SELECT salary, commission_pct, first_name FROM employees
ORDER BY commission_pct ASC;

-- # ���� ������ ������ ������ �� �ִ�
-- ex: ��å �������� ��������, ��å�� ���� ��� ���� ��������,
--     ���޸��� ������� �̸����� ��������
SELECT job_id, salary, first_name FROM employees
ORDER BY job_id ASC, salary DESC, first_name ASC; 

-- ����1: �̸��� i�� ���ԵǾ� �ִ� ������� ���� ���� �޴� ������ ��ȸ
SELECT first_name, salary FROM employees WHERE LOWER(first_name) LIKE '%i%'
ORDER BY salary DESC;

-- ����2: ��� ������� �� �������� �������� �����ϰ�
--       ���� ���� ��� �̸����� �������� �����Ͽ� ��ȸ
SELECT first_name, last_name FROM employees 
ORDER BY last_name ASC, first_name ASC;

-- ����3: �� �μ��� �� ����, ��� ����, ��� ���� ��ȸ�ϰ�
--       ��� ���� ������������ �����Ͽ� ��ȸ
SELECT
    department_id AS �μ��ڵ�,
    SUM(salary) AS �ѿ���,
    TRUNC(AVG(salary), 2) AS ��տ���,
    COUNT(*) AS �����
FROM
    employees
GROUP BY
    department_id
ORDER BY
    AVG(salary) DESC;

/*
    # �Ҽ��� �Ʒ� �ڸ��� �Լ���
    
    - CEIL(value) : �ø���
    - FLOOR(value) : ������
    - ROUND(value, num) : �ݿø��Ѵ� (�ڸ��� ���� ����)
    - TRUNC(value, num) : �߶������ (�ڸ��� ���� ����)
*/

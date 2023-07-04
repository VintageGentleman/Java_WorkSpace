-- 02_SELECT.sql

/*
    # SELECT �÷��� FROM ���̺��;
    
    - ���ϴ� ���̺��� ���ϴ� �÷��� ��ȸ�� �� �ִ� ������
    - ���� �÷��� ��ȸ�� ���� ,�� ����� �����Ѵ�
    - �÷��� �ڸ��� *�� ���� ���� ��� �÷��� �ǹ��Ѵ�
    - �÷���� ���̺���� ��ҹ��ڸ� �������� �ʴ´�
    - �������� ��ɾ ��ҹ��ڸ� �������� �ʴ´�
    - ������, �����ʹ� ��ҹ��ڸ� �����Ѵ�
*/

-- ctrl + F7 �ڵ����� ����
select FIRST_NAME from EMPLOYEES; 
SELECT FiRsT_NaMe FROM EmPlOyEeS;
SELECT first_name FROM employees;
SELECT first_name,salary FROM employees;
SELECT * FROM employees;

-- # HR ������ �̸� ��������ִ� ������ ���̺��
SELECT * FROM tab;
SELECT * FROM countries; -- ���� ���� ���̺�
SELECT * FROM employees; -- ��� ���� ���̺�
SELECT * FROM departments; -- �μ� ���� ���̺�
SELECT * FROM jobs; -- ���� ���� ���̺�
SELECT * FROM regions; -- ��� ���� ���̺�
SELECT * FROM locations; -- ���� ���� ���̺�
SELECT * FROM job_history; -- �ٹ� ���� ���̺� (�μ� �̵� or ���)

-- ����1 : ��� �μ��� �μ���ȣ�� �μ����� ��ȸ�غ�����
SELECT department_id, department_name FROM departments;
-- ����2 : ��� ����� �����ȣ/�̸�/����/�����/�μ���ȣ�� ��ȸ�غ�����
SELECT employee_id, first_name, last_name, salary, hire_date, department_id FROM employees;

/*
    # DESC ���̺��
    
    - �ش� ���̺��� �÷� ������ �� �� �ִ�
    - �÷���, NULL ���� ����, �÷�Ÿ���� �� �� �ִ�
    
    # NUMBER (n), NUMBER (n, m)
    
    - ���� �����͸� ������ �� �ִ� �÷� Ÿ��
    - ���ڰ� �ϳ��� ���������� ������ ���̸� ��Ÿ����
    - ���ڰ� �� �� ���������� ���� ��ü�� ���̿� �Ҽ��� �ڸ����� ��Ÿ����
    
    NUMBER(8) : ���� 8�ڸ����� ���尡���� ���� �÷�
    NUMBER(8,2) : ���� �κ��� 6�ڸ�, �Ҽ� �κ��� 2�ڸ����� ���尡���� ���� �÷�
    NUMBER(2,2) : ���� �κ��� 0�ڸ�, �Ҽ� �κ��� 2�ڸ����� ���尡���� ���� �÷�
    
    # VARCHAR2(n)
    
    - ���ڸ� ������ �� �ִ� Ÿ��
    - ����Ǵ� �������� ũ�⿡ ���� �˸��� ������ ����ϵ��� ����Ǿ� �ִ�
    - ���� ������ ȿ�������� ����� �� �ִ�
    
    # CHAR(n)
    
    - ���ڸ� ������ �� ������ ũ�Ⱑ ������ ���� ���� �ʴ� �÷� Ÿ��
    - ������ ũ�⿡ ������ �ʰ� �׻� ������ ������ �����Ѵ�
    - �ش� �÷��� ���ݿ� ���� ���� ���� ���� ������ �� �ִ�
    - ���� �ڵ�(ex: KR)ó�� ���̰� �����Ǿ��ִ� �ุ ���� �÷��� 
      CHAR Ÿ���� �� ���� �� �ִ�
      
    # DATE
    
    - ��¥ �� �ð� �����͸� ������ �� �ִ� �÷� Ÿ��
*/

DESC employees;
DESC departments;
DESC countries;

-- # AS�� ����� �÷� �̸��� ���ϴ� �̸����� �����Ͽ� ��ȸ�� �� �ִ�
SELECT first_name AS �̸�, last_name AS ��, salary AS ���� FROM employees;

-- # �÷� ���� ��� �����ڸ� Ȱ���� �� �ִ�
SELECT
    salary AS "�� ��ġ",
    salary * 2 AS "�� ��ġ",
    salary * 3 AS "�� ��ġ",
    first_name
FROM employees;

-- # �÷������� ����� �� �ִ�
-- # NVL(column, value)
--   : �ش� �÷� ���� null value�� ��� ��� ����� ���� �����ϴ� �Լ�
SELECT
    salary,
    commission_pct,
    salary * NVL(commission_pct, 0) AS bonus,
    salary + NVL(salary * commission_pct,0) AS total_salary,
    first_name
FROM
    employees;

-- # �� �÷��� �̾�ٿ��� ����� �� �ִ� (�̾���̱�)
SELECT first_name || ' ' || last_name AS full_name FROM employees;

-- ����1: ��� ������� '�����ȣ, Ǯ����, ��å, ����(SALARY�� ����)'�� ��ȸ�غ�����
SELECT
    employee_id AS �����ȣ,
    first_name || ' ' || last_name AS Ǯ����,
    job_id AS ��å,
    salary * 12 AS ����
FROM                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
    employees;

-- # SELECT DISTINCT : �� �����͸� �� ������ ����Ѵ� (�ߺ� ����)
SELECT DISTINCT job_id FROM employees; -- �����ϴ� ��å�� �� ������ ���
SELECT job_id FROM employees; -- ��� ����� ��å�� ��� ���

SELECT DISTINCT department_id FROM employees; -- �����ϴ� �μ� ��ȣ ����




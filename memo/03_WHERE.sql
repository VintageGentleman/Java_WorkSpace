-- 03_WHERE.sql

/*
    # SELECT �÷��� FROM ���̺�� WHERE ������;
    
    - SELECT�� �ڿ� WHERE���� �߰��Ͽ� �ش� ������ �����ϴ� �ุ ��ȸ�� �� �ִ�    
    - ���ǿ� ���Ǵ� �����ʹ� ��ҹ��ڿ� ������ �޴´�
    - ����Ŭ�� �� �����ڿ� �� �����ڸ� ����� �������� ���� �� �ִ�
    
    # �� ������
    
    =            : ������ true, (==�� �ȵȴ�)
    !=, <>, ^=   : �ٸ��� true
    <, >, <=, >= : ��
    
    # �� ������
    
    AND, OR, NOT
*/

SELECT * FROM employees WHERE job_id = 'FI_ACCOUNT';
SELECT * FROM employees WHERE job_id = 'fi-account'; -- �ȵ�

-- ���� Ÿ�� ��
SELECT * FROM employees WHERE salary >= 10000;
SELECT * FROM employees WHERE salary <= 5000;

-- ���� Ÿ�� ��
SELECT * FROM employees WHERE first_name < 'C';
SELECT * FROM employees WHERE first_name >= 'T';
SELECT * FROM employees WHERE job_id = 'SH_CLERK';
SELECT * FROM employees WHERE job_id != 'SH_CLERK';
SELECT * FROM employees WHERE job_id <> 'SH_CLERK';
SELECT * FROM employees WHERE job_id ^= 'SH_CLERK';

-- ��¥ Ÿ�� ��
SELECT * FROM employees WHERE hire_date >= '2007/09/09';

-- AND, OR, NOT
SELECT * FROM employees
WHERE hire_date >= '2007/09/09' AND job_id = 'SH_CLERK';

SELECT * FROM employees
WHERE job_id = 'SH_CLERK' OR job_id = 'IT_PROG';

-- ����1: ������ 2000���� 3000������ ������� �̸�,����,��å�� ��ȸ�غ�����
SELECT first_name AS �̸�, salary AS ����, job_id AS ��å FROM employees
WHERE salary >= 2000 AND salary <= 3000;

-- ����2: 30, 60, 100�� �μ��� ���� ������� �̸�, ��ȭ��ȣ, �μ���ȣ�� ��ȸ�غ�����.
SELECT first_name AS �̸�, phone_number  AS ��ȭ��ȣ, department_id AS �μ���ȣ FROM employees
WHERE department_id = 30 OR department_id = 60 OR department_id = 100; 

-- # �÷��� BETWEEN A AND B : �ش� �÷� ���� A�� B������ ��� true
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 3000;
SELECT * FROM employees WHERE hire_date BETWEEN '05/01/01' AND '05/12/31';

-- # �÷��� IN (A,B,C...) : ()���� ���뿡 �ش� ���� ������ true
SELECT * FROM employees WHERE department_id IN (30, 60, 100);
SELECT * FROM employees WHERE job_id IN ('SH_CLERK', 'FI_ACCOUNT');

-- ()���� �����ϴ� ��ҿ��� �ٸ� �������� �� �� �ִ�
SELECT * FROM employees WHERE department_id
IN (SELECT DISTINCT department_id FROM employees WHERE job_id IN ('SH_CLERK', 'FI_ACCOUNT'));

-- null�� ũ�� �񱳰� �Ұ����ϱ� ������ �Ϲ� �� �����ڸ� ���� ������ �� ����
SELECT * FROM employees WHERE commission_pct = null;

-- �ش� �÷��� ���� null�� ��츦 ��ȸ�ϰ� �ʹٸ� IS NULL�� ����ؾ� �Ѵ�
SELECT first_name, salary, NVL(commission_pct, 0) AS commission FROM employees 
WHERE commission_pct IS NULL;

-- �ݴ��, NULL�� �ƴ� ��츦 ��ȸ�ϰ� ���� ����
-- IS NOT NULL �Ǵ� NOT �÷� IS NULL�� ����Ѵ�
SELECT first_name, commission_pct FROM employees
WHERE commission_pct IS NOT NULL;

SELECT first_name, commission_pct FROM employees
WHERE NOT commission_pct IS NULL;

-- # �����ȣ�� Ȧ���� ����鸸 ��ȸ�غ���
--   �����ͺ��̽����� %�� �����ڰ� �ƴϹǷ�
--   �������� ���ϰ� �ʹٸ� MOD() �Լ��� ����ؾ� �Ѵ�
SELECT * FROM employees WHERE MOD(employee_id, 2) = 1;
SELECT * FROM employees WHERE MOD(employee_id, 2) = 0;

/*
    # �������� LIKE ����ϱ�
    
    - �������� �Ϻκ��� ��ġ�ϴ� ������ ��ȸ�� �� �ִ�
    - % : ���� ���� ���� ���ڰ� �־ �ǰ� ��� �Ǵ� �ڸ�
    - _ : � ���ڵ� �� ���ڰ� �ݵ�� �����ؾ��ϴ� �ڸ�
*/

SELECT first_name FROM employees WHERE first_name LIKE 'A%'; -- A�� ����
SELECT first_name FROM employees WHERE first_name LIKE '_a%'; -- 2��° ���ڰ� a
SELECT first_name FROM employees WHERE first_name LIKE '__a%'; -- 3��° ���ڰ� a
SELECT first_name FROM employees WHERE first_name LIKE '%a'; -- a�� ����
SELECT first_name FROM employees WHERE first_name LIKE '%a_'; -- �ڿ��� 2��° ���ڰ� a

SELECT hire_date FROM employees WHERE hire_date LIKE '07/%'; -- 07�⵵ �Ի���
SELECT hire_date FROM employees WHERE hire_date LIKE '_2/%'; -- 2�� ������ �⵵ �Ի���
SELECT hire_date FROM employees WHERE hire_date LIKE '%/_2/%'; -- 2��, 12�� �Ի���

-- ����1: first_name�� �ڿ��� �� ��° ���ڰ� a�� ��� ������� Ǯ������ ��ȸ
SELECT first_name || ' ' || last_name AS Ǯ���� FROM employees
WHERE first_name LIKE '%a__';

-- ����2: first_name�� e�� �� �� �̻� ���Ե� ������� Ǯ������ ��ȸ
SELECT first_name || ' ' || last_name AS Ǯ���� FROM employees
WHERE first_name LIKE '%e%e%';

SELECT first_name || ' ' || last_name AS Ǯ���� FROM employees
WHERE LOWER(first_name) LIKE '%e%e%'; -- ù �빮�� E ���ԵǴ� ����
-- UPPER(value) : ��� �빮�ڷ� ��ȯ�ϴ� �Լ�
-- LOWER(value) : ��� �ҹ��ڷ� ��ȯ�ϴ� �Լ�

-- ����3: first_name�� �ټ� �����̸鼭 r�� ������ ������� Ǯ������ ��ȸ
SELECT first_name || ' ' || last_name AS Ǯ���� FROM employees
WHERE first_name LIKE '____r';

-- ����4: 8���� �Ի��� ������� �̸��� ������� ��ȸ
SELECT first_name AS �̸�, hire_date AS ����� FROM employees
WHERE hire_date LIKE '%/08/%';

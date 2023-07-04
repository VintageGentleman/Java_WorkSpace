-- 13_���� ����.sql

/*
    # ���� ����
    
    - ������ ���ο� ���Ե� �� �ٸ� ������
    - ���� ������ �����ϰ� �ִ� ������ ���� ������� �θ���
    - ���� ������ ���� ����� ���� ���� �� ���� ������ ���� �� ���� ������ �з��Ѵ�
    - ���� �� ��� �����ڿ� ���� �� ��� �����ڰ� �ٸ���
    - ���� ������ �� �Ǵ� ���� ������ Ȱ��ǰų� 
      ��ȸ�ؾ��ϴ� ���̺� ������� Ȱ��� �� �ִ�
    
    # ���� �� ���� ����
    
    - ���� ������ ����� �� �ϳ��� ���� ���
    - ���� ������ ���ϴ� �Ϲ� �����ڸ� ����� �� �ִ�(=, >, <, ...)
    
    # ���� �� ���� ����
    
    - ���� ������ ����� 2�� �̻��� ���� �ִ� ���
    - ���� �� �����ڿ� �Բ� ����ؾ� �Ѵ�
      (IN, ANY, SOME, ALL, EXISTS, ...)
*/

/*
    # ���� �� ���� ����
    
    - ���̺��� �ϳ��� ���� �����ϴ� ���� Ȯ���� ����� �⺻Ű�� ����ϴ� ���̴�
*/

-- �� ��� �������� ���
SELECT * FROM employees 
WHERE salary >= (SELECT salary FROM employees WHERE employee_id = 102);

-- ���̺� ��� �������� ���
SELECT * FROM (SELECT job_id, job_title FROM jobs WHERE job_id = 'IT_PROG');

/*
    # ���� �� ���� ���� ������
    
    - IN     : ���� ���� �� ��ġ�ϴ� ���� �ϳ��� ������ true
    - ANY    : ���� ���� �� �ϳ��� ������ ������Ű�� ���� ������ true
    - SOME   : ANY�� ����
    - ALL    : ��� ������ ������ �������Ѿ� true
    - EXISTS : ���� �ϳ��� �����ϸ� true  
*/

-- # IN

-- ex : Steven�̶�� ����� �����ִ� ��å�� ��� �������� ��ȸ
SELECT * FROM employees WHERE job_id IN
(SELECT DISTINCT job_id FROM employees WHERE first_name = 'Steven');

-- # ANY, SOME

SELECT * FROM employees WHERE salary > ANY(8000, 10000, 5000, 8800);
SELECT * FROM employees WHERE salary > SOME(8000, 10000, 5000, 8800);
SELECT * FROM employees WHERE salary > 5000;

-- ex: IT �����ڵ� �� ���� �� ���� ������� �� ���� ���� ������� ��� ��ȸ
SELECT * FROM employees WHERE
salary > ANY(SELECT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id != 'IT_PROG';

-- # ALL
-- ex: ��� IT �����ڵ麸�� ������ ���� �޴� ������� ��ȸ
SELECT * FROM employees WHERE
salary > ALL(SELECT salary FROM employees WHERE job_id = 'IT_PROG');

-- # EXISTS

-- ex: �ִ� �޿��� �޴� ����� �ִ� �μ��� ��ȸ
SELECT * FROM departments dept
WHERE EXISTS
(SELECT employee_id FROM employees emp INNER JOIN jobs USING (job_id)
WHERE salary = max_salary AND emp.department_id = dept.department_id);

-- ����1: job_title�� Manager�� ���ԵǴ� ������� ��ȭ��ȣ�� ��ȸ
SELECT 
    phone_number
FROM 
    employees
WHERE
    job_id IN(SELECT job_id FROM jobs WHERE LOWER(job_title) LIKE '%manager%');

-- # rownum : �� ��ȣ �÷�

-- ex: ���� ������ 10���� ��ȸ�ϰ� ���� ���
--     ������� 5���� ���� �̰� ���� ������ ������ �ϴ� ���� �߻��Ѵ�
SELECT rownum, first_name FROM employees
WHERE rownum <= 10 ORDER BY salary DESC;

-- ������������ ������ ���� ������ �� rownum�� �ٿ��� ���ϴ� �����͸� ��ȸ�� �� �ִ�
SELECT rownum, emp.*
FROM (SELECT * FROM employees ORDER BY salary DESC) emp
WHERE rownum <= 10;

-- rownum�� ���� ���� ���� 20 ~ 30���� ��ȸ�Ϸ��� ������
-- ��ȸ���� �ʴ´�
-- => rownum 1���� ������ �������� ���ϸ� �ش� ���� �����Ǹ鼭
--    ���� ���� rownum 1�� �Ǳ� ����
SELECT rownum, emp.*
FROM (SELECT * FROM employees ORDER BY salary DESC) emp
WHERE rownum >= 20;

-- �����ϰ� rownum�� ���� ����� �Ǵٽ� ���������� ��ȸ�Ͽ�
-- ���� ���� 20�� ~ 30���� ��ȸ�� �� �ִ�
SELECT rownum, emp2.* FROM (SELECT rownum rn, emp.*
FROM (SELECT * FROM employees ORDER BY salary DESC) emp) emp2
WHERE rn BETWEEN 20 AND 30;



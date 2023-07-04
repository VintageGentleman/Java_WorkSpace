-- 06_CASE.sql

/*
    # CASE
    
    - DECODE()�� �÷��� ��Ȯ�ϰ� ��ġ�ϴ� ���̽��� ������ �� �־���
    - CASE ������ �ش� �÷��� ���ϴ� ������ ������ �� �ִ�
    
        CASE
            WHEN ������ THEN ����� ��
            ...
            ELSE �⺻��
        END        
*/

-- ex: ��� ������ CLERK�� 3�ۼ�Ʈ �λ��ϰ� ���� ���

SELECT
    first_name,
    job_id,
    salary AS before_salary,
    CASE 
        WHEN job_id = 'IT_PROG' THEN salary * 1.1
        WHEN job_id LIKE '%_CLERK' THEN salary * 1.03
        ELSE salary        
    END AS after_salary
FROM
    employees;   
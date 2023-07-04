-- 10_OUTER JOIN.sql

/*
    # OUTER JOIN
    
    - JOIN ������ �������� ���� �������� ���ϴ� ���� �߰��� Ȯ���� �� �ִ� JOIN
    - (+)�� ���� �ʿ� null�� �߰��ؼ� ������ ������ ���� �������� ���ߴ� ���� ��ȸ�Ѵ�
*/

-- �Ϲ����� ������ ��� �ܷ�Ű �÷��� null�� ������ ��ȸ���� �ʴ� ���� �����Ѵ�

-- departments�ʿ� (+)�� ���̸� �ش��ϴ� �μ��� ������ �����ϰ� �ȴ�
SELECT * FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
ORDER BY employee_id;

-- employees�ʿ� (+)�� ���̸� employees�ʿ� null�� �ٿ���
-- �������� ���ߴ� �μ����� �����Ѵ�
SELECT * FROM employees e, departments d
WHERE e.department_id(+) = d.department_id
ORDER BY employee_id;

-- ����1: "�μ���ȣ/�μ���/�ּ�/����"�� ��ȸ�ϵ� �Ҽӵ� �μ��� ���� ���õ鵵
--       �Բ� ��ȸ�غ�����
SELECT
    department_id   AS �μ���ȣ,
    department_name AS �μ���,
    street_address  AS �ּ�,
    city            AS ����
FROM
    departments d,
    locations   l
WHERE
    d.location_id(+) = l.location_id
ORDER BY
    department_id DESC;

-- ����2: �Ҽӵ� ����� ���� �μ��� ��ȸ�غ�����
SELECT
    department_name AS �μ���
FROM
    employees   e,
    departments d
WHERE
        e.department_id (+) = d.department_id
    AND employee_id IS NULL;

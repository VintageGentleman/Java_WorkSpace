-- 22_���� �����ϱ�.sql

-- # ���� ������ ���� ���� (���� ������ ������ ���������� �� �� �ִ�)
SHOW user;

-- # �� ���� �����ϱ�
CREATE USER testuser IDENTIFIED BY "1313";

-- # ���� ��� ����
SELECT * FROM all_users;

-- # ������ ���� �ֱ� (GRANT ���� TO ����)
GRANT CREATE SESSION TO testuser; -- �ش� ������ ������ �� �ִ� ����
GRANT CREATE TABLE TO testuser; -- ���̺� ���� ����
GRANT RESOURCE TO testuser; -- DB ���� ���� ��� ����

-- # ������ ���� ���� (REVOKE ���� FROM ����)
REVOKE RESOURCE FROM testuser;

-- # ��й�ȣ �ٲٱ�
ALTER USER testuser IDENTIFIED BY "1234";

-- # ���� �����ϱ�
DROP USER testuser;

SHOW user;
CONNECT testuser/"1313"; -- �ֿܼ��� �ٸ� ���� �����ϱ�
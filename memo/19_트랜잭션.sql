-- 19_Ʈ�����.sql

/*
    # Ʈ����� (Transaction)
    
    - �ϳ��� �۾� ���� (ex: ���� �Ǹ�, �۱� ...)
    - �����ͺ��̽��� �ϳ��� Ʈ����ǿ� ���� ��� �۾��� ���������� �Ϸ�Ǵ� ��쿡�� 
      ��������� Ȯ�� ���� �� �ִ� ����� �����Ѵ� (All or Nothing)
    - Ʈ������� �����ϱ� ���� Ű����δ�
      COMMIT, ROLLBACK, SAVEPOINT, ROLLBACK TO�� �ִ�
    - �ϳ��� Ʈ������� ���������� ����� Ŀ������ ����
      ���ο� Ŀ���� �����ϱ� ������ ����Ǵ� ��� DML���� �ǹ��Ѵ�
      (INSERT, UPDATE, DELETE ���� ���̺� ������ ������ Ʈ������� ���� ���������
       CREATE TABLE, ALTER TABLE, ALTER USER, ... ���� DB ������Ʈ ������
       Ʈ������� ��������� �ƴϴ�)
*/
SELECT * FROM user_tables;
SELECT * FROM user_constraints WHERE table_name = 'COFFEE';

SELECT * FROM coffee;
DESC coffee;

INSERT INTO coffee VALUES(1, 'Americano', 1500);
INSERT INTO coffee VALUES(2, 'Americano', 2000);

-- COMMIT : ���±����� ��������� Ȯ�����´� (�ϳ��� Ʈ������� �������Ѵ�)
COMMIT;

INSERT INTO coffee VALUES(3, 'Americano', 2000);
INSERT INTO coffee VALUES(4, 'Americano', 2000);
INSERT INTO coffee VALUES(5, 'Americano', 2000);
INSERT INTO coffee VALUES(6, 'Americano', 2000);

-- ROLLBACK : ���� �ֱٿ� �ߴ� Ŀ������ ���ư���
ROLLBACK;

SELECT * FROM coffee;

SAVEPOINT mysavepoint1;

UPDATE coffee SET coffee_price = coffee_price + 500
WHERE coffee_name = 'Americano';

SAVEPOINT mysavepoint2;

UPDATE coffee SET coffee_price = coffee_price + 500
WHERE coffee_name = 'Americano';

-- �Ϻθ� ����ϰ� Ʈ������� �ٽ� �����ϰ� ���� ��� ���̺�����Ʈ�� ����Ѵ�
ROLLBACK TO mysavepoint2;
ROLLBACK TO mysavepoint1;
ROLLBACK;

SELECT * FROM coffee;

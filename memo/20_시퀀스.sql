-- 20_������.sql

/*
    # ������ (Sequence)
    
    - �⺻Ű�� ����ϱ� ���ϵ��� ��ȣ�� �ڵ��� �������ִ� DB������Ʈ
    
    CREATE SEQUNCE ��������
                    [START WITH n] - ���� ��ȣ ����
                    [INCREMENTY BY n] - ���� ���� ����
                    [NOMAXVALUE | MAXVALUE n] - �ִ� ���� ����
                    [NOMINVALUE | MINVALUE n] - �ּ� ���� ����
                    [NOCYCLE | CYCLE] - ��ȣ ��ȯ ���� ����
                    [NOCACHE | CACHE n] - ĳ�� ���� ����
                                          �� ��ȣ�� �̸� �������� ���� ����  
                              (������ ���������� �߰� ��ȣ�� ����� ������ ����)
                                          
    - user_sequences, all_sequences�� ���������� ���¸� Ȯ���� �� �ִ�
*/
COMMIT;

SELECT * FROM coffee;
CREATE SEQUENCE coffee_id_seq 
    START WITH 7
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE
    NOCACHE;
    
-- # ������ ������ ��ųʸ� ��
SELECT * FROM user_sequences;

-- # ������.nextval : ���� ��ȣ�� ����Ѵ� (�ٽô� ���� ��ȣ�� �ǵ��� �� ����)
INSERT INTO coffee VALUES(coffee_id_seq.nextval, 'Caffe Latte', 3000);
SELECT * FROM coffee;
COMMIT;

-- # ������.currval : ���� ������ ���� Ȯ���Ѵ� (��ȣ�� �Ҹ������� �ʴ´�)
SELECT coffee_id_seq.currval FROM dual;

-- # dual ���̺� : ���� �ϳ��� �����ϴ� ������ ���̺�
SELECT * FROM dual;
SELECT 123 + 345 FROM dual;

-- ������ ���� ������� ����غ����� �ص� ���̺��� �ʿ��ϱ� ������
-- ���� ���� ���̺��� ����ϴ� �ͺ��� ������ ���̺��� ���� ������ �غ� �� �ִ�
SELECT 1, first_name, coffee_id_seq.currval FROM employees;
SELECT 123 + 345 FROM employees;
SELECT coffee_id_seq.nextval FROM employees;

-- # ��ȯ ������ ������ ����غ��� (ex: ���� ��ȣǥ, ������ ����ȣ ��)
CREATE SEQUENCE cycle_test_seq
    START WITH 1 INCREMENT BY 7
    MAXVALUE 45 NOCACHE CYCLE;
SELECT cycle_test_seq.nextval FROM employees;   

-- # ������ �����ϱ� (ALTER SEQUENCE ���� ������ ����)
ALTER SEQUENCE cycle_test_seq
        MINVALUE 30 MAXVALUE 60 INCREMENT BY 2;
SELECT cycle_test_seq.currval FROM dual;
SELECT cycle_test_seq.nextval FROM dual;

SELECT cycle_test_seq.nextval FROM employees;

-- # ������ �����ϱ�
DROP SEQUENCE cycle_test_seq;

-- # �������� �����뿡�� ������ �Ұ����ϴ�
SHOW recyclebin;
PURGE recyclebin;

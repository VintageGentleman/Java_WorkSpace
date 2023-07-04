-- 16_��������.sql

/*
    # ���Ἲ
    
    - ������ ���� ����
    - �����͸� ���Ծ��� ���·� �ùٸ��� �����ϴ� ���� ���Ἲ�� �����Ѵٰ� �Ѵ�
    - �����͸� �ùٸ��� �����ϱ� ���ؼ��� �پ��� ������ ���Ἲ�� �������Ѿ� �Ѵ�
    - �����ͺ��̽������� �پ��� ���� ���ǵ��� ���� �������� ���Ἲ�� �����Ѵ�
    
    # ��ü ���Ἲ
    
    - ���̺��� �����ʹ� �ݵ�� �ϳ��� ���� ������ �� �־�� �Ѵ�
    - ��ü ���Ἲ�� ��Ű�� ���� ������������ �⺻Ű(PK)�� ����Ѵ�
    
    # ���� ���Ἲ
    
    - ���� ���迡 �ִ� �����ʹ� ��ȿ�� �����͸� �����ؾ� �Ѵ�
    - ���� ���Ἲ�� ��Ű�� ���� ������������ �ܷ�Ű(FK)�� ����Ѵ�
    
    # ������ ���Ἲ
    
    - �ϳ��� ������(�÷�)�� �����ϴ� ��ü���� ��� ���� Ÿ���̾�� �Ѵ�
    - �÷� Ÿ���� �����Ͽ� �ش� �÷��� ������ ���Ἲ�� ������ �� �ִ�
    
    # ������ ���Ἲ
    
    - �����Ͱ� ��Ȯ��, �ϰ���, ��ȿ���� �����ϴ� ��
    - CHECK ���� ���ǰ� NOT NULL ���������� ���� ������ ���Ἲ�� ������ �� �ִ�
    
    # DB�� ���� ���ǵ�
    - UNIQUE : �ش� �����ο� �ߺ��Ǵ� ���� ������� �ʴ´� (null�� ���, �� �� ��)
    - NOT NULL : �ش� �����ο� null ���� ������� �ʴ´�
    - PRIMARY KEY : NOT NULL + UNIQUE, �� ���̺� �� �ϳ��� ����
    - FOREIGN KEY : �ش� �������� �ܷ�Ű�� ����
    - CHECK : ���ϴ� ������ ���� �����Ͽ� �ش� ������ �����ϴ� ��ü�� �߰� ����
*/

-- ���� ������ ������ �������ǵ� ����

/*
    # CONSTRAINT_TYPE
    
    - P : Primary Key
    - R : References (Foreign KEY)
    - U : Unique
    - C : Check, Not Null
*/

-- ���� ������ ������ ���� ���ǵ� ����
SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEES';

-- ��� ������ ������ ���� ���ǵ� ����
SELECT * FROM all_constraints;

/*
    # ������ ��ųʸ� (Date Dictionary)
    
    - �����Ϳ� ���� ������ (������ ����, ��Ÿ ������)
    - ���� DB�� ��Ȳ�� ����, DB�� �˾Ƽ� �����ϴ� ������
    - ����ڴ� ������ ��ųʸ��� ���� ������ �� ����
    
    # ������ ��ųʸ� ��

    - ������ ��ųʸ��� ����ڰ� Ȯ���� �� �ֵ��� �����ϴ� ��(View)
      * View - DB ������Ʈ �� �ϳ��� ��ü �������� �Ϻθ� ��ȸ ������ �̴� ���̺�
    - �տ� user_�� ���̸� ���� ������ ������ ��ųʸ��� Ȯ���� �� �ִ�
    - �տ� all_�� ���̸� ��ü ������ ������ ��ųʸ��� Ȯ���� �� �ִ�
*/

SELECT * FROM user_tables;
SELECT * FROM all_tables;
SELECT * FROM user_constraints;
SELECT * FROM all_constraints;

/*
    1. ���̺� ������ ���ÿ� �������� �߰��ϱ�

    - �÷��� �÷�Ÿ�� �������� (���������� �̸��� �ڵ����� ������)
    - �÷��� �÷�Ÿ�� CONSTRAINT ���������̸� �������� (�̸��� ���� ������)
    - �� �����ο� �������� ���������� ������ ���� �ִ�
*/
CREATE TABLE coffee(
    coffee_id    NUMBER(10) PRIMARY KEY,
    coffee_name  VARCHAR2(30) UNIQUE NOT NULL,
    coffee_price NUMBER(6) CHECK(coffee_price >= 0)
);

CREATE TABLE coffee(
    coffee_id    NUMBER(10)
        CONSTRAINT coffee_id_pk PRIMARY KEY,
    coffee_name  VARCHAR2(30)
        CONSTRAINT coffee_name_uk UNIQUE
        CONSTRAINT coffee_name_nn NOT NULL,
    coffee_price NUMBER(6)
        CONSTRAINT coffee_price_chk CHECK(coffee_price >= 0)
);

SELECT * FROM user_constraints WHERE table_name = 'COFFEE';

-- coffee_name�� null�̶� insert ��������
INSERT INTO coffee(coffee_id, coffee_price) VALUES(1, 5000);

-- check �������ǿ� �ɷ��� insert ��������
INSERT INTO coffee VALUES(1, 'Americano', -1000);

INSERT INTO coffee VALUES(1, 'Americano', 1500);
INSERT INTO coffee VALUES(2, 'Espresso', 800);

-- PK���� null�� ���� �� ��� insert ����
INSERT INTO coffee VALUES(NULL, 'Caffe Mocha', 2000);
-- PK���� �ߺ����� ���� �� ��� insert ����
INSERT INTO coffee VALUES(1, 'Caffe Mocha', 2000);

SELECT * FROM coffee;

DROP TABLE coffee;

/*
    2. ���̺� ���� �Ŀ� �������� �߰��ϱ�
    
    - ALTER TABLE ���̺�� ADD CONSTRAINT ���������̸� ��������(�÷�);
    - NOT NULL, CHECK ���� ������ MODIFY�� �ش� �÷��� �����ؾ� �Ѵ�
    - ALTER TABLE ���̺�� MODIFY(�÷��� �÷�Ÿ�� CONSTRAINT ...);
*/ 
-- # DEFAULT ���̺� ���� ���� �ʾ��� ���� �⺻��
CREATE TABLE coffee(
    coffee_id    NUMBER(10),
    coffee_name  VARCHAR2(30),
    coffee_price NUMBER(6) DEFAULT 1000
);

ALTER TABLE coffee ADD CONSTRAINT coffee_id_pk PRIMARY KEY(coffee_id);
ALTER TABLE coffee ADD CONSTRAINT coffee_name_uk UNIQUE(coffee_name);

-- NOT NULL, CHECK, DEFAULT�� MODIFY�� �߰��ؾ� �Ѵ�
ALTER TABLE coffee MODIFY (
    coffee_price NUMBER(7) DEFAULT 0
        CONSTRAINT coffee_price_chk CHECK(coffee_price >= 0)
        CONSTRAINT coffee_price_nn NOT NULL
);

SELECT * FROM user_constraints WHERE table_name = 'COFFEE';
DROP TABLE coffee;

/*
    # ���̺� ���� ������� ���� ���� �߰��ϱ�
    
    - �÷��� ���� ������ �� ���̺� ������ ���ο��� ���� ������ �ļ��ϴ� ���
    - DEFAULT, NOT NULL�� �÷� �������� �����ؾ� �Ѵ�
*/
CREATE TABLE coffee(
    coffee_id    NUMBER(10),
    coffee_name  VARCHAR2(30)
        CONSTRAINT coffee_name_nn NOT NULL,
    coffee_price NUMBER(6),
    CONSTRAINT coffee_id_pk PRIMARY KEY(coffee_id),
    CONSTRAINT coffee_name_uk UNIQUE (coffee_name),
    CONSTRAINT coffee_price_chk CHECK (coffee_price >= 0)
);

/*
    # �ܷ�Ű �����ϱ�
    
    - �ܷ�Ű ���������� ������ �� �ٸ� ���̺��� � �÷��� ������ ������ �����ؾ��Ѵ�
    - �����Ϸ��� �÷��� UNIQUE �Ǵ� PRIMARY KEY ���������� �����Ǿ� ���� �ʴٸ�
      �ܷ�Ű�� ������ �� ���� (���� �߻�)
    - �ܷ�Ű�� ������ �÷����� �����ϴ� �÷��� �����ϴ� �� �Ǵ� null�� �߰��� �� �ִ�
*/
SELECT * FROM employees;

-- 1. �÷� �������� �ܷ�Ű �������� �����ϱ�
CREATE TABLE event_participants(
    event_id NUMBER(8)
        CONSTRAINT event_id_pk PRIMARY KEY,
    part_date DATE DEFAULT sysdate,
    employee_id NUMBER(6) 
        CONSTRAINT event_emp_id_fk REFERENCES employees(employee_id)
);
SELECT * FROM user_constraints WHERE table_name LIKE 'EVENT%';

INSERT INTO event_participants(event_id, employee_id) VALUES(1, 100);
INSERT INTO event_participants(event_id, employee_id) VALUES(2, 100);

SELECT * FROM event_participants INNER JOIN employees USING (employee_id);
DROP TABLE event_participants;

-- 2�� ������� �ܷ�Ű �߰��ϱ�
CREATE TABLE event_participants(
    event_id NUMBER(8),
    part_date DATE DEFAULT sysdate,
    employee_id NUMBER(6) 
);

ALTER TABLE event_participants
    ADD CONSTRAINT event_emp_id_fk
        FOREIGN KEY (employee_id) REFERENCES employees(employee_id);

SELECT * FROM user_constraints WHERE table_name LIKE 'EVENT%';

-- 3�� ������� �ܷ�Ű �߰��ϱ�

CREATE TABLE event_participants(
    event_id NUMBER(8),
    part_date DATE DEFAULT sysdate,
    employee_id NUMBER(6), 
    CONSTRAINT event_emp_id_fk FOREIGN KEY (employee_id)
        REFERENCES employees(employee_id)
);





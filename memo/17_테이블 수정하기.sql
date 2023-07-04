-- 17_���̺� �����ϱ�.sql

/*
    # ���̺� �� �÷� �߰��ϱ�
    
    - ALTER TABLE ���̺�� ADD (�÷��� �÷�Ÿ�� ��������, ...);
    - �� �÷��� �߰��Ǹ� ������ �����ϴ� ����� �ش� �÷����� NULL�� �߰��ȴ�
    - �� �÷��� �߰��� �� DEFAULT�� ������ ������ DEFAULT�� �߰��ȴ�
*/

SELECT * FROM fruits;

ALTER TABLE fruits ADD(
    taste NUMBER(1)
);

ALTER TABLE fruits ADD(
    grade VARCHAR2(2) DEFAULT 'B'
);

UPDATE fruits SET grade = 'A+' WHERE fname = 'applepie';

-- ����1: countries ���̺��� ������ countries2 ���̺��� ��������

CREATE TABLE countries2 AS(SELECT * FROM countries);
DESC countries2;
DESC regions;
SELECT * FROM user_constraints WHERE table_name = 'COUNTRIES2';

SELECT * FROM tab;

ALTER TABLE countries2
    ADD CONSTRAINT countries2_region_id_fk
        FOREIGN KEY (region_id) REFERENCES regions(region_id);

ALTER TABLE countries2
    ADD CONSTRAINT contry_id_pk PRIMARY KEY(country_id);
        
-- ����2: fruits ���̺� countries2�� country_id��
--        �θ�Ű�� ���� �ܷ�Ű �÷��� ��������
ALTER TABLE fruits ADD(
    country_id CHAR(2)
);

ALTER TABLE vegetable
    ADD CONSTRAINT country_id_fk
        FOREIGN KEY (country_id)    REFERENCES countries2(country_id);
    
SELECT * FROM fruits;
SELECT * FROM user_constraints WHERE table_name = 'VEGETABLE';

-- �����غ���
CREATE TABLE countries2 AS (SELECT * FROM countries);
SELECT * FROM user_constraints WHERE table_name = 'COUNTRIES2';

SELECT * FROM countries;
-- countries2�� country_id�� unique �Ǵ� �⺻Ű�� �ٲ���� �Ѵ�
ALTER TABLE countries2 ADD CONSTRAINT countries2_id_pk PRIMARY KEY(country_id);

-- �� �� �ܷ�Ű �߰�
ALTER TABLE fruits ADD (
    country_id CHAR(2)
        CONSTRAINT fruits_country_id_fk REFERENCES countries2(country_id)
);
SELECT * FROM user_constraints WHERE table_name = 'FRUITS';

/*
    # ���̺� �÷� �����ϱ�
    
    - ALTER TABLE ���̺�� DROP COLUMN �÷���;
*/
ALTER TABLE fruits DROP COLUMN taste;
SELECT * FROM fruits;

/*
    # ���̺��� �÷� �̸� �����ϱ�
    
    - ALTER TABLE ���̺�� RENAME COLUMN �����̸� TO �ٲ��̸�;
*/
ALTER TABLE fruits RENAME COLUMN fname TO fruit_name;
SELECT * FROM fruits;

/*
    # ���̺� �̸� �����ϱ�
    
    - RENAME ���̺�� TO �ٲ��̸�;
*/
RENAME fruits TO vegetable;

SELECT * FROM vegetable;
SELECT * FROM user_constraints WHERE table_name = 'VEGETABLE';

/*
    # ���̺��� �÷� �����ϱ�
    
    - ALTER TABLE ���̺�� MODIFY(�÷��� �÷�Ÿ�� ��������, ... );
      �� ���������� �߰��� �� ����߾���
*/
ALTER TABLE vegetable MODIFY(
    price NUMBER(10) DEFAULT 30,
    grade VARCHAR2(2) DEFAULT 'B+'
        CONSTRAINT vege_grade_chk CHECK(grade IN('A+', 'A', 'B+', 'B', 'C'))
);

SELECT * FROM vegetable;

/*
    # ���̺��� �������� �����ϱ�
    
    - ALTER TABLE ���̺�� DROP CONSTRAINT �������Ǹ�;
    - ���� �����̸��� �ڵ����� �����Ǹ� ����� ����Ƿ� �� ������
    - ���̺��� �����ϸ� �ش� ���̺��� ��� ���������� �Բ� �����ȴ�
*/
SELECT * FROM user_constraints WHERE table_name = 'COFFEE';

ALTER TABLE coffee DROP CONSTRAINT coffee_name_nn;
ALTER TABLE coffee DROP CONSTRAINT coffee_name_uk;
ALTER TABLE coffee DROP CONSTRAINT coffee_id_pk;
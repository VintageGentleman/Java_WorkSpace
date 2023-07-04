-- 15_������ �߰�,����,����.sql

/*
    # ���̺� ������ �߰��ϱ�
    
    - INSERT INTO ���̺��(�÷�,�÷�,...) VALUES(��,��,...)
    - INSERT INTO ���̺�� VALUES(��� �÷��� �������);
*/

CREATE TABLE fruits (
    fname VARCHAR2(30),
    price NUMBER(8),
    qty NUMBER(6)
);

--  # �⺻ INSERT
INSERT INTO fruits(fname, price, qty) VALUES('apple', 500, 80);
INSERT INTO fruits(fname, price, qty) VALUES('apple', 500, 80);
INSERT INTO fruits(fname, price, qty) VALUES('banana', 1000, 100);

-- # �÷� ������ ������� �ؼ� INSERT
INSERT INTO fruits(qty, fname, price) VALUES(5, 'melon', 8000);

-- # �÷��� �Ϻθ� �����ؼ� INSERT (���� ���� ���� �÷��� null)
INSERT INTO fruits(fname, price) VALUES('water melon', 5000);
INSERT INTO fruits(fname) VALUES('peach');

-- # �÷��� �ƿ� �������� ������ �ݵ�� ��� �÷����� ������� �־�� �Ѵ� 
INSERT INTO fruits VALUES('wather melon', 5000, 33);
INSERT INTO fruits VALUES('wather melon', null, 35);

-- # ���������� INSERT �ϱ� (���̺� ������ �����ؾ� ���簡 �����ϴ�)
INSERT INTO fruits (SELECT * FROM fruits);

SELECT * FROM fruits WHERE qty <= 50;

/*  
    # ���̺� ������ �����ϱ�
    
    - UPDATE ���̺�� SET �÷�=��, �÷�=��, ... WHERE ������;
    - ���� ������ �������� ������ ��� ���� �����ȴ� �� ����
    - �ϳ��� �ุ �����ϱ� ���ؼ��� �ݵ�� �⺻Ű�� �Բ� Ȱ��Ǿ�� �Ѵ�
*/

UPDATE fruits SET fname='applepie' WHERE fname='apple';

COMMIT; -- ���� ������ DB ���� ������ Ȯ�����´�...

UPDATE fruits SET qty = 0; -- ������ �������� ������ ��� ���� ����ȴ�

ROLLBACK;

/*
    # ���̺� ������ �����ϱ�
    
    - DELETE FROM ���̺�� WHERE ����;
    - ������ ���� ������ �ش� ���̺��� ��� �����Ͱ� �����ȴ� �� ����
*/

DELETE FROM fruits;
ROLLBACK;

DELETE FROM fruits WHERE qty < 10;

SELECT * FROM fruits;

DESC chicken;
DESC chicken_house;

-- ����1: ���� ������ ���� ������ ���̺� ������ �־��
INSERT INTO chicken VALUES('BY-0001', 'MI-0001', 'Minorca', 'M', '1.2', NULL);
INSERT INTO chicken VALUES('BY-0001', 'MI-0002', 'Minorca', 'F', '3.5', NULL);
INSERT INTO chicken VALUES('BY-0001', 'MI-0003', 'Minorca', 'M', '5.11', 'Hurt');
INSERT INTO chicken VALUES('FY-0001', 'Bh-0001', 'Brahma', 'F', '6.2', NULL);
INSERT INTO chicken VALUES('FY-0001', 'Bh-0002', 'Brahma', 'M', '2.1', NULL);
INSERT INTO chicken VALUES('FY-0001', 'Bs-0001', 'Bresse', 'M', '2.3', 'ill');
INSERT INTO chicken VALUES('FY-0001', 'Bs-0002', 'Bresse', 'M', '3.4', NULL);
INSERT INTO chicken VALUES('FY-0001', 'Pc-0001', 'Pitu de Caleya', 'M', '3.5', NULL);
INSERT INTO chicken VALUES('LS-0001', 'Ch-0002', 'Cochin', 'F', '1.3', 'Weak');
INSERT INTO chicken VALUES('LS-0001', 'Ch-0003', 'Cochin', 'M', '0.5', NULL);
INSERT INTO chicken VALUES('LS-0001', 'Ch-0004', 'Cochin', 'M', '2.6', NULL);
INSERT INTO chicken VALUES('LS-0001', 'Ch-0005', 'Cochin', 'F', '3.9', NULL);

INSERT INTO chicken_house VALUES('BY-0001', 'Backyard', 100, 'Small', 20.05, '0900', '1200'); 
INSERT INTO chicken_house VALUES('FY-0001', 'Frontyard', 500, 'Large', 19.95, '1200', '1500'); 
INSERT INTO chicken_house VALUES('LS-0001', 'Leftside', 20, 'Tiny', 20.15, '1500', '1800'); 

SELECT * FROM chicken;
SELECT * FROM chicken_house; 

-- ����2: �� ���̺��� JOIN�Ͽ� ���ϴ� �����͸� ��ȸ�غ���
SELECT
    chicken_id,
    graze_time AS �����½ð�,
    close_time AS �����½ð�
FROM
        chicken 
    INNER JOIN chicken_house USING (house_id);

SELECT
    chicken_id,
    area_id AS ����ġ
FROM
        chicken
    INNER JOIN chicken_house USING (house_id);

-- ���� �غ���

SELECT * FROM countries;

CREATE TABLE fruits2(
    fid NUMBER(5), -- fruits2 ���̺��� �⺻Ű
    fname VARCHAR2(30),
    prcie NUMBER(6),
    country_id CHAR(2) -- �ܷ�Ű (countries�� �⺻Ű)
);

INSERT INTO fruits2 VALUES(1, 'Apple', 800, 'AU');
INSERT INTO fruits2 VALUES(2, 'Apple', 1200, 'FR');
INSERT INTO fruits2 VALUES(3, 'Banana', 2500, 'MX');
INSERT INTO fruits2 VALUES(4, 'Orange', 1500, 'MX');

SELECT
    *
FROM
         fruits2
    INNER JOIN countries USING ( country_id )
    INNER JOIN regions USING (region_id);
    


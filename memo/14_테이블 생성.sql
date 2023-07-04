-- 14_���̺� ����.sql

/*
    # CRUD
    
    - ��κ��� ���α׷����� ������ �ִ� �⺻���� ������ ó������ �ٿ� ǥ���� ��
    - Create (������ ����)
    - Read   (������ �б�)
    - Update (������ ����)
    - Delete (������ ����)

    # DML (Data Manipulate Language, ������ ���۾�)
    
    - ���̺��� �����͸� �����ϴ� ��ɾ��
    - INSERT : ���̺� ������ �߰��ϱ� (C)
    - SELECT : ���̺� ������ �б�    (R)
    - UPDATE : ���̺� ������ �����ϱ� (U)
    - DELETE : ���̺� ������ �����ϱ� (D)
    
    # DDL (Data Definition Language, ������ ���Ǿ�)
    
    - DB ������Ʈ�� �����ϴ� ��ɾ��
      �� DB ������Ʈ - ���̺�, ������, ��, �ε���, ����� ����, ...
    - CREATE    : DB ������Ʈ ���� (C)
    - ALTER     : DB ������Ʈ ���� (U)
    - DROP      : DB ������Ʈ ���� (�����뿡�� ���� ����) (D)
    - TURNCATE  : DB ������Ʈ ���� ���� (���� �Ұ���)
    
    # DCL (Data Control Langauge, ������ ���� ��ɾ�)
    
    - ����ڿ��� ������ �ο��ϰų� ��Ż�ϴ� ��ɾ�
    - GRANT  : ���� �ο�
    - REVOKE : ���� ȸ�� 
*/

SELECT * FROM tab;

/*
    # ���̺� �����ϱ�
    
    CREATE TABLE ���̺�� (
        �÷��� �÷�Ÿ�� (��������),
        ...
    );
*/

CREATE TABLE fruits (
    fname   VARCHAR2(30),
    price   NUMBER(6)
);

SELECT * FROM fruits;
DESC fruits;

-- # ���̺� ���� : DROP TABLE ���̺��;
DROP TABLE fruits;

-- DROP TABLE�� ������ ���̺��� �����뿡�� ������ �����ϴ�
SHOW recyclebin;

-- �����뿡 �ִ� DB ������Ʈ �����ϱ�
FLASHBACK TABLE fruits TO BEFORE DROP;

-- ������ ����
PURGE recyclebin;

-- ���� ���̺��� �����Ͽ� �� ���̺� �����
CREATE TABLE employees2 AS (SELECT * FROM employees);

SELECT * FROM employees2;
DESC employees2;

-- # TRUNCATE TABLE ���̺�� : ������ ����� ������ ��� �߶������
TRUNCATE TABLE employees2;

-- # ���̺� ������ �����ϱ� (���Ƿ� ���� ������ ��)
CREATE TABLE employees3 AS(SELECT * FROM employees WHERE 1 != 1);
SELECT * FROM employees3;
DESC employees3;

DROP TABLE employees2;
DROP TABLE employees3;
PURGE RECYCLEBIN;

SELECT * FROM tab;

/*
    ���� �����ߴ� 1:N ������ ��ü���� ���̺�� �����غ�����
*/

CREATE TABLE game(
    registration_number     NUMBER(8)    NOT NULL,
    game_name               VARCHAR2(20) NOT NULL,
    category_serialnumber   NUMBER(4)    NOT NULL,
    price                   NUMBER(8,2)  NOT NULL,
    age_limit               NUMBER(2),
    degree                  VARCHAR2(3)
);

CREATE TABLE gamecategory (
    category_serialnumber NUMBER(4)    NOT NULL,
    category_name         VARCHAR2(10) NOT NULL,
    subcompany            VARCHAR2(30)
);

CREATE TABLE galaxy (
    galaxy_classnumber  NUMBER(8)    NOT NULL,
    galaxy_name         VARCHAR2(30) NOT NULL,
    planet_number       NUMBER(32),
    galaxy_size         NUMBER(32),
    galaxy_age          NUMBER(16),
    GOG_classnumber     NUMBER(8)    NOT NULL
);

CREATE TABLE planet (
    galaxy_classnumber NUMBER(8)    NOT NULL,
    planet_classnumber CHAR(8)      NOT NULL,
    planet_name        VARCHAR2(25) NOT NULL,
    planet_size        NUMBER(16),
    planet_age         NUMBER(16),
    existence_life     CHAR(5)      NOT NULL,
    planet_temperature NUMBER(8,2),
    existence_air      CHAR(5),
    PS_classnumber     VARCHAR2(25) NOT NULL
);

DESC galaxy;
DESC planet;
SELECT * FROM tab;

SELECT * FROM galaxy;

DESC employees;

CREATE TABLE chicken_house (
    house_id        VARCHAR2(8) NOT NULL,
    area_id         VARCHAR2(20),
    chicken_number  NUMBER(4)   NOT NULL,
    house_type      VARCHAR2(8),
    temperature     NUMBER(4,2),
    graze_time      VARCHAR2(6)   NOT NULL,
    close_time      VARCHAR2(6)   NOT NULL
);

CREATE TABLE chicken (
    house_id        VARCHAR2(8)  NOT NULL,
    chicken_id      VARCHAR2(8)  NOT NULL,
    breed           VARCHAR2(25) NOT NULL,
    gender          CHAR(1)      NOT NULL,
    age             NUMBER(4,2),
    specific        VARCHAR2(25)
);

DESC chicken_house;
DESC chicken;

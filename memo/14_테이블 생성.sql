-- 14_테이블 생성.sql

/*
    # CRUD
    
    - 대부분의 프로그램들이 가지고 있는 기본적인 데이터 처리들을 줄여 표현한 것
    - Create (데이터 생성)
    - Read   (데이터 읽기)
    - Update (데이터 수정)
    - Delete (데이터 삭제)

    # DML (Data Manipulate Language, 데이터 조작어)
    
    - 테이블의 데이터를 조작하는 명령어들
    - INSERT : 테이블 데이터 추가하기 (C)
    - SELECT : 테이블 데이터 읽기    (R)
    - UPDATE : 테이블 데이터 수정하기 (U)
    - DELETE : 테이블 데이터 삭제하기 (D)
    
    # DDL (Data Definition Language, 데이터 정의어)
    
    - DB 오브젝트를 정의하는 명령어들
      ※ DB 오브젝트 - 테이블, 시퀀스, 뷰, 인덱스, 사용자 계정, ...
    - CREATE    : DB 오브젝트 생성 (C)
    - ALTER     : DB 오브젝트 수정 (U)
    - DROP      : DB 오브젝트 삭제 (휴지통에서 복구 가능) (D)
    - TURNCATE  : DB 오브젝트 완전 삭제 (복구 불가능)
    
    # DCL (Data Control Langauge, 데이터 제어 명령어)
    
    - 사용자에게 권한을 부여하거나 박탈하는 명령어
    - GRANT  : 권한 부여
    - REVOKE : 권한 회수 
*/

SELECT * FROM tab;

/*
    # 테이블 생성하기
    
    CREATE TABLE 테이블명 (
        컬럼명 컬럼타입 (제약조건),
        ...
    );
*/

CREATE TABLE fruits (
    fname   VARCHAR2(30),
    price   NUMBER(6)
);

SELECT * FROM fruits;
DESC fruits;

-- # 테이블 삭제 : DROP TABLE 테이블명;
DROP TABLE fruits;

-- DROP TABLE로 삭제한 테이블은 휴지통에서 복구가 가능하다
SHOW recyclebin;

-- 휴지통에 있던 DB 오브젝트 복구하기
FLASHBACK TABLE fruits TO BEFORE DROP;

-- 휴지통 비우기
PURGE recyclebin;

-- 기존 테이블을 복사하여 새 테이블 만들기
CREATE TABLE employees2 AS (SELECT * FROM employees);

SELECT * FROM employees2;
DESC employees2;

-- # TRUNCATE TABLE 테이블명 : 구조만 남기고 내용을 모두 잘라버린다
TRUNCATE TABLE employees2;

-- # 테이블 구조만 복사하기 (고의로 거짓 조건을 줌)
CREATE TABLE employees3 AS(SELECT * FROM employees WHERE 1 != 1);
SELECT * FROM employees3;
DESC employees3;

DROP TABLE employees2;
DROP TABLE employees3;
PURGE RECYCLEBIN;

SELECT * FROM tab;

/*
    어제 설계했던 1:N 관계의 개체들을 테이블로 생성해보세요
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

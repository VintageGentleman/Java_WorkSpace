-- 16_제약조건.sql

/*
    # 무결성
    
    - 결함이 없는 성질
    - 데이터를 결함없는 상태로 올바르게 유지하는 것을 무결성을 유지한다고 한다
    - 데이터를 올바르게 관리하기 위해서는 다양한 종류의 무결성을 충족시켜야 한다
    - 데이터베이스에서는 다양한 제약 조건들을 통해 여러가지 무결성을 보장한다
    
    # 개체 무결성
    
    - 테이블의 데이터는 반드시 하나의 행을 선택할 수 있어야 한다
    - 개체 무결성을 지키기 위해 제약조건으로 기본키(PK)를 사용한다
    
    # 참조 무결성
    
    - 참조 관계에 있는 데이터는 유효한 데이터를 참조해야 한다
    - 참조 무결성을 지키기 위해 제약조건으로 외래키(FK)를 사용한다
    
    # 도메인 무결성
    
    - 하나의 도메인(컬럼)을 구성하는 개체들은 모두 같은 타입이어야 한다
    - 컬럼 타입을 지정하여 해당 컬럼의 도메인 무결성을 유지할 수 있다
    
    # 데이터 무결성
    
    - 데이터가 정확성, 일관성, 유효성을 유지하는 것
    - CHECK 제약 조건과 NOT NULL 제약조건을 통해 데이터 무결성을 유지할 수 있다
    
    # DB의 제약 조건들
    - UNIQUE : 해당 도메인에 중복되는 값을 허용하지 않는다 (null은 허용, 딱 한 번)
    - NOT NULL : 해당 도메인에 null 값을 허용하지 않는다
    - PRIMARY KEY : NOT NULL + UNIQUE, 한 테이블 당 하나만 가능
    - FOREIGN KEY : 해당 도메인을 외래키로 설정
    - CHECK : 원하는 조건을 직접 설정하여 해당 조건을 만족하는 개체만 추가 가능
*/

-- 현재 계정에 설정된 제약조건들 보기

/*
    # CONSTRAINT_TYPE
    
    - P : Primary Key
    - R : References (Foreign KEY)
    - U : Unique
    - C : Check, Not Null
*/

-- 현재 계정에 설정된 제약 조건들 보기
SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEES';

-- 모든 계정에 설정된 제약 조건들 보기
SELECT * FROM all_constraints;

/*
    # 데이터 딕셔너리 (Date Dictionary)
    
    - 데이터에 대한 데이터 (데이터 사전, 메타 데이터)
    - 현재 DB의 상황에 대한, DB가 알아서 관리하는 데이터
    - 사용자는 데이터 딕셔너리를 직접 수정할 수 없다
    
    # 데이터 딕셔너리 뷰

    - 데이터 딕셔너리를 사용자가 확인할 수 있도록 제공하는 뷰(View)
      * View - DB 오브젝트 중 하나로 전체 데이터의 일부만 조회 가능한 미니 테이블
    - 앞에 user_를 붙이면 현재 계정의 데이터 딕셔너리를 확인할 수 있다
    - 앞에 all_을 붙이면 전체 계정의 데이터 딕셔너리를 확인할 수 있다
*/

SELECT * FROM user_tables;
SELECT * FROM all_tables;
SELECT * FROM user_constraints;
SELECT * FROM all_constraints;

/*
    1. 테이블 생성과 동시에 제약조건 추가하기

    - 컬럼명 컬럼타입 제약조건 (제약조건의 이름이 자동으로 생성됨)
    - 컬럼명 컬럼타입 CONSTRAINT 제약조건이름 제약조건 (이름을 직접 지정함)
    - 한 도메인에 여러개의 제약조건을 설정할 수도 있다
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

-- coffee_name이 null이라 insert 거절당함
INSERT INTO coffee(coffee_id, coffee_price) VALUES(1, 5000);

-- check 제약조건에 걸려서 insert 거절당함
INSERT INTO coffee VALUES(1, 'Americano', -1000);

INSERT INTO coffee VALUES(1, 'Americano', 1500);
INSERT INTO coffee VALUES(2, 'Espresso', 800);

-- PK에는 null을 넣을 수 없어서 insert 거절
INSERT INTO coffee VALUES(NULL, 'Caffe Mocha', 2000);
-- PK에는 중복값도 넣을 수 없어서 insert 거절
INSERT INTO coffee VALUES(1, 'Caffe Mocha', 2000);

SELECT * FROM coffee;

DROP TABLE coffee;

/*
    2. 테이블 생성 후에 제약조건 추가하기
    
    - ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건이름 제약조건(컬럼);
    - NOT NULL, CHECK 제약 조건은 MODIFY로 해당 컬럼을 수정해야 한다
    - ALTER TABLE 테이블명 MODIFY(컬럼명 컬럼타입 CONSTRAINT ...);
*/ 
-- # DEFAULT 테이블에 값을 주지 않았을 때의 기본값
CREATE TABLE coffee(
    coffee_id    NUMBER(10),
    coffee_name  VARCHAR2(30),
    coffee_price NUMBER(6) DEFAULT 1000
);

ALTER TABLE coffee ADD CONSTRAINT coffee_id_pk PRIMARY KEY(coffee_id);
ALTER TABLE coffee ADD CONSTRAINT coffee_name_uk UNIQUE(coffee_name);

-- NOT NULL, CHECK, DEFAULT는 MODIFY로 추가해야 한다
ALTER TABLE coffee MODIFY (
    coffee_price NUMBER(7) DEFAULT 0
        CONSTRAINT coffee_price_chk CHECK(coffee_price >= 0)
        CONSTRAINT coffee_price_nn NOT NULL
);

SELECT * FROM user_constraints WHERE table_name = 'COFFEE';
DROP TABLE coffee;

/*
    # 테이블 레벨 방식으로 제약 조건 추가하기
    
    - 컬럼을 먼저 정의한 후 테이블 생성문 내부에서 제약 조건을 후술하는 방식
    - DEFAULT, NOT NULL은 컬럼 레벨에서 정의해야 한다
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
    # 외래키 설정하기
    
    - 외래키 제약조건은 설정할 때 다른 테이블의 어떤 컬럼을 참조할 것인지 지정해야한다
    - 설정하려는 컬럼에 UNIQUE 또는 PRIMARY KEY 제약조건이 설정되어 있지 않다면
      외래키로 지정할 수 없다 (에러 발생)
    - 외래키로 설정된 컬럼에는 참조하는 컬럼에 존재하는 값 또는 null만 추가할 수 있다
*/
SELECT * FROM employees;

-- 1. 컬럼 레벨에서 외래키 제약조건 설정하기
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

-- 2번 방식으로 외래키 추가하기
CREATE TABLE event_participants(
    event_id NUMBER(8),
    part_date DATE DEFAULT sysdate,
    employee_id NUMBER(6) 
);

ALTER TABLE event_participants
    ADD CONSTRAINT event_emp_id_fk
        FOREIGN KEY (employee_id) REFERENCES employees(employee_id);

SELECT * FROM user_constraints WHERE table_name LIKE 'EVENT%';

-- 3번 방식으로 외래키 추가하기

CREATE TABLE event_participants(
    event_id NUMBER(8),
    part_date DATE DEFAULT sysdate,
    employee_id NUMBER(6), 
    CONSTRAINT event_emp_id_fk FOREIGN KEY (employee_id)
        REFERENCES employees(employee_id)
);





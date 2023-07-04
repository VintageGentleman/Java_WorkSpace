-- 17_테이블 수정하기.sql

/*
    # 테이블에 새 컬럼 추가하기
    
    - ALTER TABLE 테이블명 ADD (컬럼명 컬럼타입 제약조건, ...);
    - 새 컬럼이 추가되면 기존에 존재하던 행들은 해당 컬럼값이 NULL로 추가된다
    - 새 컬럼을 추가할 때 DEFAULT를 설정해 놓으면 DEFAULT로 추가된다
*/

SELECT * FROM fruits;

ALTER TABLE fruits ADD(
    taste NUMBER(1)
);

ALTER TABLE fruits ADD(
    grade VARCHAR2(2) DEFAULT 'B'
);

UPDATE fruits SET grade = 'A+' WHERE fname = 'applepie';

-- 연습1: countries 테이블을 복사한 countries2 테이블을 만들어보세요

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
        
-- 연습2: fruits 테이블에 countries2의 country_id를
--        부모키로 갖는 외래키 컬럼을 만들어보세요
ALTER TABLE fruits ADD(
    country_id CHAR(2)
);

ALTER TABLE vegetable
    ADD CONSTRAINT country_id_fk
        FOREIGN KEY (country_id)    REFERENCES countries2(country_id);
    
SELECT * FROM fruits;
SELECT * FROM user_constraints WHERE table_name = 'VEGETABLE';

-- 같이해보기
CREATE TABLE countries2 AS (SELECT * FROM countries);
SELECT * FROM user_constraints WHERE table_name = 'COUNTRIES2';

SELECT * FROM countries;
-- countries2의 country_id를 unique 또는 기본키로 바꿔줘야 한다
ALTER TABLE countries2 ADD CONSTRAINT countries2_id_pk PRIMARY KEY(country_id);

-- 그 후 외래키 추가
ALTER TABLE fruits ADD (
    country_id CHAR(2)
        CONSTRAINT fruits_country_id_fk REFERENCES countries2(country_id)
);
SELECT * FROM user_constraints WHERE table_name = 'FRUITS';

/*
    # 테이블 컬럼 삭제하기
    
    - ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
*/
ALTER TABLE fruits DROP COLUMN taste;
SELECT * FROM fruits;

/*
    # 테이블의 컬럼 이름 변경하기
    
    - ALTER TABLE 테이블명 RENAME COLUMN 현재이름 TO 바꿀이름;
*/
ALTER TABLE fruits RENAME COLUMN fname TO fruit_name;
SELECT * FROM fruits;

/*
    # 테이블 이름 변경하기
    
    - RENAME 테이블명 TO 바꿀이름;
*/
RENAME fruits TO vegetable;

SELECT * FROM vegetable;
SELECT * FROM user_constraints WHERE table_name = 'VEGETABLE';

/*
    # 테이블의 컬럼 수정하기
    
    - ALTER TABLE 테이블명 MODIFY(컬럼명 컬럼타입 제약조건, ... );
      ※ 제약조건을 추가할 때 사용했었다
*/
ALTER TABLE vegetable MODIFY(
    price NUMBER(10) DEFAULT 30,
    grade VARCHAR2(2) DEFAULT 'B+'
        CONSTRAINT vege_grade_chk CHECK(grade IN('A+', 'A', 'B+', 'B', 'C'))
);

SELECT * FROM vegetable;

/*
    # 테이블의 제약조건 삭제하기
    
    - ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
    - 제약 조건이름이 자동으로 생성되면 지우기 힘드므로 잘 만들자
    - 테이블을 삭제하면 해당 테이블의 모든 제약조건이 함께 삭제된다
*/
SELECT * FROM user_constraints WHERE table_name = 'COFFEE';

ALTER TABLE coffee DROP CONSTRAINT coffee_name_nn;
ALTER TABLE coffee DROP CONSTRAINT coffee_name_uk;
ALTER TABLE coffee DROP CONSTRAINT coffee_id_pk;
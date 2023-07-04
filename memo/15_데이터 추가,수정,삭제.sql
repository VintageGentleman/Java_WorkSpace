-- 15_데이터 추가,수정,삭제.sql

/*
    # 테이블에 데이터 추가하기
    
    - INSERT INTO 테이블명(컬럼,컬럼,...) VALUES(값,값,...)
    - INSERT INTO 테이블명 VALUES(모든 컬럼값 순서대로);
*/

CREATE TABLE fruits (
    fname VARCHAR2(30),
    price NUMBER(8),
    qty NUMBER(6)
);

--  # 기본 INSERT
INSERT INTO fruits(fname, price, qty) VALUES('apple', 500, 80);
INSERT INTO fruits(fname, price, qty) VALUES('apple', 500, 80);
INSERT INTO fruits(fname, price, qty) VALUES('banana', 1000, 100);

-- # 컬럼 순서를 마음대로 해서 INSERT
INSERT INTO fruits(qty, fname, price) VALUES(5, 'melon', 8000);

-- # 컬럼을 일부만 선택해서 INSERT (값을 넣지 않은 컬럼은 null)
INSERT INTO fruits(fname, price) VALUES('water melon', 5000);
INSERT INTO fruits(fname) VALUES('peach');

-- # 컬럼을 아예 선택하지 않으면 반드시 모든 컬럼값을 순서대로 넣어야 한다 
INSERT INTO fruits VALUES('wather melon', 5000, 33);
INSERT INTO fruits VALUES('wather melon', null, 35);

-- # 서브쿼리로 INSERT 하기 (테이블 구조가 동일해야 복사가 가능하다)
INSERT INTO fruits (SELECT * FROM fruits);

SELECT * FROM fruits WHERE qty <= 50;

/*  
    # 테이블 데이터 수정하기
    
    - UPDATE 테이블명 SET 컬럼=값, 컬럼=값, ... WHERE 조건절;
    - 만약 조건을 지정하지 않으면 모든 행이 수정된다 ※ 주의
    - 하나의 행만 수정하기 위해서는 반드시 기본키와 함께 활용되어야 한다
*/

UPDATE fruits SET fname='applepie' WHERE fname='apple';

COMMIT; -- 현재 까지의 DB 변경 사항을 확정짓는다...

UPDATE fruits SET qty = 0; -- 조건을 지정하지 않으면 모든 행이 변경된다

ROLLBACK;

/*
    # 테이블 데이터 삭제하기
    
    - DELETE FROM 테이블명 WHERE 조건;
    - 조건을 적지 않으면 해당 테이블의 모든 데이터가 삭제된다 ※ 주의
*/

DELETE FROM fruits;
ROLLBACK;

DELETE FROM fruits WHERE qty < 10;

SELECT * FROM fruits;

DESC chicken;
DESC chicken_house;

-- 연습1: 어제 본인이 직접 설계한 테이블에 데이터 넣어보기
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

-- 연습2: 두 테이블을 JOIN하여 원하는 데이터를 조회해보기
SELECT
    chicken_id,
    graze_time AS 나가는시간,
    close_time AS 들어오는시간
FROM
        chicken 
    INNER JOIN chicken_house USING (house_id);

SELECT
    chicken_id,
    area_id AS 닭위치
FROM
        chicken
    INNER JOIN chicken_house USING (house_id);

-- 같이 해보기

SELECT * FROM countries;

CREATE TABLE fruits2(
    fid NUMBER(5), -- fruits2 테이블의 기본키
    fname VARCHAR2(30),
    prcie NUMBER(6),
    country_id CHAR(2) -- 외래키 (countries의 기본키)
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
    


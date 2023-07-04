-- 19_트랜잭션.sql

/*
    # 트랜잭션 (Transaction)
    
    - 하나의 작업 단위 (ex: 물건 판매, 송금 ...)
    - 데이터베이스는 하나의 트랜잭션에 속한 모든 작업이 정상적으로 완료되는 경우에만 
      변경사항을 확정 지을 수 있는 기능을 제공한다 (All or Nothing)
    - 트랜잭션을 관리하기 위한 키워드로는
      COMMIT, ROLLBACK, SAVEPOINT, ROLLBACK TO가 있다
    - 하나의 트랜잭션은 마지막으로 실행된 커밋으로 부터
      새로운 커밋을 실행하기 전까지 수행되는 모든 DML만을 의미한다
      (INSERT, UPDATE, DELETE 등의 테이블 데이터 수정은 트랜잭션의 관리 대상이지만
       CREATE TABLE, ALTER TABLE, ALTER USER, ... 등의 DB 오브젝트 수정은
       트랜잭션의 관리대상이 아니다)
*/
SELECT * FROM user_tables;
SELECT * FROM user_constraints WHERE table_name = 'COFFEE';

SELECT * FROM coffee;
DESC coffee;

INSERT INTO coffee VALUES(1, 'Americano', 1500);
INSERT INTO coffee VALUES(2, 'Americano', 2000);

-- COMMIT : 여태까지의 변경사항을 확정짓는다 (하나의 트랜잭션을 마무리한다)
COMMIT;

INSERT INTO coffee VALUES(3, 'Americano', 2000);
INSERT INTO coffee VALUES(4, 'Americano', 2000);
INSERT INTO coffee VALUES(5, 'Americano', 2000);
INSERT INTO coffee VALUES(6, 'Americano', 2000);

-- ROLLBACK : 가장 최근에 했던 커밋으로 돌아간다
ROLLBACK;

SELECT * FROM coffee;

SAVEPOINT mysavepoint1;

UPDATE coffee SET coffee_price = coffee_price + 500
WHERE coffee_name = 'Americano';

SAVEPOINT mysavepoint2;

UPDATE coffee SET coffee_price = coffee_price + 500
WHERE coffee_name = 'Americano';

-- 일부만 취소하고 트랜잭션을 다시 진행하고 싶은 경우 세이브포인트를 사용한다
ROLLBACK TO mysavepoint2;
ROLLBACK TO mysavepoint1;
ROLLBACK;

SELECT * FROM coffee;

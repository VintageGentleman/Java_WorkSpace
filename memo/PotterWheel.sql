/*
    # 경품 추첨 이벤트를 구현해보세요
    
    (1) DB에 경품들의 이름, 당첨 확률, 남은 수량 등을 저장할 수 있는
        테이블이 존재해야 한다
        
    (2) 콘솔에서 뽑기를 진행하면 실제로 DB에서 수량이 줄어들어야 한다
    
    (3) 상품이 모두 소진되면 프로그램이 종료되어야 한다
    
    (4) 리셋 기능을 실행하면 DB의 상품이 다시 충전 된다
*/

CREATE TABLE prize (
    prize_id NUMBER(3)
        CONSTRAINT prize_id_pk PRIMARY KEY,
    prize_name VARCHAR2(40)
        CONSTRAINT prize_name_nn NOT NULL,
    prize_rate NUMBER(3,3) DEFAULT 0,    
    prize_curr_qty NUMBER(6) DEFAULT 0
        CONSTRAINT prize_curr_qty_ckh CHECK(prize_curr_qty >= 0),
    prize_max_qty NUMBER(6)
        CONSTRAINT prize_max_qty_ckh CHECK(prize_max_qty >= 0)
        CONSTRAINT prize_max_qty_nn NOT NULL
);

DESC prize;
SELECT * FROM user_tables;
SELECT * FROM user_constraints;

INSERT INTO prize VALUES(1, '다리미', 0.25, 100, 100);
INSERT INTO prize VALUES(2, '옷걸이', 0.25, 200, 200);
INSERT INTO prize VALUES(3, '쓰레기봉투', 0.25, 300, 300);
INSERT INTO prize VALUES(4, '휴지', 0.25, 400, 400);
INSERT INTO prize VALUES(5, '물휴지', 0.25, 500, 500);

UPDATE prize SET prize_max_qty = 200;

SELECT * FROM prize;

COMMIT;

-- 새 상품을 INSERT 할 때 확률이 1이 넘으면 취소하는 로직이 필요하다
INSERT INTO prize VALUES(6, '물휴지', 0.25, 500, 500);
SELECT SUM(prize_rate) FROM prize;
COMMIT;
ROLLBACK;

-- 전체 상품의 남은 수량
SELECT SUM(prize_curr_qty) FROM prize;

-- 상품 수량 원래대로 돌리기
UPDATE prize SET prize_curr_qty = prize_max_qty;


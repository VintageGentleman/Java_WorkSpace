/*
    # ��ǰ ��÷ �̺�Ʈ�� �����غ�����
    
    (1) DB�� ��ǰ���� �̸�, ��÷ Ȯ��, ���� ���� ���� ������ �� �ִ�
        ���̺��� �����ؾ� �Ѵ�
        
    (2) �ֿܼ��� �̱⸦ �����ϸ� ������ DB���� ������ �پ���� �Ѵ�
    
    (3) ��ǰ�� ��� �����Ǹ� ���α׷��� ����Ǿ�� �Ѵ�
    
    (4) ���� ����� �����ϸ� DB�� ��ǰ�� �ٽ� ���� �ȴ�
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

INSERT INTO prize VALUES(1, '�ٸ���', 0.25, 100, 100);
INSERT INTO prize VALUES(2, '�ʰ���', 0.25, 200, 200);
INSERT INTO prize VALUES(3, '���������', 0.25, 300, 300);
INSERT INTO prize VALUES(4, '����', 0.25, 400, 400);
INSERT INTO prize VALUES(5, '������', 0.25, 500, 500);

UPDATE prize SET prize_max_qty = 200;

SELECT * FROM prize;

COMMIT;

-- �� ��ǰ�� INSERT �� �� Ȯ���� 1�� ������ ����ϴ� ������ �ʿ��ϴ�
INSERT INTO prize VALUES(6, '������', 0.25, 500, 500);
SELECT SUM(prize_rate) FROM prize;
COMMIT;
ROLLBACK;

-- ��ü ��ǰ�� ���� ����
SELECT SUM(prize_curr_qty) FROM prize;

-- ��ǰ ���� ������� ������
UPDATE prize SET prize_curr_qty = prize_max_qty;


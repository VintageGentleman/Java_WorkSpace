-- 20_시퀀스.sql

/*
    # 시퀀스 (Sequence)
    
    - 기본키로 사용하기 편리하도록 번호를 자동을 생성해주는 DB오브젝트
    
    CREATE SEQUNCE 시퀀스명
                    [START WITH n] - 시작 번호 설정
                    [INCREMENTY BY n] - 증가 숫자 설정
                    [NOMAXVALUE | MAXVALUE n] - 최대 숫자 설정
                    [NOMINVALUE | MINVALUE n] - 최소 숫자 설정
                    [NOCYCLE | CYCLE] - 번호 순환 여부 설정
                    [NOCACHE | CACHE n] - 캐시 설정 여부
                                          ※ 번호를 미리 만들어놓을 양을 설정  
                              (성능은 좋아지지만 중간 번호가 사라질 위험이 있음)
                                          
    - user_sequences, all_sequences로 시퀀스들의 상태를 확인할 수 있다
*/
COMMIT;

SELECT * FROM coffee;
CREATE SEQUENCE coffee_id_seq 
    START WITH 7
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE
    NOCACHE;
    
-- # 시퀀스 데이터 딕셔너리 뷰
SELECT * FROM user_sequences;

-- # 시퀀스.nextval : 다음 번호를 사용한다 (다시는 이전 번호로 되돌릴 수 없다)
INSERT INTO coffee VALUES(coffee_id_seq.nextval, 'Caffe Latte', 3000);
SELECT * FROM coffee;
COMMIT;

-- # 시퀀스.currval : 현재 시퀀스 값을 확인한다 (번호를 소모하지는 않는다)
SELECT coffee_id_seq.currval FROM dual;

-- # dual 테이블 : 행이 하나만 존재하는 연습용 테이블
SELECT * FROM dual;
SELECT 123 + 345 FROM dual;

-- 간단한 값을 연습삼아 출력해보려고 해도 테이블이 필요하기 때문에
-- 행이 많은 테이블을 사용하는 것보다 연습용 테이블을 통해 연습을 해볼 수 있다
SELECT 1, first_name, coffee_id_seq.currval FROM employees;
SELECT 123 + 345 FROM employees;
SELECT coffee_id_seq.nextval FROM employees;

-- # 순환 설정된 시퀀스 사용해보기 (ex: 은행 번호표, 진동벨 대기번호 등)
CREATE SEQUENCE cycle_test_seq
    START WITH 1 INCREMENT BY 7
    MAXVALUE 45 NOCACHE CYCLE;
SELECT cycle_test_seq.nextval FROM employees;   

-- # 시퀀스 수정하기 (ALTER SEQUENCE 이후 문법은 같음)
ALTER SEQUENCE cycle_test_seq
        MINVALUE 30 MAXVALUE 60 INCREMENT BY 2;
SELECT cycle_test_seq.currval FROM dual;
SELECT cycle_test_seq.nextval FROM dual;

SELECT cycle_test_seq.nextval FROM employees;

-- # 시퀀스 삭제하기
DROP SEQUENCE cycle_test_seq;

-- # 시퀀스는 휴지통에서 복구가 불가능하다
SHOW recyclebin;
PURGE recyclebin;

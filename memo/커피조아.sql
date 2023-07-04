
SELECT * FROM tab;

CREATE TABLE coupon (
    phone_number VARCHAR2(11) 
        CONSTRAINT phone_number_pk PRIMARY KEY
        CONSTRAINT phone_number_chk CHECK(
            regexp_like(phone_number, '[0-9]{11}')),
    coupon_count NUMBER(2) DEFAULT 0,
    stamp_count NUMBER(2) DEFAULT 0
);

SELECT * FROM user_constraints;
SELECT * FROM coupon;
INSERT INTO coupon VALUES('01012341234', 0, 0);

ROLLBACK;
COMMIT;

UPDATE coupon SET stamp_count = stamp_count + 3 WHERE phone_number = '01012341234';
SELECT coupon_count, stamp_count FROM coupon WHERE phone_number = '01012341234';

UPDATE coupon SET coupon_count = 1, stamp_count = 1 WHERE phone_number = '01012341234';


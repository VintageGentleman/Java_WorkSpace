SELECT * FROM tab;

CREATE TABLE members (
    members_key NUMBER(6)
        CONSTRAINT members_key_pk PRIMARY KEY,
    members_id VARCHAR2(20)
        CONSTRAINT members_id_uk UNIQUE
        CONSTRAINT members_id_nn NOT NULL,
    members_pw VARCHAR2(20)
        CONSTRAINT members_pw_nn NOT NULL,
    members_name VARCHAR2(18)
        CONSTRAINT members_name_nn NOT NULL,
    members_RRM VARCHAR2(7)
        CONSTRAINT members_RRM_nn NOT NULL
        CONSTRAINT members_RRM_chk CHECK(members_RRM LIKE '_______'),
    members_email VARCHAR2(30)
);

CREATE SEQUENCE members_key_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 999999
    NOCACHE NOCYCLE;

DESC members;

INSERT INTO members VALUES(0, 'test_dummy12345', 'Nn1234', 'Å×½ºÆ®', '0000000', 'test@test.com'); 

SELECT * FROM members;

UPDATE members SET members_id = ? WHERE members_key = 0;

PURGE recyclebin;
SELECT * FROM user_constraints where table_name = 'MEMBERS';
SELECT * FROM user_sequences;


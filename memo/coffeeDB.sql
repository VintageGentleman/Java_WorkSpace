SELECT * FROM employees;
SELECT * FROM tab;
SELECT * FROM coffee ORDER BY coffee_id;

SELECT * FROM user_sequences;
SELECT * FROM user_constraints WHERE table_name = 'COFFEE';

DESC employees;

SELECT * FROM coffee WHERE coffee_price <= 3000;
SELECT * FROM coffee;

commit;

UPDATE 

ALTER TABLE coffee 
    ADD CONSTRAINT coffee_id_pk PRIMARY KEY (coffee_id);

ALTER TABLE coffee 
    ADD CONSTRAINT coffee_id_uk UNIQUE (coffee_name);


DROP SEQUENCE coffee_id_seq;

CREATE SEQUENCE coffee_id_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCACHE NOCYCLE;
    
-- 테마 theme  약축 - tm
CREATE TABLE Theme (
    tm_id NUMBER(5) PRIMARY KEY,
    tm_name VARCHAR2(50) NOT NULL,
    thumbnail VARCHAR2(200) NOT NULL
);

-- 제품  약축 -pd
CREATE TABLE product(
        pd_id NUMBER(4) PRIMARY KEY,
        pd_name VARCHAR2(30) NOT NULL,
        pd_price NUMBER(6) NOT NULL,
        pd_thumbnail VARCHAR2(500) NOT NULL,
        pd_theme_id NUMBER(5) REFERENCES  Theme(tm_id),
        pf_shot char(1) CONSTRAINT pf_shot_chk CHECK(pf_shot ='0' or pf_shot ='1'),
        pf_milk  char(1) CONSTRAINT pf_milk_chk CHECK(pf_milk ='0' or pf_milk ='1'),
        pf_ice  char(1) CONSTRAINT pf_ice_chk CHECK(pf_ice ='0' or pf_ice ='1'),
        pf_stevia  char(1) CONSTRAINT pf_stevia_chk CHECK(pf_stevia ='0' or pf_stevia ='1')
);

-- 옵션  약축 - op
CREATE TABLE personal_option(
    op_id NUMBER(5) PRIMARY KEY,
    op_cream NUMBER(1),
    op_shot NUMBER(1) NOT NULL,
    op_milk NUMBER(1) NOT NULL,
    op_ice NUMBER(1) NOT NULL,
    op_sugar NUMBER(1)  NOT NULL
);

-- 지점  약축 - bc
CREATE TABLE branch(
    bc_id NUMBER(5) PRIMARY KEY,
    bc_name VARCHAR2(50) NOT NULL,
    bc_location VARCHAR2(500) NOT NULL,
    bc_chief VARCHAR2(20)
);


-- 주문내역  약축 -od 
CREATE TABLE order_list (
    od_id NUMBER(5) PRIMARY KEY,
    od_price NUMBER(5) NOT NULL
); 

--결제  - 약축 -pay
CREATE TABLE payment(
    pay_id NUMBER(5) PRIMARY KEY,
    pay_way VARCHAR2(30) NOT NULL
);

-- 판매데이터  약축 - sd
CREATE TABLE sellingdata (
    sd_id NUMBER(6) PRIMARY KEY,
    sd_time DATE DEFAULT sysdate,
    sd_pay_id NUMBER(5) REFERENCES payment(pay_id),
    sd_od_id NUMBER(5) REFERENCES order_list(od_id),
    sd_bc_id NUMBER(5) REFERENCES branch(bc_id)
);

-- 선택목록  약축- alist_
CREATE TABLE available_list (
    alist_id NUMBER(5) PRIMARY KEY,
    alist_od_id NUMBER(5) REFERENCES order_list(od_id),
    alist_pd_id NUMBER(5) REFERENCES product(pd_id),
    alist_op_id NUMBER(5) REFERENCES personal_option(op_id),
    alist_count NUMBER(2) NOT NULL
);

-- 매니저 약축 - mg
CREATE TABLE manager(
    mg_id NUMBER(6) PRIMARY KEY,
    mg_name VARCHAR2(30) NOT NULL,
    mg_phone NUMBER(11) NOT NULL,
    mg_position VARCHAR(30) NOT NULL,
    mg_bc_id NUMBER(5) REFERENCES branch(bc_id),
    mg_hire_date DATE NOT NULL
);

SELECT * FROM tabs;

DESC personal_option;
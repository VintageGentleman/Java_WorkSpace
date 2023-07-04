-- 21_유용한 함수들.sql

/*****              숫자 타입 함수들              *****/

-- # TO_NUMBER(data) : 다른 타입 데이터를 숫자 타입으로 변환한다
SELECT TO_NUMBER('1234567') FROM dual;

-- # 포맷을 사용해 형식이 있는 문자열도 쉽게 숫자 타입으로 변환할 수 있다
SELECT TO_NUMBER('10,000', '999,999,999') FROM dual;
SELECT TO_NUMBER('123,000,000', '999,999,999') FROM dual;
SELECT TO_NUMBER('$5,000', '$999,999,999') FROM dual;
SELECT TO_NUMBER('5,000￦', '999,999,999L') FROM dual;
SELECT TO_NUMBER('550,000￦', '999,999,999L') FROM dual;

-- # abs(n) : 절대값
SELECT abs(-5) FROM dual;

-- # floor(n) : 내림
SELECT floor(5.1) FROM dual;

-- # ceil(n) : 올림
SELECT ceil(5.1) FROM dual;

-- # round(n) : 반올림, 자리수 설정 가능
SELECT round(5.5555) FROM dual;
SELECT round(5.5555, 3) FROM dual;

-- # mod(n, m) : 나머지 연산
SELECT mod(13, 10) FROM dual;

-- # trunc(n, m) : 원하는 자리까지 자르기 (반올림 X)
SELECT trunc(123.123456, 3) FROM dual;

/*****              문자 타입 함수들              *****/

-- # to_char(data) : 전달한 데이터를 문자 타입으로 변환 (날짜도 가능)
SELECT to_char(1234) FROM dual;

-- # 숫자를 문자로 변환할 때도 형식을 사용할 수 있다
SELECT to_char(5500, '9,999$') FROM dual;
SELECT to_char(5500, '9,999L') FROM dual;

-- # 날짜 타입을 문자로 변환하기
SELECT to_char(sysdate) FROM dual;
SELECT to_char(hire_date) FROM employees;

-- # 날짜 타입도 형식을 사용해 변환할 수 있다 (SimpleDateFormat과 다르므로 주의)
SELECT to_char(sysdate, 'YYYY/MM/DD HH:MI:SS') FROM dual;
SELECT to_char(hire_date, 'YYYY/MM/DD HH:MI:SS') FROM employees;

-- # substr(문자, 시작위치, 문자개수) : 자른다 (마지막 index가 아니라 문자개수인 점 유의)
SELECT substr('Hello, Datebase', 5, 6) FROM dual;
SELECT substr('헬로우데이터베이스', 4, 3) FROM dual;

-- # ltrim(문자, 제거대상문자들) : 왼쪽부터 제거 대상 문자들을 제거하다가 대상 문자가 아닌 것을 만나면 멈춘다
SELECT ltrim('##########database', '#') FROM dual;
SELECT ltrim('@@#@@#@@#@@@@database', '#@') FROM dual;

-- # rtrim(문자, 제거대상문자들) : 오른쪽부터 제거 대상 문자들을 제거하다가 대상 문자가 아닌 것을 만나면 멈춘다
SELECT rtrim('##########database#######', '#') FROM dual;
SELECT rtrim('##########database!@@@@@@!!!!!#######', '!@#') FROM dual;

-- # lpad(문자, 원하는전체길이, 채울문자) : 왼쪽에 원하는 문자들을 채운다
-- # rpad(문자, 원하는전체길이, 채울문자) : 오른쪽에 원하는 문자들을 채운다
SELECT lpad('COFFEE', 20, '<') FROM dual;
SELECT rpad('TEA', 20, '>') FROM dual;

-- # upper(문자) : 대문자로
-- # lower(문자) : 소문자로
-- # initcap(문자) : 첫 글자만 대문자로
SELECT upper('hello') FROM dual;
SELECT lower(first_name||' '||last_name) FROM employees;
SELECT rpad(upper(first_name||' '||last_name), 30, '+!@') FROM employees;
SELECT initcap(email) FROM employees;

-- # replace(문자, old, new) : 교체
SELECT replace('abc@naver.com', 'naver', 'google') FROM dual;

/*****              날짜 타입 함수들              *****/

-- # to_date(data) : 데이터를 날짜 타입으로 변환
SELECT to_date('1998/11/25') FROM dual;
SELECT to_date('1999-8-5') FROM dual;
SELECT to_date('2005+9+20') FROM dual;

-- # 형식을 지정해서 date타입으로 변환하는 것도 가능하다
SELECT to_date('1999+++8+++5', 'YYYY+++MM+++DD') FROM dual;
SELECT to_date('1999+++8+++5, 13:40:55', 'YYYY+++MM+++DD, HH24:MI:SS') FROM dual;

-- # trunc(dateType) : 원하는 단위로 날짜를 잘라서 사용할 수 있다

 -- day 아래는 다 잘림(시간)
SELECT 
    to_char(trunc(sysdate, 'day'), 'YYYY/MM/DD, HH24:MI:SS')
FROM dual;

-- month 아래는 다 잘림(날짜, 시간)
SELECT 
    to_char(trunc(sysdate, 'month'), 'YYYY/MM/DD, HH24:MI:SS')
FROM dual; 

-- year 아래는 다 잘림(월, 날짜, 시간)
SELECT 
    to_char(trunc(sysdate, 'year'), 'YYYY/MM/DD, HH24:MI:SS')
FROM dual; 

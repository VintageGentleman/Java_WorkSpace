-- 21_������ �Լ���.sql

/*****              ���� Ÿ�� �Լ���              *****/

-- # TO_NUMBER(data) : �ٸ� Ÿ�� �����͸� ���� Ÿ������ ��ȯ�Ѵ�
SELECT TO_NUMBER('1234567') FROM dual;

-- # ������ ����� ������ �ִ� ���ڿ��� ���� ���� Ÿ������ ��ȯ�� �� �ִ�
SELECT TO_NUMBER('10,000', '999,999,999') FROM dual;
SELECT TO_NUMBER('123,000,000', '999,999,999') FROM dual;
SELECT TO_NUMBER('$5,000', '$999,999,999') FROM dual;
SELECT TO_NUMBER('5,000��', '999,999,999L') FROM dual;
SELECT TO_NUMBER('550,000��', '999,999,999L') FROM dual;

-- # abs(n) : ���밪
SELECT abs(-5) FROM dual;

-- # floor(n) : ����
SELECT floor(5.1) FROM dual;

-- # ceil(n) : �ø�
SELECT ceil(5.1) FROM dual;

-- # round(n) : �ݿø�, �ڸ��� ���� ����
SELECT round(5.5555) FROM dual;
SELECT round(5.5555, 3) FROM dual;

-- # mod(n, m) : ������ ����
SELECT mod(13, 10) FROM dual;

-- # trunc(n, m) : ���ϴ� �ڸ����� �ڸ��� (�ݿø� X)
SELECT trunc(123.123456, 3) FROM dual;

/*****              ���� Ÿ�� �Լ���              *****/

-- # to_char(data) : ������ �����͸� ���� Ÿ������ ��ȯ (��¥�� ����)
SELECT to_char(1234) FROM dual;

-- # ���ڸ� ���ڷ� ��ȯ�� ���� ������ ����� �� �ִ�
SELECT to_char(5500, '9,999$') FROM dual;
SELECT to_char(5500, '9,999L') FROM dual;

-- # ��¥ Ÿ���� ���ڷ� ��ȯ�ϱ�
SELECT to_char(sysdate) FROM dual;
SELECT to_char(hire_date) FROM employees;

-- # ��¥ Ÿ�Ե� ������ ����� ��ȯ�� �� �ִ� (SimpleDateFormat�� �ٸ��Ƿ� ����)
SELECT to_char(sysdate, 'YYYY/MM/DD HH:MI:SS') FROM dual;
SELECT to_char(hire_date, 'YYYY/MM/DD HH:MI:SS') FROM employees;

-- # substr(����, ������ġ, ���ڰ���) : �ڸ��� (������ index�� �ƴ϶� ���ڰ����� �� ����)
SELECT substr('Hello, Datebase', 5, 6) FROM dual;
SELECT substr('��ο쵥���ͺ��̽�', 4, 3) FROM dual;

-- # ltrim(����, ���Ŵ���ڵ�) : ���ʺ��� ���� ��� ���ڵ��� �����ϴٰ� ��� ���ڰ� �ƴ� ���� ������ �����
SELECT ltrim('##########database', '#') FROM dual;
SELECT ltrim('@@#@@#@@#@@@@database', '#@') FROM dual;

-- # rtrim(����, ���Ŵ���ڵ�) : �����ʺ��� ���� ��� ���ڵ��� �����ϴٰ� ��� ���ڰ� �ƴ� ���� ������ �����
SELECT rtrim('##########database#######', '#') FROM dual;
SELECT rtrim('##########database!@@@@@@!!!!!#######', '!@#') FROM dual;

-- # lpad(����, ���ϴ���ü����, ä�﹮��) : ���ʿ� ���ϴ� ���ڵ��� ä���
-- # rpad(����, ���ϴ���ü����, ä�﹮��) : �����ʿ� ���ϴ� ���ڵ��� ä���
SELECT lpad('COFFEE', 20, '<') FROM dual;
SELECT rpad('TEA', 20, '>') FROM dual;

-- # upper(����) : �빮�ڷ�
-- # lower(����) : �ҹ��ڷ�
-- # initcap(����) : ù ���ڸ� �빮�ڷ�
SELECT upper('hello') FROM dual;
SELECT lower(first_name||' '||last_name) FROM employees;
SELECT rpad(upper(first_name||' '||last_name), 30, '+!@') FROM employees;
SELECT initcap(email) FROM employees;

-- # replace(����, old, new) : ��ü
SELECT replace('abc@naver.com', 'naver', 'google') FROM dual;

/*****              ��¥ Ÿ�� �Լ���              *****/

-- # to_date(data) : �����͸� ��¥ Ÿ������ ��ȯ
SELECT to_date('1998/11/25') FROM dual;
SELECT to_date('1999-8-5') FROM dual;
SELECT to_date('2005+9+20') FROM dual;

-- # ������ �����ؼ� dateŸ������ ��ȯ�ϴ� �͵� �����ϴ�
SELECT to_date('1999+++8+++5', 'YYYY+++MM+++DD') FROM dual;
SELECT to_date('1999+++8+++5, 13:40:55', 'YYYY+++MM+++DD, HH24:MI:SS') FROM dual;

-- # trunc(dateType) : ���ϴ� ������ ��¥�� �߶� ����� �� �ִ�

 -- day �Ʒ��� �� �߸�(�ð�)
SELECT 
    to_char(trunc(sysdate, 'day'), 'YYYY/MM/DD, HH24:MI:SS')
FROM dual;

-- month �Ʒ��� �� �߸�(��¥, �ð�)
SELECT 
    to_char(trunc(sysdate, 'month'), 'YYYY/MM/DD, HH24:MI:SS')
FROM dual; 

-- year �Ʒ��� �� �߸�(��, ��¥, �ð�)
SELECT 
    to_char(trunc(sysdate, 'year'), 'YYYY/MM/DD, HH24:MI:SS')
FROM dual; 

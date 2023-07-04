-- 한 줄 주석

/*
    여러 줄 주석
*/

/*
    # Oracle XE 11g 다운로드 및 설치
    
    1. 구글링
    2. 다운로드
    3. 설치
    
    # 설치할 때 주의할 점
    
    1. 설치 경로를 잘 기억해둘 것 (C:/oraclexe)
    2. 설치 시 사용되는 포트번호를 기억할 것(1521, 2030, 8080)
    3. 설치 시 설정한 비밀번호를 잊어버리지 말 것
    
    # 설치 후 확인할 것
    
    1. cmd에서 sqlplus 실행되나 확인 (설치 완료)
    2. 관리자 계정으로 로그인 해보기 (sys as sysdba, 비밀번호 필요없음)
    3. sql developer를 다운받아서 관리자 계정으로 로그인해보기
       (sys, 역할을 sysdba로 바꾸고 로그인, 설치시 사용했던 비밀번호가 필요)
       
    ※ SQL Developer - DB를 GUI환경에서 다루게 해주는 프로그램
    
    # 연습용 계정 설정하기
    
    1. 관리자 계정으로 로그인
    2. ALTER USER hr ACCOUNT UNLOCK; (잠금 해제)
    3. ALTER USER hr IDENTIFIED BY 1234; (비밀번호 변경)
*/

-- CTRL + ENTER : 명령어 하나 실행하기
-- F5 : 모든 명령어 실행하기
SELECT * FROM all_users; -- 계정 확인하기 명령어

-- HR : 연습용 계정
-- SYSTEM, SYS : 관리자 계정








-- 22_계정 관리하기.sql

-- # 현재 접속한 계정 보기 (계정 관리는 관리자 계정에서만 할 수 있다)
SHOW user;

-- # 새 계정 생성하기
CREATE USER testuser IDENTIFIED BY "1313";

-- # 계정 목록 보기
SELECT * FROM all_users;

-- # 계정에 권한 주기 (GRANT 권한 TO 유저)
GRANT CREATE SESSION TO testuser; -- 해당 계정에 접속할 수 있는 권한
GRANT CREATE TABLE TO testuser; -- 테이블 생성 권한
GRANT RESOURCE TO testuser; -- DB 저장 공간 사용 권한

-- # 계정의 권한 뺏기 (REVOKE 권한 FROM 유저)
REVOKE RESOURCE FROM testuser;

-- # 비밀번호 바꾸기
ALTER USER testuser IDENTIFIED BY "1234";

-- # 계정 삭제하기
DROP USER testuser;

SHOW user;
CONNECT testuser/"1313"; -- 콘솔에서 다른 계정 접속하기
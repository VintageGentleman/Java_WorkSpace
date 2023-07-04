package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J01_JdbcConnection {

	/*
	  	# JDBC (Java Database Connectivity)
	  	
	  	- 자바에서 데이터베이스에 연결하여 쿼리문을 전달하고 결과를 받아오는 
	  	  기능들이 정의되어있는 인터페이스
	  	- 다양한 종류의 DB와 연결할 수 있다
	  	- 어떤 종류의 DB와 연결하더라도 Java쪽 소스코드는 항상 동일하게끔
	  	  설계되어있다
	  	  (Java에는 인터페이스만 존재하고 구현을 각 DB회사에게 미룸) 
	 	
	 	# OJDBC (Oracle JDBC)
	 	
	 	- 오라클 DB가 jdbc api와 소통하기 위해 만들어놓은 라이브러리
	 	- 오라클 DB 설치 폴더에 포함되어 있다
	 	- SQLDeveloper에도 포함되어 있다
	*/
	
	public static void main(String[] args) {
		
		// 1. Class.forName()으로 각 회사의 jdbc 드라이버를 로드한다		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로딩 성공 ... ");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 못찾음.");
		}
		
		// 2. DriverManager 클래스를 통해 DB에 연결한다
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "1234");
			// 워크시트 시작
			System.out.println("연결 성공!" + conn);
					
			// 3. 생성된 연결 인스턴스를 통해 쿼리문을 전달한다
			// 	  (쿼리문에 ;은 쓰면 에러가 발생하므로 주의)
			String sql = "SELECT * FROM employees INNER JOIN departments"
					+ " USING (department_id) ORDER BY employee_id";
			
			// [3-1] 쿼리문 준비시키기
			// [3-2] 준빈된 쿼리문을 DB로 전달해 실행시키기 (결과가 리턴됨)
			try(
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
				// 4. 받아온 결과를 사용한다 (SELECT의 경우 ResultSet에 담겨온다)
				while(rs.next()) {
					System.out.printf("%d / %s %s / %d / %s\n",
							rs.getInt("employee_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getInt("salary"),
							rs.getString("department_name"));
				}
			}
			// 워크시트 끝
		} catch (SQLException e) {
			System.out.println("SQL 진행 도중 뭔가 문제 발생...");
		}
		
	}
}

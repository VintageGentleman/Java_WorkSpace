package database.quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class J03_Practice {

	/*	
	  	(1) SqlDeveloper로 DB에 새 계정을 추가한다
	  	
	  	(2) 해당 계정에 새 테이블을 추가한다
	  	 	(주제 자유, 컬럼 4개 이상, 컬럼 타입 Date가 반드시 포함되어야 함)
	  	
	  	(3) 해당 테이블에서 사용할 시퀀스를 생성한다
	  	
	  	(4) 프로그램을 실행 해 해당 테이블에 INSERT를 진행한다
	  	
	  	(5) SqlDeveloper에서 INSERT가 잘 되었는지 확인한다
	*/
	
	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String query = "INSERT INTO coffee"
				+ " VALUES(coffee_id_seq.nextval, ?, ?, ?)";
		
		LocalDate now = LocalDate.now();
		
		Date temp = Date.valueOf(now);
		
		try(
			Connection conn = DriverManager.getConnection(url, "coffeeJOA", "1234"); 	
			PreparedStatement pstmt = conn.prepareStatement(query);	
		) {
			pstmt.setString(1, "chocolatte");
			pstmt.setInt(2, 4500);
			pstmt.setDate(3, temp);
			
			int row = pstmt.executeUpdate();
			System.out.println(row + "행이 추가되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

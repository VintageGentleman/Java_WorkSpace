package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J02_PrepareStatement {
	
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName(driver);
			
			// String.format() 또는 + 를 통해 쿼리문을 직접 생성하는 것은 위험하다
			// (보안상 SQL Injection 위험이 있음)
			
			// ※ SQL Injection 공격
			// SELECT * FROM employees WHERE password = ? AND ...
			// ? 자리에 "1 OR 1=1 --"가 들어오게되면 무조건 실행되는 쿼리가 된다
			
			// 쿼리문에 변수를 넣고 싶은 경우 값 자리에 ?를 넣은 후 구문을 준비시킨다
			String query = "SELECT * FROM employees WHERE"
					+ " employee_id BETWEEN ? AND ?";
			
			try(
				Connection conn = DriverManager.getConnection(url, "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				// 준비된 구문을 실행하기 전 물음표를 먼저 채워야 한다
				// (첫 번째 물음표가 0번이 아닌 1번인 것을 주의해야 한다) 
				pstmt.setInt(1, 150);
				pstmt.setInt(2, 180);
				
				try (
					ResultSet rs = pstmt.executeQuery(); 
				) {
					while(rs.next()){
						System.out.printf("%d / %s %s\n",
								rs.getInt("employee_id"),
								rs.getString("first_name"),
								rs.getString("last_name"));
					}
				}
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스가 존재하지 않습니다");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL을 실행하는 도중 문제가 발생했습니다.");
		}
		
	}
	
}

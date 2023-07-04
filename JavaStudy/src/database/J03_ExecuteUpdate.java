package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class J03_ExecuteUpdate {

	/*
	  	1. executeQuery() : 리턴값 ResultSet, SELECT문에만 사용한다
	  	2. executeUpdate() : 리턴값 int, INSERT, UPDATE, DELETE문에 사용한다
	*/
	
	public static void main(String[] args) {
		String query = "INSERT INTO coffee"
				+ " VALUES(coffee_id_seq.nextval, ?, ?)";
		
		try(
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setString(1, "Javachip ...");
			pstmt.setInt(2, 5500);
			
			// INSERT, UPDATE, DELETE는 SELECT와 다르게
			// executeUpdate() 메서드를 사용해야 한다
			// 리턴값으로는 몇 행이 (추가/수정/삭제)되었는지 리턴된다
			int row = pstmt.executeUpdate();
			System.out.println(row + "행이 추가되었습니다");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}

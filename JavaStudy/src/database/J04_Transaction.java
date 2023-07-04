package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class J04_Transaction {

	public static void main(String[] args) {
		
		try(
			Connection conn = OjdbcConnection.getConnection();
		) {
			conn.setAutoCommit(false); // 자동 커밋 해제 (기본값 true)
			
			// coffee에 INSERT 
			String query = "INSERT INTO coffee"
					+ " VALUES(coffee_id_seq.nextval,?,?)";
			
			try(
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, "Caffe Mocha");
				pstmt.setInt(2, 4500);
				
				for (int i = 0; i < 5; ++i) {
					pstmt.executeUpdate();
					System.out.println("Insert 했습니다.");
				}
			}
			
			// 자동 커밋을 해제했으므로 커밋 또는 롤백을 직접 실행해야 한다
			conn.commit();
			System.out.println("커밋했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

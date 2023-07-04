package gui.quiz.register_T.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.OjdbcConnectionPool;
import database.OjdbcSession;

public class MemberDao {
	
	static OjdbcConnectionPool pool = new OjdbcConnectionPool("testuser", "1234"); 
	
	public boolean idExists(String id) {
		try(
			OjdbcSession session = pool.getSession();
		) {
			String query = "SELECT COUNT(*) FROM member WHERE mem_id = ?";
			
			Connection conn = session.getConnection();
			
			try(
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, id);
				
				try(
					ResultSet rs = pstmt.executeQuery();	
				) {
					rs.next();
					return rs.getInt(1) > 0; 
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

package gui.quiz.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Pattern;

import database.OjdbcConnectionPool;
import database.OjdbcSession;
import database.StaticResources;

public class RegistDAO {

	OjdbcConnectionPool cp = StaticResources.cp;
	
	public int checkID(String id) {
		
		if(id.equals("")) {
			return 2;
		}
		
		try(
			OjdbcSession session = cp.getSession();
		) {
		
			Connection conn = session.getConnection();
			
			conn.setAutoCommit(false);
			
			String query = "UPDATE members SET members_id = ?"
					+ " WHERE members_key = 0";
			
			try(
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, id);
				
				int result = pstmt.executeUpdate();
				
				conn.rollback();
				conn.setAutoCommit(true);
				
				return result;
			}
			
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("중복값");
			return 0;
		} catch(Exception e) {
			e.printStackTrace();
			return 2;
		}
		
	}
	
	public int regist(MemberDTO newMember) {
		
		try(
			OjdbcSession session = cp.getSession();
		) {
			Connection conn = session.getConnection();
			
			conn.setAutoCommit(true);
			
			String query = "INSERT INTO members"
					+ " VALUES(members_key_seq.nextval,"
					+ "?,?,?,?,?)";
			
			try(
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, newMember.getMembers_id());
				pstmt.setString(2, newMember.getMembers_pw());
				pstmt.setString(3, newMember.getMembers_name());
				pstmt.setString(4, newMember.getMembers_RRM());
				pstmt.setString(5, newMember.getMembers_email());
				
				int result = pstmt.executeUpdate();
				
				return result;
			}
			
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("값에 결점이 있음");
			return 0;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/** [0]=name [1]=RRM [2]=email.
	 *  If value is false, it means relevant data is error */
	public boolean[] checkData(MemberDTO target) {
		
		boolean[] result = {true, true, true};
		
		if(!Pattern.matches("[가-힣]{1,6}", target.getMembers_name())) {
			System.out.println("이름은 6글자 이상 등록안됨");
			result[0] = false;
		}
		
		if(!Pattern.matches("\\d{2}(1[012]|0[1-9])(3[01]|2[0-9]|0[1-9])[1-4]", target.getMembers_RRM())) {
			System.out.println("RRM은 주민번호의 일반적인 형식과 같아야함");
			result[1] = false;
		}
		
		if(!Pattern.matches("\\w+@\\w+[.].*", target.getMembers_email())) {
			System.out.println("email은 일반적인 이메일 형식과 같아야함");
			result[2] = false;
		}
		
		return result;
	}
	
}

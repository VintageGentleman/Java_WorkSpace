package database.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

// Database Access Object (DAO)
// : 데이터베이스에 접속해서 처리해야하는 모든 코드들을 모아놓는 곳 
public class PotterWheelDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Connection을 새로 연결하고 끊는 작업은 많은 비용이 소모된다.
	// (DB의 많은 프로세스를 사용한다)
	private static Connection conn = getConnection();
	private static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"testuser",
					"1234"
					);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 모든 상품을 SELECT해서 리스트에 담아서 리턴해주는 메서드
	// SELECT의 결과는 정보를 담은 여러 행이므로 List<Data> 타입이 좋다
	public List<Prize> getAllPrizes() {
		String query = "SELECT * FROM prize";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			// 쿼리의 실행결과가 담겨있는 ResultSet의 데이터를
			// 사용하기 편리한 리스트에 옮겨담아서 리턴한다 
			List<Prize> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Prize(
					rs.getInt("prize_id"),
					rs.getString("prize_name"),
					rs.getDouble("prize_rate"),
					rs.getInt("prize_curr_qty"),
					rs.getInt("prize_max_qty"))
				);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// DB에 원하는 상품을 추가하는 메서드 (만약 확률이 1을 넘으면 취소)
	// INSERT의 결과는 행의 수이므로 리턴 타입은 int여야 한다
	public int addPrize(Prize prize) {
		String query1 = "SELECT SUM(prize_rate) FROM prize";
		String query2 = "INSERT INTO prize VALUES(?,?,?,?,?)";
		
		try(
			PreparedStatement pstmt1 = conn.prepareStatement(query1);
			ResultSet rs = pstmt1.executeQuery();
		) {
			// 현재 전체 확률을 조회 후 확인이 필요
			rs.next();
			double rate = rs.getDouble(1);
			
			System.out.println("현재 상품들의 확률 : " + rate);
			
			if(prize.getPrize_rate() + rate > 1.0) {
				System.out.println("추가 불가능입니다.");
				return 0;
			}
			
			int state;
			
			try(
				PreparedStatement pstmt2 = conn.prepareStatement(query2);	
			) {
				pstmt2.setInt(1, prize.getPrize_id());
				pstmt2.setString(2, prize.getPrize_name());
				pstmt2.setDouble(3, prize.getPrize_rate());
				pstmt2.setInt(4, prize.getPrize_curr_qty());
				pstmt2.setInt(5, prize.getPrize_max_qty());
				
				state = pstmt2.executeUpdate();
			}
			
			return state;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	// 당첨된 상품의 남은 수량을 하나 감소시킨다.
	// 이미 남은 수량이 0인 경우 리턴 0
	public int minusQty(int pk) {
		String query = "UPDATE prize SET"
				+ " prize_curr_qty = prize_curr_qty - 1"
				+ " WHERE prize_id = ?";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setInt(1, pk);
			return pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("해당 상품 수량이 모두 소진되었습니다 ...");
			return 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	// 남은 수량을 조회하는 메서드
	public int getRemainCount() {
		String query = "SELECT SUM(prize_curr_qty) AS remain FROM prize";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			rs.next();
			return rs.getInt("remain"); // 또는 숫자 1
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void resetQty() {
		String query = "UPDATE prize SET prize_curr_qty = prize_max_qty";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

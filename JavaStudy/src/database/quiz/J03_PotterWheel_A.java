package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.OjdbcConnection;

public class J03_PotterWheel_A {
	
	/*
	  	# 경품 추첨 이벤트를 구현해보세요
	  	
	  	(1) DB에 경품들의 이름, 당첨 확률, 남은 수량 등을 저장할 수 있는
	  		테이블이 존재해야 한다
	  		
	   	(2) 콘솔에서 뽑기를 진행하면 실제로 DB에서 수량이 줄어들어야 한다
	   	
	   	(3) 상품이 모두 소진되면 프로그램이 종료되어야 한다
	   	
	   	(4) 리셋 기능을 실행하면 DB의 상품이 다시 충전 된다
	*/

	static {
		OjdbcConnection.userChange("coffeeJOA", "1234");
	}
	
	List<J03_PotterWheel_Prize> prizes;
	J03_PotterWheel_Prize[] box;
	
	public J03_PotterWheel_A() {
		
		prizes = new ArrayList<>();
		
		String query = "SELECT * FROM prize";
		
		try(
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				prizes.add(
					new J03_PotterWheel_Prize(
							rs.getInt("prize_id"),
							rs.getString("prize_name"),
							rs.getDouble("probability"),
							rs.getInt("stock")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("클래스 생성 중 오류 발생");
		}
		
		updateBox();
	}

	private void updateBox() {
		// 확률을 위한 임시 저장소 만들기
		int boxSize = 100;
		box = new J03_PotterWheel_Prize[boxSize];
		
		int index = 0;
		for(int i = 0; i < prizes.size(); ++i) {
			
			int num = (int)(prizes.get(i).getRate() * boxSize);
					
			for(int j = 0; j < num; ++j) {
				box[index++] = prizes.get(i);
			}
		}
	}
	
	public J03_PotterWheel_Prize wheel() {
		J03_PotterWheel_Prize prize =
				box[(int)(Math.random() * box.length)];
		
		String query = "SELECT stock FROM prize"
				+ " WHERE prize_id = ?";
		
		String minus = "UPDATE prize SET stock = stock - 1"
				+ " WHERE prize_id = ? AND stock > 0";

		if(prize != null) {
			try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				PreparedStatement pstmt2 = conn.prepareStatement(minus);
			) {
				pstmt.setInt(1, prize.getPrize_id());

				int stock = 0;
				
				try(
					ResultSet rs = pstmt.executeQuery();	
				) {
					while(rs.next()) {
						stock = rs.getInt("stock");
					}
				}
				
				if(stock == 0) {
					return null;
				} else {
					pstmt2.setInt(1, prize.getPrize_id());
					pstmt2.executeUpdate();
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("상품 추첨 중 오류 발생");
			}
		} 
		
		return prize;
	}
	
	// 상품 재고 체크
	public boolean stockCheck() {
		String query = "SELECT stock FROM prize";
		
		try(
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				if(rs.getInt("stock") == 0) {
					return false;
				};
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("재고 체크 중 오류 발생");
		}
		
		return true;
	}
	
	// 재고 리셋
	public void stockReset() {
		String query = "UPDATE prize SET stock = ?"
				+ " WHERE prize_id = ?";
		
		int row = 0;
		try(
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			for(int i = 0; i < prizes.size(); ++i) {
				pstmt.setInt(1, prizes.get(i).getQty());
				pstmt.setInt(2, prizes.get(i).getPrize_id());
				
				row += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("재고 리셋 중 오류 발생");
		}
		
		System.out.println(row + "개의 상품재고를 채웠습니다.");
	}
	
	public static void main(String[] args) {
		J03_PotterWheel_A potterWheel = new J03_PotterWheel_A();
		J03_PotterWheel_Prize prize;
		
		int count = 0;
		while(true) {
			if(!potterWheel.stockCheck()) {
				break;
			}
			
			prize = potterWheel.wheel();

			if(prize == null) {
				System.out.printf("%d번째: 꽝!\n", count++);
			} else {
				System.out.printf("%d번째: %s 당첨\n", count++, prize.getName());
			}
			
			// 속도조절
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("재고가 모두 떨어진 상품이 있습니다.");
		
		potterWheel.stockReset();
	}
	
}

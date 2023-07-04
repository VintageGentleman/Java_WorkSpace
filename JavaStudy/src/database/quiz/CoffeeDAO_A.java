package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import database.OjdbcConnection;

public class CoffeeDAO_A {

	// DB 연결 (hr)
	private static Connection conn = getConnection(); 
	private static Connection getConnection() {
		try {
			return conn = OjdbcConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 모든 커피 조회 후 List에 담아서 리턴
	public List<Coffee_A> getAllCoffee(){
		String query = "SELECT * FROM coffee";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();	
		) {
			List<Coffee_A> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Coffee_A(
						rs.getInt("coffee_id"),
						rs.getString("coffee_name"),
						rs.getInt("coffee_price"))
				);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 가격이 3000원 이하인 커피를 조회하여 List에 담아서 리턴
	public List<Coffee_A> getCoffee_pricebelow3000(){
		String query = "SELECT * FROM coffee WHERE coffee_price <= 3000";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();	
		) {
			List<Coffee_A> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Coffee_A(
						rs.getInt("coffee_id"),
						rs.getString("coffee_name"),
						rs.getInt("coffee_price"))
				);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	// 새로운 커피를 하나 추가하는 메서드
	public int addCoffee(Coffee_A coffee) {
		String query = "INSERT INTO coffee"
				+ " VALUES(coffee_id_seq.nextval,?,?)";
		
		int state;
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setString(1, coffee.getCoffee_name());
			pstmt.setInt(2, coffee.getCoffee_price());
			
			state = pstmt.executeUpdate();
			
			return state;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(coffee.getCoffee_name() + "는 중복된 이름입니다.");
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	// 여러개의 커피를 한번에 추가하는 메서드
	public int addAllCoffee(List<Coffee_A> coffees) {
		try {
			conn.setAutoCommit(false);
		
			int result = 0;
			for(int i = 0; i < coffees.size(); ++i) {
				
				result += addCoffee(coffees.get(i));
				
				if(result == -1) {
					conn.rollback();
					System.out.println("중복된 이름을 가진 커피가 포함되어있습니다.");
					conn.setAutoCommit(true);
					return 0;
				}
				
				if(result == 0) {
					conn.rollback();
					System.out.println("커피 정보 입력 중 오류가 발생했습니다.");
					conn.setAutoCommit(true);
					return 0;
				}
			}
			
			conn.commit();
			System.out.println(result + "개의 커피가 추가되었습니다.");
			conn.setAutoCommit(true);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int setInfo(int pk, String newName, int newPrice) {
		String query = "UPDATE coffee SET coffee_name = ?, coffee_price = ?"
				+ " WHERE coffee_id = ?";
		
		int result;
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setString(1, newName);
			pstmt.setInt(2, newPrice);
			pstmt.setInt(3, pk);
			
			result = pstmt.executeUpdate();
			System.out.println(pk + "번 음료 정보가 변경되었습니다.");
			
			return result;
		} catch(SQLIntegrityConstraintViolationException e) {
			return -1;
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}	
		
	}
	
	private Coffee_A searchInfo(int pk) {
		String query = "SELECT * FROM coffee WHERE coffee_id = ?";

		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setInt(1, pk);
			
			try(
				ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				return new Coffee_A(rs.getString("coffee_name"), rs.getInt("coffee_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 이름 바꾸기
	public int setInfo(int pk, String newName) {
		Coffee_A target = searchInfo(pk);
		
		return setInfo(pk, newName, target.getCoffee_price());
	}
	
	// 가격 바꾸기
	public int setInfo(int pk, int newPrice) {
		Coffee_A target = searchInfo(pk);
		
		return setInfo(pk, target.getCoffee_name(), newPrice);
	}
	
}

package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OjdbcConnectionPool {

	/*
	  	# Connection Pool
	  	
	  	- 미리 몇 개의 연결을 생성해놓는다
	  	- 클래스에서 Connection을 요청하면 잠시 빌려준다
	  	- 사용을 끝마치면 반환받고 프로그램이 종료될때까지 연결을 계속 유지한다
	*/
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static int initPoolSize = 5;
	
	// Map<연결인스턴스, 사용중>
	// private Map<Connection, Boolean> connectionMap = new HashMap<>();
	
	// List
	private List<OjdbcSession> sessions = new ArrayList<>();
	
	public OjdbcConnectionPool(String id, String password) {
		// 초기 크기만큼 연결을 미리 생성해서 List에 넣어놓는다
		try {
			for(int i = 0; i < initPoolSize; ++i) {
				sessions.add(new OjdbcSession(
						DriverManager.getConnection(url, id, password)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public OjdbcSession getSession() {
		for(OjdbcSession session : sessions) {
			if(!session.using()) {
				session.setUse();
				return session;
			}
		}
		
		System.out.println("모든 OjdbcSession이 사용 중입니다.");
		return null;
	}

	public void status() {
		int size = sessions.size();
		for(int i = 0; i < size; ++i) {
			System.out.printf("Session %d: %s\n",
					i, sessions.get(i).using() ? "이미사용중" : "사용가능");
		}
	}
	
}

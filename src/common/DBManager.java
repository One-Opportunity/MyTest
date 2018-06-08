package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {

	private static Connection conn;
	
	// Connection 관련 정보 상수
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String USER = "test";
	private static String PASS = "1234";
	
	private DBManager() {
		
	}
	
	public static Connection getConnection() {
		conn = null;
		
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	private static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

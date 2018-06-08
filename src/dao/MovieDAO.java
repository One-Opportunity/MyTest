package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DBManager;
import dto.MovieDTO;

public class MovieDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertMovie(MovieDTO movieDTO) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "";
			sql += "INSERT INTO DAUMMOVIE(RNO, MTITLE, MWRITER, MSCORE, MREVIEWS, REGDATE) VALUES (DAUMMOVIE_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieDTO.getMtitle());
			pstmt.setString(2, movieDTO.getMwriter());
			pstmt.setFloat(3, movieDTO.getMscore());
			pstmt.setString(4, movieDTO.getMreviews());
			
			
			// pstmt = �ϼ��� SQL
			
			// SELECT => executeQuery();
			// INSERT, DELETE, UPDATE => executeUpdate();
			// execute*** => SQL�� ����
			int result = pstmt.executeUpdate();
			
			if(result >  0) {
				System.out.println("���� ��� ����");
			} else {
				System.out.println("���� ��� ����");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

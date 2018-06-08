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
			
			
			// pstmt = 완성된 SQL
			
			// SELECT => executeQuery();
			// INSERT, DELETE, UPDATE => executeUpdate();
			// execute*** => SQL문 실행
			int result = pstmt.executeUpdate();
			
			if(result >  0) {
				System.out.println("리뷰 등록 성공");
			} else {
				System.out.println("리뷰 등록 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

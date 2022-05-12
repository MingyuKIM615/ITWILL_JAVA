package edu.java.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static edu.java.jdbc.ojdbc.OracleJdbc.*;

import oracle.jdbc.OracleDriver;

public class JdbcMain03 {

	public static void main(String[] args) {
		
		Connection conn = null; // DB와 연결을 맺기 위한 객체
		PreparedStatement pstmt = null; // SQL 문장을 실행시키기 위한 객체
		Scanner sc = new Scanner(System.in);
		
		try {
			// Oracle JDBC 드라이버를 등록(로딩)
			DriverManager.registerDriver(new OracleDriver());
			
			// Oracle DB 서버 접속(연결)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// SQL문장 템플릿(template)
			// UPDATE blogs SET title = ?, content = ?, update_time = sysdate WHERE blogs_no = ?
			String sql = "update " + TABLE_BLOGS
					+ " set " + COL_TITLE + " = ?, "
					+ COL_CONTENT + " = ?, "
					+ COL_UPDATE_TIME + " =sysdate"
					+ " where " + COL_BLOG_NO + " = ? ";
			System.out.println(sql);
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// pstst의 ? 세 개를 채움
			System.out.println("변경할 제목 입력>>>");
			String title  = sc.nextLine();
			System.out.println("변경할 본문 입력 >>>");
			String content = sc.nextLine();
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, 1);
			// pstmt의 모든 내용이 완성.
			
			// SQL을 실행, 결과 확인
			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 업데이트 됐습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

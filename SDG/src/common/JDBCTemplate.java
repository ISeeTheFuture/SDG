package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCTemplate {

	public static Connection getConnection() {
		Connection conn = null;
		
		
		try {
			
			Properties prop = new Properties();
			// 현재 클래스 객체의 루트 디렉토리(build path - /WebContent/WEB-INF/classes)부터 위치한 파일의 경로를 찾는다.
			String fileName = JDBCTemplate.class.getResource("/driver.properties")
												.getPath();
			System.out.println("fileName@JDBCTemplate="+fileName);
			prop.load(new FileReader(fileName)); // prop.load(입력객체(경로))
			
			//Property내역 출력
//			prop.list(System.out); // 잘 받아왔나 properties 내용 확인
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			Class.forName(driver); // 클래스 객체 등록 - 생략가능
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e) { // 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) // isClosed : 닫혔으면 true 를 리턴. 
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) 
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {		
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {		
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

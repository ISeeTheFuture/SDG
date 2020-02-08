package space.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
<<<<<<< HEAD
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


import space.model.vo.SpacesTimeTable;

public class SpaceDAO {
	private Properties prop = new Properties();
	
	public SpaceDAO() {
		
		String fileName = SpaceDAO.class.getResource("/sql/spc/space-query.properties")
										 .getPath();
		System.out.println("fileName@SpaceDAO="+fileName);
				
		try {
			
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public int insertSpaceTimeTable(Connection conn, SpacesTimeTable spacestimetable) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertSpaceTimeTable");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, spacestimetable.getSpcDetNo());
			pstmt.setString(2, spacestimetable.getSpcDay());
			pstmt.setDate(3, (Date) spacestimetable.getSpcHourStart());
			pstmt.setDate(4, (Date) spacestimetable.getSpcHourEnd());
			pstmt.setString(5,String.valueOf(spacestimetable.getSpcAvail()));

			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

=======
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import space.model.vo.SpacesDefault;

public class SpaceDAO {
	private Properties prop = new Properties();

	public SpaceDAO() {
		String fileName = SpaceDAO.class.getResource("/sql/member/member-query.properties").getPath();
		System.out.println("fileName@MemberDAO=" + fileName);

		try {

			prop.load(new FileReader(fileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertComp(Connection conn, SpacesDefault spDefault) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertComp");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spDefault.getMemberId());
			pstmt.setString(2, spDefault.getSpcName());
			pstmt.setString(3,  spDefault.getSpcAddr());
			pstmt.setString(4,  spDefault.getSpcContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
>>>>>>> branch 'master' of https://github.com/ISeeTheFuture/SDG.git

}

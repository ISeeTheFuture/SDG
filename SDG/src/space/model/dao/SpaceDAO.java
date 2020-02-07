package space.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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

}

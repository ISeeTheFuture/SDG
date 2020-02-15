package space.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import space.model.vo.SpacesDefault;

public class SpcViewDAO {

	private Properties prop = new Properties();

	public SpcViewDAO() {
		String fileName = SpcViewDAO.class.getResource("/sql/spc/spcView-query.properties").getPath();

		try {

			prop.load(new FileReader(fileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SpacesDefault selectSpc(Connection conn, int spcNo) {
		SpacesDefault spc = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpc");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				spc = new SpacesDefault();
				spc.setSpcNo(rset.getInt("spc_no"));
				spc.setMemberId(rset.getString("mem_id"));
				spc.setSpcName(rset.getString("spc_name"));
				spc.setSpcAddr(rset.getString("spc_addr"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spc;
	}
	
	
}

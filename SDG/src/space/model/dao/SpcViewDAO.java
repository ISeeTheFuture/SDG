package space.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import space.model.vo.Spaces;
import space.model.vo.SpacesCttImg;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;

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
			
			if(rset.next()) {
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

	public Spaces selectSpcDtl(Connection conn, int spcNo) {
		Spaces spcDtl = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpcDtl");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				spcDtl = new Spaces();
				spcDtl.setSpcDetNo(rset.getInt("spc_detail_no"));
				spcDtl.setSpcNo(rset.getInt("spc_no"));
				spcDtl.setSpcTypeNo(rset.getInt("spc_type_no"));
				spcDtl.setSpcLocNo(rset.getInt("spc_location_no"));
				spcDtl.setSpcDetAvail((char) rset.getInt("spc_detail_avail"));
				spcDtl.setSpcDetContent(rset.getString("spc_detail_content"));
				spcDtl.setSpcDetSharing((char) rset.getInt("spc_detail_sharing"));
				spcDtl.setSpcDetHoliday((char) rset.getInt("spc_detail_holiday"));
				spcDtl.setSpcDetSize(rset.getInt("spc_detail_size"));
				spcDtl.setSpcDetCapacity(rset.getInt("spc_detail_storable"));
				spcDtl.setSpcCapMin(rset.getInt("spc_man_min"));
				spcDtl.setSpcCapMax(rset.getInt("spc_man_max"));
				spcDtl.setSpcTimeMin(rset.getInt("spc_time_min"));
				spcDtl.setSpcTimeMax(rset.getInt("spc_time_max"));
				spcDtl.setSpcDateStart(rset.getDate("spc_date_start"));
				spcDtl.setSpcDateEnd(rset.getDate("spc_date_end"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spcDtl;
	}

	public SpacesImg selectSpcImg(Connection conn, int spcDtlNo) {
		SpacesImg spcImg = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpcImg");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcDtlNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				spcImg = new SpacesImg();
				spcImg.setSpcDetNo(rset.getInt("spc_detail_no"));
				spcImg.setSpcImgTitle(rset.getString("spc_img_title"));
				spcImg.setSpcImgText(rset.getString("spc_img_text"));
				spcImg.setSpcImgRoute(rset.getString("spc_img_route"));
				spcImg.setSpcNo(rset.getInt("spc_no"));

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spcImg;
	}

	public String selectSpcLoc(Connection conn, int spcLocNo) {
		String spcLoc = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpcLoc");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcLocNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				spcLoc = rset.getString("spc_location_name");

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spcLoc;
	}

	public SpacesPrice selectSpcPrice(Connection conn, int spcDtlNo) {
		SpacesPrice spcPrice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpcPrice");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcDtlNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				spcPrice = new SpacesPrice();
				spcPrice.setSpcPriceNo(rset.getInt("spc_price_no"));
				spcPrice.setSpcDetNo(rset.getInt("spc_detail_no"));
				spcPrice.setSpcDetName(rset.getString("spc_detail_name"));
				spcPrice.setSpcPriceDay(rset.getString("spc_price_day"));
				spcPrice.setSpcPriceStart(rset.getInt("spc_price_start"));
				spcPrice.setSpcPriceEnd(rset.getInt("spc_price_end"));
				spcPrice.setSpcPricePeak((char)rset.getInt("spc_price_peak"));
				spcPrice.setSpcPricePer((char)rset.getInt("spc_price_perman"));
				spcPrice.setSpcPriceDayBool((char)rset.getInt("spc_price_day_bool"));
				spcPrice.setSpcPricePrice(rset.getInt("spc_price_price"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spcPrice;
	}

	public String selectSpcType(Connection conn, int spcTypeNo) {
		String spcType = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpcType");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcTypeNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				spcType = rset.getString("spc_type_name");

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spcType;
	}

	public SpacesCttImg selectSpcCttImg(Connection conn, int spcDtlNo) {
		SpacesCttImg spcCttImg = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSpcCttImg");
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setInt(1, spcDtlNo);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				spcCttImg = new SpacesCttImg();
				spcCttImg.setSpcDetNo(rset.getInt("spc_detail_no"));
				spcCttImg.setSpcNo(rset.getInt("spc_no"));
				spcCttImg.setSpcCttImgTitle(rset.getString("spc_img_title"));
				spcCttImg.setSpcImgText(rset.getString("spc_img_text"));
				spcCttImg.setSpcCttOldTitle(rset.getString("spc_img_old"));

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return spcCttImg;
	}
	
	
}

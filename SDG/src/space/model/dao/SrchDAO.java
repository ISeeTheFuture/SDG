package space.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import space.model.vo.SpacesLocation;
import space.model.vo.SpacesSrch;
import space.model.vo.SpacesType;

public class SrchDAO {
	private Properties prop = new Properties();
	
	public SrchDAO() {
		String fileName = SpaceDAO.class.getResource("/sql/spc/srch-query.properties").getPath();
//		System.out.println("fileName@MemberDAO=" + fileName);

		try {

			prop.load(new FileReader(fileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SpacesSrch> selectSpcSrch(Connection conn, String srchWord, int spcLoc, int spcType) {
		List<SpacesSrch> list = new ArrayList<>();
		SpacesSrch spacesSrch = null;
		SpacesType spacesType = null;
		SpacesLocation spacesLoc = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="";
		
		
		List<SpacesType> typeList = new ArrayList<>();
		query = prop.getProperty("selectType");
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				spacesType = new SpacesType();
				spacesType.setSpc_type_no(rset.getInt("spc_type_no"));
				spacesType.setSpc_type_name(rset.getString("spc_type_name"));								
				
				typeList.add(spacesType);
			}
			rset = null;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		List<SpacesLocation> locList = new ArrayList<>();
		query = prop.getProperty("selectLoc");
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				spacesLoc = new SpacesLocation();
				spacesLoc.setSpcLocationNo(rset.getInt("spc_location_no"));
				spacesLoc.setSpcLocationName(rset.getString("spc_location_name"));
				
				locList.add(spacesLoc);
			}
			rset = null;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(spcType==0&&spcLoc!=0) {
			query = prop.getProperty("selectSrchListny");
		}else if(spcType!=0&&spcLoc==0) {
			query = prop.getProperty("selectSrchListyn");
		}else if(spcType==0&&spcLoc==0) {
			query = prop.getProperty("selectSrchListnn");
		}else {
			query = prop.getProperty("selectSrchList");
		}
		
//		System.out.println("query="+query);
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+srchWord+"%");
			if(spcType==0&&spcLoc!=0) {
				pstmt.setInt(2, spcLoc);
			}else if(spcType!=0&&spcLoc==0) {
				pstmt.setInt(2, spcType);
			}else if(spcType!=0&&spcLoc!=0) {
				pstmt.setInt(2, spcType);
				pstmt.setInt(3, spcLoc);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				spacesSrch = new SpacesSrch();
				spacesSrch.setSpcNo(rset.getInt("spc_no"));
				spacesSrch.setSpcDetNo(rset.getInt("spc_detail_no"));				
				spacesSrch.setSpcName(rset.getString("spc_name"));				
				spacesSrch.setSpcTypeNo(rset.getInt("spc_type_no"));
				for(int i = 0; i < typeList.size(); i++) {
					if(typeList.get(i).getSpc_type_no()==spacesSrch.getSpcTypeNo()) {
						spacesSrch.setSpcTypeName(typeList.get(i).getSpc_type_name());
					}
				}
				spacesSrch.setSpcLocNo(rset.getInt("spc_location_no"));
				for(int i = 0; i < locList.size(); i++) {
					if(locList.get(i).getSpcLocationNo()==spacesSrch.getSpcLocNo()) {
						spacesSrch.setSpcLocationName(locList.get(i).getSpcLocationName());
					}
				}
				spacesSrch.setSpcPricePrice(rset.getInt("spc_price_price"));
				spacesSrch.setSpcImgTitle(rset.getString("spc_img_title"));				
				
				list.add(spacesSrch);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
//		System.out.println("selectSpcSrch@SrchDAO ="list);
		return list;
	}
	
	
	
}

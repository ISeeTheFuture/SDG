package space.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import space.model.dao.SpcViewDAO;
import space.model.vo.Spaces;
import space.model.vo.SpacesCttImg;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;

public class SpcViewService {

	public SpacesDefault selectSpc(int spcNo) {
		Connection conn = getConnection();
		SpacesDefault spc= new SpcViewDAO().selectSpc(conn, spcNo);
		
		close(conn);
		return spc;
	}

	public Spaces selectSpcDtl(int spcNo) {
		Connection conn = getConnection();
		Spaces spcDtl= new SpcViewDAO().selectSpcDtl(conn, spcNo);
		
		close(conn);
		return spcDtl;
	}


	public SpacesImg selectSpcImg(int spcDtlNo) {
		Connection conn = getConnection();
		SpacesImg spcImg= new SpcViewDAO().selectSpcImg(conn, spcDtlNo);
		
		close(conn);
		return spcImg;
	}

	public String selectSpcLoc(int spcLocNo) {
		Connection conn = getConnection();
		String spcLoc= new SpcViewDAO().selectSpcLoc(conn, spcLocNo);
		
		close(conn);
		return spcLoc;
	}

	public SpacesPrice selectSpcPrice(int spcDtlNo) {
		Connection conn = getConnection();
		SpacesPrice spcPrice = new SpcViewDAO().selectSpcPrice(conn, spcDtlNo);
		
		close(conn);
		return spcPrice;
	}

	public String selectSpcType(int spcTypeNo) {
		Connection conn = getConnection();
		String spcType= new SpcViewDAO().selectSpcType(conn, spcTypeNo);
		
		close(conn);
		return spcType;
	}

	public SpacesCttImg selectSpcCttImg(int spcDtlNo) {
		Connection conn = getConnection();
		SpacesCttImg spcCttImg= new SpcViewDAO().selectSpcCttImg(conn, spcDtlNo);
		
		close(conn);
		return spcCttImg;
	}

}

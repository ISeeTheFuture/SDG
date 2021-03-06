package space.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import space.model.dao.SpaceDAO;
import space.model.vo.Spaces;
import space.model.vo.SpacesCttImg;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;
import space.model.vo.SpacesSrch;
import space.model.vo.SpacesTimeExp;
import space.model.vo.SpacesTimeTable;

public class SpaceService {

//	public int insertComp(SpacesDefault spDefault) {
//		Connection conn = getConnection();
//		int result = new SpaceDAO().insertComp(conn, spDefault);
//		
//		if(result > 0) commit(conn);
//		else rollback(conn);
//		
//		close(conn);
//		
//		return result;
//	}
	
	public int insertComp(SpacesDefault spDefault) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertComp(conn, spDefault);
		int spcNo = new SpaceDAO().selectSpcNo(conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return spcNo;
	}
	
	public int insertSpaceTimeTable(SpacesTimeTable spacestimetable) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertSpaceTimeTable(conn, spacestimetable);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;

	}
	

	public int insertSapceTimeExp(SpacesTimeExp spacetimeexp) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertSapceTimeExp(conn, spacetimeexp);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertPrice(SpacesPrice spaceprice) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertPrice(conn, spaceprice);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public SpacesDefault selectOneComp(String memberId) {
		Connection conn = getConnection();
		SpacesDefault comp= new SpaceDAO().selectOneComp(conn, memberId);
		close(conn);
		return comp;
	}

	public int insertSpace(Spaces space) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertSpace(conn, space);
		int spcDtlNo = new SpaceDAO().selectSpcDtlNo(conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		System.out.println("서비스"+spcDtlNo);
		return spcDtlNo;
	}
	
	
//	public int insertSpace(Spaces space) {
//		Connection conn = getConnection();
//		int result = new SpaceDAO().insertSpace(conn, space);
//		int spcDtlNo = new SpaceDAO().selectSpcDtlNo(conn);
//		
//		if(result > 0) commit(conn);
//		else rollback(conn);
//		
//		close(conn);
//		
//		return spcDtlNo;
//	}

	public Spaces selectOneSpace(int spcNo) {
		Connection conn = getConnection();
		Spaces spcObj= new SpaceDAO().selectOneSpace(conn, spcNo);
		close(conn);
		return spcObj;
	}

	public int updatePrice(SpacesPrice spaceprice) {
		Connection conn = getConnection();
		int result = new SpaceDAO().updatePrice(conn, spaceprice);

		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public SpacesPrice selectOnePrice(int spcDetNo) {
		Connection conn = getConnection();
		SpacesPrice spacesprice = new SpaceDAO().selectOnePrice(conn, spcDetNo);
		close(conn);
		return spacesprice;
	}

	public int insertImg(SpacesImg spaceimg) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertImg(conn, spaceimg);

		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertCttImg(SpacesCttImg spaceCttimg) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertCttImg(conn, spaceCttimg);

		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertImgTitle(String newName) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertImgTitle(conn, newName);

		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public String[] selectImgSum(int imgNum) {
		Connection conn = getConnection();
		String[] spcImgSum = new SpaceDAO().selectImgSum(conn, imgNum);
		close(conn);
		return spcImgSum;
	}
	
}

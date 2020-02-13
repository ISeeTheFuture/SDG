package space.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import space.model.dao.SpaceDAO;
import space.model.vo.Spaces;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;
import space.model.vo.SpacesSrch;
import space.model.vo.SpacesTimeExp;
import space.model.vo.SpacesTimeTable;

public class SpaceService {

	public int insertComp(SpacesDefault spDefault) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertComp(conn, spDefault);

		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
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

		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

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

	public List<SpacesSrch> selectSpcSrch(String srchWord, int spcLoc, int spcType) {
		Connection conn = getConnection();
		List<SpacesSrch> spacesSrch = null;
		
		close(conn);
		return spacesSrch;
	}
}

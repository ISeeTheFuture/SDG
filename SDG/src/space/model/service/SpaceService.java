package space.model.service;


import static common.JDBCTemplate.*;

import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.vo.SpacesTimeTable;

import space.model.vo.Spaces;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesPrice;
import space.model.vo.SpacesTimeExp;

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
}

package space.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.vo.SpacesTimeTable;


import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesTimeExp;

import static common.JDBCTemplate.*;
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
}

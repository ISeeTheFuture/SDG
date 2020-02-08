package space.model.service;

<<<<<<< HEAD
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.vo.SpacesTimeTable;

public class SpaceService {

	public int insertSpaceTimeTable(SpacesTimeTable spacestimetable) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertSpaceTimeTable(conn, spacestimetable);
=======
import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.vo.SpacesDefault;

import static common.JDBCTemplate.*;
public class SpaceService {

	public int insertComp(SpacesDefault spDefault) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertComp(conn, spDefault);
>>>>>>> branch 'master' of https://github.com/ISeeTheFuture/SDG.git
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

}

package space.model.service;

import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.vo.SpacesDefault;

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

}

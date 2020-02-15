package space.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import space.model.dao.SpaceDAO;
import space.model.dao.SpcViewDAO;
import space.model.vo.SpacesDefault;

public class SpcViewService {

	public SpacesDefault selectSpc(int spcNo) {
		Connection conn = getConnection();
		SpacesDefault spc= new SpcViewDAO().selectSpc(conn, spcNo);
		
		close(conn);
		return spc;
	}

}

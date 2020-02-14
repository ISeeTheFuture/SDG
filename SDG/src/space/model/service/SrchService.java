package space.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import space.model.dao.SrchDAO;
import space.model.vo.SpacesSrch;

public class SrchService {

	public List<SpacesSrch> selectSpcSrch(String srchWord, int spcLoc, int spcType) {
		Connection conn = getConnection();
		List<SpacesSrch> list = new SrchDAO().selectSpcSrch(conn, srchWord, spcLoc, spcType);
		
		close(conn);
//		System.out.println(list.toString());
		return list;
	}

}

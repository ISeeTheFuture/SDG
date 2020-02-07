package res.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import res.model.dao.ResDAO;
import res.model.vo.Res;
import res.model.vo.ResGrp;

public class ResService {

	public int insertRes(Res res) {
		Connection conn = getConnection();
		int result = new ResDAO().insertRes(conn, res);
		
		int resGrpNo = new ResDAO().selectLastResGrpNo(conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return resGrpNo;
	}


	public int insertResGrp(List<ResGrp> list) {
		Connection conn = getConnection();
		int result = new ResDAO().insertResGrp(conn, list);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

}

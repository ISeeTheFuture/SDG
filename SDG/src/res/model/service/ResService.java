package res.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import res.model.dao.ResDAO;
import res.model.vo.Res;
import res.model.vo.ResGrp;
import res.model.vo.ResView;

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


	public List<ResView> selectResView(int spcNo) {
		Connection conn = getConnection();
		List<ResView> result = new ResDAO().selectResView(conn, spcNo);
		
		
		return result;
	}

}

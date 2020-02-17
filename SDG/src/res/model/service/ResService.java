package res.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import res.model.dao.ResDAO;
import res.model.vo.Res;
import res.model.vo.ResGrp;
import res.model.vo.ResMeView;
import res.model.vo.ResView;

public class ResService {

	public int insertRes(Res res) {
		Connection conn = getConnection();
		int result = new ResDAO().insertRes(conn, res);
		
		int resGrpNo = new ResDAO().selectLastResGrpNo(conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);

		close(conn);
		commit(conn);
		return resGrpNo;
	}


	public int insertResGrp(List<ResGrp> list) {
		Connection conn = getConnection();
		int result = new ResDAO().insertResGrp(conn, list);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		commit(conn);
		return result;
	}


	public List<ResView> selectResView(int spcNo) {
		Connection conn = getConnection();
		List<ResView> result = new ResDAO().selectResView(conn, spcNo);
		
		close(conn);
		return result;
	}


	public List<ResView> selectResUpdateView(String memId) {
		Connection conn = getConnection();
		List<ResView> result = new ResDAO().selectResUpdateView(conn, memId);
		
		close(conn);
		return result;
	}


	public ResView selectResOneGrp(int resGroupNo) {
		Connection conn = getConnection();
		ResView resGrp = new ResDAO().selectResOneGrp(conn, resGroupNo);
		
		
		return resGrp;
	}


	public int deleteResOneGrp(int resGroupNo) {
		int result = 0;
		Connection conn = getConnection();
		
		result = new ResDAO().deleteResOneGrp(conn, resGroupNo);
		
		commit(conn);
		close(conn);
		return result;
	}


	public int deleteResGrp(int resGroupNo) {
		int result = 0;
		Connection conn = getConnection();
		
		result = new ResDAO().deleteResOne(conn, resGroupNo);
		
		commit(conn);
		close(conn);
		return result;
	}


	public Res selectResOne(int resGroupNo) {
		Connection conn = getConnection();
		Res res = new ResDAO().selectResOne(conn, resGroupNo);
		
		
		return res;
	}


	public List<ResMeView> selectResMeView(String memId) {
		Connection conn = getConnection();
		List<ResMeView> result = new ResDAO().selectResMeView(conn, memId);
		
		close(conn);
		return result;
	}

}

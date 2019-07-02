package DAO;



//import Domain.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.myapp.domain.Cinema;
import DAO.iStudioDAO;
import Domain.Studio;
import Servlet.StudioSlt;
import static java.lang.System.out;
import com.myapp.domain.Cinema;
import util.DBUtil;
import java.sql.ResultSet;

public class SinfoDAO implements iSinfoDAO {
    //修改
	
	public int update(Cinema cin) {
		int rtn = 0;
		try {
			String sqlstr = "update cinema  set cinemaPwd = '" + cin.getCinemaPwd() + "', cinemaAddr = '"
					+ cin.getCinemaAddr() + '", cinemaTel = "' + cin.getCinemaTel() + '", cinemaService = '"
					+ cin.getCinemaService()+"'";
                        out.println(sqlstr);
			sqlstr += " where cinemaId = '" + cin.getCinemaId()+"'";
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn = db.execCommand(sqlstr);//执行语句
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}}

